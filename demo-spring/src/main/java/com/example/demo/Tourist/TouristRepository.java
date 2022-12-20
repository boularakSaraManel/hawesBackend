package com.example.demo.Tourist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TouristRepository extends JpaRepository<Tourist,Long> {

    Optional<Tourist> findTouristByEmail(String email);

}
