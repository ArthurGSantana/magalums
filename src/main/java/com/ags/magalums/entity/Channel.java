package com.ags.magalums.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_channel")
public class Channel {
    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name")
    private String name;

    public Channel() {
    }

    public Channel(UUID id, String name) {
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
        EMAIL("00000000-0000-0000-0000-000000000001", "Email"),
        SMS("00000000-0000-0000-0000-000000000002", "SMS"),
        PUSH("00000000-0000-0000-0000-000000000003", "Push"),
        WHATSAPP("00000000-0000-0000-0000-000000000004", "WhatsApp");

        private final UUID id;
        private final String name;

        Values(String id, String name) {
            this.name = name;
            this.id = UUID.nameUUIDFromBytes(id.getBytes());
        }

        public Channel toChannel() {
            return new Channel(
                    this.id,
                    this.name
            );
        }
    }
}
