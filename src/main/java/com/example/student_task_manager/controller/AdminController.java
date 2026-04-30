package com.example.student_task_manager.controller;

import com.example.student_task_manager.dto.AuthRequest;
import com.example.student_task_manager.model.Role;
import com.example.student_task_manager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody AuthRequest request) {
        // Admin-ul poate crea atat USER cat si un alt ADMIN. Aici default la USER pentru simplitate.
        userService.registerUser(request.getUsername(), request.getPassword(), Role.ROLE_USER);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created by admin");
    }
}