package com.example.app.shopping.controller.user;

import com.example.app.shopping.domain.dto.UserDto;
import com.example.app.shopping.domain.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/joinForm")
    public void getJoinForm(){
        log.info("GET/joinForm");
    }
    @PostMapping("/users")
    @ResponseBody
    public boolean join(@RequestBody UserDto userDto){
        return userService.userJoin(userDto);
    }

}
