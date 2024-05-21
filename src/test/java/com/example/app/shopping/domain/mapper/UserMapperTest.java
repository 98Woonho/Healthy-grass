package com.example.app.shopping.domain.mapper;

import com.example.app.shopping.domain.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    void getUserById() {
        // Arrange
        String userId = "testUser";
        UserDto userDto = new UserDto();
        userDto.setId(userId);

    }

    @Test
    public void insertUser() {
        // Arrange
        UserDto userDto = new UserDto();
        userDto.setId("testUser");
        try {
            userMapper.insertUser(userDto);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(userDto);
    }


}
