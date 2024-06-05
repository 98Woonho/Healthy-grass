package com.example.app.shopping.domain.service.product;

import com.example.app.shopping.domain.dto.common.Criteria;
import com.example.app.shopping.domain.dto.common.PageDto;
import com.example.app.shopping.domain.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    // 상품리스트 조회 (페이징 처리)
    @Override
    @Transactional
    public Map<String, Object> getItems(Criteria criteria) throws Exception {
        // 검색 결과로 나오는 상품의 수 확인
        int count = productMapper.selectItemsCount(criteria);
        PageDto pageDto = new PageDto(count, criteria);

        // 시작 게시물 번호 구하기
        int offset = (criteria.getPageno() - 1) * criteria.getAmount();

        List<Map<String, Object>> list = productMapper.selectItems(criteria, offset);

        Map<String, Object> returnVal = new HashMap<>();
        returnVal.put("list", list);
        returnVal.put("pageDto", pageDto);

        return returnVal;
    }

    // 상품 단건조회 (상품정보 상세조회를 위해 리뷰수, 평점 데이터도 같이 가져옵니다)
    @Override
    @Transactional
    public Map<String, Object> getItemDetail(Integer id) throws Exception {
         return productMapper.findProductById(id);
    }

    // 카테고리별 인기상품을 12건씩 데이터를 담아 반환합니다.
    @Override
    @Transactional
    public Map<String, Object> getPopularProductsByCategory() throws Exception {
        Map<String, Object> result = new HashMap<>();

        List<Map<String, Object>> riceProducts = productMapper.findByRiceProducts();
        List<Map<String, Object>> fruitVegetableProducts = productMapper.findByFruitVegetableProducts();
        List<Map<String, Object>> meatProducts = productMapper.findByMeatProducts();
        List<Map<String, Object>> healthProducts = productMapper.findByHealthProducts();
        List<Map<String, Object>> processedFoodProducts = productMapper.findByProcessedFoodProducts();
        List<Map<String, Object>> allCategoryProducts = productMapper.findByAllCategoryProducts();

        result.put("riceProducts", riceProducts);
        result.put("fruitVegetableProducts", fruitVegetableProducts);
        result.put("meatProducts", meatProducts);
        result.put("healthProducts", healthProducts);
        result.put("processedFoodProducts", processedFoodProducts);
        result.put("allCategoryProducts", allCategoryProducts);

        return result;
    }

    // 할인률이 높은 인기상품 12건을 담아 반환합니다.
    @Override
    @Transactional
    public Map<String, Object> getHighDiscountProducts() throws Exception {
        Map<String, Object> result = new HashMap<>();

        List<Map<String, Object>> products = productMapper.findByHighDiscountProducts();

        result.put("products", products);

        return result;
    }

    // 최신 상품 12건을 담아 반환합니다.
    @Override
    @Transactional
    public Map<String, Object> getRecentProducts() throws Exception {
        Map<String, Object> result = new HashMap<>();

        List<Map<String, Object>> products = productMapper.findByRecentProducts();

        result.put("products", products);

        return result;
    }
}
