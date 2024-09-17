package com.song.echobeat.exception;

public class PhoneNumberAlreadyRegisteredException extends RuntimeException {
    public PhoneNumberAlreadyRegisteredException(String phoneNumber) {
        super("Phone number is already registered: " + phoneNumber);
    }
}
