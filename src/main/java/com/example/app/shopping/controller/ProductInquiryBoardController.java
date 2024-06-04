package com.example.app.shopping.controller;

import com.example.app.shopping.domain.dto.common.Criteria;
import com.example.app.shopping.domain.service.productInquiryBoard.productInquiryBoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductInquiryBoardController {
    @Autowired
    private productInquiryBoardServiceImpl productInquiryBoardService;
    
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

            System.out.println(serviceReturnVal.get("pageDto"));

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
            String boardPassword = (String) productInquiryBoardService.getproductInquiryBoardDetail(id).get("password");

            System.out.println("boardPassword: " + boardPassword + " password: " + password);


            // 게시판 작성을 구현하고 나면 Bcrypt 비교로 수정 필요
            if (boardPassword.equals(password)) {
                unlockId = id;
                System.out.println(unlockId);
                response.put("success", true);
            } else {
                response.put("success", false);
            }
        } catch (Exception e) {
            response.put("success", false);
        }
        
        return response;
    }

}
