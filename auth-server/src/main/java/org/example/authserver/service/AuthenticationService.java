package org.example.authserver.service;


import org.springframework.security.core.Authentication;

public interface AuthenticationService {
    Authentication authenticate(String username, String password);
}
