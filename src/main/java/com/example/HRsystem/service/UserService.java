package com.example.HRsystem.service;

import com.example.HRsystem.enums.Role;
import com.example.HRsystem.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserService extends UserDetailsService {
    public UserDetails loadUserByUsername(String username);
    public void addUser(String username, String password, String email, Set<Role> roles);

    public void updateUser(Long userId, String newUsername, String newPassword, String newEmail);

    public void deleteUser(Long userId);

    public User getUserById(Long userId);

    public boolean userExists(String username);
}
