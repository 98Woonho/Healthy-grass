package com.example.app.shopping.domain.dto;


import com.example.app.shopping.valid.PasswordMatches;
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
@PasswordMatches
@Builder
public class UserDto {
    @NotBlank(message = "Id를 입력하세요")
    @Pattern(regexp = "^[A-Za-z0-9]{6,16}$")
    private String id;

    @NotBlank(message = "이름을 입력하세요")
    private String name;

    @NotBlank(message = "비밀번호를 입력하세요")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$")
    private String password;

    private String rePassword;

    @NotBlank(message = "우편번호를 입력하세요")
    private String zipcode;

    @NotBlank(message = "주소를 입력하세요")
    private String streetAdr;

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
