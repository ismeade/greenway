package com.ade.extra.greenway.security.controller;

import com.ade.extra.greenway.security.controller.vo.PasswordLoginRequest;
import com.ade.extra.greenway.security.controller.vo.PasswordLoginResponse;
import com.ade.extra.greenway.security.service.SysUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/sys/auth")
@RequiredArgsConstructor
//@PreAuthorize("hasRole('ROLE_GUEST')") // hasRole需要带前缀写法 ROLE_xxxx 同时userDetails的权限里也有ROLE_xxxx
//@PreAuthorize("hasAuthority('auth')") // userDetails包含auth就行
public class AuthController {

    private final SysUserService sysUserService;

    @PostMapping("/login")
    public ResponseEntity<PasswordLoginResponse> login(@Valid @RequestBody PasswordLoginRequest passwordLoginRequest) {
        log.info("login request: {}", passwordLoginRequest);
        final String token = sysUserService.login(passwordLoginRequest.getUsername(), passwordLoginRequest.getPassword());
        log.info("token: {}", token);
        return ResponseEntity.ok(PasswordLoginResponse.builder().token(token).build());
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Object> admin() {
        return ResponseEntity.ok("hello");
    }

}
