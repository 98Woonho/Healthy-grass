package com.example.app.shopping.domain.mapper;

import com.example.app.shopping.domain.dto.ProductDto;
import com.example.app.shopping.domain.dto.common.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {
    int selectItemsCount(@Param("criteria") Criteria criteria) throws Exception;
    List<Map<String, Object>> selectItems(@Param("criteria") Criteria criteria, @Param("offset") int offset) throws Exception;


    List<String> selectDistinctMajorCategoryList();
}