package com.example.app.shopping.domain.service.user;

import com.example.app.shopping.domain.dto.UserDto;
import com.example.app.shopping.domain.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private boolean isUserExists(String id) {
        UserDto selectUserById = userMapper.getUserById(id);
        //만약 유저를 조회해서 유저가 있다면 false 없다면 true 반환
        return selectUserById == null;
    }

    public String userJoin(UserDto userDto) {
        if (!isUserExists(userDto.getId())) {
            return "FAILURE_DUPLICATED_USER_ID";
        } else {
            UserDto result = UserDto.builder()
                    .id(userDto.getId())
                    .phone(userDto.getPhone())
                    .email(userDto.getEmail())
                    .pwChkAns(userDto.getPwChkAns())
                    .pwChkHint(userDto.getPwChkHint())
                    .password(passwordEncoder.encode(userDto.getPassword()))
                    .streetAdr(userDto.getStreetAdr())
                    .zipcode(userDto.getZipcode())
                    .detailAdr(userDto.getDetailAdr())
                    .role("ROLE_USER")
                    .build();
            userMapper.insertUser(result);
            return "SUCCESS";
        }
    }

    public String confirmUserId(String id) {
        UserDto UserId = userMapper.getUserById(id);
        if (UserId != null && UserId.getId().equals(id)) {
            return "FAILURE_DUPLICATED_USER_ID";
        }
        return "SUCCESS";
    }
}
