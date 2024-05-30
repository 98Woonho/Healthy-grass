package com.example.app.shopping.domain.service.admin;

import com.example.app.shopping.domain.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private ProductMapper productMapper;

    public List<String> getProductMajorCategoryList() {
        return productMapper.selectDistinctMajorCategoryList();
    }

    public List<String> getProductMiddleCategoryList() {
        return productMapper.selectDistinctMiddleCategoryList();
    }
}
