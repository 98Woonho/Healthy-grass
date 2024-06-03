package com.example.app.shopping.domain.mapper;

import com.example.app.shopping.domain.dto.common.Criteria;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductInquiryBoardMapperTest {
    @Autowired
    private ProductInquiryBoardMapper productInquiryBoardMapper;

    @Test
    public void t1() {
        Criteria criteria = new Criteria();
        int offset = 0;
        criteria.setAmount(10);
        criteria.setCommentChk("true");

        try {
            productInquiryBoardMapper.findProductInquiryBoards(criteria, offset).forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}