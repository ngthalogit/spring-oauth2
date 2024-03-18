package org.example.authserver.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication authenticate(String username, String password) {
        UsernamePasswordAuthenticationToken authn =
                UsernamePasswordAuthenticationToken.unauthenticated(username, password);
        Authentication auth = authenticationManager.authenticate(authn);
        SecurityContextHolder.getContext().setAuthentication(auth);
        return auth;
    }
}
