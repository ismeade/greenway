package com.ade.extra.greenway.security.component;

import com.ade.extra.greenway.security.domain.Token;
import com.ade.extra.greenway.security.service.impl.TokenServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * 在spring容器托管的OncePerRequestFilter的bean，都会自动加入到servlet的filter chain，
 * 而上面的定义，还额外把filter加入到了spring security的ememberMeAuthenticationFilter之前。 而spring
 * security也是一系列的filter，在mvc的filter之前执行。 因此在鉴权通过的情况下，就会先后各执行一次。
 */
@Slf4j
@RequiredArgsConstructor
@Configuration
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private final TokenServiceImpl tokenServiceImpl;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        log.info("uri: {}, Authorization: {}", request.getRequestURI(), authHeader);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring("Bearer ".length());
            final Token jwtToken = tokenServiceImpl.analysisToken(token);
            if (null != jwtToken) {
                log.info(jwtToken.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                        .collect(Collectors.joining(",")));
                if (SecurityContextHolder.getContext().getAuthentication() == null) {
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                            jwtToken.getUsername(), null, jwtToken.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        } else {
            log.info("set default authentication: ROLE_GUEST");
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken("GUEST",
                    null, Collections.singletonList(new SimpleGrantedAuthority("ROLE_GUEST")));
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        chain.doFilter(request, response);
    }

}
