package com.ags.magalums.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_notification")
public class Notification extends BaseEntity {
    @Column(name = "destination")
    private String destination;

    @Column(name = "message")
    private String message;

    @Column(name = "dateTime")
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "channelId")
    private Channel channel;

    @ManyToOne
    @JoinColumn(name = "statusId")
    private NotificationStatus status;

    public Notification() {
    }

    public Notification(String destination, String message, LocalDateTime dateTime, Channel channel, NotificationStatus status) {
        this.destination = destination;
        this.message = message;
        this.dateTime = dateTime;
        this.channel = channel;
        this.status = status;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }
}
