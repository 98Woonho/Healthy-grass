package com.example.app.shopping.domain.service.productInquiryBoardComment;

import java.util.List;
import java.util.Map;

public interface ProductInquiryBoardCommentService {
    List<Map<String, Object>> getComments(Integer id) throws Exception;
}
