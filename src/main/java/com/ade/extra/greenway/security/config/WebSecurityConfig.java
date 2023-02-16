//package com.ade.extra.greenway.security.config;
//
//import com.ade.extra.greenway.service.impl.UserServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.core.GrantedAuthorityDefaults;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity // 启用web安全检查
//@EnableGlobalMethodSecurity(prePostEnabled = true) // 启用全局方法检查
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private PasswordEncoder passwordEncoder;
//    private UserServiceImpl userServiceImpl;
//    private MyAccessDeniedHandle myAccessDeniedHandle;
//    private MyAuthenticationEntryPoint myAuthenticationEntryPoint;
//
//    @Autowired
//    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Autowired
//    public void setUserService(UserServiceImpl userServiceImpl) {
//        this.userServiceImpl = userServiceImpl;
//    }
//
//    @Autowired
//    public void setRestfulAccessDeniedHandle(MyAccessDeniedHandle myAccessDeniedHandle) {
//        this.myAccessDeniedHandle = myAccessDeniedHandle;
//    }
//
//    @Autowired
//    public void setRestAuthenticationEntryPoint(MyAuthenticationEntryPoint myAuthenticationEntryPoint) {
//        this.myAuthenticationEntryPoint = myAuthenticationEntryPoint;
//    }
//
//    @Bean
//    public PasswordEncoder myPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    /**
//     * Remove the ROLE_ prefix
//     */
//    @Bean
//    public GrantedAuthorityDefaults grantedAuthorityDefaults() {
//        return new GrantedAuthorityDefaults("");
//    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                // 允许访问
//                .antMatchers("/login").permitAll()
//                .anyRequest().authenticated() // 其他请求拦截
//                .and()
//                .csrf().disable() //关闭csrf
//                .addFilter(new JwtLoginFilter(super.authenticationManager()))
//                .addFilter(new JwtVerifyFilter(super.authenticationManager()))
//                .exceptionHandling()
//                .accessDeniedHandler(myAccessDeniedHandle) // 自定义无权限访问
//                .authenticationEntryPoint(myAuthenticationEntryPoint) // 自定义未登录返回
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //禁用session
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // UserDetailsService类
//        auth.userDetailsService(userServiceImpl)
//                // 加密策略
//                .passwordEncoder(passwordEncoder);
//
//    }
//
//    /**
//     * 解决 AuthenticationManager 无法注入的问题
//     */
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//}
