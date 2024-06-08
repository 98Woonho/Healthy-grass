package com.example.app.shopping.domain.service.cart;

import com.example.app.shopping.domain.dto.UserDto;
import com.example.app.shopping.domain.mapper.CartItemMapper;
import com.example.app.shopping.domain.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private CartItemMapper cartItemMapper;
    public void cartAddNotUserLogin(Integer productId, Integer quantity){
        cartMapper.insertCart();
//        Integer findById = cartMapper.findById();
//        cartMapper.insertCartItem(productId, quantity);
    }

    public void addCartItem(Integer productId, Integer quantity) {

    }

//    @Transactional
    public void cartAddLoignedUser(Integer productId, Integer quantity, String userId) {
        try {
            if (cartMapper.findCartIdByUserId(userId) > 0){
                Integer cartId = cartMapper.findCartIdByUserId(userId);
                cartItemMapper.insertCartItem(cartId, productId, quantity);
            }else {
                cartMapper.insertCartByUserId(userId);
                Integer cartId = cartMapper.findCartIdByUserId(userId);
                cartItemMapper.insertCartItem(cartId, productId, quantity);
            }
        } catch (Exception e){
            System.out.println("오류 발생" + e.getMessage());
            throw e; // 예외 던져 트랜잭션 롤백
        }

    }
}
