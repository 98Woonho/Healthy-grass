package com.example.app.shopping.controller;

import com.example.app.shopping.domain.dto.common.Criteria;
import com.example.app.shopping.domain.service.productReviewBoard.ProductReviewBoardServiceImpl;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductReviewBoardController {
    @Autowired
    private ProductReviewBoardServiceImpl service;

    // 상품 조회에서 상품 리뷰 뿌려주는 rest API, 기존 게시판과 구분을 위해 url 끝에 API 를 작성하였습니다.
    @PostMapping("/productReviewBoardListAPI")
    public @ResponseBody Map<String, Object> productReviewBoardListAPI(@RequestBody ProductReviewBoardAPI request) {
        System.out.println("ProductReviewBoardController's productReviewBoardListAPI");
        System.out.println("request: " + request);
        Criteria criteria = request.getCriteria();

        Integer pId = request.getPId();
        String productName = request.getProductName();

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
            returnVal = service.getproductReviewBoards(criteria, pId, productName);
            returnVal.put("success", true);
        } catch (Exception e) {
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
        @JsonProperty("productName")
        String productName;  // 상품명
    }
}
