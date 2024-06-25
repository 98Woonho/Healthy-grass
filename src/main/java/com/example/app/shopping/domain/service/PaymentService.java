package com.example.app.shopping.domain.service;

import com.example.app.shopping.controller.PaymentController;
import com.example.app.shopping.domain.dto.OrderDto;
import com.example.app.shopping.domain.dto.OrderItemDto;
import com.example.app.shopping.domain.dto.PaymentDto;
import com.example.app.shopping.domain.dto.common.Criteria;
import com.example.app.shopping.domain.dto.common.PageDto;
import com.example.app.shopping.domain.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private CartItemMapper cartItemMapper;
    @Autowired
    private ProductMapper productMapper;

    public void payResultSave(PaymentController.RequestDto paymentDto, String uid) {
        try {
            OrderDto orderInfo = new OrderDto();
            orderInfo.setUid(uid);
            orderInfo.setTotal_amount(paymentDto.getPaid_amount());
            orderMapper.save(orderInfo);
            Long id = orderInfo.getId(); // AutoIncrement 값 가져오기
            Integer cartId = cartMapper.findCartIdByUserId(uid);
            for (PaymentController.ProductList product : paymentDto.getProductList()) {

                OrderItemDto orderItemDto = new OrderItemDto();
                orderItemDto.setOid(id);
                orderItemDto.setPid((long) product.getId());
                orderItemDto.setQuantity(product.getQuantity());
                orderItemDto.setPrice(product.getPrice());
                orderItemMapper.save(orderItemDto);

                //재고 빼주는 로직
                Long orderItemId = orderItemDto.getId();
                cartItemMapper.deleteCartItemByCartIdAndProductId(cartId, product.getId());
                System.out.println("orderItemId : " +orderItemId);
                long quantity = orderItemMapper.findQuantityByorderId(orderItemId);
                int ProductAmount = productMapper.findAmountByProductId(product.getId());
                long amount = ProductAmount - quantity;

                System.out.println(amount);
                productMapper.updateProductAmount(product.getId(), amount);
            }
            paymentMapper.save(paymentDto, uid, id);

        } catch (Exception e) {
            throw new RuntimeException("결제 처리 중 오류 발생: " + e.getMessage(), e);
        }
    }

    public List<PaymentDto> searchPayment(String id) {
        return paymentMapper.searchPayment(id);
    }

    /*
        Payment 리스트를 조회할 때 사용하는 서비스
    */
    public Map<String, Object> getMyPayments(Criteria criteria, String uId) throws Exception {
        Map<String, Object> result = new HashMap<>();

        // 검색 결과로 나오는 상품의 수 확인
        int count = paymentMapper.selectAllCountByUid(uId);

        PageDto pageDto = new PageDto(count, criteria);

        // 시작 게시물 번호 구하기
        int offset = (criteria.getPageno() - 1) * criteria.getAmount();

        List<Map<String, Object>> list = paymentMapper.selectAllByUid(criteria, offset, uId);

        result.put("list", list);
        result.put("pageDto", pageDto);

        return result;
    }

    /*
        환불요청상태 변경 서비스
        환불 요청: R (Requested)
        환불 상태 없음: N (None, default)
        환불 완료: C (Completed)
     */
    public boolean putPaymentServ(Map<String, Object> request) throws Exception {
        int putReturnVal = paymentMapper.updateRefundStatus(request);

        return putReturnVal > 0 ? true : false;
    }

    public Map<String, Object> getPaymentById(Object id) throws Exception {
        Map<String, Object> userPayment = paymentMapper.selectPaymentById(id);

        return userPayment != null ? userPayment : new HashMap<>();
    }
}
