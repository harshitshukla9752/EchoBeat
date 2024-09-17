package com.song.echobeat.exception;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(String email) {
        super("Invalid credentials for user: " + email);
    }
}
