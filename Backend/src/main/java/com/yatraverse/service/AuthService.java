package com.yatraverse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yatraverse.dto.LoginRequest;
import com.yatraverse.dto.RegisterRequest;
import com.yatraverse.entity.User;
import com.yatraverse.enums.Role;
import com.yatraverse.repository.UserRepository;
import com.yatraverse.security.JwtUtil;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder();

    public String register(RegisterRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(
                encoder.encode(request.getPassword()));
        user.setRole(Role.USER);

        userRepository.save(user);

        return "User Registered Successfully";
    }

    public String login(LoginRequest request) {

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow();

        if (encoder.matches(
                request.getPassword(),
                user.getPassword())) {

            return jwtUtil.generateToken(user.getEmail());
        }

        throw new RuntimeException("Invalid Password");
    }
}