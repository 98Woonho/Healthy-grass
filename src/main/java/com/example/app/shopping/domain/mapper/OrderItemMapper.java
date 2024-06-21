package com.example.app.shopping.domain.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderItemMapper {
    // Oid 를 사용하여 OrderItems list 를 조회한다. 이 때, product 의 일부 요소도 같이 조회한다 (join)
    List<Map<String, Object>> selectOrderItemsWithProductByOid(Long id) throws Exception;

    // oId, pId 를 사용하여 OrderItem 을 조회한다
    Map<String, Object> selectOrderItemByoIdAndpId(@Param("oId") Long oId, @Param("pId") Long pId) throws Exception;
    
    // 리뷰 등록 상태를 변경한다
    Integer updateReviewStatus(String status) throws Exception;
}
