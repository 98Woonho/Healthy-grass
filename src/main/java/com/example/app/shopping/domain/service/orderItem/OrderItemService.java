package com.example.app.shopping.domain.service.orderItem;

import java.util.List;
import java.util.Map;

public interface OrderItemService {
    List<Map<String, Object>> getOrderItemsWithProductByOid(Long id) throws Exception;
}
