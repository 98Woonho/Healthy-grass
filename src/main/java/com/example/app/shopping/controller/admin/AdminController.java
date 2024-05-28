package com.example.app.shopping.controller.admin;

import com.example.app.shopping.domain.service.admin.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping(value = "admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    // 상품 등록 Get
    @GetMapping("addProduct")
    public void getAddProduct(Model model) {
        model.addAttribute("ㅎㅇ", 1);
    }
}
