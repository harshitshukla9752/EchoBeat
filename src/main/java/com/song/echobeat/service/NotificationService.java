package com.song.echobeat.service;

import com.song.echobeat.model.Notification;
import com.song.echobeat.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification createNotification(String message, String recipient) {
        Notification notification = new Notification(message, recipient);
        return notificationRepository.save(notification);
    }

    public List<Notification> getNotificationsForUser(String recipient) {
        return notificationRepository.findByRecipient(recipient);
    }

    public void markAsRead(String notificationId) {
        Notification notification = notificationRepository.findById(notificationId).orElseThrow();
        notification.setRead(true);
        notificationRepository.save(notification);
    }
}
