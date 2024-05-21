package com.example.app.shopping.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MybatisConfigTest {

    @Autowired
    private DataSource dataSource;
    @Test
    public void t1() throws SQLException {
        System.out.println(dataSource);
        System.out.println(dataSource.getConnection());
    }

}




