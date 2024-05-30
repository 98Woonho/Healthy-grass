package com.example.app.shopping.domain.mapper;

import com.example.app.shopping.domain.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    UserDto getUserById(@Param("id") String id);

    int insertUser(UserDto userDto);

    int updateUser(UserDto user);

    int updateUserPassword(@Param("password") String password,
                           @Param("id") String id);

    int deleteUserById(@Param("id") String id);

    String findUserIdByEmailAndUserName(@Param("email") String id,
                                              @Param("name") String name);

    String findUserIdByPhoneAndUserName(@Param("phone") String phone,
                                              @Param("name") String name);

    String findUserPasswordByEmailAndUserId(@Param("email") String email,
                                            @Param("id") String id);

    String findUserEmailByUsernameAndUserPhone(@Param("name") String name,
                                             @Param("phone") String phone);

}
