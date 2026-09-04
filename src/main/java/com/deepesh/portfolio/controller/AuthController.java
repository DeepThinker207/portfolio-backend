package com.deepesh.portfolio.controller;

import com.deepesh.portfolio.dto.AuthRequest;
import com.deepesh.portfolio.security.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final JwtUtil jwtUtil;

    // Hardcoded credentials for single-admin portfolio
    private final String ADMIN_USER = "deepesh_admin";
    private final String ADMIN_PASS = "Deepesh@2026";

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody AuthRequest request) {
        if (ADMIN_USER.equals(request.getUsername()) && ADMIN_PASS.equals(request.getPassword())) {
            String token = jwtUtil.generateToken(request.getUsername());

            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}