package com.example.app.shopping.config;

import com.example.app.shopping.domain.service.user.PrincipalDetailsService;
import com.example.app.shopping.handler.CustomLoginFailureHandler;
import com.example.app.shopping.handler.CustomLogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration //스프링 빈등록
@EnableWebSecurity // 클래스가 스프링 시큐리티라는 것을 설정
public class SecurityConfig {
    @Autowired
    private PrincipalDetailsService principalDetailsService;
    @Autowired
    private DataSource dataSource;
    @Bean //스프링 필터체인 등록 스프링 시큐리티 6.0이후 버전부터 변경
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // csrf비활성화
        http.csrf(
                (config)-> config.disable()
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
                    formLogin.loginPage("/user/loginForm").permitAll(); //유저가 허가되지 않은 url에 접속시 리다이렉트 될 로그인 페이지를 지정 get 요청
                    formLogin.loginProcessingUrl("/user/login").permitAll(); //로그인 폼의 action 속성에 사용될 URL을 지정 비동기 처리시 무조건 빼야한다!!!!!! 주의!!!
                    formLogin.usernameParameter("id"); //로그인에 필요한 ID값을 id로 변경 defalt(username)
                    formLogin.passwordParameter("password"); // 로그인에 필요한 password값을 password로 변경 defalt(password)
                    formLogin.defaultSuccessUrl("/"); //로그인 성공시 이동할 url
                    formLogin.failureHandler(customFailureHandler()); // 로그인 실패시 핸들러 작용
        });
        http.logout(
                logout ->{
                    logout.logoutUrl("/user/logout").permitAll(); // 로그아웃 url 지정
                    logout.addLogoutHandler(customLogoutHandler()); // 로그아웃시 customLogoutHandler 실행
                    logout.logoutSuccessUrl("/"); // 로그아웃 성공시 이동할 url
                }
        );
        http.rememberMe(
                rememberMe ->{
                    rememberMe.key("rememberMeKey"); // rememberMe 토큰 생성할 때 사용할 키 지정
                    rememberMe.rememberMeParameter("rememberMe"); // Remember Me 기능을 활성화하는 데 사용할 HTTP 파라미터의 이름을 지정합니다. 예를 들어, 로그인 폼에서 "Remember Me" 옵션을 선택할 때 해당 파라미터가 전송됩니다.
                    rememberMe.alwaysRemember(false); //기본적으로 로그인 유지가 항상 선택된 것처럼 동작합니다. false로 설정하면 사용자가 "Remember Me" 옵션을 선택하지 않으면 자동으로 로그인 유지를 하지 않습니다.
                    rememberMe.tokenValiditySeconds(60*60*24); // Remember Me 토큰의 유효 기간을 초 단위로 지정합니다.
                    rememberMe.tokenRepository(tokenRepository());
                }
        );
        http.userDetailsService(principalDetailsService);
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public CustomLoginFailureHandler customFailureHandler(){
        return new CustomLoginFailureHandler();
    }
    @Bean
    CustomLogoutHandler customLogoutHandler(){
        return new CustomLogoutHandler();
    }
    @Bean
    public PersistentTokenRepository tokenRepository(){
        JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();
        repository.setDataSource(dataSource);
        return repository;
    }
}
