package com.ade.extra.greenway.security.service.impl;

import com.ade.extra.greenway.security.domain.JwtToken;
import com.ade.extra.greenway.exception.ErrorCode;
import com.ade.extra.greenway.exception.ReturnException;
import com.ade.extra.greenway.repository.SysUserRepository;
import com.ade.extra.greenway.repository.entity.SysUser;
import com.ade.extra.greenway.security.service.SysUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Collections;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl implements SysUserService, InitializingBean {

    private final SysUserRepository sysUserRepository;
    private final TokenServiceImpl tokenServiceImpl;

    @Override
    public String login(String username, String password) {
        log.info("username: {}", username);
        final SysUser sysUser = sysUserRepository.findByUsername(username)
                .orElseThrow(() -> new ReturnException(ErrorCode.ERROR_LOGIN_USERNAME_NOT_FOUND));
        if (!Objects.equals(DigestUtils.md5DigestAsHex(password.getBytes()), sysUser.getPassword())) {
            throw new ReturnException(ErrorCode.ERROR_LOGIN_PASSWORD_NOT_MATCH);
        }
        JwtToken jwtToken = new JwtToken(username, Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")));
        return tokenServiceImpl.generalToken(jwtToken);
    }

    @Override
    public void afterPropertiesSet() {
        sysUserRepository.findByUsername("admin").orElseGet(() -> {
            SysUser sysUser = new SysUser();
            sysUser.setUsername("admin");
            sysUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
            sysUserRepository.saveAndFlush(sysUser);
            return sysUser;
        });
    }

}
