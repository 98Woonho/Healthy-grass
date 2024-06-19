package com.example.app.shopping.config.auth;

import com.example.app.shopping.domain.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PrincipalDetails implements UserDetails {

    private UserDto userDto;

    //OAUTH2---------------------------------------
//    private String accessToken;
//    private Map<String,Object> attributes;
//
//    public PrincipalDetails(UserDto userDto) {
//        this.userDto = userDto;
//    }
//
//
//    @Override
//    public Map<String, Object> getAttributes() {
//        return null;
//    }
//    @Override
//    public String getName() {
//        return null;
//    }
    //OAUTH2---------------------------------------

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return userDto.getRole();
            }
        });
        return collection;
    }

    @Override
    public String getPassword() {
        return userDto.getPassword();
    }

    @Override
    public String getUsername() {
        return userDto.getId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
