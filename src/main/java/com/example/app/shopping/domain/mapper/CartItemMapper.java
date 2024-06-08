package com.example.app.shopping.domain.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CartItemMapper {

    void insertCartItem(@Param("cartId") Integer cartId, @Param("productId") Integer productId, @Param("quantity") Integer quantity);
}
