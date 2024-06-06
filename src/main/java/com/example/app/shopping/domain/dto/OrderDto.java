package com.example.app.shopping.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private String Uid;
    private Integer total_amount;
    private String status;
    private String name;
    private Integer price;
    private Integer discount;
    private String mainImgPath;
    private String mainImgName;
    private Integer amount;
    private Integer discountedPrice;
    private Integer totalPrice;
    private String productUrl;
}

