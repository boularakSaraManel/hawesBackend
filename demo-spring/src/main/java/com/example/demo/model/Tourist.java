package com.example.demo.model;
import java.util.ArrayList;
import java.util.Date;

public class Tourist {
    int id;
    String firstName;
    String lastName;
    String email;
    Date birthDate;
    int reputation;
    String password;
    String photoFilePath;
    ArrayList<Visit> TouristVisit;
    static ArrayList<Tourist> touristList = new ArrayList<>();
    public Tourist(){

    }

    public Tourist(int id, String firstName, String lastName, String email, String password, Date birthDate, int reputation, String photoFilePath){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.reputation = reputation;
        this.password = password;
        this.photoFilePath = photoFilePath;
        this.TouristVisit = new ArrayList<>();

        Tourist.touristList.add(this);

    }

    public void setId(int id) {
        this.id = id;

    }

    public int getId() {
        return this.id;
    }

    public ArrayList<Visit> getRVisit() {
        return this.TouristVisit;
    }

    public void addTouristVisit(Visit v) {

        v.tourist.TouristVisit.remove(v);
        v.tourist=this;
        this.TouristVisit.add(v);

    }

    public int vote(Place p) {
        Visit v;
        int r = -1;
        for (int i = 0 ; i<this.TouristVisit.size() ; i++){
            v = this.TouristVisit.get(i);
            if (v.place == p){
                 r = v.vote;
                 break;
            }
        }
        return r;
    }

    public void resetPassword(String oldPassword, String newPassword) {
        if(this.password == oldPassword){
            this.password = newPassword;
        }
    }

    public String getPassword() {
        return this.password;
    }

    public int hashCode() {
         return this.id;
    }

    public boolean equals(Object obj) {
        return this.id == ((Tourist)obj).id;
    }
}
