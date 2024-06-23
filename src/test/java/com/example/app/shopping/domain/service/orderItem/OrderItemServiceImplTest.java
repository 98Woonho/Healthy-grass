package com.example.app.shopping.domain.service.orderItem;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class OrderItemServiceImplTest {
    @Autowired
    private OrderItemService service;

    @Test
    public void t1() throws Exception {
        Long id = 57L;

        System.out.println(
                service.getOrderItemsWithProductByOid(id)
        );
    }
}