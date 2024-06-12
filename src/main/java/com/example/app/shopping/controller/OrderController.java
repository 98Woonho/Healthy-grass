package com.example.app.shopping.controller;

import com.example.app.shopping.config.auth.PrincipalDetails;
import com.example.app.shopping.domain.dto.OrderDto;
import com.example.app.shopping.domain.dto.ProductDto;
import com.example.app.shopping.domain.dto.UserDto;
import com.example.app.shopping.domain.service.order.OrderService;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@RequestMapping("/order")
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    private Map<String, Object> tmp = new HashMap<>();

    @PostMapping("")
    public @ResponseBody String orderForm(@RequestBody List<AddOrder> result, Authentication authentication, HttpServletRequest request) {
        System.out.println(result);
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        UserDto userDto = principal.getUserDto();

        tmp.put("result", result);

        return "SUCCESS";
    }

    @Data
    public static class AddOrder {
        private Integer price;
        private Integer quantity;
        private Integer total_amount;
        @JsonProperty("Pid")
        private Integer Pid;
    }
}
