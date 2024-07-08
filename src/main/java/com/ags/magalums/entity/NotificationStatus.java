package com.ags.magalums.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_notification_status")
public class NotificationStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    public NotificationStatus() {
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
}
