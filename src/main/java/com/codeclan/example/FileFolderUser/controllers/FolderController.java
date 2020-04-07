package com.codeclan.example.FileFolderUser.controllers;

import com.codeclan.example.FileFolderUser.models.Folder;
import com.codeclan.example.FileFolderUser.models.User;
import com.codeclan.example.FileFolderUser.repositories.FolderRepository;
import com.codeclan.example.FileFolderUser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FolderController {

    @Autowired
    private FolderRepository folderRepository;
    private Folder folder;

    @GetMapping(value = "/folders")
    public ResponseEntity<List<Folder>> getAllFolders(){
        List<Folder> folders= folderRepository.findAll();
        return new ResponseEntity<>(folders, HttpStatus.OK);
    }

    @GetMapping(value = "/folders/{id}")
    public ResponseEntity getFolder(@PathVariable Long id){
        return new ResponseEntity(folderRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/folders")
    public ResponseEntity<Folder> postFolder(@RequestBody Folder Folder){
        folderRepository.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }

}
