package org.example.authserver.service;

import org.example.authserver.model.UserRegistry;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {
    private final UserDetailsManager userDetailsManager;

    public UserServiceImpl(UserDetailsManager userDetailsManager) {
        this.userDetailsManager = userDetailsManager;
    }

    @Override
    public boolean save(UserRegistry userRegistry) {
        boolean existed =  userDetailsManager.userExists(userRegistry.getUsername());
        if (!existed) {
            User user = new User(
                    userRegistry.getUsername(),
                    userRegistry.getPassword(),
                    Collections.singleton(new SimpleGrantedAuthority("READ"))
            );
            userDetailsManager.createUser(user);
        }
        return !existed;
    }
}
