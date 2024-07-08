package com.ags.magalums.repository;

import com.ags.magalums.entity.Notification;
import com.ags.magalums.entity.NotificationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, UUID> {
    List<Notification> findByStatusInAndDateTimeBefore(List<NotificationStatus> notificationStatus, LocalDateTime dateTime);
}
