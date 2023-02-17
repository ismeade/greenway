package com.ade.extra.greenway.security.controller.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PasswordLoginRequest {

    @NotBlank(message = "请输入用户名")
    private String username;
    @NotBlank(message = "请输入密码")
    private String password;

}
