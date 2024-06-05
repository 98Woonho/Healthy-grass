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

        criteria.setType("title");
        criteria.setKeyword("Excellent");

        int offset = 0;

        try {
            mapper.findMyProductReviewBoards(criteria, offset, "user12").forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}