package com.example.app.shopping.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductReviewBoardDto {
    private Long id;
    private Long Pid;
    private Long Oid;
    private String Uid;
    private String title;
    private LocalDate regDate;
    private LocalDate updateDate;
    private String content;
    private String imgPath;
    private String imgName;
    private Integer rating;
}
