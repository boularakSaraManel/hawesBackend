package com.example.demo.Photo;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhotoService {
    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public void addPhoto(Photo photo) {
        Optional<Photo> photoOptional= photoRepository.findByPath(photo.getPath());
        //if photo allready exists throw exception
        if(photoOptional.isPresent()){
           throw new IllegalStateException("this photo already exists");
        }
        photoRepository.save(photo);

    }
}
