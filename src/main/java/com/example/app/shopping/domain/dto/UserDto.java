package com.example.app.shopping.domain.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    @NotBlank(message = "Id를 입력하세요")
    @Pattern(regexp = "", message = "아이디는 소문자와 숫자로만 이루어진 6~16자여야 합니다.")
    private String id;

    @NotBlank(message = "비밀번호를 입력하세요")
    private String password;

    @NotBlank(message = "비밀번호 확인 질문 입력하세요")
    private String pwChkHint;

    @NotBlank(message = "비밀번호 확인 답변을 입력하세요")
    private String pwChkAns;

    @NotBlank(message = "우편번호를 입력하세요")
    private String zipcode;

    @NotBlank(message = "주소를 입력하세요")
    private String streetAdr;

    @NotBlank(message = "상세 주소를 입력하세요")
    private String detailAdr;

    @NotBlank(message = "전화번호를 입력하세요")
    private String phone;

    @NotBlank(message = "이메일을 입력하세요")
    @Email(message = "올바른 이메일 형식이어야 합니다.")
    private String email;

    private String role;
    private String provider;
    private String providerId;

}
