package com.example.app.shopping.controller;

import com.example.app.shopping.domain.dto.ProductDto;
import com.example.app.shopping.domain.service.admin.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Controller
@Slf4j
@RequestMapping(value = "admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    // 제품 등록 Get
    @GetMapping("addProduct")
    public void getAddProduct(Model model) {
        // 제품 메인 카테고리 List 가져오기
        List<String> productMajorCategoryList = adminService.getProductMajorCategoryList();

        // 제품 서브 카테고리 List 가져오기
        List<String> productMiddleCategoryList = adminService.getProductMiddleCategoryList();

        // 테스트
        model.addAttribute("productMajorCategoryList", productMajorCategoryList);
        model.addAttribute("productMiddleCategoryList", productMiddleCategoryList);
    }

    // 제품 등록 Post
    @PostMapping("addProduct")
    public ResponseEntity<String> postAddProduct(@RequestPart(value = "mainImage") MultipartFile mainImage,
                                                 @RequestPart(value = "subImage") MultipartFile subImage,
                                                 ProductDto productDto) throws IOException {
        // 제품 등록
        adminService.addProduct(mainImage, subImage, productDto);
        return ResponseEntity.ok("제품 등록이 완료 되었습니다.");
    }
}
