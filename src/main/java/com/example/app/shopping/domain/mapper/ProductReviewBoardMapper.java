package com.example.app.shopping.domain.mapper;

import com.example.app.shopping.domain.dto.common.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductReviewBoardMapper {
    int findProductReviewBoardsCount(@Param("criteria") Criteria criteria, @Param("pId") Integer pId, @Param("productName") String productName) throws Exception;
    List<Map<String, Object>> findProductReviewBoards(@Param("criteria") Criteria criteria, @Param("offset") int offset, @Param("pId") Integer pId, @Param("productName") String productName) throws Exception;
    Map<String, Object> findProductReviewBoardById(@Param("id") Integer id) throws Exception;
}
