package com.example.app.shopping.domain.mapper;

import com.example.app.shopping.domain.dto.CartDto;
import com.example.app.shopping.domain.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CartMapper {
    void insertCart();

    void insertCartByUserId(@Param("userId") String userId);

    Integer findCartIdByUserId(@Param("userId") String userId);
}
