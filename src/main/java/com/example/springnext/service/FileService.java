package com.example.springnext.service;

import com.example.springnext.model.File;
import com.example.springnext.model.Folder;
import com.example.springnext.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;
    public File saveFile(MultipartFile multipartFile, Folder folder) throws IOException {
        File file = new File();
        file.setName(multipartFile.getOriginalFilename());
        file.setContentType(multipartFile.getContentType());
        file.setSize(multipartFile.getSize());
        file.setData(multipartFile.getBytes());
        file.setFolder(folder);

        return fileRepository.save(file);
    }

    public File getFile(Long id) {
        return fileRepository.findById(id).orElse(null);
    }


}
