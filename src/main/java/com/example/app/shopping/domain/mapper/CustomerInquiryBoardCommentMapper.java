package com.example.app.shopping.domain.mapper;

import com.example.app.shopping.domain.dto.CustomerInquiryCommentDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CustomerInquiryBoardCommentMapper {
    List<Map<String, Object>> findCommentsByCustomerInquiryBoardId(@Param("id") Integer id) throws Exception;
    int insertComment(CustomerInquiryCommentDto commentDto) throws Exception;
    CustomerInquiryCommentDto selectCustomerInquiryCommentById(Long id) throws Exception;
    int deleteCustomerInquiryComment(Long id) throws Exception;
}
