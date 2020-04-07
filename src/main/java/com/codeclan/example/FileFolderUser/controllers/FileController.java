package com.codeclan.example.FileFolderUser.controllers;

import com.codeclan.example.FileFolderUser.models.File;
import com.codeclan.example.FileFolderUser.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.util.List;


@RestController
public class FileController {

    @Autowired
    private FileRepository fileRepository;
    private Files files;

    @GetMapping(value = "/files")
    public ResponseEntity getAllFiles(){
        List<File> raids=fileRepository.findAll();
        return new ResponseEntity<>(files, HttpStatus.OK);
    }

    @GetMapping(value ="/files/{id}")
    public ResponseEntity getFile(@PathVariable Long id){
        return new ResponseEntity(fileRepository.findById(id), HttpStatus.OK);
    }

}
