package com.example.app.shopping.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
    private String buyer_addr; //구매자 주소
    private String buyer_email; //구매자 이메일
    private String buyer_name; //구매자 이름
    private String buyer_postcode; //구매자 우편번호
    private String buyer_tel; //구매자 연락처
    private String card_name; //사용 카드
    private String imp_uid; //
    private String merchant_uid; //
    private String name; // 결제 상품 이름
    private int paid_amount; //결제금액
    private int paid_at; //결제 날짜
    private String pg_type; // 결제 타입
    private String pay_method; //
    private String status;
    private Date regDate;
    private Date updateDate;
}
