package com.example.app.shopping.controller;

import com.example.app.shopping.config.auth.PrincipalDetails;
import com.example.app.shopping.domain.dto.ProductReviewBoardDto;
import com.example.app.shopping.domain.dto.common.Criteria;
import com.example.app.shopping.domain.service.product.ProductService;
import com.example.app.shopping.domain.service.productReviewBoard.ProductReviewBoardService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class ProductReviewBoardController {
    @Autowired
    private ProductReviewBoardService service;
    @Autowired
    private ProductService productService;

    // 상품 조회에서 상품 리뷰 뿌려주는 rest API, 기존 게시판과 구분을 위해 url 끝에 API 를 작성하였습니다.
    @PostMapping("/productReviewBoardListAPI")
    public @ResponseBody Map<String, Object> productReviewBoardListAPI(@RequestBody ProductReviewBoardAPI request) {
        System.out.println("ProductReviewBoardController's productReviewBoardListAPI");
        System.out.println("request: " + request);
        Criteria criteria = request.getCriteria();

        Integer pId = request.getPId();

        if (criteria.getPageno() == null) {
            criteria.setPageno(1);
        }

        if (criteria.getAmount() == null) {
            criteria.setAmount(10);
        }

        System.out.println(request);
        System.out.println(criteria);

        Map<String, Object> returnVal = new HashMap<>();
        
        try {
            returnVal = service.getproductReviewBoards(criteria, pId);
            returnVal.put("success", true);
        } catch (Exception e) {
            returnVal.put("success", false);
        }

        return returnVal;
    }

    // 악의적인 리뷰 혹은 광고 등을 검열하기 위한 개발자 뷰를 위한 메서드입니다. (일반 유저는 볼 이유가 없어 접근 제한 필요할 듯 합니다)
    @GetMapping("/productReviewBoardList")
    public String productReviewBoardList(
            @ModelAttribute Criteria criteria,
            Model model
    ) {
        System.out.println("ProductReviewBoardController's productReviewBoardList " +
                "criteria: " + criteria + " model: " + model);

        if (criteria.getPageno() == null) {
            criteria.setPageno(1);
        }

        if (criteria.getAmount() == null) {
            criteria.setAmount(10);
        }

        try {
            Map<String, Object> serviceReturnVal = service.getproductReviewBoards(criteria, null);  // pId 는 criteria 의 keyword 로 대체
            model.addAttribute("success", true);
            model.addAttribute("list", serviceReturnVal.get("list"));  // 상품 리스트 정보
            model.addAttribute("pageDto", serviceReturnVal.get("pageDto"));  // 페이징 처리를 위한 정보
        } catch (Exception e) {
            model.addAttribute("success", false);
        }

        return "/productReviewBoard/boardList";
    }

    @GetMapping("/productReviewBoard")
    public String productReviewBoard (
            @RequestParam(name = "id", defaultValue = "0", required = false) Integer id,
            Model model) {
        System.out.println("ProductReviewBoardController's productReviewBoard id: " + id + " model: " + model);

        Map<String, Object> response = null;  // 반환할 데이터를 담을 변수

        try {
            response = service.getproductReviewBoardDetail(id);
            response.put("success", true);
        } catch (Exception e) {
            response = new HashMap<>();
            response.put("success", false);
        }

        model.addAttribute("response", response);
        response = null;

        return "/productReviewBoard/boardDetail";
    }

    // 내 작성 리뷰 뿌리기

    @GetMapping("/myProductReviewBoardList")
    public String myProductReviewBoardList(
            @ModelAttribute Criteria criteria,
            Model model,
            Authentication authentication
    ) {
        System.out.println("ProductReviewBoardController's myProductReviewBoardList " +
                "criteria: " + criteria + " model: " + model);

        if (criteria.getPageno() == null) {
            criteria.setPageno(1);
        }

        criteria.setAmount(6);

        if (authentication == null) {
            String error = "로그인 정보가 없습니다.";
            model.addAttribute("error", error);

            return "/error/error";
        }

        String uId = ((PrincipalDetails) authentication.getPrincipal()).getUsername();

        try {
            Map<String, Object> serviceReturnVal = service.getMyProductReviewBoards(criteria, uId);
            model.addAttribute("success", true);
            model.addAttribute("list", serviceReturnVal.get("list"));  // 상품 리스트 정보
            model.addAttribute("pageDto", serviceReturnVal.get("pageDto"));  // 페이징 처리를 위한 정보
        } catch (Exception e) {
            model.addAttribute("success", false);
        }

        return "/myPage/myReviewPage";
    }

    @Data
    private static class ProductReviewBoardAPI {
        @JsonProperty("criteria")
        Criteria criteria;
        @JsonProperty("pId")
        Integer pId;  // 상품 ID
    }

    /*
        리뷰 작성 페이지로 이동합니다.
        Order 의 id, Product 의 id 를 파라미터로 전달받습니다.
    */
    @GetMapping("/productReview/new")
    public String productReviewAddPage(@ModelAttribute productReviewAddPageRequestDto dto, Model model) {
        log.info("ProductReviewBoardController's productReviewAddPage request: " + dto);

        try {
            model.addAttribute("pId", dto.getPId());
            model.addAttribute("oId", dto.getOId());
            model.addAttribute("product", productService.getItemDetail( dto.getPId().intValue() ));
            model.addAttribute("success", true);
        } catch (Exception e) {
            model.addAttribute("success", false);
            model.addAttribute("msg", "해당 상품에 대한 리뷰를 작성할 수 없습니다.");
        }

        return "productReviewBoard/addProductReview";
    }

    @Data
    private static class productReviewAddPageRequestDto {
        private Long oId;
        private Long pId;
    }

    /*
        리뷰 작성 POST

        User 의 id 를 확인하여 Order 의 Uid 와 일치하는지 확인하고,
        Order 의 pId 와 Product 의 id 가 일치하는지 확인합니다.
    */
    @PostMapping(value = "/productReview")
    public @ResponseBody Map<String, Object> postProductReview(@ModelAttribute PostProductReviewRequestDto request, Authentication authentication) {
        log.info("ProductReviewBoardController's postProductReview request: " + request);

        Map<String, Object> response = new HashMap<>();
        
        // 비회원 체크
        if(authentication == null) {
            response.put("success", false);
            response.put("msg", "비회원은 작성할 수 없습니다.");

            return response;
        }
        
        // 본인이 구매한 상품에 대한 리뷰 작성인지 체크 (oId, pId 로 조회를 하고 oId에 uId가 일치하는지 체크, oId 로 조회한 order_item 리스트에 pId가 있는지, 이미 작성한 리뷰가 있는지 체크)
        try {
            response = service.checkAddReview(request.getOId(), request.getPId(), authentication.getName());
            // 리뷰를 삽입하는 작업 필요
            ProductReviewBoardDto boardDto =
                    ProductReviewBoardDto
                            .builder()
                            .Pid(request.getPId())
                            .Uid(authentication.getName())
                            .title(request.getTitle())
                            .content(request.getContent())
                            .rating(request.getRating())
                            .regDate(LocalDate.now())
                            .updateDate(LocalDate.now())
                            .build();

            MultipartFile image = request.getImage();

            service.insertProductReviewServ(boardDto, image, request.getOId());
        } catch (Exception e) {
//            e.printStackTrace();
            response.put("success", false);
            response.put("msg", e.getMessage());
        }


        return response;
    }

    @Data
    private static class PostProductReviewRequestDto {
        @JsonProperty("title")
        private String title;
        @JsonProperty("content")
        private String content;
        @JsonProperty("rating")
        private Integer rating;
        @JsonProperty("oId")
        private Long oId;
        @JsonProperty("pId")
        private Long pId;
        @JsonProperty("image")
        private MultipartFile image;
    }


    /*
        상품 리뷰 수정페이지로 이동
        기존 상품 리뷰에 대한 데이터 전달
    */
    @GetMapping("/productReview/edit")
    private String productReviewEditPage(@RequestParam("boardId") Long boardId, Model model) {
        log.info("ProductReviewBoardController's productReviewEditPage boardId: " + boardId);

        try {
            model.addAttribute("review", service.getproductReviewBoardDetail(boardId.intValue()));
            model.addAttribute("success", true);
        } catch (Exception e) {
            model.addAttribute("success", false);
            model.addAttribute("msg", "리뷰 정보를 가져오는데 실패하였습니다.");
        }

        return "productReviewBoard/editProductReview";
    }

    /*
        상품 리뷰 수정 put
    */
    @PutMapping("/productReview")
    public @ResponseBody Map<String, Object> putProductReview(
            @ModelAttribute PutProductReviewDto putDto, Authentication authentication) {
        log.info("ProductReviewBoardController's putProductReview dto: " + putDto);

        Map<String, Object> response = new HashMap<>();

        if (authentication == null) {
            response.put("success", false);
            response.put("msg", "비회원은 수정할 수 없습니다.");
            return response;
        }

        ProductReviewBoardDto boardDto = new ProductReviewBoardDto();
        boardDto.setId(putDto.getId());
        boardDto.setUid(authentication.getName());
        boardDto.setTitle(putDto.getTitle());
        boardDto.setContent(putDto.getContent());
        boardDto.setRating(putDto.getRating());

        MultipartFile file = putDto.getImage();
        boolean deleteImage = putDto.isDeleteImage();

        try {
            response = service.putProductReviewServ(boardDto, file, deleteImage);
        } catch (Exception e) {
            response.put("success", false);
            response.put("msg", "리뷰 수정에 실패하였습니다.");
        }

        return response;
    }

    @Data
    private static class PutProductReviewDto {
        @JsonProperty("id")
        private Long id;
        @JsonProperty("title")
        private String title;
        @JsonProperty("content")
        private String content;
        @JsonProperty("rating")
        private Integer rating;
        @JsonProperty("image")
        private MultipartFile image;
        @JsonProperty("deleteImage")
        private boolean deleteImage;
    }


    /*
        리뷰 삭제 요청 처리
        관리자, 작성자 본인만 삭제 가능
    */
    @DeleteMapping("productReview")
    public @ResponseBody Map<String, Object> deleteReview(@RequestParam("boardId") Long id, Authentication authentication) {
        System.out.println("ReviewController's deleteReview id: " + id);

        Map<String, Object> response = new HashMap<>();

        boolean isAdmin = false;

        if (authentication == null) {
            // 만약 비회원 상태라면
            response.put("success", false);
            response.put("msg", "작성한 회원만 삭제 요청을 할 수 있습니다.");

            return response;
        }

        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        String userName = principalDetails.getUsername();
        Collection<? extends GrantedAuthority> authorities = principalDetails.getAuthorities();
        isAdmin = authorities.stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));

        try {
            Map<String, Object> reviewInfo = service.getReviewDetail(id);

            if (!isAdmin && !userName.equals(reviewInfo.get("Uid"))) {
                response.put("success", false);
                response.put("msg", "본인이 작성한 리뷰만 삭제할 수 있습니다.");
            } else {
                // 제거 요청에 대한 서비스 호출
                response = service.deleteReview(id);
            }
        } catch (NullPointerException e) {
            response.put("success", false);
            response.put("msg", "리뷰 정보를 찾을 수 없습니다.");
        } catch (Exception e) {
            response.put("success", false);
            response.put("msg", e.getMessage());
        }

        return response;
    }

}
