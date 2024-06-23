package com.example.app.shopping.config.auth;




import com.example.app.shopping.config.auth.provider.GoogleUserInfo;
import com.example.app.shopping.config.auth.provider.KakaoUserInfo;
import com.example.app.shopping.config.auth.provider.NaverUserInfo;
import com.example.app.shopping.config.auth.provider.OAuth2UserInfo;
import com.example.app.shopping.domain.dto.UserDto;
import com.example.app.shopping.domain.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class PrincipalDetailsOAuth2Service extends DefaultOAuth2UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("[PrincipalDetailsOAuth2Service] loadUser() userRequest : "+userRequest);
        System.out.println("[PrincipalDetailsOAuth2Service] loadUser() userRequest.getClientRegistration() : "+userRequest.getClientRegistration());
        System.out.println("[PrincipalDetailsOAuth2Service] loadUser() userRequest.getAccessToken() : "+userRequest.getAccessToken());
        System.out.println("[PrincipalDetailsOAuth2Service] loadUser() userRequest.getAdditionalParameters() : "+userRequest.getAdditionalParameters());
        System.out.println("[PrincipalDetailsOAuth2Service] loadUser() userRequest.getAccessToken().getTokenValue() : "+userRequest.getAccessToken().getTokenValue());
        System.out.println("[PrincipalDetailsOAuth2Service] loadUser() userRequest.getAccessToken().getTokenType().getValue() : "+userRequest.getAccessToken().getTokenType().getValue());
        System.out.println("[PrincipalDetailsOAuth2Service] loadUser() userRequest.getAccessToken().getAccessToken().getScopes() : "+userRequest.getAccessToken().getScopes());

        //Attribute확인
        OAuth2User oAuth2User =    super.loadUser(userRequest);
        System.out.println("[PrincipalDetailsOAuth2Service] loadUser() oAuth2User : " + oAuth2User);
        System.out.println("[PrincipalDetailsOAuth2Service] loadUser() oAuth2User.getAttributes() : " + oAuth2User.getAttributes());

        //OAuth Server Provider 구별
        String provider = userRequest.getClientRegistration().getRegistrationId();
        System.out.println("[PrincipalDetailsOAuth2Service] loadUser() provider : " + provider);

        OAuth2UserInfo oAuth2UserInfo = null;
        if(provider!=null&&provider.equals("kakao")){
            String id = oAuth2User.getAttributes().get("id").toString();
            KakaoUserInfo kakaUserInfo = new KakaoUserInfo(id, (Map<String, Object>)oAuth2User.getAttributes().get("properties") );
            System.out.println("[PrincipalDetailsOAuth2Service] loadUser() kakaUserInfo : " + kakaUserInfo );
            oAuth2UserInfo = kakaUserInfo;
        }else if(provider!=null&&provider.equals("naver")){
            Map<String, Object> resp = (Map<String, Object>)oAuth2User.getAttributes().get("response");
            String id = (String)resp.get("id");
            NaverUserInfo naverUserInfo = new NaverUserInfo(id, resp);
            System.out.println("[PrincipalDetailsOAuth2Service] loadUser() naverUserInfo : " + naverUserInfo );
            oAuth2UserInfo = naverUserInfo;

        }else if(provider!=null&&provider.equals("google")){
            String id = (String)oAuth2User.getAttributes().get("sub");
            GoogleUserInfo googleUserInfo = new GoogleUserInfo(id,oAuth2User.getAttributes());
            oAuth2UserInfo = googleUserInfo;
        }

        System.out.println("[PrincipalDetailsOAuth2Service] loadUser() oAuth2UserInfo : " + oAuth2UserInfo);


        //Db조회
        String username = oAuth2UserInfo.getProvider()+"_"+oAuth2UserInfo.getProviderId();
        String password = passwordEncoder.encode("1234");


        UserDto dto=null;
        dto =  userMapper.findUserByUserId(username);

        if(dto==null){
            dto =UserDto.builder()
                    .id(username)
                    .password(password)
                    .role("ROLE_USER")
                    .provider(oAuth2UserInfo.getProvider())
                    .providerId(oAuth2UserInfo.getProviderId())
                    .build();
            userMapper.insertUser(dto);
            System.out.println("[PrincipalDetailsOAuth2Service] loadUser() "+oAuth2UserInfo.getProvider()+" 최초 로그인!");
        }else{
            System.out.println("[PrincipalDetailsOAuth2Service] loadUser() "+oAuth2UserInfo.getProvider()+" 기존계정 로그인!");
        }

        //PrincipalDetails생성
        PrincipalDetails principalDetails = new PrincipalDetails();
        principalDetails.setAttributes(oAuth2UserInfo.getAttributes());
        principalDetails.setAccessToken(userRequest.getAccessToken().getTokenValue());
        principalDetails.setUserDto(dto);
        return principalDetails;
    }


}
