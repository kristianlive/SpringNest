package com.example.springnext.repository;

import com.example.springnext.model.Folder;
import org.springframework.stereotype.Repository;
import com.example.springnext.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository

// FileRepository är ett repository-gränssnitt för att hantera File-entiteter.
// Det utökar JpaRepository och ger standard CRUD-operationer för File-entiteter.
public interface FileRepository extends JpaRepository<File, Long> {

    // Hämtar alla filer som är associerade med en specifik mapp.
    List<File> findAllByFolder(Folder folder);
}
