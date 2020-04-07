package com.codeclan.example.FileFolderUser.components;

import com.codeclan.example.FileFolderUser.models.File;
import com.codeclan.example.FileFolderUser.models.Folder;
import com.codeclan.example.FileFolderUser.models.User;
import com.codeclan.example.FileFolderUser.repositories.FileRepository;
import com.codeclan.example.FileFolderUser.repositories.FolderRepository;
import com.codeclan.example.FileFolderUser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader() {

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

            folderRepository.deleteAll();
            userRepository.deleteAll();
            fileRepository.deleteAll();



            User user = new User("Sky");
            userRepository.save(user);

            Folder folder1 = new Folder("Folder123");
            Folder folder2 = new Folder("Folder456");
            user.addFolder(folder1);
            user.addFolder(folder2);
            folderRepository.save(folder1);
            folderRepository.save(folder2);


            File file1 = new File("TestFile1", "txt", 123, folder1);
            File file2 = new File("TestFile2", "pdf", 456, folder2);

            fileRepository.save(file1);
            fileRepository.save(file2);
        }
    }

