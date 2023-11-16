package com.example.springnext.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

import com.example.springnext.model.User;
import com.example.springnext.service.FolderService;
import com.example.springnext.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private FolderService folderService;

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        String username = principal != null ? principal.getName() : "Guest";
        User user = userService.getUserByUsername(username);

        if (principal != null) {
            // Hämta mappar för den inloggade användaren
            model.addAttribute("folders", folderService.getFoldersByUser(user));
        }

        model.addAttribute("user", username);
        return "home";
    }

    @PostMapping("/createFolder")
    public String createFolder(@RequestParam String name, Principal principal) {
        if (principal != null) {
            String username = principal.getName();
            User user = userService.getUserByUsername(username);
            folderService.createFolder(name, user);
        }
        return "redirect:/home";
    }

    @PostMapping("/deleteFolder")
    public String deleteFolder(@RequestParam Long folderId) {
        folderService.deleteFolder(folderId);
        return "redirect:/home";
    }

}

