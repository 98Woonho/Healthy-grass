package com.example.app.shopping.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemsDto {
    private Long id;
    private Long Cart_Id;
    private Long Pid;
    private Integer quantity;
}
