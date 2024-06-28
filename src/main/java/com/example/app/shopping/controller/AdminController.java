package com.example.app.shopping.controller;

import com.example.app.shopping.domain.dto.MiddleCategoryDto;
import com.example.app.shopping.domain.dto.ProductDto;
import com.example.app.shopping.domain.mapper.MiddleCategoryMapper;
import com.example.app.shopping.domain.dto.common.Criteria;
import com.example.app.shopping.domain.service.PaymentService;
import com.example.app.shopping.domain.service.admin.AdminService;
import com.example.app.shopping.domain.service.product.ProductService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping(value = "admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private ProductService productService;

    @Autowired
    private PaymentService paymentService;

    // 관리자 페이지 GET
    @GetMapping("")
    public String getAdminPage() {
        return "admin/admin";
    }

    // 제품 등록 Get
    @GetMapping("addProduct")
    public void getAddProduct(Model model) {
        // 제품 메인 카테고리 List 가져오기
        List<String> majorCategoryList = adminService.getMajorCategoryList();

        // 제품 서브 카테고리 List 가져오기
        List<MiddleCategoryDto> middleCategoryList = adminService.getMiddleCategoryList();

        model.addAttribute("majorCategoryList", majorCategoryList);
        model.addAttribute("middleCategoryList", middleCategoryList);
    }

    // 제품 등록 Post
    @PostMapping("product")
    public ResponseEntity<String> postAddProduct(@RequestPart(value = "mainImage") MultipartFile mainImage,
                                                 @RequestPart(value = "subImage") MultipartFile subImage,
                                                 ProductDto productDto) throws IOException {
        // 제품 등록
        adminService.addProduct(mainImage, subImage, productDto);
        return ResponseEntity.ok("제품 등록이 완료 되었습니다.");
    }

    // 제품 수정 Get
    @GetMapping("modifyProduct")
    public void getModifyProduct(@RequestParam(value = "id", required = false) Long productId,
                                 Model model) {
        // 제품 메인 카테고리 List 가져오기
        List<String> majorCategoryList = adminService.getMajorCategoryList();

        // 제품 서브 카테고리 List 가져오기
        List<MiddleCategoryDto> middleCategoryList = adminService.getMiddleCategoryList();

        // 제품 id로 정보 가져오기
        ProductDto product = adminService.getProductById(productId);

        model.addAttribute("majorCategoryList", majorCategoryList);
        model.addAttribute("middleCategoryList", middleCategoryList);
        model.addAttribute("product", product);
    }

    // 제품 수정 Put
    @PutMapping("product")
    public ResponseEntity<String> putProduct(@RequestPart(value = "mainImage", required = false) MultipartFile mainImage,
                                                 @RequestPart(value = "subImage", required = false) MultipartFile subImage,
                                                 ProductDto productDto) throws IOException {
        // 제품 수정
        adminService.modifyProduct(mainImage, subImage, productDto);
        return ResponseEntity.ok("제품 수정이 완료 되었습니다.");
    }

    @DeleteMapping("product")
    public ResponseEntity<String> deleteProduct(@RequestParam(value = "id") Long id) {
        adminService.deleteProduct(id);

        return ResponseEntity.ok("제품 삭제가 완료 되었습니다.");
    }

    /*
        최근 등록된 상품을 조회하는 페이지로 이동
    */
    @GetMapping("productList")
    public String getProductList(@ModelAttribute Criteria criteria, Model model) {
        Map<String, Object> response = new HashMap<>();

        if (criteria.getPageno() == null) criteria.setPageno(1);
        criteria.setAmount(6);

        try {
            // 서비스 호출
            response = productService.getProductList(criteria);
            model.addAttribute("success", true);
            model.addAttribute("list", response.get("list"));
            model.addAttribute("pageDto", response.get("pageDto"));
        } catch (Exception e) {
            model.addAttribute("success", false);
        }

        return "admin/productList";
    }

    /*
        payment 리스트를 띄워주는 페이지 ( 배송 상태에 따른 )
        payment 테이블의 delivery_status 는 아래의 상태를 가진다
        * 배송준비
        * 배송중
        * 배송완료

        이 중 배송준비, 배송중 상태인 데이터 리스트를 가져와 View 에 뿌려준다.

        View 는
        * 배송준비 상태의 경우
         - 배송중 상태값으로 변경시켜주는 버튼
        * 배송중 상태의 경우
         - 배송완료 상태값으로 변경시켜주는 버튼
        을 추가시키도록 한다.

        이때 상태값 변경에 대한 처리는 하나의 Put Controller 로 처리시킨다.
    */
    @GetMapping("payment/delivery")
    public String getPaymentDeliveryListPage(@ModelAttribute Criteria criteria, Model model) {
        log.info("AdminController's getPaymentDeliveryListPage criteria: {}", criteria);

        // Criteria 초기화
        if (criteria.getPageno() == null) criteria.setPageno(1);
        criteria.setAmount(6);

        try {
            // Payment List 가져오기 ( delivery_status ( "배송준비", "배송중" ) 인 List )
            Map<String, Object> paymentList = paymentService.getAdminPaymentsByDeliveryStatus(criteria);
            model.addAttribute("success", paymentList.get("success"));
            model.addAttribute("list", paymentList.get("list"));
            model.addAttribute("pageDto", paymentList.get("pageDto"));
        } catch (Exception e) {
            model.addAttribute("success", false);
            model.addAttribute("msg", e.getMessage());
        }

        return "admin/payment/delivery";
    }

    /*
        payment 리스트를 띄워주는 페이지 ( 환불 신청에 따른 )
        payment 테이블의 refund_request_status 는 아래의 상태를 가진다

        환불요청상태
        환불 요청: R (Requested)
        환불 상태 없음: N (None, default)
        환불 완료: C (Completed)
        환불 취소: B (Block)
        
        이 중 해당 Controller 요청은 환불 요청: R 인 상태의 Payment 리스트를 가져온다
    */
    @GetMapping("payment/refund")
    public String getPaymentRefundListPage(@ModelAttribute Criteria criteria, Model model) {
        log.info("AdminController's getPaymentRefundListPage criteria: {}", criteria);

        // Criteria 초기화
        if (criteria.getPageno() == null) criteria.setPageno(1);
        criteria.setAmount(6);

        try {
            // Payment List 가져오기 ( refund_request_status 가 "R" 인 List )
            Map<String, Object> paymentList = paymentService.getAdminPaymentsByRefundStatus(criteria);
            model.addAttribute("success", paymentList.get("success"));
            model.addAttribute("list", paymentList.get("list"));
            model.addAttribute("pageDto", paymentList.get("pageDto"));
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("success", false);
            model.addAttribute("msg", e.getMessage());
        }

        return "admin/payment/refund";
    }
}
