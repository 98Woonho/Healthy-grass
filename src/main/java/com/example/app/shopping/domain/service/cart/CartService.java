package com.example.app.shopping.domain.service.cart;

import com.example.app.shopping.domain.dto.UserDto;
import com.example.app.shopping.domain.mapper.CartItemMapper;
import com.example.app.shopping.domain.mapper.CartMapper;
import com.example.app.shopping.domain.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CartService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private CartItemMapper cartItemMapper;

    public String cartAddNotUserLogin(Integer productId, Integer quantity) {
        cartMapper.insertCart();
        return null;
//        Integer findById = cartMapper.findById();
//        cartMapper.insertCartItem(productId, quantity);
    }

    public void addCartItem(Integer productId, Integer quantity) {

    }

    //    @Transactional
    public String cartAddLoignedUser(Integer productId, Integer quantity, String userId) {
        try {
            if (cartMapper.findCartIdByUserId(userId) == null){
                cartMapper.insertCartByUserId(userId); // 유저아이디 등록 // 카트에 유저 등록후
                Integer cartId = cartMapper.findCartIdByUserId(userId);  // 유저아이디 로 카트 아이디 찾아서
                cartItemMapper.insertCartItem(cartId, productId, quantity); //카트 아이디와, 제품아이디, 수량 장바구니에 등록
                //리턴값을 다르게 주어 유저아이디가 없을 땐 그냥 장바구니에 담고 유저아이디가 있을 땐 장바구니로 이동하면 함께 주문된다고 알림주기 나중에 시간있을 때
            }
            else if (cartMapper.findCartIdByUserId(userId) > 0) {//유저가 장바구니에 한번이라도 물건을 담은적이 있으면
                Integer cartId = cartMapper.findCartIdByUserId(userId);
                if (cartItemMapper.findQuantityByProductId(productId) == null){
                    cartItemMapper.insertCartItem(cartId, productId, quantity); //카트 아이디와, 제품아이디, 수량 장바구니에 등록
                } else {
                    Integer quantityByProductId = cartItemMapper.findQuantityByProductId(productId); //수량을 확인하고
                    int sumQuantity = quantity + quantityByProductId; //수량을 더해준다음에
                    Integer CartItemId = cartItemMapper.findIdByProductIdAndCartId(productId, cartId);
                    cartItemMapper.updateCartItem(CartItemId, sumQuantity);
                }
                return "SUCCESS";
            }
            return "SUCCESS";
        } catch (Exception e) { // 오류가 발생시 롤백
            System.out.println("오류 발생" + e.getMessage());
            throw e; // 예외 던져 트랜잭션 롤백
        }
    }

    public List<Map<String, Object>> cartList(String userId) throws Exception {
        Integer cartIdByUserId = cartMapper.findCartIdByUserId(userId);
        List<Integer> productIdByCartId = cartItemMapper.findProductIdByCartId(cartIdByUserId);
        List<Map<String, Object>> productList = new ArrayList<>();
        productIdByCartId.forEach(productId -> {
            productList.addAll(cartItemMapper.findProductListById(productId));
        });
        return productList;
    }
}
