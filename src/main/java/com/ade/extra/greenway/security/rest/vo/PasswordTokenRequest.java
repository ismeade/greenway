package com.ade.extra.greenway.security.rest.vo;

import lombok.Data;

@Data
public class PasswordTokenRequest {

    private String username;
    private String password;

}
