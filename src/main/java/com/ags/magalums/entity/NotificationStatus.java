package com.ags.magalums.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_notification_status")
public class NotificationStatus extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    public NotificationStatus() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enum Values {
        PENDING("Pending"),
        SUCCESS("Success"),
        FAILED("Failed"),
        CANCELED("Canceled");

        private final String name;

        Values(String name) {
            this.name = name;
        }

        public NotificationStatus toNotificationStatus() {
            NotificationStatus notificationStatus = new NotificationStatus();
            notificationStatus.setName(name);
            return notificationStatus;
        }
    }
}
