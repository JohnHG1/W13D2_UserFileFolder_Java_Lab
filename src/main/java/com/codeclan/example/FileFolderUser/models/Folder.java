package com.codeclan.example.FileFolderUser.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "folders")
public class Folder {

    @Column
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "folder", fetch = FetchType.LAZY)
    private List<File> files;

    @JsonIgnore

    @ManyToOne

    @JoinColumn(name = "user_id")
    private User user;
    //    @Column

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    public Folder(){
    }

    public Folder(String name){
        this.name = name;
        this.files = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}