package com.example.demo.Address;

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
    private int zipcode;
    private String country;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
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
    public Address(Long id, double latitude, double longitude, String street, String city, int zipcode, String country) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
    }
//constructor without id: id autoincremented
    public Address(double latitude, double longitude, String street, String city, int zipcode, String country) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipcode=" + zipcode +
                ", country='" + country + '\'' +
                '}';
    }

}
