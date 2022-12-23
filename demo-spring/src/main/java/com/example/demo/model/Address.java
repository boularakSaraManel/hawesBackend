package com.example.demo.model;

public class Address {
    int id;
    double latitude;
    double longitude;
    String street;
    String city;
    String zipCode;
    String country;

    public Address(int id, double latitude, double longitude, String street, String city, String zipCode, String country){
        this.latitude = latitude;
        this.longitude = longitude;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }
    public String getWilayaCode(){
        return this.zipCode.substring(0,2);
    }
    }
