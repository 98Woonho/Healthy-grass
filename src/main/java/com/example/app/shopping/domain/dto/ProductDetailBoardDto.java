package com.example.app.shopping.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailBoardDto {
    private Long id;
    private Long Pid;
    private Date regDate;
    private Date updateDate;
    private String content;
    private String imgPath;
    private String imgName;
}
