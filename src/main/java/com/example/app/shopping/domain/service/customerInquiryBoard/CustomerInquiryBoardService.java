package com.example.app.shopping.domain.service.customerInquiryBoard;

import com.example.app.shopping.domain.dto.common.Criteria;

import java.util.Map;

public interface CustomerInquiryBoardService {
    public Map<String, Object> getCustomerInquiryBoards(Criteria criteria) throws Exception;
    public Map<String, Object> getCustomerInquiryBoardDetail(Integer id) throws Exception;
}
