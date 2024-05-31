package com.example.app.shopping.domain.mapper;

import com.example.app.shopping.domain.dto.common.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductInquiryBoardMapper {
    int findProductInquiryBoardsCount(@Param("criteria") Criteria criteria) throws Exception;
    List<Map<String, Object>> findProductInquiryBoards(@Param("criteria") Criteria criteria, @Param("offset") int offset) throws Exception;
}
