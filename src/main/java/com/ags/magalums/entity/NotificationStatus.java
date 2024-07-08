package com.ags.magalums.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_notification_status")
public class NotificationStatus {
    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name")
    private String name;

    public NotificationStatus() {
    }

    public NotificationStatus(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enum Values {
        PENDING("00000000-0000-0000-0000-000000000001","Pending"),
        SUCCESS("00000000-0000-0000-0000-000000000002","Success"),
        FAILED("00000000-0000-0000-0000-000000000003","Failed"),
        CANCELED("00000000-0000-0000-0000-000000000004","Canceled");

        private final UUID id;
        private final String name;

        Values(String id, String name) {
            this.name = name;
            this.id = UUID.nameUUIDFromBytes(id.getBytes());
        }

        public NotificationStatus toNotificationStatus() {
            return new NotificationStatus(
                    this.id,
                    this.name
            );
        }
    }
}
