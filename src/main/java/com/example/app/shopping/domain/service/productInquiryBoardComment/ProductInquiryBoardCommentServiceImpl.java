package com.example.app.shopping.domain.service.productInquiryBoardComment;

import com.example.app.shopping.domain.mapper.ProductInquiryBoardCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductInquiryBoardCommentServiceImpl implements ProductInquiryBoardCommentService {

    @Autowired
    private ProductInquiryBoardCommentMapper mapper;

    @Override
    public List<Map<String, Object>> getComments(Integer id) throws Exception {
        return mapper.findCommentsByProductInquiryBoardId(id);
    }
}
