package com.example.app.shopping.controller;

import com.example.app.shopping.config.auth.PrincipalDetails;
import com.example.app.shopping.domain.dto.OrderDto;
import com.example.app.shopping.domain.dto.ProductDto;
import com.example.app.shopping.domain.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequestMapping("/order")
@Controller
public class OrderController {

    @GetMapping("")
    public String orderForm(){
        return "order/orderForm";
    }
}
