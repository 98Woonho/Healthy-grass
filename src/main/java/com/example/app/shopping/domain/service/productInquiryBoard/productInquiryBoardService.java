package com.example.app.shopping.domain.service.productInquiryBoard;

import com.example.app.shopping.domain.dto.common.Criteria;

import java.util.Map;

public interface productInquiryBoardService {
    public Map<String, Object> getproductInquiryBoards(Criteria criteria) throws Exception;
    public Map<String, Object> getproductInquiryBoardDetail(Integer id) throws Exception;
}
