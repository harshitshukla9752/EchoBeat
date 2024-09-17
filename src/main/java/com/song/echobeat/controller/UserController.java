package com.song.echobeat.controller;

import org.springframework.web.bind.annotation.*;

import com.song.echobeat.dto.LoginDto;
import com.song.echobeat.dto.UserDto;
import com.song.echobeat.model.User;
import com.song.echobeat.service.AuthService;
import com.song.echobeat.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final AuthService authService;
    private final UserService userService;

    // Constructor injection
    public UserController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/signup")
    public void signup(@RequestBody UserDto userDto) {
        authService.signup(userDto);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto) {
        return authService.login(loginDto);
    }

    @GetMapping("/{id}")
    public User updateUser(@PathVariable String id) {
        return userService.updateUser(id, null);
    }
}
