package com.ade.extra.greenway.repository.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 登录用户
 */
@Data
@Entity(name = "sys_name")
public class SysUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;

}
