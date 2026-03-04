package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> body) {
        User user = new User();
        user.setFirst_name(body.get("firstName"));
        user.setLast_name(body.get("lastName"));
        user.setEmail(body.get("email"));
        user.setPhone(body.get("phone"));

        authService.register(user, body.get("password"));

        return ResponseEntity.ok(Map.of("result", true, "message", "Registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        boolean ok = authService.login(body.get("email"), body.get("password"));

        if (ok) {
            return ResponseEntity.ok(Map.of("result", true, "message", "Login successful"));
        }
        return ResponseEntity.status(401).body(Map.of("result", false, "message", "Invalid credentials"));
    }
}