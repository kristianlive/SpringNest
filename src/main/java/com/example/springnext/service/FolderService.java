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


///**
// * Klassen FolderService hanterar operationer relaterade till mappar.
// * Det inkluderar skapande, radering och hämtning av mappinformation.
// */
@Service
public class FolderService {

    @Autowired
    private FolderRepository folderRepository;

    // Skapar en ny mapp och sparar den i databasen
    public Folder createFolder(String name, User user) {
        Folder folder = new Folder();
        folder.setName(name);
        folder.setUser(user);
        return folderRepository.save(folder);
    }

    // Hämtar en mapp baserat på dess ID
    public Folder getFolder(Long id) {
        return folderRepository.findById(id).orElse(null);
    }

    // Returnerar en lista med alla mappar för en given användare
    public List<Folder> getFoldersByUser(User user) {
        return folderRepository.findAll();
    }

    // Raderar en mapp från databasen baserat på dess ID
    public void deleteFolder(Long folderId) {
        folderRepository.deleteById(folderId);
    }

    // Returnerar en lista med alla mappar i databasen
    public List<Folder> getAllFolders() {
        return folderRepository.findAll();
    }

    @Autowired
    private FileRepository fileRepository;

    // Hämtar alla filer i en specifik mapp
    public List<File> getFilesByFolder(Long folderId) {
        Folder folder = getFolder(folderId);
        if (folder != null) {
            return fileRepository.findAllByFolder(folder);
        }
        return new ArrayList<>();
    }
}


