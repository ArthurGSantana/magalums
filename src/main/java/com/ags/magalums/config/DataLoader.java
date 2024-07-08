package com.ags.magalums.config;

import com.ags.magalums.entity.Channel;
import com.ags.magalums.entity.NotificationStatus;
import com.ags.magalums.repository.ChannelRepository;
import com.ags.magalums.repository.NotificationStatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final ChannelRepository channelRepository;
    private final NotificationStatusRepository notificationStatusRepository;

    public DataLoader(ChannelRepository channelRepository, NotificationStatusRepository notificationStatusRepository) {
        this.channelRepository = channelRepository;
        this.notificationStatusRepository = notificationStatusRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(Channel.Values.values())
                .map(Channel.Values::toChannel)
                .forEach(channelRepository::save);

        Arrays.stream(NotificationStatus.Values.values())
                .map(NotificationStatus.Values::toNotificationStatus)
                .forEach(notificationStatusRepository::save);
    }
}
