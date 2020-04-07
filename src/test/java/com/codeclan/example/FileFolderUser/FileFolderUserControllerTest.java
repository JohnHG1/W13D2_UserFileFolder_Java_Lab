package com.codeclan.example.FileFolderUser;

import com.codeclan.example.FileFolderUser.models.User;
import com.codeclan.example.FileFolderUser.repositories.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;


@SpringBootTest(classes = {FileFolderUserApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

class FileFolderUserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    UserRepository userRepository;

    @Test
    public void canCallGetAllUsersRoute(){
        ResponseEntity<User[]> response =
                restTemplate.getForEntity(
                        "/users/",
                        User[].class);
        User[] users = response.getBody();
        Assert.assertEquals("Sky", users[0].getUserName());
    }

}
