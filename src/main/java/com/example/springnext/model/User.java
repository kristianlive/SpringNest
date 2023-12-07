package com.example.springnext.model;

import jakarta.persistence.*;


/**
 * Entitetsklass som representerar en användare i systemet.
 */
@Entity
@Table(name = "springNext_users")
public class User {

    // Standardkonstruktör
    public User() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    // Hämtar användarens ID
    public Long getId() {
        return id;
    }

    // Sätter användarens ID
    public void setId(Long id) {
        this.id = id;
    }

    // Hämtar användarens användarnamn
    public String getUsername() {
        return username;
    }

    // Sätter användarens användarnamn
    public void setUsername(String username) {
        this.username = username;
    }

    // Hämtar användarens lösenord
    public String getPassword() {
        return password;
    }

    // Sätter användarens lösenord
    public void setPassword(String password) {
        this.password = password;
    }
}

