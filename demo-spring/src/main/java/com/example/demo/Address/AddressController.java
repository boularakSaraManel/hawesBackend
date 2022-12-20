package com.example.demo.Address;

import com.example.demo.Tourist.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/address")
public class AddressController {

    private final AddressRepository AddressRepository;
    private final AddressService AddressService;

    @Autowired
    public AddressController(AddressRepository addressRepository, AddressService addressService) {
        this.AddressRepository = addressRepository;
        this.AddressService = addressService;
    }


    @GetMapping
    public List<Address> getAddress(){return AddressService.getAddresses();}

    @PostMapping
    public void addAddress(@RequestBody Address address){
        AddressService.addNewAddress(address);
    }

    @DeleteMapping(path= "{addressId}")
    public void deleteAddress(@PathVariable("addressId") Long addressId){
        AddressService.deleteAddress(addressId);
    }

}
