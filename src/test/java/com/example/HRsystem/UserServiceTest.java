//package com.example.HRsystem;
//
//import com.example.HRsystem.entity.User;
//import com.example.HRsystem.enums.Role;
//import com.example.HRsystem.repository.UserRepository;
//import com.example.HRsystem.service.UserService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Transactional
//class UserServiceTest {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Test
//    void testAddUser() {
//        // Given
//        String username = "testUser";
//        String password = "testPassword";
//        String email = "test@example.com";
//
//        // When
//        userService.addUser(username, password, email);
//
//        // Then
//        Optional<User> savedUserOptional = userRepository.findByUsername(username);
//        assertTrue(savedUserOptional.isPresent(), "User should be saved in the database");
//
//        User savedUser = savedUserOptional.get();
//        assertEquals(username, savedUser.getUsername(), "Username should match");
//        assertEquals(password, savedUser.getPassword(), "Password should match");
//        assertEquals(email, savedUser.getEmail(), "Email should match");
//        assertEquals(1, savedUser.getRoles().size(), "User should have one role");
//        assertTrue(savedUser.getRoles().contains(Role.USER), "User should have ROLE_USER role");
//    }
//}
//
