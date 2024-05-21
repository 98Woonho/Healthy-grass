package com.example.app.shopping.domain.mapper;

import com.example.app.shopping.domain.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    UserDto getUserById(@Param("id") String id);
    void insertUser(UserDto user);
    void updateUser(UserDto user);
    void deleteUserById(@Param("id") String id);
}
