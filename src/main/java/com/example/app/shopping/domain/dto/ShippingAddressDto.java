package com.example.app.shopping.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingAddressDto {
    private Long id;
    private String Uid;
    private String recipient_name;
    private String phone;
    private String zipcode;
    private String streetAdr;
    private String detailAdr;
}
