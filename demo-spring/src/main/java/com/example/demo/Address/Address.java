package com.example.demo.Address;

import com.example.demo.Place.Place;

import javax.persistence.*;

@Entity
@Table
public class Address {
    @Id
    @SequenceGenerator(
            name="address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_sequence"
    )
    private Long id;
    private double latitude;
    private double longitude;
    private String street;
    private String city;
    private String zipcode;
    private String country;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Place place;



    public Long getId() {
        return Address.this.id;
    }

    public void setId(Long id) {
        this.id = Address.this.id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
//empty constructor
    public Address() {}
//constructor with id
    public Address(Long id, double latitude, double longitude, String street, String city, String zipcode, String country) {
        this.id = Address.this.id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
    }
//constructor without id: id autoincremented
    public Address(double latitude, double longitude, String street, String city, String zipcode, String country) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + Address.this.id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipcode=" + zipcode +
                ", country='" + country + '\'' +
                '}';
    }

    public String getWilayaCode(){
        return this.zipcode.substring(0,2);
    }
}


