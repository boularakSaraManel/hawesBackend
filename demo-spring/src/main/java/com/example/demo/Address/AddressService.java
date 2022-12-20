package com.example.demo.Address;


import com.example.demo.Tourist.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    public List<Address> getAddresses() {
       return addressRepository.findAll();
    }

    public void addNewAddress(Address address) {
            Optional<Address> addressLat = addressRepository.findAddressByLatitude(address.getLatitude()).stream().findFirst();
            Optional<Address> addressLong = addressRepository.findAddressByLongitude(address.getLongitude()).stream().findFirst();
            if (addressLat.isPresent()&&addressLong.isPresent()){
                throw new IllegalStateException("coordinates already exist");
            }
            addressRepository.save(address);
    }


    public void deleteAddress(Long addressId) {
        boolean exists = addressRepository.existsById(addressId);
        if(!exists){ throw new IllegalStateException("the address with id "+addressId+" does not exist!!");}
        addressRepository.deleteById(addressId);
    }
}
