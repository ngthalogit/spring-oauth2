package org.example.resourceserver.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.resourceserver.tools.JwtHelper;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


public class AccessTokenFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = JwtHelper.getAuthorizationHeader(request);
        if (StringUtils.hasText(token)) {
            String scope = JwtHelper.verifyCodeAuthorization(token);
        }
        filterChain.doFilter(request, response);
    }
}
