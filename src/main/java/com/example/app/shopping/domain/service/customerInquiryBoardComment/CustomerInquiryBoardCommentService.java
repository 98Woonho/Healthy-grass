package com.example.app.shopping.domain.service.customerInquiryBoardComment;

import java.util.List;
import java.util.Map;

public interface CustomerInquiryBoardCommentService {
    List<Map<String, Object>> getComments(Integer id) throws Exception;
}
