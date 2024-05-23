package com.example.app.shopping.domain.service.product;

import com.example.app.shopping.domain.dto.ProductDto;
import com.example.app.shopping.domain.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Transactional
    public boolean addProduct(ProductDto productDto) {
        try {
            productMapper.insertProduct(productDto);
            return true; // 삽입 성공
        } catch (Exception e) {
            e.printStackTrace();
            return false; // 삽입 실패
        }
    }

    @Transactional
    public boolean updateProduct(ProductDto productDto) {
        try {
            productMapper.updateProduct(productDto);
            return true; // 수정 성공
        } catch (Exception e) {
            e.printStackTrace();
            return false; // 수정 실패
        }
    }
}
