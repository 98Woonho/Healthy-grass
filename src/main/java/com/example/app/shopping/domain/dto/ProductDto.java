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
    private Integer amount;
    private Integer saleAmount;
    private Integer discount;
    private String majorCategory;
    private String middleCategory;
    private Date regDate;
    private Date updateDate;
    private String mainImgPath;
    private String mainImgName;
    private String subImgPath;
    private String subImgName;
}