package com.example.demo.Tourist;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service //or component
public class TouristService {

    private final TouristRepository touristRepository;
    @Autowired
    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public List<Tourist> getTourists(){
        return touristRepository.findAll();
    }
    public void addNewTourist(Tourist tourist) {
        Optional<Tourist> touristOptional = touristRepository.findTouristByEmail(tourist.getEmail());
        if (touristOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }

        touristRepository.save(tourist);

    }

    //used by admin only, update deletedAt and do not delete
    public void deleteTourist(Long touristId) {
        boolean exists= touristRepository.existsById(touristId);
        if (!exists){
            throw new IllegalStateException("tourist with id "+ touristId+" does not exist!!");
        }
        touristRepository.deleteById(touristId);
    }

    @Transactional //not using any queries: just getters and setters to not access database
    public void updateTourist(Long touristId,String fname, String lname, String email, LocalDate dob, String password) { //add password
        Tourist tourist=touristRepository.findById(touristId).orElseThrow(()-> new IllegalStateException("tourist with id "+ touristId+" does not exist!!"));


        if(fname!=null && fname.length()>0 && !Objects.equals(tourist.getFirstname(), fname) ){
            tourist.setFirstname(fname);
        }

        if(lname!=null && lname.length()>0 && !Objects.equals(tourist.getLastname(), lname) ){
            tourist.setLastname(lname);
        }

        if(email!=null && email.length()>0 && !Objects.equals(tourist.getEmail(), email ) ){
            //not the first cuz no email is supposed to belong to 2 accounts
            // Optional<Tourist> touristOptional= touristRepository.findTouristByEmail(email).stream().findFirst();
            Optional<Tourist> touristOptional= touristRepository.findTouristByEmail(email);
            if(touristOptional.isPresent()){
                throw new IllegalStateException("email taken by another account");
            }
            tourist.setEmail(email);
        }

        if(dob!=null && !Objects.equals(tourist.getDob(), dob) ){
            tourist.setDob(dob);
        }

        if(password!=null && !Objects.equals(tourist.getPassword(), password)){
            tourist.setPassword(password);
        }

        touristRepository.save(tourist);


    }
}
