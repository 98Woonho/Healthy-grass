package com.example.app.shopping.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInquiryCommentDto {
    private Long id;
    private Long C_Board_id;
    private String title;
    private String comment;
    private String imgPath;
    private String imgName;
    private LocalDate regDate;
    private LocalDate updateDate;
}
