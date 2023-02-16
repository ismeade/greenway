package com.ade.extra.greenway.security.rest;

import com.ade.extra.greenway.security.rest.vo.PasswordTokenRequest;
import com.ade.extra.greenway.security.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/extend/auth")
//@PreAuthorize("hasRole('ROLE_GUEST')") // hasRole需要带前缀写法 ROLE_xxxx 同时userDetails的权限里也有ROLE_xxxx
//@PreAuthorize("hasAuthority('auth')") // userDetails包含auth就行
public class AuthController {

    @Autowired
    protected JwtService jwtService;


//    @PostMapping("/login")
//    public ResponseEntity<Object> login(@RequestBody PasswordTokenRequest passwordTokenRequest) {
//        log.info("authWechat request: {}", passwordTokenRequest);
//        try {
//            if (!StringUtils.hasText(wechatMpAuthRequest.getCode())) {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//            }
//            // openId
//            String openId = wechatApiService.getOpenId(wechatMpAuthRequest.getCode())
//                    .map(oId -> {
//                        log.info("openId: {}", oId);
//                        return oId.getOpenid();
//                    })
//                    .filter(StringUtils::hasText)
//                    .orElseThrow(() -> new IllegalArgumentException("获取openId出错"));
//            log.info("openId: {}", openId);
//            final JwtUser jwtUser = jwtService.getJwtUser(openId);
//
//            return ResponseEntity.ok(jwtService.create(jwtUser));
//        } catch (Exception e) {
//            log.error(e.getLocalizedMessage(), e);
//        }
//        return ResponseEntityFactory.badRequest("登录失败");
//    }

}
