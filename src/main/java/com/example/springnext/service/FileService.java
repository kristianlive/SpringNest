package com.example.springnext.service;

import com.example.springnext.model.File;
import com.example.springnext.model.Folder;
import com.example.springnext.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
// FileService hanterar operationer relaterade till filer, som att spara och hämta filer.
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    // Sparar en fil som har laddats upp, associerad med en specifik mapp.
    public File saveFile(MultipartFile multipartFile, Folder folder) throws IOException {
        File file = new File();
        file.setName(multipartFile.getOriginalFilename());
        file.setContentType(multipartFile.getContentType());
        file.setSize(multipartFile.getSize());
        file.setData(multipartFile.getBytes());
        file.setFolder(folder);

        return fileRepository.save(file);
    }

    // Hämtar en fil baserat på dess ID.
    public File getFile(Long id) {
        return fileRepository.findById(id).orElse(null);
    }
}

