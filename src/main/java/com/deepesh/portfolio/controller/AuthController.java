package com.deepesh.portfolio.controller;

import com.deepesh.portfolio.dto.AuthRequest;
import com.deepesh.portfolio.security.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Value("${app.admin.username}")
    private String adminUsername;

    @Value("${app.admin.password}")
    private String adminPassword;

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    /**
     * Authenticates the admin user and returns a JWT token.
     *
     * @param authRequest Contains the username and password from the client.
     * @return ResponseEntity containing the JWT token or an error message.
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        // Validate credentials against securely injected environment properties
        if (adminUsername.equals(authRequest.getUsername()) &&
                adminPassword.equals(authRequest.getPassword())) {

            String token = jwtUtil.generateToken(adminUsername);
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}