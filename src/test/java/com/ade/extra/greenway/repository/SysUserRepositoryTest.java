package com.ade.extra.greenway.repository;

import com.ade.extra.greenway.repository.entity.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
class SysUserRepositoryTest {

    @Autowired
    SysUserRepository SysUserRepository;

    @Test
    void insertTest() {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("admin");
        sysUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        SysUserRepository.save(sysUser);
    }

    @Test
    void selectTest() {
        System.out.println(SysUserRepository.findAll());
    }

}