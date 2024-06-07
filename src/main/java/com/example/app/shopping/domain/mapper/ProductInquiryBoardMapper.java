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
    Map<String, Object> findProductInquiryBoardById(@Param("id") Integer id) throws Exception;
    int findMyProductInquiryBoardsCount(@Param("criteria") Criteria criteria, @Param("uId") String uId) throws Exception;
    List<Map<String, Object>> findMyProductInquiryBoards(@Param("criteria") Criteria criteria, @Param("offset") int offset, @Param("uId") String uId) throws Exception;
    List<Map<String, Object>> findProductInquiryBoardByPid(@Param("criteria") Criteria criteria, @Param("offset") int offset, @Param("pId") Integer pId) throws Exception;
    int findProductInquiryBoardByPidCount(@Param("pId") Integer pId) throws Exception;
}
