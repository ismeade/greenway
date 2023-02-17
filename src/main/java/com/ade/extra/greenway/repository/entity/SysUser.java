package com.ade.extra.greenway.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class SysUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

}
