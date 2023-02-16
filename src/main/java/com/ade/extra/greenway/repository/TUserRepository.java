package com.ade.extra.greenway.repository;

import com.ade.extra.greenway.repository.entity.TUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TUserRepository extends JpaRepository<TUser, Long> {

    Optional<TUser> findByUsername(String username);
}
