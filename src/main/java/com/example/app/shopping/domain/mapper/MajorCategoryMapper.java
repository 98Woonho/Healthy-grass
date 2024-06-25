package com.example.app.shopping.domain.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MajorCategoryMapper {
    List<String> findMajorCategoryList();
}
