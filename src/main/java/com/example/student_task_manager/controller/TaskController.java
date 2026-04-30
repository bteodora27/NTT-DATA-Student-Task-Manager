package com.example.student_task_manager.controller;

import com.example.student_task_manager.model.*;
import com.example.student_task_manager.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final UserService userService;

    @GetMapping("/my")
    public List<Task> getMyTasks(Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        return taskService.getTasksForUser(user.getId());
    }

    @PostMapping
    public Task createTask(@RequestBody Task task, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());
        return taskService.createTask(task.getTitle(), task.getDescription(), user);
    }

    // ADMIN Endpoints
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}