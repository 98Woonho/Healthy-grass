package com.example.app.shopping.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersistentLoginsDto {
    private String username;
    private String series;
    private String token;
    private Timestamp last_used;
}
