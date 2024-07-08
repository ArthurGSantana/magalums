package com.ags.magalums.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_channel")
public class Channel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    public Channel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enum Values {
        EMAIL("Email"),
        SMS("SMS"),
        PUSH("Push"),
        WHATSAPP("WhatsApp");

        private final String name;

        Values(String name) {
            this.name = name;
        }

        public Channel toChannel() {
            Channel channel = new Channel();
            channel.setName(name);
            return channel;
        }
    }
}
