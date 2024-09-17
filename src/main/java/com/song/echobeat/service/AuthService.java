package com.song.echobeat.service;

import com.song.echobeat.dto.LoginDto;
import com.song.echobeat.dto.UserDto;
import com.song.echobeat.model.User;
import com.song.echobeat.repository.UserRepository;
import com.song.echobeat.security.JwtTokenProvider;
import com.song.echobeat.exception.*;

import jakarta.validation.Valid;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final NotificationService notificationService;

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                       JwtTokenProvider jwtTokenProvider, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.notificationService = notificationService;
    }

    public String login(LoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(() -> {
                    logger.warn("Login attempt for non-existent user: {}", loginDto.getEmail());
                    return new UserNotFoundException(loginDto.getEmail());
                });

        if (passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                user.getEmail(),
                loginDto.getPassword(),
                user.getAuthorities()
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtTokenProvider.generateToken(authentication);
            logger.info("User {} logged in successfully", user.getEmail());
            return token;
        } else {
            logger.warn("Invalid credentials for user: {}", loginDto.getEmail());
            throw new InvalidCredentialsException(loginDto.getEmail());
        }
    }

    public String logout() {
        // Implement token invalidation if needed
        return "User logged out successfully";
    }

    public void signup(@Valid UserDto userDto) {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new EmailAlreadyRegisteredException(userDto.getEmail());
        }

        if (userRepository.existsByPhoneNumber(userDto.getPhoneNumber())) {
            throw new PhoneNumberAlreadyRegisteredException(userDto.getPhoneNumber());
        }

        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);

        notificationService.createNotification("Registration successful", user.getId());
    }
}
