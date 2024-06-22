package com.example.app.shopping.domain.service.orderItem;

import com.example.app.shopping.domain.mapper.OrderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemMapper orderItemMapper;

    public List<Map<String, Object>> getOrderItemsWithProductByOid(Long id) throws Exception  {
        return orderItemMapper.selectOrderItemsWithProductByOid(id);
    }
}
