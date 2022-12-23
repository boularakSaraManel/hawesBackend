package com.example.demo.model;

import java.util.Date;

public class Photo {
    int id;
    Date createdAt;
    String photoFilePath;


    public Photo(int id, String photoFilePath,Date createdAt){
        this.id = id;
        this.createdAt = createdAt;
        this.photoFilePath = photoFilePath;

    }

}
