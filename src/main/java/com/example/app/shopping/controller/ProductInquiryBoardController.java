package com.example.app.shopping.controller;

import com.example.app.shopping.config.auth.PrincipalDetails;
import com.example.app.shopping.domain.dto.ProductInquiryBoardDto;
import com.example.app.shopping.domain.dto.common.Criteria;
import com.example.app.shopping.domain.service.product.ProductServiceImpl;
import com.example.app.shopping.domain.service.productInquiryBoard.productInquiryBoardServiceImpl;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductInquiryBoardController {
    @Autowired
    private productInquiryBoardServiceImpl productInquiryBoardService;

    @Autowired
    private ProductServiceImpl productService;
    
    Integer unlockId;  // 게시글 번호 비밀번호 체크 상태변수

    @GetMapping("/productInquiryBoardList")
    public String productInquiryBoardList(@ModelAttribute Criteria criteria, Model model) {
        System.out.println("productInquiryBoardController's productInquiryBoardList criteria: " + criteria + " model: " + model);

        if (criteria.getPageno() == null) {
            criteria.setPageno(1);
        }

        if (criteria.getAmount() == null) {
            criteria.setAmount(10);
        }

        try {
            Map<String, Object> serviceReturnVal = productInquiryBoardService.getproductInquiryBoards(criteria);
            model.addAttribute("success", true);
            model.addAttribute("list", serviceReturnVal.get("list"));  // 상품 리스트 정보
            model.addAttribute("pageDto", serviceReturnVal.get("pageDto"));  // 페이징 처리를 위한 정보
        } catch (Exception e) {
            model.addAttribute("success", false);
        }

        return "/productInquiryBoard/boardList";
    }

    @GetMapping("/productInquiryBoard")
    public String productInquiryBoard(
            @RequestParam(name = "id", defaultValue = "0", required = false) Integer id,
            Model model) {
        System.out.println("productInquiryBoardController's productInquiryBoard id: " + id + " model: " + model);

        Map<String, Object> response = null;  // 반환할 데이터를 담을 변수

        try {
            response = productInquiryBoardService.getproductInquiryBoardDetail(id);

            if("Y".equals(response.get("isLocked")) && !id.equals(unlockId) ) {
                // 잠금 상태이고 비밀번호 체크가 안 된 상태라면
                model.addAttribute("id", id);

                return "/productInquiryBoard/passwordChk";
            }

            unlockId = null;  // 비밀번호 체크 상태 초기화

            response.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            response = new HashMap<>();
            response.put("success", false);
        }

        model.addAttribute("response", response);
        response = null;

        return "/productInquiryBoard/boardDetail";
    }

    @PostMapping("/productInquiryBoard/passwordCheck")
    public @ResponseBody Map<String, Object> passwordCheck(@RequestBody Map<String, Object> request) {
        Integer id = Integer.parseInt((String)request.get("id"));
        String password = (String) request.get("password");

        System.out.println("productInquiryBoardController's passwordCheck password: " + password + " id: " + id);
        Map<String, Object> response = new HashMap<>();

        try {
            Map<String, Object> result = productInquiryBoardService.getproductInquiryBoardDetail(id);
            String boardPassword = (String) result.get("password");

            System.out.println("boardPassword: " + boardPassword + " password: " + password);


            // 게시판 작성을 구현하고 나면 Bcrypt 비교로 수정 필요
            if (boardPassword.equals(password)) {
                unlockId = id;
                System.out.println(unlockId);
                response.put("result", result);
                response.put("success", true);
            } else {
                response.put("success", false);
            }
        } catch (Exception e) {
            response.put("success", false);
        }
        
        return response;
    }

    @GetMapping("/myProductInquiryBoardList")
    public String MyProductInquiryBoardList(@ModelAttribute Criteria criteria, Authentication authentication, Model model) {
        System.out.println("productInquiryBoardController's productInquiryBoardList criteria: " + criteria);

        if (criteria.getPageno() == null) {
            criteria.setPageno(1);
        }

        if (criteria.getAmount() == null) {
            criteria.setAmount(10);
        }

        if (authentication == null) {
            String error = "로그인 정보가 없습니다.";
            model.addAttribute("error", error);

            return "/error/error";
        }

        criteria.setAmount(6);
        String uId = ((PrincipalDetails) authentication.getPrincipal()).getUsername();

        try {
            Map<String, Object> serviceReturnVal = productInquiryBoardService.getMyProductInquiryBoards(criteria, uId);

            System.out.println(serviceReturnVal.get("pageDto"));

            model.addAttribute("success", true);
            model.addAttribute("list", serviceReturnVal.get("list"));  // 상품 리스트 정보
            model.addAttribute("pageDto", serviceReturnVal.get("pageDto"));  // 페이징 처리를 위한 정보
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("success", false);
        }

        return "/myPage/myProductInquiryPage";
    }

    // 상품 조회에서 상품 리뷰 뿌려주는 rest API, 기존 게시판과 구분을 위해 url 끝에 API 를 작성하였습니다.
    @PostMapping("/productInquiryBoardListAPI")
    public @ResponseBody Map<String, Object> productInquiryBoardListAPI(@RequestBody ProductReviewBoardAPI request) {
        System.out.println("ProductInquiryBoardController's productInquiryBoardListAPI");
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
            returnVal = productInquiryBoardService.getProductInquiryBoardsByPid(criteria, pId);

            returnVal.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            returnVal.put("success", false);
        }

        return returnVal;
    }

    @Data
    private static class ProductReviewBoardAPI {
        @JsonProperty("criteria")
        Criteria criteria;
        @JsonProperty("pId")
        Integer pId;  // 상품 ID
    }

    @GetMapping("productInquiry")
    public String addProductGet(@RequestParam("productId") Integer pId, Model model) {
        System.out.println("ProductInquiryBoardController's addProductGet pId: " + pId);

        try {
            Map<String, Object> product = productService.getItemDetail(pId);
            model.addAttribute("productName", product.get("name"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("pId", pId);

        return "productInquiryBoard/addProductInquiry";
    }

    @PostMapping("productInquiry")
    public @ResponseBody Map<String, Object> addProductPost(@ModelAttribute ProductInquiryBoardDto boardDto, Authentication authentication) {
        System.out.println("ProductInquiryBoardController's addProductPost boardDto: " + boardDto);
        String uId = null;
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Map<String, Object> result = new HashMap<>();

        if (authentication == null) {
            // 계정 정보가 없을 시 필요한 로직 추가 필요
            result.put("success", false);
            result.put("msg", "회원만 작성할 수 있습니다.");
            return result;
        } else {
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
            uId = principalDetails.getUsername();

            boardDto.setUid(uId);
        }

        /*
        *  isLocked 가 check 되었다면 'Y', 아니라면 'N' 으로 변환 작업
        *  패스워드 인코딩
        */

        if(boardDto.getIsLocked() != null) {
            boardDto.setIsLocked("Y");

            if(boardDto.getPassword() != null) {
                boardDto.setPassword(encoder.encode(boardDto.getPassword()));
            } else {
                boardDto.setIsLocked("N");
            }

        } else {
            boardDto.setIsLocked("N");
        }

        // 업로드 날짜 등록
        boardDto.setRegDate(LocalDate.now());
        boardDto.setUpdateDate(LocalDate.now());

        // DB에 삽입 작업 + result 추가 작업
        try {
            result = productInquiryBoardService.postProductInquiry(boardDto);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("msg", "데이터베이스 에러");
        }

        return result;
    }
}
