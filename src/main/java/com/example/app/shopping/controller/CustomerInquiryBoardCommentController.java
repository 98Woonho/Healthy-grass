package com.example.app.shopping.controller;

import com.example.app.shopping.domain.service.customerInquiryBoardComment.CustomerInquiryBoardCommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CustomerInquiryBoardCommentController {
    @Autowired
    private CustomerInquiryBoardCommentServiceImpl service;

    @GetMapping("/customerInquiryBoardComment")
    public @ResponseBody Map<String, Object> CustomerInquiryBoardComment(@RequestParam(name = "id") Integer id) {
        System.out.println("CustomerInquiryBoardCommentController's CustomerInquiryBoardComment id: " + id);

        Map<String, Object> response = new HashMap<>();

        try {
            response.put("list", service.getComments(id));
            response.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            response.put("success", false);
        }

        return response;
    }
}
