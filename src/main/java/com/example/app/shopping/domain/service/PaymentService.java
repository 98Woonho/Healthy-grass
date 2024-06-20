package com.example.app.shopping.domain.service;

import com.example.app.shopping.domain.dto.PaymentDto;
import com.example.app.shopping.domain.dto.common.Criteria;
import com.example.app.shopping.domain.dto.common.PageDto;
import com.example.app.shopping.domain.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public boolean putPaymentServ(Map<String, Object> request) throws Exception {
        int putReturnVal = paymentMapper.updateRefundStatus(request);

        return putReturnVal > 0 ? true : false;
    }

    public Map<String, Object> getPaymentById(Object id) throws Exception {
        Map<String, Object> userPayment = paymentMapper.selectPaymentById(id);

        return userPayment != null ? userPayment : new HashMap<>();
    }
}
