package com.example.student_task_manager;

import com.example.student_task_manager.model.*;
import com.example.student_task_manager.repository.TaskRepository;
import com.example.student_task_manager.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {
    @Mock
    private TaskRepository taskRepository;
    @InjectMocks
    private TaskService taskService;

    @Test
    void createTask_ReturnsTask() {
        User user = User.builder().id(1L).username("testuser").build();
        Task task = Task.builder().title("Title").description("Desc").owner(user).build();
        when(taskRepository.save(any(Task.class))).thenReturn(task);
        Task result = taskService.createTask("Title", "Desc", user);
        assertNotNull(result);
        assertEquals("Title", result.getTitle());
        verify(taskRepository, times(1)).save(any(Task.class));
    }

    @Test
    void getTasksForUser_ReturnsTaskList() {
        when(taskRepository.findByOwnerId(1L)).thenReturn(List.of(new Task()));
        List<Task> tasks = taskService.getTasksForUser(1L);
        assertEquals(1, tasks.size());
    }
}