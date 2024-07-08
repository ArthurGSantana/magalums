package com.ags.magalums.dto;

import com.ags.magalums.entity.Channel;
import com.ags.magalums.entity.Notification;
import com.ags.magalums.entity.NotificationStatus;

import java.time.LocalDateTime;

public record NotificationRequestDto(
        String destination,
        String message,
        LocalDateTime dateTime,
        Channel.Values channel
) {
    public Notification toEntity() {
        return new Notification(
                this.destination(),
                this.message(),
                this.dateTime(),
                channel.toChannel(),
                NotificationStatus.Values.PENDING.toNotificationStatus()
        );
    }
}
