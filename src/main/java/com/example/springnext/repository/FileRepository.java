package com.example.springnext.repository;

import org.springframework.stereotype.Repository;
import com.example.springnext.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface FileRepository extends JpaRepository <File, Long> {

}
