package com.example.app.shopping.domain.service.product;

import com.example.app.shopping.domain.dto.common.Criteria;

import java.util.List;
import java.util.Map;

public interface ProductService {
    public Map<String, Object> getItems(Criteria criteria) throws Exception;
    public Map<String, Object> getItemDetail(Integer id) throws Exception;
    Map<String, Object> getPopularProductsByCategory() throws Exception;
    Map<String, Object> getHighDiscountProducts() throws Exception;
    Map<String, Object> getRecentProducts() throws Exception;
    //상품 리스트 가져오는 코드
    Map<String, Object> getProductList(int productId) throws Exception;
    Map<String, Object> getProductList(Criteria criteria) throws Exception;
}
