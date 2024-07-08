package com.ags.magalums.controller;

import com.ags.magalums.dto.NotificationRequestDto;
import com.ags.magalums.entity.Notification;
import com.ags.magalums.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotification(@PathVariable UUID id) {
        return ResponseEntity.ok(notificationService.getNotification(id));
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getNotifications() {
        return ResponseEntity.ok(notificationService.getNotifications());
    }

    @PostMapping
    public ResponseEntity<Void> createNotification(@RequestBody NotificationRequestDto notificationRequestDto) {
        notificationService.createNotification(notificationRequestDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelNotification(@PathVariable UUID id) {
        notificationService.cancelNotification(id);
        return ResponseEntity.noContent().build();
    }
}
