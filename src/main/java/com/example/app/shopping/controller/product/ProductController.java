package com.example.app.shopping.controller.product;

import com.example.app.shopping.domain.dto.common.Criteria;
import com.example.app.shopping.domain.service.product.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Map;

@Controller
public class ProductController {
    
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/productList")
    public String productList(@ModelAttribute Criteria criteria, Model model) {
        System.out.println("GET /productList invoke...");

        if (criteria.getPageno() == null) {
            criteria.setPageno(1);
        }

        if (criteria.getAmount() == null) {
            criteria.setAmount(10);
        }

        System.out.println("criteria : " + criteria);

        try {
            Map<String, Object> serviceReturnVal = productService.getItems(criteria);
            model.addAttribute("success", true);
            model.addAttribute("list", serviceReturnVal.get("list"));  // 상품 리스트 정보
            model.addAttribute("pageDto", serviceReturnVal.get("pageDto"));  // 페이징 처리를 위한 정보

            System.out.println(serviceReturnVal.get("pageDto"));

        } catch (Exception e) {
            model.addAttribute("success", false);
        }

        return "/product/productList";
    }
}
