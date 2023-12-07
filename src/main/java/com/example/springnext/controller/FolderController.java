package com.example.springnext.controller;

import com.example.springnext.model.Folder;
import com.example.springnext.service.FolderService;
import com.example.springnext.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Kontrollerklass för att hantera åtgärder relaterade till mappar.
 */
@Controller
public class FolderController {

    @Autowired
    private FolderService folderService;

    @Autowired
    private UserService userService;

    // Hämtar alla mappar och returnerar dem som en ResponseEntity
    @GetMapping("/folders")
    public ResponseEntity<List<Folder>> getAllFolders() {
        List<Folder> folders = folderService.getAllFolders();
        if (folders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(folders, HttpStatus.OK);
    }

}
