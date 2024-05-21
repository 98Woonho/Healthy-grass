package com.example.app.shopping.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
    private Long id;
    private Long Oid;
    private Integer amount;
    private String payment_method;
    private String status;
    private String transaction_id;
    private Date regDate;
    private Date updateDate;
}
