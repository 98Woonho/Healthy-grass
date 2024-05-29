package com.example.app.shopping.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private Integer price;
    private Integer discountedPrice;
    private Integer discount;
    private Integer amount;
    private String majorCategory;
    private String middleCategory;
    private String content;
    private Date regDate;
    private Date updateDate;
    private String mainImgPath;
    private String mainImgName;
    private String subImgPath;
    private String subImgName;
}