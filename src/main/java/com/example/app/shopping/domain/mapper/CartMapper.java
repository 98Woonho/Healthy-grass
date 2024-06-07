package com.example.app.shopping.domain.mapper;

import com.example.app.shopping.domain.dto.CartDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CartMapper {

    void insertCart();

    void insertCart(CartDto cartDto);

    void insertCartItem(@Param("cartId") Integer cartId, @Param("productId") Integer productId, @Param("quantity") Integer quantity);

}
