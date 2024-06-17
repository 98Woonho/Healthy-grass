package com.example.app.shopping.domain.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CartItemMapper {

    void insertCartItem(@Param("cartId") Integer cartId, @Param("productId") Integer productId, @Param("quantity") Integer quantity);

    int findProductIdByCartIdAndAmountAndProductId(@Param("cartId") Integer cartId, @Param("quantity") Integer quantity, @Param("productId") Integer productId);

    Integer findQuantityByProductIdAndCardId(@Param("productId") Integer productId, @Param("cartId") Integer cartId);

    Integer findIdByProductIdAndCartId(@Param("productId") Integer productId, @Param("cartId") Integer cartId);

    void updateAddSumQuantityByCartItem(@Param("cartItemId") Integer cartItemId, @Param("sumQuantity") int sumQuantity);

    List<Map<String, Object>> findProductListById(@Param("userId") String userId);

    void updateQuantityByCartIdAndProductId(@Param("cartId") int cartId, @Param("productId") int productId, @Param("amountValue") int amountValue);

    void deleteCartItemByCartIdAndProductId(@Param("cartId") int cartId, @Param("productId") int productId);
}
