package com.example.student_task_manager.service;

import com.example.student_task_manager.model.*;
import com.example.student_task_manager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User registerUser(String username, String password, Role role) {
        if (userRepository.findByUsername(username).isPresent()) throw new RuntimeException("User already exists");
        User user = User.builder().username(username).password(passwordEncoder.encode(password)).role(role).build();
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }
}