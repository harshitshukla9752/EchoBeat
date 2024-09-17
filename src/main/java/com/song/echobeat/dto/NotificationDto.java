package com.song.echobeat.dto;

public class NotificationDto {
    private String message;
    private String recipient;

    // Getters and setters

    public NotificationDto() {}

    public NotificationDto(String message, String recipient) {
        this.message = message;
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
