package com.example.app.shopping.domain.service.product;

import com.example.app.shopping.domain.dto.ProductDto;
import com.example.app.shopping.domain.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Transactional
    @Override
    public ProductDto getProductById(Long id) {
        return productMapper.getProductById(id);
    }

    @Transactional
    @Override
    public List<ProductDto> getProductsBySearch(String name, String majorCategory, String middleCategory, String orderBy, int page, int size) throws Exception {
        int offset = (page - 1) * size;
        return productMapper.getProductsBySearch(name, majorCategory, middleCategory, orderBy, offset, size);
    }

    @Transactional
    @Override
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
    @Override
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
