package com.example.app.shopping.domain.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CustomerInquiryBoardCommentMapper {
    List<Map<String, Object>> findCommentsByCustomerInquiryBoardId(@Param("id") Integer id) throws Exception;
}
