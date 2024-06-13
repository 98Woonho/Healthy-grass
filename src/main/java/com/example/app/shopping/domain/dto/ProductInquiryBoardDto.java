package com.example.app.shopping.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInquiryBoardDto {
    private Long id;
    @JsonProperty("Pid")
    private Long Pid;
    private String Uid;
    @JsonProperty("title")
    private String title;
    @JsonProperty("content")
    private String content;
    private LocalDate regDate;
    private LocalDate updateDate;
    @JsonProperty("isLocked")
    private String isLocked;
    @JsonProperty("password")
    private String password;
}
