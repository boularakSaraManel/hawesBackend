package com.example.demo.Visit;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table
public class Visit implements Serializable {
        @EmbeddedId
        private VisitId visit_id;
        //make obj visitID comp de placeid and touristid and make it serializable
        private String comment;

}