package com.example.demo.Place;

import com.example.demo.Address.Address;
import com.example.demo.Photo.Photo;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table (name = "Place")
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
   private Long place_id;
   private String name;
   private String description;
   private LocalDate createdAt;

   @OneToOne(orphanRemoval = true, fetch =FetchType.LAZY)
   @JoinColumn(name="photo_id")
   //added auto by spring so i edited it to a simpler approach
   /*@JoinTable(name = "place_photo",
           joinColumns = @JoinColumn(name = "place_id"),
           inverseJoinColumns = @JoinColumn(name = "photo_id"))*/
   private Photo photo;

   @OneToOne(orphanRemoval = true, fetch = FetchType.LAZY)
   @JoinColumn(name="address_id")
   //added auto by spring so i edited it to a simpler approach
   /*@JoinTable(name = "place_address",
           joinColumns = @JoinColumn(name = "place_place_id"),
           inverseJoinColumns = @JoinColumn(name = "address_id"))*/
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
      return place_id;
   }

   public void setId(Long place_id) {
      this.place_id = place_id;
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

   public Place(Long place_id, String name, String description, LocalDate createdAt, Photo photo) {
      this.place_id = place_id;
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
              "place_id=" + place_id +
              ", name='" + name + '\'' +
              ", description='" + description + '\'' +
              ", createdAt=" + createdAt +
              ", photo=" + photo +
              '}';
   }
}