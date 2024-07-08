package com.ags.magalums.repository;

import com.ags.magalums.entity.NotificationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NotificationStatusRepository extends JpaRepository<NotificationStatus, UUID> {
}
