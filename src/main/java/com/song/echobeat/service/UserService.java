package com.song.echobeat.service;

import com.song.echobeat.dto.UserDto;
import com.song.echobeat.model.User;
import com.song.echobeat.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final NotificationService notificationService;

    public UserService(UserRepository userRepository, NotificationService notificationService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.notificationService = notificationService;
    }

    public User registerUser(UserDto userDto) {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new IllegalArgumentException("Email is already in use");
        }
        if (userRepository.existsByPhoneNumber(userDto.getPhoneNumber())) {
            throw new IllegalArgumentException("Phone number is already in use");
        }

        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));  // Encrypt password

        // Save the user before sending the notification
        User savedUser = userRepository.save(user);

        // Send notification after the user is saved
        notificationService.createNotification("Welcome " + savedUser.getUsername() + "!", savedUser.getEmail());

        return savedUser;
    }

    public User updateUser(String id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));  // Encrypt password
        return userRepository.save(user);
    }

    // public User getUser(String id) {
    //             return userRepository.findById(id)
    //                     .orElseThrow(() -> new RuntimeException("User not found"));
    //    
}
