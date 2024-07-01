package com.example.app.shopping.controller;

import com.example.app.shopping.config.auth.PrincipalDetails;
import com.example.app.shopping.domain.dto.PaymentDto;
import com.example.app.shopping.domain.service.PaymentService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Controller
@Slf4j
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    private PortOneTokenResponse portOneTokenResponse;

    @Value("${spring.portOne.imp}")
    private String imp;
    @Value("${spring.portOne.imp_key}")
    private String imp_key;
    @Value("${spring.portOne.imp_secret}")
    private String imp_secret;

    @GetMapping("imp")
    public @ResponseBody String getImp() {
        return imp;
    }

    /* 배송상태 변경 */
    @PutMapping("delivery")
    public @ResponseBody Map<String, Object> putPaymentDeliveryStatusById(@RequestBody PutPaymentDeliveryStatusRequestDto request, Authentication authentication) {
        log.info("PaymentController's putPaymentDeliveryStatusById request: {}", request);

        Map<String, Object> response = new HashMap<>();

        if (authentication == null) {
            response.put("success", false);
            response.put("msg", "비회원은 이용할 수 없는 서비스입니다.");

            return response;
        }

        boolean isAdmin = false;

        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        String userName = principalDetails.getUsername();
        Collection<? extends GrantedAuthority> authorities = principalDetails.getAuthorities();
        isAdmin = authorities.stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));

        try {
            // 관리자 권한 체크
            if (!isAdmin) {
                response.put("success", false);
                response.put("msg", "관리자만 사용할 수 있는 기능입니다.");
            } else {
                // payment 수정
                boolean isUpdated = paymentService.putPaymentDeliveryStatusServ(request.getId(), request.getStatus());

                if (isUpdated) {
                    response.put("success", true);
                    response.put("msg", "배송 상태 변경 요청이 성공적으로 처리되었습니다.");
                } else {
                    response.put("success", false);
                    response.put("msg", "배송 상태 변경 요청 처리에 실패하였습니다.");
                }
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("msg", e.getMessage());
        }

        return response;
    }

    @Data
    private static class PutPaymentDeliveryStatusRequestDto {
        @JsonProperty("id")
        private Long id;
        @JsonProperty("status")
        private String status;
    }

    /* 환불 상태 변경 */
    @PutMapping("refund")
    @Transactional
    public @ResponseBody Map<String, Object> putPaymentRefundStatusById(@RequestBody PutPaymentRefundStatusRequestDto request, Authentication authentication) {
        log.info("PaymentController's putPaymentRefundStatusById request: ");

        Map<String, Object> response = new HashMap<>();

        if (authentication == null) {
            response.put("success", false);
            response.put("msg", "비회원은 이용할 수 없는 서비스입니다.");

            return response;
        }

        boolean isAdmin = false;

        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        String userName = principalDetails.getUsername();
        Collection<? extends GrantedAuthority> authorities = principalDetails.getAuthorities();
        isAdmin = authorities.stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));

        try {
            // 관리자 권한 체크
            if (!isAdmin) {
                response.put("success", false);
                response.put("msg", "관리자만 사용할 수 있는 기능입니다.");
            } else {
                // payment 수정
                boolean isUpdated = paymentService.putPaymentRefundStatusServ(request.getId(), request.getStatus());

                if ("C".equals(request.getStatus())) {
                    // 환불 승인 요청이라면
                    Map<String, Object> paymentInfo = paymentService.getPaymentById(request.getId());
                    String impUid = (String) paymentInfo.get("imp_uid");
                    String merchantUid = (String) paymentInfo.get("merchant_uid");
                    cancel(impUid, merchantUid);
                    System.out.println("환불 성공!");
                }

                if (isUpdated) {
                    response.put("success", true);
                    response.put("msg", "환불 상태 변경 요청이 성공적으로 처리되었습니다.");
                } else {
                    response.put("success", false);
                    response.put("msg", "환불 상태 변경 요청 처리에 실패하였습니다.");
                }
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("msg", e.getMessage());
        }

        return response;
    }

    @Data
    private static class PutPaymentRefundStatusRequestDto {
        @JsonProperty("id")
        private Long id;
        @JsonProperty("status")
        private String status;
    }

    @GetMapping("")
    public String payment(Authentication authentication) {
        return "payment/paymentForm";
    }


    @GetMapping("paymentForm")
    public String payment_search(Authentication authentication, Model model) {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        String id = principal.getUserDto().getId();
        List<PaymentDto> paymentDtos = paymentService.searchPayment(id);
        model.addAttribute("payment", paymentDtos);
        return "payment/paymentList";
    }

    //결제 결과값을 db에 저장
    @PostMapping("save")
    @ResponseBody
    public void payment_save(@RequestBody RequestDto request, Authentication authentication) {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        String id = principal.getUserDto().getId();
        log.info("PaymentController's payment_save request: " + request);
        paymentService.payResultSave(request, id);
    }

    @Data
    public static class ProductList {
        public int id;
        public int quantity;
        public int price;
    }

    @Data
    public static class RequestDto{
        public boolean success;
        public String imp_uid;
        public String pay_method;
        public String merchant_uid;
        public String name;
        public int paid_amount;
        public String currency;
        public String pg_provider;
        public String pg_type;
        public String pg_tid;
        public String apply_num;
        public String buyer_name;
        public String buyer_email;
        public String buyer_tel;
        public String buyer_addr;
        public String buyer_postcode;
        public Object custom_data;
        public String status;
        public int paid_at;
        public String receipt_url;
        public Object card_name;
        public Object bank_name;
        public int card_quota;
        public String card_number;
        public ArrayList<ProductList> productList;
    }


    //엑세스 토큰 받기
    @GetMapping("token")
    public @ResponseBody void AccessToken(){
        String url = "https://api.iamport.kr/users/getToken";
        //HEADER
        HttpHeaders headers = new HttpHeaders();

        //PARAM
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("imp_key",imp_key);
        params.add("imp_secret",imp_secret);
        //Entity
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);
        //ENTITY
        //REQUEST
        RestTemplate rt = new RestTemplate();
        ResponseEntity<PortOneTokenResponse> response = rt.exchange(url, HttpMethod.POST, entity, PortOneTokenResponse.class);
        System.out.println(response.getBody());
        //RESPONSE
        this.portOneTokenResponse = response.getBody(); //엑세스 토큰 객체를 넣어줌
    }
    //access토큰 객체
    @Data
    private static class TokenResponse{
        public String access_token;
        public int now;
        public int expired_at;
    }
    @Data
    private static class PortOneTokenResponse{
        public int code;
        public Object message;
        public TokenResponse response;
    }
    //access토큰 객체

    // 결제 취소 요청 // axios로 받기 + 서비스단 구현!!!!!
    @PostMapping("cancel")
    public @ResponseBody void cancel(@RequestParam("imp_uid") String imp_uid, @RequestParam("merchant_uid") String merchant_uid) throws Exception {
        AccessToken();
        log.info("Post /payment/cancel..");
        // access-token 받기

        //URL
        String url = "https://api.iamport.kr/payments/cancel";

        //Request Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Bearer " + portOneTokenResponse.getResponse().getAccess_token());
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        //Request Body
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("imp_uid",imp_uid);
        params.add("merchant_uid", merchant_uid);

        //Hader+Body
        HttpEntity<MultiValueMap<String,String>> entity = new HttpEntity(params,headers);

        //요청
        RestTemplate restTemplate = new RestTemplate();

        //반환값확인
        ResponseEntity<String> resp =  restTemplate.exchange(url, HttpMethod.POST,entity,String.class);

        System.out.println(resp);
        System.out.println(resp.getBody());
    }
}