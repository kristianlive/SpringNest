package com.example.springnext.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.springnext.model.User;
import com.example.springnext.service.UserService;

import java.util.List;


/**
 * Kontrollerklass för att hantera användarrelaterade webbåtgärder.
 */
@Controller
public class UserController {

    private final UserService userService;

    // Konstruktör för att autowire UserService
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Hanterar POST-begäran för att registrera en användare
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/login";
    }

    // Visar registreringsformuläret
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // Visar inloggningsformuläret
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Hämtar alla användare (används i API)
    @ResponseBody
    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Visar en lista med alla användare (används i webbgränssnittet)
    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    // Hanterar begäran om att radera en användare
    @PostMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}


