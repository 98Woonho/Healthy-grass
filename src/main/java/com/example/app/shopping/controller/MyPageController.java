package com.example.app.shopping.controller;

import com.example.app.shopping.config.auth.PrincipalDetails;
import com.example.app.shopping.domain.dto.UserDto;
import com.example.app.shopping.domain.service.user.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/myPage")
public class MyPageController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public String myPage(Authentication authentication){
        if (authentication != null) {
            return "/myPage/mypage";
        }
        return "redirect:/user/loginForm";
    }

    @GetMapping("/user/searchForm") //회원정보 조회
    public String userSearchForm(Authentication authentication, Model model) {
        if (authentication != null) {
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal(); // authentication안에 userDto를 꺼내려면 PrincipalDetails안에 들어있는 userDto의 정보를 꺼내와야한다.
            UserDto userDto = principalDetails.getUserDto();
            model.addAttribute("userDto", userDto);
            return "/myPage/searchForm";
        } else {
            return "redirect:/user/loginForm";
        }
    }

    @GetMapping("/user/modifyForm") // 회원정보 수정 페이지로 가기
    public String userModifyForm(Authentication authentication, Model model) {
        if (authentication != null && passwordCheck) {
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
            // authentication안에 userDto를 꺼내려면 PrincipalDetails안에 들어있는 userDto의 정보를 꺼내와야한다.
            UserDto userDto = principalDetails.getUserDto();
            model.addAttribute("userDto", userDto);
            return "/myPage/modifyForm";
        } else if (authentication != null){
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
            // authentication안에 userDto를 꺼내려면 PrincipalDetails안에 들어있는 userDto의 정보를 꺼내와야한다.
            UserDto userDto = principalDetails.getUserDto();
            model.addAttribute("userDto", userDto);
            model.addAttribute("tmp", "modify");
            return "/myPage/passwordCheckForm";
        }
        return "redirect:/user/loginForm";
    }

    @PostMapping("/user/modify") // 회원정보 수정
    public @ResponseBody ResponseEntity<String> userModify(@Valid @RequestBody UserDto userDto, BindingResult bindingResult) {
        System.out.println(userDto);
        if (bindingResult.hasErrors()) {
            // 유효성 검사 실패 시 오류 메시지 알려줌
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage())
            );
            return new ResponseEntity<>("FAIL", HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(userService.userUpdate(userDto), HttpStatus.OK);
    }

    @GetMapping("/user/deleteForm") // 회원정보 삭제 페이지로 가기
    public String userDeleteForm(Authentication authentication, Model model) {
        if (authentication != null && passwordCheck) {
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
            // authentication안에 userDto를 꺼내려면 PrincipalDetails안에 들어있는 userDto의 정보를 꺼내와야한다.
            UserDto userDto = principalDetails.getUserDto();
            model.addAttribute("userDto", userDto);
            return "/myPage/deleteForm";}
        else if (authentication != null) {
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
            // authentication안에 userDto를 꺼내려면 PrincipalDetails안에 들어있는 userDto의 정보를 꺼내와야한다.
            UserDto userDto = principalDetails.getUserDto();
            model.addAttribute("userDto", userDto);
            model.addAttribute("tmp", "delete");
            return "/myPage/passwordCheckForm";
        }
        return "redirect:/user/loginForm";
    }

    @DeleteMapping("/user/delete")
    public @ResponseBody String userDelete(@RequestParam String id, HttpServletRequest request, HttpServletResponse response) {
        String result = userService.deleteUser(id);
        if (result.equals("SUCCESS")) {
            // 삭제 시 세션과 인증 정보를 무효화하여 보안강화를 하기 위한 목적.
            SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
            logoutHandler.logout(request, response, SecurityContextHolder.getContext().getAuthentication());
            return result;
        }
        return result;
    }

    //유저 패스워드 재확인 폼으로 이동
    @GetMapping("/user/passwordCheckForm")
    public String passwordCheckForm(Authentication authentication, Model model) {
        if (authentication != null) {
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
            // authentication안에 userDto를 꺼내려면 PrincipalDetails안에 들어있는 userDto의 정보를 꺼내와야한다.
            UserDto userDto = principalDetails.getUserDto();
            model.addAttribute("userDto", userDto);
            return "/myPage/passwordCheckForm";
        }
        return "redirect:/user/loginForm";
    }
    boolean passwordCheck = false;
    @PostMapping("/user/passwordCheck") // 회원정보 수정 페이지나, 삭제페이지 갈때 비밀번호 재확인 받는 코드
    @ResponseBody
    public String checkPasswordIntoMyPage(@RequestBody UserDto userDto, Authentication authentication) {
        if (authentication != null) {
            String key = userService.userIdAndPasswordCheck(userDto.getId(), userDto.getPassword());
            System.out.println("key : " + key);
            if (key.equals("SUCCESS")){
                passwordCheck = true;
            }
            return key;
        }
        return "redirect:/user/loginForm";
    }
}
