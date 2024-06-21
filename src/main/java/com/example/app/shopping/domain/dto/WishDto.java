package com.example.app.shopping.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishDto {
    private Long id;
    private Long Pid;
    private String Uid;
}
