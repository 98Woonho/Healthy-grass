package com.example.app.shopping.controller;

import com.example.app.shopping.config.auth.PrincipalDetails;
import com.example.app.shopping.domain.dto.CustomerInquiryBoardDto;
import com.example.app.shopping.domain.dto.common.Criteria;
import com.example.app.shopping.domain.service.customerInquiryBoard.CustomerInquiryBoardServiceImpl;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CustomerInquiryBoardController {

    @Autowired
    private CustomerInquiryBoardServiceImpl service;

    @GetMapping("/customerInquiryBoardList")
    public String customerInquiryBoardList (@ModelAttribute Criteria criteria, Model model) {
        System.out.println("CustomerInquiryBoardController's customerInquiryBoardList");

        if (criteria.getPageno() == null) {
            criteria.setPageno(1);
        }

        if (criteria.getAmount() == null) {
            criteria.setAmount(10);
        }

        try {
            Map<String, Object> serviceReturnVal = service.getCustomerInquiryBoards(criteria);
            model.addAttribute("success", true);
            model.addAttribute("list", serviceReturnVal.get("list"));  // 상품 리스트 정보
            model.addAttribute("pageDto", serviceReturnVal.get("pageDto"));  // 페이징 처리를 위한 정보

            System.out.println(serviceReturnVal.get("pageDto"));

        } catch (Exception e) {
            model.addAttribute("success", false);
        }

        return "CustomerInquiryBoard/boardList";
    }

    @GetMapping("/customerInquiryBoard")
    public String customerInquiryBoard(
            @RequestParam(name = "id", defaultValue = "0", required = false) Integer id,
            Model model) {
        System.out.println("CustomerInquiryBoardController's customerInquiryBoardList id: " + id + " model: " + model);

        Map<String, Object> response = null;  // 반환할 데이터를 담을 변수

        try {
            response = service.getCustomerInquiryBoardDetail(id);
            response.put("success", true);
        } catch (Exception e) {
            response = new HashMap<>();
            response.put("success", false);
        }

        model.addAttribute("response", response);

        return "/customerInquiryBoard/boardDetail";
    }

    @GetMapping("/myCustomerInquiryBoardList")
    public String myCustomerInquiryBoardList(@ModelAttribute Criteria criteria, Authentication authentication, Model model) {
        System.out.println("CustomerInquiryBoardController's myCustomerInquiryBoardList criteria: " + criteria);

        if (criteria.getPageno() == null) {
            criteria.setPageno(1);
        }

        if (authentication == null) {
            String error = "로그인 정보가 없습니다.";
            model.addAttribute("error", error);

            return "/error/error";
        }

        criteria.setAmount(6);

        String uId = ((PrincipalDetails) authentication.getPrincipal()).getUsername();

        try {
            Map<String, Object> serviceReturnVal = service.getMyCustomerInquiryBoards(criteria, uId);
            model.addAttribute("success", true);
            model.addAttribute("list", serviceReturnVal.get("list"));  // 상품 리스트 정보
            model.addAttribute("pageDto", serviceReturnVal.get("pageDto"));  // 페이징 처리를 위한 정보

            System.out.println(serviceReturnVal.get("pageDto"));

        } catch (Exception e) {
            model.addAttribute("success", false);
        }

        return "/myPage/myCustomerInquiryPage";
    }

    
    /*
        고객 문의 페이지로 이동시켜준다
    */
    @GetMapping("/customerInquiry")
    public String getCustomerInquiry(Model model, Authentication authentication) {
        System.out.println("CustomerInquiryBoardController's getCustomerInquiry");

        return "/customerInquiryBoard/addCustomerInquiry";
    }


    /*
        POST    /customerInquiry

        고객 문의글에 작성된 내용을 받아 DB에 저장합니다.
        성공 시
        ("success", true)
        ("msg", "성공 메시지")
        실패 시
        ("success", false)
        ("msg", "실패 메시지")
        가 Map 형태로 전달됩니다.
    */
    @PostMapping("/customerInquiry")
    public @ResponseBody Map<String, Object> postCustomerInquiry(@ModelAttribute postCustomerInquiryDto postDto, Authentication authentication)
    {
        System.out.println("CustomerInquiryBoardController's handleCustomerInquiry dto: " + postDto);

        Map<String, Object> response = new HashMap<>();

        if(authentication == null) {
            response.put("success", false);
            response.put("msg", "비회원은 작성할 수 없습니다.");

            return response;
        }

        CustomerInquiryBoardDto boardDto = new CustomerInquiryBoardDto();

        boardDto.setUid(authentication.getName());
        boardDto.setTitle(postDto.getTitle());
        boardDto.setContent(postDto.getContent());

        MultipartFile file = postDto.getImage();

        try {
            response = service.postCustomerInquiryServ(boardDto, file);
        } catch (Exception e) {
            response.put("success", false);
            response.put("msg", "상품 등록에 실패하였습니다.");
        }

        return response;
    }

    @Data
    private static class postCustomerInquiryDto {
        @JsonProperty("title")
        private String title;
        @JsonProperty("content")
        private String content;
        @JsonProperty("image")
        private MultipartFile image;
    }

    /*
        고객 문의 게시글 수정 페이지로 이동시킵니다.
        비회원 이거나 게시글 정보를 찾을 수 없을때는 그에대한 메시지를 Model 에 담습니다.
    */
    @GetMapping("/customerInquiry/edit")
    public String customerInquiryEditPage(@RequestParam("id") Integer id, Model model, Authentication authentication) {
        System.out.println("CustomerInquiryBoardController's customerInquiryEditPage id: " + id);

        String userName = "";

        if (authentication != null) {
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
            userName = principalDetails.getUsername();
        }

        try {
            // 서비스로부터 게시글 정보를 받아온다
            Map<String, Object> result = service.getCustomerInquiryBoardDetail(id);

            // 게시글 작성자와 수정자가 일치하는지 확인한다
            if(!userName.equals( (String) result.get("Uid") )) {
                model.addAttribute("success", false);
                model.addAttribute("boardId", id);
                model.addAttribute("msg", "본인의 게시글만 수정할 수 있습니다.");
            } else {
                // 게시글 작성자와 수정자가 일치한다
                model.addAttribute("success", true);
                model.addAttribute("board", result);
            }
        } catch (NullPointerException e) {
            // 게시글을 찾지 못한 상황
            model.addAttribute("success", false);
            model.addAttribute("boardId", id);
            model.addAttribute("msg", "해당 게시물을 찾을수 없습니다.");
        } catch (Exception e) {
            // DB 통신 에러처리
            model.addAttribute("success", false);
            model.addAttribute("boardId", id);
            model.addAttribute("msg", "데이터베이스 연동에 실패하였습니다.");
        }

        return "/customerInquiryBoard/edit";
    }

    /*
        게시글 수정 요청을 서비스를 수행합니다.
    */
    @PutMapping("/customerInquiry")
    public @ResponseBody Map<String, Object> updateCustomerInquiry(
            @ModelAttribute postCustomerInquiryDto postDto, Authentication authentication) {
        System.out.println("CustomerInquiryBoardController's updateCustomerInquiry dto: " + postDto);

        Map<String, Object> response = new HashMap<>();

        if (authentication == null) {
            response.put("success", false);
            response.put("msg", "비회원은 수정할 수 없습니다.");
            return response;
        }

        CustomerInquiryBoardDto boardDto = new CustomerInquiryBoardDto();
        boardDto.setId(postDto.getId());
        boardDto.setUid(authentication.getName());
        boardDto.setTitle(postDto.getTitle());
        boardDto.setContent(postDto.getContent());

        MultipartFile file = postDto.getImage();

        try {
//            response = service.updateCustomerInquiry(boardDto, file);
        } catch (Exception e) {
            response.put("success", false);
            response.put("msg", "문의 수정에 실패하였습니다.");
        }

        return response;
    }

    @Data
    private static class putCustomerInquiryDto {
        @JsonProperty("id")
        private Long id;
        @JsonProperty("title")
        private String title;
        @JsonProperty("content")
        private String content;
        @JsonProperty("image")
        private MultipartFile image;
    }
}
