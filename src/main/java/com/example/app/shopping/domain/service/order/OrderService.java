package com.example.app.shopping.domain.service.order;

import com.example.app.shopping.controller.OrderController;
import com.example.app.shopping.domain.dto.UserDto;
import com.example.app.shopping.domain.mapper.CartMapper;
import com.example.app.shopping.domain.mapper.OrderItemMapper;
import com.example.app.shopping.domain.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;

}
