package com.example.app.shopping.controller.user;

import com.example.app.shopping.domain.dto.UserDto;
import com.example.app.shopping.domain.service.user.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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

    @GetMapping("/user/loginForm")
    public void getLoginForm(Authentication authentication){
        System.out.println("authentication" + authentication );
    }
    @PostMapping("/user/login")
    public String postLogin(){

        return "redirect:/";
    }

    //회원가입 폼으로 이동
    @GetMapping("/user/joinForm")
    public void getJoinForm(){

    }

    //회원가입
    @PostMapping("/users")
    @ResponseBody
    public ResponseEntity<String> join(@Valid @RequestBody UserDto userDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            // 유효성 검사 실패 시 오류 메시지 알려줌
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage())
            );

            return new ResponseEntity<>("FAIL", HttpStatus.BAD_GATEWAY);
        }
        System.out.println(bindingResult.hasErrors());
        return new ResponseEntity<>(userService.userJoin(userDto), HttpStatus.OK);
    }
    // 유저 등록시 유저 중복확인
    @GetMapping(value = "/user/confirmUserId")
    @ResponseBody
    public String getConfirmHotelName(@RequestParam(value = "id") String id) {
        return userService.confirmUserId(id);
    }
}
