package com.example.app.shopping.domain.mapper;

import com.example.app.shopping.domain.dto.MiddleCategoryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MiddleCategoryMapper {
    List<MiddleCategoryDto> findMiddleCategoryList();
}
