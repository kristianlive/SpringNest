package com.example.springnext.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.*;

import jakarta.persistence.*;

/**
 * Entitetsklass som representerar en mapp i systemet.
 */
@Entity
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Hämtar mappens ID
    public Long getId() {
        return id;
    }

    // Sätter mappens ID
    public void setId(Long id) {
        this.id = id;
    }

    // Hämtar mappens namn
    public String getName() {
        return name;
    }

    // Sätter mappens namn
    public void setName(String name) {
        this.name = name;
    }

    // Hämtar användaren som mappen är associerad med
    public User getUser() {
        return user;
    }

    // Sätter användaren som mappen är associerad med
    public void setUser(User user) {
        this.user = user;
    }
}


