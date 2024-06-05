package com.example.app.shopping.domain.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductInquiryBoardCommentMapper {
    List<Map<String, Object>> findCommentsByProductInquiryBoardId(@Param("id") Integer id) throws Exception;
}
