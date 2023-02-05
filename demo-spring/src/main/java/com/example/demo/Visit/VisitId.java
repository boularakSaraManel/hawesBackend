package com.example.demo.Visit;

import com.example.demo.Place.Place;
import com.example.demo.Tourist.Tourist;
import org.hibernate.loader.entity.plan.PaddedBatchingEntityLoader;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.Serializable;


@Embeddable
public class VisitId implements Serializable {
    private Tourist tourist;
    private Place place;

    public Tourist getTourist() {
        return tourist;
    }

    public Place getPlace(){
        return place;
    }
}
