package com.example.app.shopping.domain.service.productInquiryBoardComment;

import com.example.app.shopping.domain.dto.ProductInquiryBoardCommentDto;

import java.util.List;
import java.util.Map;

public interface ProductInquiryBoardCommentService {
    List<Map<String, Object>> getComments(Integer id) throws Exception;
    Map<String, Object> postComments(ProductInquiryBoardCommentDto commentDto) throws Exception;
    Map<String, Object> deleteComments(Long id) throws Exception;
}
