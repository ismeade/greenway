package com.ade.extra.greenway.security.service;

import com.ade.extra.greenway.security.domain.Token;

public interface TokenService {

    String generalToken(Token token);

    Token analysisToken(String token);

}
