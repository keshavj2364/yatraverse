package com.yatraverse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yatraverse.dto.AuthResponse;
import com.yatraverse.dto.LoginRequest;
import com.yatraverse.dto.RegisterRequest;
import com.yatraverse.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(
            @RequestBody RegisterRequest request) {

        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody LoginRequest request) {

        String token = authService.login(request);

        return new AuthResponse(token);
    }
}