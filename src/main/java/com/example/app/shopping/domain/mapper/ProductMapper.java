package com.example.app.shopping.domain.mapper;

import com.example.app.shopping.domain.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductDto getProductById(Long id);
    public List<ProductDto> getProductsBySearch(String name, String majorCategory, String middleCategory, String orderBy, int offset, int size) throws Exception;
    void insertProduct(ProductDto product);
    void updateProduct(ProductDto product);
    int getProductCountBySearch(
            @Param("name") String name,
            @Param("majorCategory") String majorCategory,
            @Param("middleCategory") String middleCategory
    ) throws Exception;
}
