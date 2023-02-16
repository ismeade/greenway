package com.ade.extra.greenway.repository;

import com.ade.extra.greenway.repository.entity.TUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
class TUserRepositoryTest {

    @Autowired
    TUserRepository TUserRepository;

    @Test
    void insertTest() {
        TUser tUser = new TUser();
        tUser.setUsername("admin");
        tUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        TUserRepository.save(tUser);
    }

    @Test
    void selectTest() {
        System.out.println(TUserRepository.findAll());
    }

}