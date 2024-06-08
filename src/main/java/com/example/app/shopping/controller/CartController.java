package com.example.app.shopping.controller;

import com.example.app.shopping.config.auth.PrincipalDetails;
import com.example.app.shopping.domain.dto.UserDto;
import com.example.app.shopping.domain.service.cart.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping(value = "cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("")
    public String cartForm() {

        return "cart/cartForm";
    }

    @PostMapping("")
    @ResponseBody
    public void cartAdd(@RequestBody Map<String, Object> result, Authentication authentication) {
        String str_productId = (String) result.get("productId");
        String str_quantity = (String) result.get("quantity");
        Integer productId = Integer.parseInt(str_productId);
        Integer quantity = Integer.parseInt(str_quantity);
        System.out.println("quantity : " + quantity);
        //로그인 안한 유저가 장바구니에 물건을 담을 때
        if (authentication == null) {
            System.out.println("cartAddNotUserLogin!!!+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            cartService.cartAddNotUserLogin(productId, quantity);
        } else {
            PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
            String userId = principal.getUserDto().getId();
            cartService.cartAddLoignedUser(productId, quantity, userId);
        }
    }
}
