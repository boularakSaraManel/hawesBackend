package com.example.demo.Tourist;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table
public class Tourist {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @SequenceGenerator(
            name="tourist_sequence",
            sequenceName = "tourist_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tourist_sequence"
    )
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private LocalDate dob;
    private String password;
    private int phonenumber;
    private LocalDate deletedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public LocalDate getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDate deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Tourist() {
    }

    public Tourist(Long id, String firstname, String lastname, String email, LocalDate dob, String password, int phonenumber, LocalDate deletedAt) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.dob = dob;
        this.password = password;
        this.phonenumber = phonenumber;
        this.deletedAt = deletedAt;
    }

    public Tourist(String firstname, String lastname, String email, LocalDate dob, String password, int phonenumber, LocalDate deletedAt) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.dob = dob;
        this.password = password;
        this.phonenumber = phonenumber;
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "Tourist{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", password='" + password + '\'' +
                ", phonenumber=" + phonenumber +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
