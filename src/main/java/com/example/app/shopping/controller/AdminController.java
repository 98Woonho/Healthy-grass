package com.example.app.shopping.controller;

import com.example.app.shopping.domain.service.admin.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping(value = "admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    // 상품 등록 Get
    @GetMapping("addProduct")
    public void getAddProduct(Model model) {
        // 제품 메인 카테고리 List 가져오기
        List<String> productMajorCategoryList = adminService.getProductMajorCategoryList();

        // 제품 서브 카테고리 List 가져오기
        List<String> productMiddleCategoryList = adminService.getProductMiddleCategoryList();

        model.addAttribute("productMajorCategoryList", productMajorCategoryList);
        model.addAttribute("productMiddleCategoryList", productMiddleCategoryList);
    }
}
