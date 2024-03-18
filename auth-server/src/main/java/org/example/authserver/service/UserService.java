package org.example.authserver.service;

import org.example.authserver.model.UserRegistry;


public interface UserService {
    boolean save(UserRegistry userRegistry);
}
