package com.ade.extra.greenway.service.impl;

import com.ade.extra.greenway.repository.TUserRepository;
import com.ade.extra.greenway.repository.entity.TUser;
import com.ade.extra.greenway.service.UserService;
import com.ade.extra.greenway.service.mapstruct.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Collections;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, InitializingBean {

    private final TUserRepository tUserRepository;
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return tUserRepository.findByUsername(username)
                .map(userMapper::toDto)
                .map(userDto -> {
                    userDto.setRoles(Collections.singletonList("ADMIN"));
                    return userDto;
                })
                .orElseThrow(() -> new UsernameNotFoundException(""));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        tUserRepository.findByUsername("admin").orElseGet(() -> {
            TUser tUser = new TUser();
            tUser.setUsername("admin");
            tUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
            tUserRepository.saveAndFlush(tUser);
            return tUser;
        });
    }
}
