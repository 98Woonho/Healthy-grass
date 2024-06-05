package com.example.app.shopping.domain.service.productReviewBoard;

import com.example.app.shopping.domain.dto.common.Criteria;

import java.util.Map;

public interface ProductReviewBoardService {
    public Map<String, Object> getproductReviewBoards(Criteria criteria, Integer pId) throws Exception;
    public Map<String, Object> getproductReviewBoardDetail(Integer id) throws Exception;
    public Map<String, Object> getMyProductReviewBoards(Criteria criteria, String uId) throws Exception;
}
