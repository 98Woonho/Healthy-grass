package com.example.app.shopping.domain.service.product;

import com.example.app.shopping.domain.dto.ProductDto;

import java.util.List;

public interface ProductService {
    public boolean addProduct(ProductDto productDto) throws Exception;
    public boolean updateProduct(ProductDto productDto) throws Exception;
    ProductDto getProductById(Long id);
    public List<ProductDto> getProductsBySearch(String name, String majorCategory, String middleCategory, String orderBy, int page, int size) throws Exception;
}
