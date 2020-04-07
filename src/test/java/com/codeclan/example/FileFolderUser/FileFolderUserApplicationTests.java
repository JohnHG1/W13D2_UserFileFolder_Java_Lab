package com.codeclan.example.FileFolderUser;

import com.codeclan.example.FileFolderUser.models.File;
import com.codeclan.example.FileFolderUser.models.Folder;
import com.codeclan.example.FileFolderUser.models.User;
import com.codeclan.example.FileFolderUser.repositories.FileRepository;
import com.codeclan.example.FileFolderUser.repositories.FolderRepository;
import com.codeclan.example.FileFolderUser.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes ={FileFolderUserApplication.class},
		webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

class FileFolderUserApplicationTests {

	@Autowired
	FileRepository fileRepository;

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	UserRepository userRepository;

	@Test
	public void contextLoads() {

	}


	@Test
	public void createFileAndFolderThenSave(){

		Folder bigFolder = new Folder("BigFolder");
		folderRepository.save(bigFolder);
		File codingInstructions = new File("Coding Instructions", "Txt", 123, bigFolder);
		fileRepository.save(codingInstructions);
	}

	@Test
	public void createPirateAndRaidThenSave(){

		Folder smallFolder = new Folder("Small Folder");
		folderRepository.save(smallFolder);
		File XFile = new File("X File", ".pdf", 456, smallFolder);
		fileRepository.save(XFile);
		User user = new User("Sky");
		userRepository.save(user);
		user.addFolder(smallFolder);
		userRepository.save(user);

	}

}
