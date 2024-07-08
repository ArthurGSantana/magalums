package com.ags.magalums.service;

import com.ags.magalums.dto.NotificationRequestDto;
import com.ags.magalums.entity.Notification;
import com.ags.magalums.entity.NotificationStatus;
import com.ags.magalums.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification getNotification(UUID id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
    }

    public List<Notification> getNotifications() {
        return notificationRepository.findAll();
    }

    public void createNotification(NotificationRequestDto notificationRequestDto) {
        var notification = notificationRequestDto.toEntity();
        notificationRepository.save(notification);
    }

    public void cancelNotification(UUID id) {
        var notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        notification.setStatus(NotificationStatus.Values.CANCELED.toNotificationStatus());

        notificationRepository.save(notification);
    }
}
