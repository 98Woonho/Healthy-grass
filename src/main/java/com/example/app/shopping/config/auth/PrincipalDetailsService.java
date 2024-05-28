package com.example.app.shopping.config.auth;

import com.example.app.shopping.config.auth.PrincipalDetails;
import com.example.app.shopping.domain.dto.UserDto;
import com.example.app.shopping.domain.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrincipalDetailsService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        log.info("principal DetailService g: " + id);
        UserDto userDto = userMapper.getUserById(id);
        if (userDto == null){
            throw new UsernameNotFoundException(id);
        }return new PrincipalDetails(userDto);
    }
}
