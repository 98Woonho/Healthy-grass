package com.example.app.shopping.config.auth.provider;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NaverUserInfo implements OAuth2UserInfo{

    private String id;
    private Map<String,Object> attributes;
    @Override
    public String getName() {
        return (String)attributes.get("nickname");
    }

    @Override
    public String getEmail() {
        return (String)attributes.get("email");
    }

    @Override
    public String getProvider() {
        return "naver";
    }

    @Override
    public String getProviderId() {
        return (String)attributes.get("id");
    }


}
