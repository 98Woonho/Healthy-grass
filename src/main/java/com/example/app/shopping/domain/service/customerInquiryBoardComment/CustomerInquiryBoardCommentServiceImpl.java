package com.example.app.shopping.domain.service.customerInquiryBoardComment;

import com.example.app.shopping.domain.mapper.CustomerInquiryBoardCommentMapper;
import com.example.app.shopping.domain.service.productInquiryBoardComment.ProductInquiryBoardCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerInquiryBoardCommentServiceImpl implements ProductInquiryBoardCommentService {

    @Autowired
    private CustomerInquiryBoardCommentMapper mapper;

    @Override
    public List<Map<String, Object>> getComments(Integer id) throws Exception {
        return mapper.findCommentsByCustomerInquiryBoardId(id);
    }
}
