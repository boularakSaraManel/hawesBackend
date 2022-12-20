package com.example.demo.Address;

import com.example.demo.Tourist.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findAddressByLatitude(double latitude);
    Optional<Address> findAddressByLongitude(double longitude);
}
