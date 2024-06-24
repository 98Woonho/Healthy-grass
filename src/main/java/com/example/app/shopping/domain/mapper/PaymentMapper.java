package com.example.app.shopping.domain.mapper;

import com.example.app.shopping.controller.PaymentController;
import com.example.app.shopping.domain.dto.PaymentDto;
import com.example.app.shopping.domain.dto.common.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface PaymentMapper {
    void save(@Param("paymentDto") PaymentController.RequestDto paymentDto, @Param("userid") String uid, @Param("Oid") Long id);
    List<PaymentDto> searchPayment(String id);
    Integer selectAllCountByUid(@Param("uId") String uId) throws Exception;
    List<Map<String, Object>> selectAllByUid(@Param("criteria") Criteria criteria, @Param("offset") int offset, @Param("uId") String uId) throws Exception;
    int updateRefundStatus(Map<String, Object> request) throws Exception;
    Map<String, Object> selectPaymentById(@Param("id") Object id) throws Exception;
}
