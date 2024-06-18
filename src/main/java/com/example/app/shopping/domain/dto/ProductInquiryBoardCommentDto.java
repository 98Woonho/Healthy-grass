package com.example.app.shopping.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInquiryBoardCommentDto {
    private Long id;
    private Long P_Board_Id;
    private String title;
    private String content;
    private LocalDate regDate;
    private LocalDate updateDate;
}
