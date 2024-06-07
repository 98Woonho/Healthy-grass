package com.example.app.shopping.domain.service.cart;

import com.example.app.shopping.domain.dto.UserDto;
import com.example.app.shopping.domain.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CartMapper cartMapper;
    public void cartAddNotUserLogin(Integer productId, Integer quantity){
        cartMapper.insertCart();
//        Integer findById = cartMapper.findById();
//        cartMapper.insertCartItem(productId, quantity);
    }

    public void addCartItem(Integer productId, Integer quantity) {

    }

    public void addCart(Integer productId, Integer quantity, UserDto userDto) {

    }
}
