package com.example.app.shopping.domain.service.product;

import com.example.app.shopping.domain.dto.WishDto;
import com.example.app.shopping.domain.dto.ProductDto;
import com.example.app.shopping.domain.dto.common.Criteria;
import com.example.app.shopping.domain.dto.common.PageDto;
import com.example.app.shopping.domain.mapper.ProductMapper;
import com.example.app.shopping.domain.mapper.WishMapper;
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

    @Autowired
    private WishMapper wishMapper;

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

    @Override
    public Map<String, Object> getProductList(int productId) throws Exception {
        return productMapper.findProductById(productId);
    }

    /*
        관리자 상품 리스트 조회 페이지에 사용하는 서비스입니다.
        Criteria 에 있는 내용을 기반으로 상품 리스트 결과를 반환합니다.
    */
    @Override
    public Map<String, Object> getProductList(Criteria criteria) throws Exception {
        Map<String, Object> result = new HashMap<>();

        // 카테고리 정보 초기화
        criteria.setMajorCategory("");
        criteria.setMiddleCategory("");

        // 검색 결과로 나오는 상품의 수 확인
        int count = productMapper.selectItemsCount(criteria);
        PageDto pageDto = new PageDto(count, criteria);

        // 시작 게시물 번호 구하기
        int offset = (criteria.getPageno() - 1) * criteria.getAmount();

        List<Map<String, Object>> list = productMapper.selectAllProducts(criteria, offset);
        result.put("list", list);
        result.put("pageDto", pageDto);

        return result;
    }
}
