package com.example.app.shopping.config.auth.jwt;


import com.example.app.shopping.domain.dto.UserDto;
import com.example.app.shopping.domain.mapper.UserMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;

/**
 * JWT를 이용한 인증
 */

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private  JwtTokenProvider jwtTokenProvider;


    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException, IOException {

        //System.out.println("[JWTAUTHORIZATIONFILTER] doFilterInternal...");
        String token = null;
        try{

            if(token==null) {
                // cookie 에서 JWT token을 가져옵니다.
                token = Arrays.stream(request.getCookies())
                        .filter(c -> c.getName().equals(JwtProperties.COOKIE_NAME)).findFirst()
                        .map(c -> c.getValue())
                        .orElse(null);
            }
        } catch (Exception ignored) {
            //일반적으로 접근하는 요청 URI에 대한 쿠키 예외는 무시한다..
//            System.out.println("[JWTAUTHORIZATIONFILTER] ignored " + ignored);
            //ignored.printStackTrace();
        }
       // System.out.println("[JWTAUTHORIZATIONFILTER] doFilterInternal...token " + token);


        try {
            if (jwtTokenProvider.validateToken(token)) {
                Authentication authentication = getUsernamePasswordAuthenticationToken(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                //System.out.println("[JWTAUTHORIZATIONFILTER] : authentication : " + authentication);
            } else {
               // System.out.println("JWT 토큰 유효성 검증 오류!");
            }
        }catch(Exception e){
           // e.printStackTrace();
        }
        chain.doFilter(request, response);
    }

    /**
     * JWT 토큰으로 User를 찾아서 UsernamePasswordAuthenticationToken를 만들어서 반환한다.
     * User가 없다면 null
     */
    private Authentication getUsernamePasswordAuthenticationToken(String token) {

        Authentication authentication = jwtTokenProvider.getAuthentication(token);
       // System.out.println("[JWTAUTHORIZATIONFILTER] : ...getUsernamePasswordAuthenticationToken ...."+authentication);

        UserDto user = userMapper.findUserByUserId(authentication.getName()); // 유저를 유저명으로 찾습니다.
        //System.out.println("JwtAuthorizationFilter.getUsernamePasswordAuthenticationToken...authenticationToken : " +authentication );
        if(user!=null)
        {
            return authentication;
        }
        return null; // 유저가 없으면 NULL
    }

}