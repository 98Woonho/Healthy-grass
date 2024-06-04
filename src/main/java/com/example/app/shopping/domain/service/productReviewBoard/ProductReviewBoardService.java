package com.example.app.shopping.domain.service.productReviewBoard;

import com.example.app.shopping.domain.dto.common.Criteria;

import java.util.Map;

public interface ProductReviewBoardService {
    public Map<String, Object> getproductReviewBoards(Criteria criteria, Integer pId, String productName) throws Exception;
    public Map<String, Object> getproductReviewBoardDetail(Integer id) throws Exception;
}
