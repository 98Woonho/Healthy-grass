package com.example.app.shopping.domain.mapper;

import com.example.app.shopping.domain.dto.OrderDto;
import com.example.app.shopping.domain.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

    void save(@Param("orderDto") OrderDto orderDto);
}

