package com.example.student_task_manager.service;

import com.example.student_task_manager.model.*;
import com.example.student_task_manager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Task createTask(String title, String description, User owner) {
        Task task = Task.builder().title(title).description(description).owner(owner).build();
        return taskRepository.save(task);
    }

    public List<Task> getTasksForUser(Long userId) {
        return taskRepository.findByOwnerId(userId);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}