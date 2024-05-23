package com.example.app.shopping.domain.mapper;

import com.example.app.shopping.domain.dto.ProductDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductMapperTest {
    @Autowired
    private ProductMapper mapper;

    @Test
    public void t1() {
        Date currentDate = new Date();

        ProductDto product = new ProductDto(
                1L,
                "Sample Product",
                2000,
                10,
                5,
                10,
                "Electronics",
                "Mobile",
                currentDate,
                currentDate,
                "/images/sample.png",
                "sample.png"
        );

        mapper.updateProduct(product);
    }
}