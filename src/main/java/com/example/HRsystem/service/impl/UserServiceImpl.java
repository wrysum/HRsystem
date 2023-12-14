package com.example.HRsystem.service.impl;

import com.example.HRsystem.enums.Role;
import com.example.HRsystem.entity.User;
import com.example.HRsystem.repository.UserRepository;
import com.example.HRsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public void addUser(String username, String password, String email, Set<Role> roles) {
        if (!userExists(username)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setRoles(roles);

            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User with username '" + username + "' already exists");
        }
    }

    public void updateUser(Long userId, String newUsername, String newPassword, String newEmail) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setUsername(newUsername);
            user.setPassword(newPassword);
            user.setEmail(newEmail);
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("Пользователь не найден с ID: " + userId);
        }
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Пользователь не найден с ID: " + userId));
    }

    public boolean userExists(String username) {
        return userRepository.existsByUsername(username);
    }
}
