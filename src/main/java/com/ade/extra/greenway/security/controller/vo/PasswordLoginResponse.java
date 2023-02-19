package com.ade.extra.greenway.security.controller.vo;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class PasswordLoginResponse {

    private String token;

}
