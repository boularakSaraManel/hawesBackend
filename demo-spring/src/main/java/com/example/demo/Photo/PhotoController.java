package com.example.demo.Photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/photo")
public class PhotoController {
    private final PhotoService photoService;
    private final PhotoRepository photoRepository;

    @Autowired
    public PhotoController(PhotoService photoService, PhotoRepository photoRepository) {
        this.photoService = photoService;
        this.photoRepository = photoRepository;
    }


    @PostMapping
    public void addPhoto(@RequestBody Photo photo){
        photoService.addPhoto(photo);
    }
}
