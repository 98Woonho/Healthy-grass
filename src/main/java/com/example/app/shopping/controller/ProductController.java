package com.example.app.shopping.controller;

import com.example.app.shopping.config.auth.PrincipalDetails;
import com.example.app.shopping.domain.dto.UserDto;
import com.example.app.shopping.domain.dto.common.Criteria;
import com.example.app.shopping.domain.service.product.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @GetMapping("/product")
    public String product(
            @RequestParam(name = "id", defaultValue = "0", required = false) Integer id,
            Model model)
    {
        System.out.println("GET: ProductController's product id: " + id);

        Map<String, Object> response = null;

        try {
            response = productService.getItemDetail(id);
            response.put("success", true);
        } catch (Exception e) {
            response = new HashMap<>();
            response.put("success", false);
        }

        model.addAttribute("response", response);

        return "/product/productDetail";
    }

    @GetMapping("/popularProducts")
    public @ResponseBody Map<String, Object> popularProducts() {
        Map<String, Object> response = null;

        try {
            response = productService.getPopularProductsByCategory();
            response.put("success", true);
        } catch (Exception e) {
            response = new HashMap<>();
            response.put("success", false);
        }

        return response;
    }

    @GetMapping("/highDiscountProducts")
    public @ResponseBody Map<String, Object> highDiscountProducts() {
        Map<String, Object> response = null;

        try {
            response = productService.getHighDiscountProducts();
            response.put("success", true);
        } catch (Exception e) {
            response = new HashMap<>();
            response.put("success", false);
        }

        return response;
    }

    @GetMapping("/recentProducts")
    public @ResponseBody Map<String, Object> recentProducts() {
        Map<String, Object> response = null;

        try {
            response = productService.getRecentProducts();
            response.put("success", true);
        } catch (Exception e) {
            response = new HashMap<>();
            response.put("success", false);
        }

        return response;
    }

    // 실시간으로 상품금액의 크기를 변경시키는 로직
    @PostMapping("/productPrice")
    public @ResponseBody Integer totalProductAmountChange(@RequestBody Map<String, Integer> request){
        System.out.println("totalProductAmount : " +request.get("totalProductAmount"));
        return request.get("totalProductAmount");
    }

    // 찜리스트에 제품 저장
    @PostMapping("/product/wish")
    public ResponseEntity<String> postWish(@RequestBody Map<String, Long> parameters, Authentication authentication) {
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        UserDto userDto = principalDetails.getUserDto();

        Long Pid = parameters.get("productId");
        String Uid = userDto.getId();

        String result = productService.addWish(Pid, Uid);

        if (result.equals("FAILURE_DUPLICATE_WISH")) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 찜리스트에 등록된 제품입니다.");
        }

        return ResponseEntity.ok("찜리스트에 제품이 등록 되었습니다.");
    }
}
