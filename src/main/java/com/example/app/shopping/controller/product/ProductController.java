package com.example.app.shopping.controller.product;

import com.example.app.shopping.domain.dto.ProductDto;
import com.example.app.shopping.domain.service.product.ProductService;
import com.example.app.shopping.domain.service.product.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/product")
    public String getProductsBySearch(@RequestParam(required = false) String name,
                                      @RequestParam(required = false) String majorCategory,
                                      @RequestParam(required = false) String middleCategory,
                                      @RequestParam(required = false) String orderBy,
                                      @RequestParam(defaultValue = "1") int page,
                                      @RequestParam(defaultValue = "10") int size,
                                      Model model) {
        try {
            List<ProductDto> products = productService.getProductsBySearch(name, majorCategory, middleCategory, orderBy, page, size);
            model.addAttribute("product", products);
            return "product/product";
        } catch (Exception e) {
            e.printStackTrace(); // 또는 로깅
            model.addAttribute("error", "상품 검색 중에 오류가 발생했습니다.");
            return "error"; // 예외 페이지로 이동하거나, 적절한 에러 처리를 수행할 수 있습니다.
        }
    }

}
