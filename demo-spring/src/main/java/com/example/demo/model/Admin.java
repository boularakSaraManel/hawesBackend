package com.example.demo.model;

public class Admin {
    int phoneNumber;
    String affiliation;
    String ipAddress;

    public Admin(int phoneNumber, String affiliation, String ipAddress) {
        this.affiliation = affiliation;
        this.phoneNumber = phoneNumber;
        this.ipAddress = ipAddress;
    }
}
