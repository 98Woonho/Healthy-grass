package com.example.app.shopping.domain.mapper;

import com.example.app.shopping.domain.dto.OrderItemDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderItemMapper {
    // Oid 를 사용하여 OrderItems list 를 조회한다. 이 때, product 의 일부 요소도 같이 조회한다 (join)
    List<Map<String, Object>> selectOrderItemsWithProductByOid(Long id) throws Exception;

    void save(OrderItemDto orderItemDto);

    long findQuantityByorderId(@Param("orderItemId") Long orderItemId);
}
