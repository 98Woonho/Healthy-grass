package com.example.app.shopping.domain.mapper;

import com.example.app.shopping.domain.dto.common.Criteria;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductReviewBoardMapperTest {
    @Autowired
    private ProductReviewBoardMapper mapper;

    @Test
    public void t1() {

        Criteria criteria
                = new Criteria();

        criteria.setAmount(10);
        criteria.setPageno(1);

        int offset = 0;

        try {
            System.out.println(mapper.findProductReviewBoardById(163));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}