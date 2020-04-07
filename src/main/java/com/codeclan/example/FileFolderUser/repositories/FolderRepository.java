package com.codeclan.example.FileFolderUser.repositories;

import com.codeclan.example.FileFolderUser.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {

}


