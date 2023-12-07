package com.example.springnext.repository;

import com.example.springnext.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// UserRepository är ett repository-gränssnitt för att hantera User-entiteter.
public interface UserRepository extends JpaRepository<User, Long> {

    // Hittar en User baserat på dess användarnamn.
    Optional<User> findByUsername(String username);
}
