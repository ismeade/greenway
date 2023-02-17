package com.ade.extra.greenway.security.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class JwtToken {

    private final String username;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtToken(String username, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.authorities = authorities;
    }

}
