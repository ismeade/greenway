package com.ade.extra.greenway.security.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
@SuperBuilder
public class JwtUser {

    private Long userId;

    private final Collection<? extends GrantedAuthority> authorities;

}
