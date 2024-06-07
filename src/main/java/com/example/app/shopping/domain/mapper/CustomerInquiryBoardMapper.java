package com.example.app.shopping.domain.mapper;

import com.example.app.shopping.domain.dto.common.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CustomerInquiryBoardMapper {
    int findCustomerInquiryBoardsCount(@Param("criteria") Criteria criteria) throws Exception;
    List<Map<String, Object>> findCustomerInquiryBoards(@Param("criteria") Criteria criteria, @Param("offset") int offset) throws Exception;
    Map<String, Object> findCustomerInquiryBoardById(@Param("id") Integer id) throws Exception;
    int findMyCustomerInquiryBoardsCount(@Param("criteria") Criteria criteria, @Param("uId") String uId) throws Exception;
    List<Map<String, Object>> findMyCustomerInquiryBoards(@Param("criteria") Criteria criteria, @Param("offset") int offset, @Param("uId") String uId) throws Exception;
}
