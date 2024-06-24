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

    List<String> findProductList();

    ProductDto findProductById1(Long id);

    Map<String, Object> findProductById(@Param("id") Integer id) throws Exception;

    // 카테고리 전체에서 인기 상품들을 조회하는 메서드
    List<Map<String, Object>> findByAllCategoryProducts() throws Exception;

    // '쌀/잡곡' 카테고리의 상품들을 조회하는 메서드
    List<Map<String, Object>> findByRiceProducts() throws Exception;

    // '과일/채소' 카테고리의 상품들을 조회하는 메서드
    List<Map<String, Object>> findByFruitVegetableProducts() throws Exception;

    // '축산물' 카테고리의 상품들을 조회하는 메서드
    List<Map<String, Object>> findByMeatProducts() throws Exception;

    // '건강식품' 카테고리의 상품들을 조회하는 메서드
    List<Map<String, Object>> findByHealthProducts() throws Exception;

    // '가공식품' 카테고리의 상품들을 조회하는 메서드
    List<Map<String, Object>> findByProcessedFoodProducts() throws Exception;

    // 할인률이 높은 상품 12개 조회하는 메서드
    List<Map<String, Object>> findByHighDiscountProducts() throws Exception;

    // 최신 상품 12개 조회하는 메서드
    List<Map<String, Object>> findByRecentProducts() throws Exception;

    int findAmountByProductId(@Param("productId") int productId);

    void insertProduct(ProductDto productDto);

    void updateProduct(ProductDto productDto);

    void deleteProduct(@Param("id") Long id);

    List<Map<String, Object>> selectAllProducts(@Param("criteria") Criteria criteria, @Param("offset") int offset) throws Exception;
}