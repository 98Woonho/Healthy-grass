package com.example.app.shopping.domain.mapper;

import com.example.app.shopping.domain.dto.common.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductReviewBoardMapper {
    int findProductReviewBoardsCount(@Param("criteria") Criteria criteria, @Param("pId") Integer pId) throws Exception;
    List<Map<String, Object>> findProductReviewBoards(@Param("criteria") Criteria criteria, @Param("offset") int offset, @Param("pId") Integer pId) throws Exception;
    Map<String, Object> findProductReviewBoardById(@Param("id") Integer id) throws Exception;
    int findMyProductReviewBoardsCount(@Param("criteria") Criteria criteria, @Param("uId") String uId) throws Exception;
    List<Map<String, Object>> findMyProductReviewBoards(@Param("criteria") Criteria criteria, @Param("offset") int offset, @Param("uId") String uId) throws Exception;
}
