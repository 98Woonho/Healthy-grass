package com.example.app.shopping.controller;

import com.example.app.shopping.config.auth.PrincipalDetails;
import com.example.app.shopping.domain.dto.PaymentDto;
import com.example.app.shopping.domain.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("")
    public String payment(Authentication authentication) {
        return "/payment/paymentForm";
    }

    @GetMapping("/paymentForm")
    public String payment_search(Authentication authentication, Model model) {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        String id = principal.getUserDto().getId();
        List<PaymentDto> paymentDtos = paymentService.searchPayment(id);
        model.addAttribute("payment", paymentDtos);
        return "payment/paymentList";
    }

    //결제 결과값을 db에 저장
    @PostMapping("/save")
    @ResponseBody
    public void payment_save(@RequestBody PaymentDto paymentDto, Authentication authentication) {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        String id = principal.getUserDto().getId();
        System.out.println(paymentDto);

        paymentService.payResultSave(paymentDto, id);
    }


}
