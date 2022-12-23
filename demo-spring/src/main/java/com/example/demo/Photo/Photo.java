package com.example.demo.Photo;

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
   private Long photo_id;
   private Date createdAt;
   private String path;
   private String alternative;

   @OneToOne(mappedBy = "photo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private Place place;


   public Long getId() {
      return photo_id;
   }

   public void setId(Long photo_id) {
      this.photo_id = photo_id;
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

   public Photo(Long photo_id, Date createdAt, String path, String alternative) {
      this.photo_id = photo_id;
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

   @Override
   public String toString() {
      return "Photo{" +
              "photo_id=" + photo_id +
              ", createdAt=" + createdAt +
              ", path='" + path + '\'' +
              ", alternative='" + alternative + '\'' +
              '}';
   }
}
