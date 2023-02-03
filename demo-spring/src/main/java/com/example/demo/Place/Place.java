package com.example.demo.Place;

import com.example.demo.Address.Address;
import com.example.demo.Photo.Photo;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table
public class Place {
   @Id
   @SequenceGenerator(
           name="place_sequence",
           sequenceName = "place_sequence",
           allocationSize = 1
   )
   @GeneratedValue(
           strategy = GenerationType.SEQUENCE,
           generator = "place_sequence"
   )
   private Long id;
   private String name;
   private String description;
   private LocalDate createdAt;

   @OneToOne(cascade= CascadeType.ALL,orphanRemoval = true, fetch =FetchType.LAZY)
   @JoinColumn(name="photoId", referencedColumnName = "id")
   //added auto by spring so i edited it to a simpler approach
   /*@JoinTable(name = "place_photo",
           joinColumns = @JoinColumn(name = "id"),
           inverseJoinColumns = @JoinColumn(name = "photo_id"))*/
   private Photo photo;

   @OneToOne(cascade= CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
   @JoinColumn(name = "address_id", referencedColumnName = "id")
   private Address address;

   public Address getAddress() {
      return address;
   }

   public void setAddress(Address address) {
      this.address = address;
   }

   public Photo getPhoto() {
      return photo;
   }

   public void setPhoto(Photo photo) {
      this.photo = photo;
   }
   //private Long addressId;


   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public LocalDate getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(LocalDate createdAt) {
      this.createdAt = createdAt;
   }

   public Place() {
   }

   public Place(Long id, String name, String description, LocalDate createdAt, Photo photo) {
      this.id = id;
      this.name = name;
      this.description = description;
      this.createdAt = createdAt;
      this.photo = photo;
   }

   public Place(String name, String description, LocalDate createdAt, Photo photo) {
      this.name = name;
      this.description = description;
      this.createdAt = createdAt;
      this.photo = photo;
   }

   @Override
   public String toString() {
      return "Place{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", description='" + description + '\'' +
              ", createdAt=" + createdAt +
              ", photo=" + photo +
              '}';
   }
}