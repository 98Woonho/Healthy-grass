package com.example.app.shopping.config;

import com.example.app.shopping.domain.service.user.PrincipalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //스프링 빈등록
@EnableWebSecurity // 클래스가 스프링 시큐리티라는 것을 설정
public class SecurityConfig {
    @Autowired
    private PrincipalDetailsService principalDetailsService;
    @Bean //스프링 필터체인 등록 스프링 시큐리티 6.0이후 버전부터 변경
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // csrf비활성화
        http.csrf(
                (config)->{config.disable();}
        );

        // 요청 URL별 접근 권한
        http.authorizeHttpRequests(
                authorize -> {
                    authorize.requestMatchers("/js/**","/css/**","/images/**","/templates").permitAll();
                    authorize.requestMatchers("/**").permitAll(); //모든 페이지에 허가 나중에 수정해야함.
//                    authorize.requestMatchers("/user/**").hasAnyRole("ROLE_USER","ROLE_ADMIN");
//                    authorize.requestMatchers("/admin/**").hasRole("ROLE_ADMIN");
                    authorize.anyRequest().permitAll(); //이 이외 나머지 페이지 접근에 대해 모두 허용
                }
        );
        http.formLogin(
                formLogin -> {
            formLogin.loginPage("/user/login");
        });

        http.userDetailsService(principalDetailsService);
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
