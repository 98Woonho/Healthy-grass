package com.example.app.shopping.domain.service.product;

import com.example.app.shopping.domain.dto.common.Criteria;

import java.util.Map;

public interface ProductService {
    public Map<String, Object> getItems(Criteria criteria) throws Exception;
    public Map<String, Object> getItemDetail(Integer id) throws Exception;
    Map<String, Object> getPopularProductsByCategory() throws Exception;
    Map<String, Object> getHighDiscountProducts() throws Exception;
    Map<String, Object> getRecentProducts() throws Exception;
}
