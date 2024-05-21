package com.example.app.shopping.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String id;
    private String password;
    private String pwChkHint;
    private String pwChkAns;
    private String zipcode;
    private String streetAdr;
    private String detailAdr;
    private String phone;
    private String email;
    private String role;
    private String provider;
    private String providerId;
}
