package com.example.app.shopping.domain.mapper;

import com.example.app.shopping.domain.dto.ProductInquiryBoardCommentDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductInquiryBoardCommentMapper {
    List<Map<String, Object>> findCommentsByProductInquiryBoardId(@Param("id") Integer id) throws Exception;
    Integer insertProductInquiryBoardComment(ProductInquiryBoardCommentDto commentDto) throws Exception;
    Integer deleteCommentById(@Param("id") Long id) throws Exception;
}
