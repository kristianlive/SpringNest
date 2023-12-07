package com.example.springnext.service;

import com.example.springnext.model.User;
import com.example.springnext.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// UserService hanterar användarrelaterade operationer.
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    // Konstruktör för att autowire UserRepository
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Laddar en användare baserat på användarnamnet för autentisering
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

    // Lägger till en ny användare i databasen
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // Hämtar en användare baserat på användarnamnet
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    // Uppdaterar en befintlig användare i databasen
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // Raderar en användare från databasen baserat på ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Hämtar en lista med alla användare i databasen
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

