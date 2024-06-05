package com.example.app.shopping.domain.service;

import com.example.app.shopping.domain.dto.PaymentDto;
import com.example.app.shopping.domain.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    PaymentMapper paymentMapper;

    public void payResultSave(PaymentDto paymentDto, String id) {
        // 등록 날짜정보랑 수정 한 정보 set으로 넣기
        paymentMapper.save(paymentDto, id);
    }

    public List<PaymentDto> searchPayment(String id) {
        return paymentMapper.searchPayment(id);
    }
}
