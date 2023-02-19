package com.ade.extra.greenway.security.config;

import com.ade.extra.greenway.security.component.JwtAuthenticationTokenFilter;
import com.ade.extra.greenway.security.component.RestAuthenticationEntryPoint;
import com.ade.extra.greenway.security.component.RestAccessDeniedHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启方法注解权限
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    private final RestAccessDeniedHandler restAccessDeniedHandler;
    private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                // 关闭csrf
                .csrf().disable()
                // 关闭session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity
                // 禁用缓存
                .headers().cacheControl();

        httpSecurity.authorizeRequests()
                // 允许未登陆用户访问
                .antMatchers("/sys/auth/login").permitAll()
                // 其余url全部需要认证
                .anyRequest().authenticated();

        // 在UsernamePasswordAuthenticationFilter前添加filter
        httpSecurity
                .addFilterBefore(jwtAuthenticationTokenFilter,
                        UsernamePasswordAuthenticationFilter.class);

        // 异常处理
        httpSecurity
                .exceptionHandling()
                // 权限不足处理器
                .accessDeniedHandler(restAccessDeniedHandler)
                // 认证失败处理器
                .authenticationEntryPoint(restAuthenticationEntryPoint);

        return httpSecurity.build();
    }

}
