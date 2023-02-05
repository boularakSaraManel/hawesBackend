package com.example.demo.model;

import java.util.Date;

public class Visit {
    String photoFilePath;
    int vote;
    String comment;
    Date createdAt;
    Tourist tourist;
    Place place;
    public Visit( String photoFilePath, int vote, String comment, Date createdAt, Tourist tourist, Place place){
        this.photoFilePath = photoFilePath;
        this.comment = comment;
        this.vote = vote;
        this.createdAt = createdAt;
        this.tourist = tourist;
        this.place = place;
        /*
        if (place.placeVisit.contains(this)){
                place.placeVisit.add(this);
            }

        if (tourist.TouristVisit.contains(this)){
            tourist.TouristVisit.add(this);
        }
        */
    }
    public Tourist getRTourist() {
        return this.tourist;
    }
}
