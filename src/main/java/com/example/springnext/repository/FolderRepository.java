package com.example.springnext.repository;

import com.example.springnext.model.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

// FolderRepository är ett repository-gränssnitt för att hantera Folder-entiteter.
public interface FolderRepository extends JpaRepository<Folder, Long> {
}
