package com.example.demo.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class TestManager {


    Tourist hadir, amani, sara, ahmed;
    Place constantine , mila , alger , annaba  , oran;

    ArrayList<Tourist> tourists;
    ArrayList<Place> places;
    ArrayList<Visit> visites;


    @BeforeEach
    void setUp() throws Exception {

        //add tourists
        hadir = new Tourist(1 , "hadir" , "kadri" , "hadir.kadri@gmail.com" , "hadir1234" ,
                new GregorianCalendar(2000, Calendar.JUNE, 8).getTime(), 1 , "hadirProfilePhotoFile");

        amani = new Tourist(2 ,"amani" , "herida" , "amani.herida@gmail.com" , "amani1234" ,
                new GregorianCalendar(1999, Calendar.JULY, 28).getTime(), 2 , "amaniprofilePhotoFile");

        sara = new Tourist(3 ,"sara" , "kerbab" , "sara.kerbab@gmail.com" , "sara1234" ,
                new GregorianCalendar(1998, Calendar.OCTOBER, 11).getTime(), 3 , "saraProfilePhotoFile");

        ahmed = new Tourist(4 ,"Ahmed" , "Chaouche" , "ahmed.chaouche@gmail.com" , "ahmed1234" ,
                new GregorianCalendar(1980, Calendar.JANUARY, 11).getTime(), 4 , "ahmedProfilePhotoFile");

        tourists = new ArrayList<>();

        tourists.add(hadir);
        tourists.add(amani);
        tourists.add(sara);
        tourists.add(ahmed);

        //add place
        constantine = new Place(11, "constantine", "constantine description", new GregorianCalendar(2022, Calendar.NOVEMBER, 21).getTime());
        mila = new Place(12, "mila", "mila description", new GregorianCalendar(2022, Calendar.NOVEMBER, 21).getTime());
        alger = new Place(13, "alger", "alger description", new GregorianCalendar(2022, Calendar.NOVEMBER, 21).getTime());
        annaba = new Place(14, "annaba", "annaba description", new GregorianCalendar(2022, Calendar.NOVEMBER, 21).getTime());
        oran = new Place(15, "oran", "oran description", new GregorianCalendar(2022, Calendar.NOVEMBER, 21).getTime());

        //add address to places
        constantine.addAddress(new Address(1,30.04589, 6.3802, "street", "ali mandjli", "25000" , "Algeria"));
        mila.addAddress(new Address(2,30.04589, 6.3802, "street", "ali mandjli", "25000" , "Algeria"));
        alger.addAddress(new Address(3,30.04589, 6.3802, "street", "ali mandjli", "25000" , "Algeria"));
        annaba.addAddress(new Address(4,30.04589, 6.3802, "street", "ali mandjli", "25000" , "Algeria"));
        oran.addAddress(new Address(5,30.04589, 6.3802, "street", "ali mandjli", "25000" , "Algeria"));


        //add photos to place
        Photo p1 =new Photo(1, "photo01FilePath", new GregorianCalendar(2022, Calendar.NOVEMBER, 21).getTime());
        constantine.addPlacePhoto(p1);

        Photo p2 = new Photo(2, "photo02FilePath", new GregorianCalendar(2022, Calendar.NOVEMBER, 21).getTime());
        constantine.addPlacePhoto(p2);

        Photo p3 = new Photo(3, "photo03FilePath", new GregorianCalendar(2022, Calendar.NOVEMBER, 21).getTime());
        constantine.addPlacePhoto(p3);

        mila.addPlacePhoto(p3);

        Photo p4 = new Photo(4, "photo04FilePath", new GregorianCalendar(2022, Calendar.NOVEMBER, 21).getTime());
        alger.addPlacePhoto(p4);


        Photo p5 = new Photo(5, "photo05FilePath", new GregorianCalendar(2022, Calendar.NOVEMBER, 21).getTime());
        annaba.addPlacePhoto(p5);

        oran.addPlacePhoto(p4);


        //add visit
        Visit visit01 = new Visit("photo01FilePath", 4, "great place", new GregorianCalendar(2022, Calendar.NOVEMBER, 21).getTime()
                ,hadir,constantine);
        constantine.addPlaceVisit(visit01);
        hadir.addTouristVisit(visit01);

        Visit visit02 = new Visit("photo02FilePath", 3, "great place", new GregorianCalendar(2022, Calendar.NOVEMBER, 21).getTime()
                ,amani , constantine);
        constantine.addPlaceVisit(visit02);
        amani.addTouristVisit(visit02);


        Visit visit03 = new Visit("photo03FilePath", 2, "great place", new GregorianCalendar(2022, Calendar.NOVEMBER, 21).getTime()
                ,sara , constantine);
        constantine.addPlaceVisit(visit03);
        sara.addTouristVisit(visit03);

        Visit visit04 = new Visit("photo04FilePath", 4, "great place", new GregorianCalendar(2022, Calendar.NOVEMBER, 21).getTime()
                ,ahmed , oran);
        oran.addPlaceVisit(visit04);
        ahmed.addTouristVisit(visit04);

        Visit visit05 = new Visit("photo05FilePath", 4, "great place", new GregorianCalendar(2022, Calendar.NOVEMBER, 21).getTime()
                ,hadir , mila);
        mila.addPlaceVisit(visit05);
        hadir.addTouristVisit(visit05);

        Visit visit06 = new Visit("photo06FilePath", 4, "great place", new GregorianCalendar(2022, Calendar.NOVEMBER, 21).getTime()
                ,ahmed , alger);


        ahmed.addTouristVisit(visit06);
        alger.addPlaceVisit(visit06);


        ahmed.addTouristVisit(visit03);


        places = new ArrayList<>();
        places.add(constantine);
        places.add(mila);
        places.add(alger);
        places.add(annaba);
        places.add(oran);

        visites = new ArrayList<>();
        visites.add(visit01);
        visites.add(visit02);
        visites.add(visit03);
        visites.add(visit04);
        visites.add(visit05);
        visites.add(visit06);


    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    public void testTouristEquals() {
        assertNotNull(hadir);
        Tourist t = new Tourist();
        t.setId(1);
        assertEquals(t, hadir);
    }

    @Test
    public void testAddress(){
        assertNotNull(constantine);
        assertNotNull(constantine.getAddress().getWilayaCode());
        assertEquals("25", constantine.getAddress().getWilayaCode());
    }

    @Test
    public void testTouristVisitNumber(){
        assertNotNull(ahmed);
        int visitNumber = 0;
        for (Visit v : visites) {
            if(v.getRTourist().getId() == ahmed.getId()){
                visitNumber = visitNumber + 1;
            }
        }
        assertEquals(3, visitNumber);
    }

    @Test
    public void testPlaceNotVisitNumber(){
        int placeNumber = 0;
        for (Place p : places) {
            if(p.getRVisit().size() == 0){
                placeNumber = placeNumber + 1;
            }
        }
        assertEquals(1 , placeNumber);
    }

    @Test
    public void testTouristNotVisitNumber(){
        int touristNumber = 0;
        for (Tourist t : tourists) {
            if(t.getRVisit().size() == 0){
                touristNumber = touristNumber + 1;
            }
        }
        assertEquals(1 , touristNumber);
    }


    @Test
    public void testPlacetNoPhotoNumber(){
        int photoNumber = 0;
        for (Place p : places) {
            if(p.getRPhoto().size() == 0){
                photoNumber = photoNumber + 1;
            }
        }
        assertEquals(0 , photoNumber);
    }

    @Test
    public void testPlacePhotoNumber(){
        assertNotNull(constantine);
        assertEquals(3, constantine.getRPhoto().size());
        assertNotNull(alger);
        assertEquals(1, alger.getRPhoto().size());
    }


    ///place with visit >= 2
    @Test
    public void testPlaceWithvisit(){
        int visitNumber = 0;
        for (Place v : places) {
            if(v.getRVisit().size() >= 2){
                visitNumber = visitNumber + 1;
            }
        }
        assertEquals(1 , visitNumber);
    }

    ///tourist with visit >= 1
    @Test
    public void testTouistWithvisit(){
        int visitNumber = 0;
        for (Tourist t : tourists) {
            if(t.getRVisit().size() >= 1){
                visitNumber = visitNumber + 1;
            }
        }
        assertEquals(3 , visitNumber);
    }

    @Test
    public void testVote(){
        assertNotNull(hadir);
        assertNotNull(constantine);
        assertEquals(4 , hadir.vote(constantine));
    }

    @Test
    public void testResetPasswordNotWork(){
        assertNotNull(ahmed);
        ahmed.resetPassword("ahmed124", "ahmed12");
        assertEquals("ahmed1234" , ahmed.getPassword());
    }

    @Test
    public void testResetPasswordWork(){
        assertNotNull(ahmed);
        ahmed.resetPassword("ahmed1234", "ahmed12");
        assertEquals("ahmed12" , ahmed.getPassword());
    }

}