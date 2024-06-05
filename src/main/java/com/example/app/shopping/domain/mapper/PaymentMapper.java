package com.example.app.shopping.domain.mapper;

import com.example.app.shopping.domain.dto.PaymentDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaymentMapper {

    void save(@Param("paymentDto") PaymentDto paymentDto, @Param("id") String id);

    List<PaymentDto> searchPayment(String id);

}
