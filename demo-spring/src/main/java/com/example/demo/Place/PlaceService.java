package com.example.demo.Place;

import com.example.demo.Address.Address;
import com.example.demo.Address.AddressRepository;
import com.example.demo.Photo.Photo;
import com.example.demo.Photo.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaceService {
    private final PlaceRepository placeRepository;
    private final AddressRepository addressRepository;
    private final PhotoRepository photoRepository;

    @Autowired
    public PlaceService(PlaceRepository placeRepository,AddressRepository addressRepository,
                        PhotoRepository photoRepository){
        this.placeRepository=placeRepository;
        this.addressRepository=addressRepository;
        this.photoRepository = photoRepository;
    }

    //, Long address_id, Long photo_id deleted from param
    public void addPlace(Place place, Long address_id, Long photo_id) {
        //Long address_id=place.getAddress().getId();
        //Long photo_id=place.getPhoto().getId();

        Optional<Address> address = addressRepository.findById(address_id);
        Optional<Photo> photo= photoRepository.findById(photo_id);
        //test if foreign key tuple for address exists
        if(!address.isPresent()){
            throw new IllegalStateException("Address with id " +address_id+" does not exist");
        }
        place.setAddress(address.get()); //optional is like arrayList<T>
        //test if foreign key tuple for photo exists
        if(!photo.isPresent()){
            throw new IllegalStateException("Photo with id " +photo_id+" does not exist");
        }
        place.setPhoto(photo.get());
        placeRepository.save(place);
        address.get().setPlace(place);
        photo.get().setPlace(place);
    }
}
