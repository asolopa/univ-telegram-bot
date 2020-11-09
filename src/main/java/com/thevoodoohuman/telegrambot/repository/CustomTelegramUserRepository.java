package com.thevoodoohuman.telegrambot.repository;

import com.thevoodoohuman.telegrambot.model.CustomTelegramUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomTelegramUserRepository extends JpaRepository<CustomTelegramUser, Long> {


    Optional<CustomTelegramUser> findById(Long databaseId);
}
