package com.example.app.shopping.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInquiryBoardDto {
    private Long id;
    private Long Pid;
    private String Uid;
    private String title;
    private String content;
    private Date regDate;
    private Date updateDate;
    private String isLocked;
    private String password;
}
