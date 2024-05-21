package com.example.app.shopping.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInquiryBoardDto {
    private Long id;
    private String Uid;
    private String title;
    private String content;
    private String imgPath;
    private String imgName;
    private Date regDate;
    private Date updateDate;
}
