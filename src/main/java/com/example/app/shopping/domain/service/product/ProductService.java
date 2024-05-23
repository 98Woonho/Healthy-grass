package com.example.app.shopping.domain.service.product;

import com.example.app.shopping.domain.dto.ProductDto;

public interface ProductServiceImpl {
    public boolean addProduct(ProductDto productDto) throws Exception;
    public boolean updateProduct(ProductDto productDto) throws Exception;
}
