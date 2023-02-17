package com.ade.extra.greenway.security.service;

/**
 * 管理系统用户
 */
public interface SysUserService {

    /**
     * 用户名密码登录
     */
    String login(String username, String password);

}
