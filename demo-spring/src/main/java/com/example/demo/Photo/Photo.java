package com.example.demo.Photo;

import com.example.demo.Address.Address;
import com.example.demo.Place.Place;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Photo {
   @Id
   @SequenceGenerator(
           name="photo_sequence",
           sequenceName = "photo_sequence",
           allocationSize = 1
   )
   @GeneratedValue(
           strategy = GenerationType.SEQUENCE,
           generator = "photo_sequence"
   )
   private Long id;
   private Date createdAt;
   private String path;
   private String alternative;


   @OneToOne(mappedBy = "photo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private Place place;


   public Long getId() {
      return id;
   }
   public void setId(Long id) {
      this.id = id;
   }

   public Date getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(Date createdAt) {
      this.createdAt = createdAt;
   }

   public String getPath() {
      return path;
   }

   public void setPath(String path) {
      this.path = path;
   }

   public String getAlternative() {
      return alternative;
   }

   public void setAlternative(String alternative) {
      this.alternative = alternative;
   }

   public Photo() {
   }

   public Photo(Long id, Date createdAt, String path, String alternative) {
      this.id = id;
      this.createdAt = createdAt;
      this.path = path;
      this.alternative = alternative;
   }
//the used with db
   public Photo(Date createdAt, String path, String alternative) {
      this.createdAt = createdAt;
      this.path = path;
      this.alternative = alternative;
   }

   public Place getPlace() {
      return place;
   }

   public void setPlace(Place place) {
      this.place = place;
   }

   @Override
   public String toString() {
      return "Photo{" +
              "id=" + id +
              ", createdAt=" + createdAt +
              ", path='" + path + '\'' +
              ", alternative='" + alternative + '\'' +
              '}';
   }
}
