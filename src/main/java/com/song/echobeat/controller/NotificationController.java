package com.song.echobeat.controller;

import com.song.echobeat.model.Notification;
import com.song.echobeat.service.NotificationService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/{recipient}")
    public List<Notification> getNotifications(@PathVariable String recipient) {
        return notificationService.getNotificationsForUser(recipient);
    }

    @PostMapping("/mark-as-read/{id}")
    public void markNotificationAsRead(@PathVariable String id) {
        notificationService.markAsRead(id);
    }
}
