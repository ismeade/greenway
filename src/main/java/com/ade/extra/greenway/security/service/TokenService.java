package com.ade.extra.greenway.security.service;

import com.ade.extra.greenway.security.domain.JwtToken;

public interface TokenService {

    String generalToken(JwtToken jwtToken);

    JwtToken analysisToken(String token);

}
