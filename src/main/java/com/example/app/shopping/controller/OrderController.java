package com.example.app.shopping.controller;

import com.example.app.shopping.config.auth.PrincipalDetails;
import com.example.app.shopping.domain.dto.OrderDto;
import com.example.app.shopping.domain.dto.ShippingAddressDto;
import com.example.app.shopping.domain.dto.UserDto;
import com.example.app.shopping.domain.service.myPage.MyPageService;
import com.example.app.shopping.domain.service.order.OrderService;
import com.example.app.shopping.domain.service.product.ProductService;
import com.example.app.shopping.domain.service.product.ProductServiceImpl;
import com.example.app.shopping.domain.service.user.UserService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@RequestMapping("/order")
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private MyPageService myPageService;

    private Map<String, Object> tmp = new HashMap<>();
    private Map<String, Object> product = new HashMap<>();
    private List<Map<String, Object>> productList = new ArrayList<>();

    @PostMapping("")
    public @ResponseBody String orderForm(@RequestBody List<AddOrder> result, Authentication authentication) {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        UserDto userDto = principal.getUserDto();
        AddOrder addOrder = result.get(0);
        Integer totalAmount = addOrder.total_amount;
        //상품이 계속해서 증가하는걸 방지하기 해서 비워주기
        productList.clear();

        result.forEach(order ->{
            try {
                product = productService.getProductList(order.Pid);
                productList.add(product);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        tmp.put("productList", productList);
        tmp.put("orderList", result);
        tmp.put("userDto", userDto);
        tmp.put("totalAmount", totalAmount);

        return "SUCCESS";
    }

    @GetMapping("")
    public String orderForm(Authentication authentication, Model model){
        if (authentication == null){
            return "user/loginForm";
        }else {
            System.out.println(productList);
            model.addAttribute("productList", tmp.get("productList"));
            System.out.println("userDto" + tmp.get("userDto"));
            model.addAttribute("orderList", tmp.get("orderList"));
            model.addAttribute("userDto", tmp.get("userDto"));
            model.addAttribute("totalAmount", tmp.get("totalAmount"));

            return "order/orderForm";
        }
    }

    @Data
    public static class AddOrder {
        private Integer price;
        private Integer quantity;
        private Integer total_amount;
        private Integer noSaleTotalPrice;
        @JsonProperty("Pid")
        private Integer Pid;
    }

    // 주문자 정보와 동일함 클릭시 order화면에 주문자 정보 뿌려주기
    @GetMapping("/user")
    @ResponseBody
    public UserDto findUser(Authentication authentication){
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        String id = principal.getUserDto().getId();
        return userService.findUserByUserId(id);
    }

    //기본배송지 정보 가져오기
    @GetMapping("/shipping")
    @ResponseBody
    public ShippingAddressDto findShipping(Authentication authentication){
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        String id = principal.getUserDto().getId();
        return myPageService.isExistShippingAddress(id);
    }
}
