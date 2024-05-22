package com.example.app.shopping.controller.user;

import com.example.app.shopping.domain.dto.UserDto;
import com.example.app.shopping.domain.service.user.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/user/joinForm")
    public void getJoinForm(){

    }

    @PostMapping("/users")
    @ResponseBody
    public String join(@RequestBody UserDto userDto, BindingResult bindingResult){
//        if(bindingResult.hasFieldErrors()) {
//
//            for(FieldError error  : bindingResult.getFieldErrors()) {
//                log.info("ErrorField : " + error.getField() + " ErrorMsg : " + error.getDefaultMessage());
////                return result.put(error.getField(), error.getDefaultMessage());
//            }
//        }
        return userService.userJoin(userDto);
    }
    // 호텔 등록 시 호텔 이름 중복 확인
    @GetMapping(value = "/user/confirmUserId")
    @ResponseBody
    public String getConfirmHotelName(@RequestParam(value = "id") String id) {
        return userService.confirmUserId(id);
    }
}
