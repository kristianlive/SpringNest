package com.example.springnext.repository;

import com.example.springnext.model.Folder;
import org.springframework.stereotype.Repository;
import com.example.springnext.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository

public interface FileRepository extends JpaRepository <File, Long> {
    List<File> findAllByFolder(Folder folder);

}
