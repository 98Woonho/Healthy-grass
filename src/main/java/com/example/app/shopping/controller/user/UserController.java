package com.example.app.shopping.controller.user;

import com.example.app.shopping.domain.dto.UserDto;
import com.example.app.shopping.domain.service.user.UserService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    private PortOneTokenResponse portOneTokenResponse;
    private String security;

    @GetMapping("/loginForm")
    public String getLoginForm(@RequestParam(value = "exception", required = false) String exception,
                             Authentication authentication, Model model) {
        System.out.println("login");
        if (authentication != null) {
            return "redirect:/";
        }
        model.addAttribute("exception", exception);
        return "user/loginForm";
    }

    //엑세스 토큰 받기
    @GetMapping("/getToken")
    public @ResponseBody void getAcessToken(){

        String imp_key = "6257186181622002";
        String imp_secret = "LFmdkrDK2syh8Z4YCr7XoiVvDs5IRSAMHYAS43i4Jdy7FVSMKxGKCYMcYf5C7OWpsYXkdQUUufqHWz33";

        String url = "https://api.iamport.kr/users/getToken";
        //HEADER
        HttpHeaders headers = new HttpHeaders();

        //PARAM
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("imp_key",imp_key);
        params.add("imp_secret",imp_secret);
        //Entity
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);
        //ENTITY
        //REQUEST
        RestTemplate rt = new RestTemplate();
        ResponseEntity<PortOneTokenResponse> response = rt.exchange(url, HttpMethod.POST, entity, PortOneTokenResponse.class);
        System.out.println(response.getBody());
        //RESPONSE
        this.portOneTokenResponse = response.getBody(); //엑세스 토큰 객체를 넣어줌
    }
    //access토큰 객체
    @Data
    private static class TokenResponse{
        public String access_token;
        public int now;
        public int expired_at;
    }
    @Data
    private static class PortOneTokenResponse{
        public int code;
        public Object message;
        public TokenResponse response;
    }
    // 인증된 사용자 정보 가져오기
    @GetMapping(value = "/getAuthInfo/{imp_uid}",produces = MediaType.APPLICATION_JSON_VALUE) //인증하면 imp_uid를 받아올 수 있음 받아온 값을 사용
    public @ResponseBody PortOneAuthInfoResponse getAuthInfo(@PathVariable("imp_uid")String imp_uid){
        getAcessToken();// 엑세스 토큰 가져오기
        log.info("Get/portOne/getAuthInfo" + imp_uid);
        String url = "https://api.iamport.kr/certifications/"+imp_uid;
        //header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization","Bearer "+portOneTokenResponse.getResponse().getAccess_token());
        //params
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        //Entity
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);
        //request
        RestTemplate rt = new RestTemplate();

        //response
        ResponseEntity<PortOneAuthInfoResponse> response = rt.exchange(url, HttpMethod.GET,entity,PortOneAuthInfoResponse.class);
        System.out.println(response.getBody());

        security = "security"; // 회원가입 보안설정

        return response.getBody();
    }
    //인증 객체
    @Data
    private static class AuthInfoResponse{
        public int birth;
        public String birthday;
        public boolean certified;
        public int certified_at;
        public boolean foreigner;
        public Object foreigner_v2;
        public Object gender;
        public String imp_uid;
        public String merchant_uid;
        public String name;
        public String origin;
        public String pg_provider;
        public String pg_tid;
        public String phone;
        public Object unique_in_site;
        public String unique_key;
    }
    @Data
    private static class PortOneAuthInfoResponse{
        public int code;
        public Object message;
        public AuthInfoResponse response;
    }
    

    //회원가입 폼으로 이동
    @GetMapping("/joinForm")
    public void getJoinForm(){

    }

    //회원가입
    @PostMapping("")
    @ResponseBody
    public ResponseEntity<String> join(@Valid @RequestBody UserDto userDto, BindingResult bindingResult){
        System.out.println(userDto);
        if (bindingResult.hasErrors() || security == null) {
            // 유효성 검사 실패 시 오류 메시지 알려줌
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage())
            );
            System.out.println(errors);
            return new ResponseEntity<>("FAIL", HttpStatus.BAD_GATEWAY);
        }
        System.out.println(bindingResult.hasErrors());
        return new ResponseEntity<>(userService.userJoin(userDto), HttpStatus.OK);
    }

    // 유저 등록시 유저 중복확인
    @GetMapping(value = "/confirmUserId")
    @ResponseBody
    public String getConfirmHotelName(@RequestParam(value = "id") String id) {
        return userService.confirmUserId(id);
    }

    // 유저 아이디 찾기폼으로 이동
    @GetMapping("/findUserIdForm")
    public void findUserIdForm(){
        
    }

    @PostMapping("/findUserId")
    @ResponseBody
    public String findUserId(@RequestBody UserDto userDto){
        return userService.sendEmailUserId(userDto);
    }
}
