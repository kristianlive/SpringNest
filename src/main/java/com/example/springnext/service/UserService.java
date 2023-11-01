package com.example.springnext.service;

import com.example.springnext.model.User;
import com.example.springnext.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User addUser(User user) {
        return userRepository.save(user);
    }
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
    public User updateUser(User user) {
        return userRepository.save(user);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
