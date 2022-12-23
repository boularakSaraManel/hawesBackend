package com.example.demo.model;
import java.util.ArrayList;
import java.util.Date;
public class Place {
    int id;
    String name;
    String description;
    Date createdAt;
    ArrayList <Photo> placePhoto;
    Address placeAdress;
    ArrayList<Visit> placeVisit;
    public Place(int id, String name, String description, Date createdAt){
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.placePhoto = new ArrayList<>();
        this.placeVisit = new ArrayList<>();
    }
    public void addPlacePhoto(Photo p2) {
        this.placePhoto.add(p2);
    }
    public void addAddress(Address address) {
        this.placeAdress = address;
    }
    public void addPlaceVisit(Visit v) {this.placeVisit.add(v);}
    public Address getAddress() {return this.placeAdress;}
    public ArrayList<Visit> getRVisit() {return this.placeVisit;}
    public ArrayList<Photo> getRPhoto() {return  this.placePhoto;}
}
