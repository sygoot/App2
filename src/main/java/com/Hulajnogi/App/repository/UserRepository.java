package com.Hulajnogi.App.repository;

import com.Hulajnogi.App.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Metody związane z wyszukiwaniem użytkowników, np. findByEmail, jeśli potrzebne
}
