package org.example.authserver.controller;

import org.example.authserver.model.UserRegistry;
import org.example.authserver.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegistry userRegistry) {

        userRegistry.setPassword(passwordEncoder.encode(userRegistry.getPassword()));
        boolean saved = userService.save(userRegistry);
        if (saved) {
            return ResponseEntity.ok("User registered successfully");
        }
        return ResponseEntity.ok("User existed !!! Please try again with different username");
    }
}
