package com.example.demo.Place;

import com.example.demo.Address.Address;
import com.example.demo.Photo.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/place")
public class PlaceController {
    public final PlaceService placeService;
    public final PlaceRepository placeRepository;

    @Autowired
    public PlaceController(PlaceService placeService, PlaceRepository placeRepository) {
        this.placeService = placeService;
        this.placeRepository = placeRepository;
    }

    @PostMapping
    public void addPlace(@RequestBody Place place, Long addressId, Long photoId){
        placeService.addPlace(place, addressId,photoId);
    }

}
