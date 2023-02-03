package com.example.demo.Photo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhotoRepository extends JpaRepository<Photo,Long> {
    Optional<Photo> findByPath(String path);
}
