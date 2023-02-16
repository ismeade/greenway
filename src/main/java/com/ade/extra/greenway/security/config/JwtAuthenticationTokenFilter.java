package com.ade.extra.greenway.security.config;

import com.ade.extra.greenway.security.service.JwtService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 过滤每次请求中的token
 */
@Slf4j
// 在spring容器托管的OncePerRequestFilter的bean，都会自动加入到servlet的filter chain，而上面的定义，还额外把filter加入到了spring security的
// ememberMeAuthenticationFilter之前。而spring security也是一系列的filter，在mvc的filter之前执行。因此在鉴权通过的情况下，就会先后各执行一次。
//@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    protected JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response,
                                    @NonNull FilterChain chain) throws ServletException, IOException {
        // 获取jwt token
        String authHeader = request.getHeader("Authorization");
        log.info("uri: {}, Authorization: {}", request.getRequestURI(), authHeader);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            final String authToken = authHeader.substring("Bearer ".length());
            jwtService.verify(authToken)
                    .ifPresent(jwtUser -> {
                        if (SecurityContextHolder.getContext().getAuthentication() == null) {
                            log.info("userDetails: {}", jwtUser.getAuthorities());
                            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                                    jwtUser, null, jwtUser.getAuthorities());
                            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                            SecurityContextHolder.getContext().setAuthentication(authentication);
                        }
                    });
        }
        chain.doFilter(request, response);
    }
}
