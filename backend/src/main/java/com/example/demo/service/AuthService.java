package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user, String plainPassword) {
        user.setPassword_hash(encoder.encode(plainPassword));
        return userRepository.save(user);
    }

    public boolean login(String email, String plainPassword) {
        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) return false;

        return encoder.matches(plainPassword, user.getPassword_hash());
    }
}