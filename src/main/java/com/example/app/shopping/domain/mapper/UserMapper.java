package com.example.app.shopping.domain.mapper;

import com.example.app.shopping.domain.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    UserDto getUserById(@Param("id") String id);

    int insertUser(UserDto userDto);

    int updateUser(UserDto user);

    int deleteUserById(@Param("id") String id);

    List<String> findUserIdByEmailAndUserName(@Param("email") String id,
                                              @Param("name") String name);

}
