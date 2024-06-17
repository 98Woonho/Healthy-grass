package com.example.app.shopping.domain.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShippingAddressDto {
    private Long id;
    private String Uid;
    private String name;
    private String phone;
    private String zipcode;
    private String streetAdr;
    private String detailAdr;
    private String shippingText;
}
