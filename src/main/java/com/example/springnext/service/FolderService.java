package com.example.springnext.service;

import com.example.springnext.model.File;
import com.example.springnext.model.Folder;
import com.example.springnext.model.User;
import com.example.springnext.repository.FileRepository;
import com.example.springnext.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FolderService {

    @Autowired
    private FolderRepository folderRepository;

    public Folder createFolder(String name, User user) {
        Folder folder = new Folder();
        folder.setName(name);
        folder.setUser(user);
        return folderRepository.save(folder);
    }
    public Folder getFolder(Long id) {
        return folderRepository.findById(id).orElse(null);
    }

    public List<Folder> getFoldersByUser(User user) {
        return folderRepository.findAll();
    }

    public void deleteFolder(Long folderId) {
        folderRepository.deleteById(folderId);
    }

    public List<Folder> getAllFolders() {
        return folderRepository.findAll();
    }

    @Autowired
    private FileRepository fileRepository;

    public List<File> getFilesByFolder(Long folderId) {
        Folder folder = getFolder(folderId);
        if (folder != null) {
            return fileRepository.findAllByFolder(folder);
        }
        return new ArrayList<>();
    }



}

