package com.example.app.shopping.config.auth.jwt;

/**
 * JWT 기본 설정값
 */
public class JwtProperties {
    public static final int EXPIRATION_TIME =  60*30*1000;; // 60*30초
    public static final String COOKIE_NAME = "JWT-AUTHENTICATION";
}