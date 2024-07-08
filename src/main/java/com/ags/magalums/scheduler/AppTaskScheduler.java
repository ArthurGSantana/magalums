package com.ags.magalums.scheduler;

import com.ags.magalums.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class AppTaskScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppTaskScheduler.class);
    private final NotificationService notificationService;

    public AppTaskScheduler(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void checkTasks() {
        var dateTime = LocalDateTime.now();
        notificationService.checkAndSendNotifications(dateTime);
        LOGGER.info("Checking tasks...");
    }
}
