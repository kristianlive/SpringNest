package com.example.springnext.controller;

import com.example.springnext.model.File;
import com.example.springnext.model.Folder;
import com.example.springnext.service.FileService;
import com.example.springnext.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @Autowired
    private FolderService folderService;

    // Endpoint upload
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,
                                             @RequestParam("folderId") Long folderId) {
        try {
            Folder folder = folderService.getFolder(folderId);
            if (folder == null) {
                return new ResponseEntity<>("Folder not found", HttpStatus.NOT_FOUND);
            }

            File savedFile = fileService.saveFile(file, folder);
            return new ResponseEntity<>("File uploaded successfully: " + savedFile.getId(), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint nedladdning
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        File file = fileService.getFile(id);
        if (file == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"")
                .body(file.getData());
    }

    // Другие методы, например, для удаления файла, можно добавить здесь
}

