package com.example.student_task_manager;
import com.example.student_task_manager.model.*;
import com.example.student_task_manager.repository.UserRepository;
import com.example.student_task_manager.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock private UserRepository userRepository;
    @Mock private PasswordEncoder passwordEncoder;
    @InjectMocks private UserService userService;
    @Test
    void registerUser_Success() {
        when(userRepository.findByUsername("user")).thenReturn(Optional.empty());
        when(passwordEncoder.encode("pass")).thenReturn("encodedPass");
        when(userRepository.save(any(User.class))).thenAnswer(i -> i.getArguments()[0]);
        User savedUser = userService.registerUser("user", "pass", Role.ROLE_USER);
        assertEquals("user", savedUser.getUsername());
        assertEquals("encodedPass", savedUser.getPassword());
    }
}