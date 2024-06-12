package com.example.app.shopping.domain.service.productInquiryBoard;

import com.example.app.shopping.domain.dto.ProductInquiryBoardDto;
import com.example.app.shopping.domain.dto.common.Criteria;

import java.util.Map;

public interface productInquiryBoardService {
    public Map<String, Object> getproductInquiryBoards(Criteria criteria) throws Exception;
    public Map<String, Object> getproductInquiryBoardDetail(Integer id) throws Exception;
    public Map<String, Object> getMyProductInquiryBoards(Criteria criteria, String uId) throws Exception;
    public Map<String, Object> getProductInquiryBoardsByPid(Criteria criteria, Integer pId) throws Exception;
    public Map<String, Object> postProductInquiry(ProductInquiryBoardDto boardDto) throws Exception;
}
