package com.example.demo.Tourist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="api/tourist")
public class TouristController {

    private final TouristService TouristService;
    private final TouristRepository TouristRepository;

    @Autowired
    public TouristController(TouristService touristService,
                             TouristRepository touristRepository){
        this.TouristService=touristService;
        this.TouristRepository = touristRepository;
    }

    @GetMapping
    public List<Tourist> getTourists(){
        return TouristService.getTourists();
    }

    @PostMapping
    public void registerTourist(@RequestBody Tourist tourist){
        TouristService.addNewTourist(tourist);

    }

    @DeleteMapping(path= "{touristId}")
    public void deleteTourist(@PathVariable("touristId") Long touristId){
        TouristService.deleteTourist(touristId);
    }

    @PutMapping(path="{studentId}") //add password
    public void updateTourist(@PathVariable("studentId") Long touristId,
                                 @RequestParam(required = false) String fname,
                                 @RequestParam(required = false) String lname,
                                 @RequestParam(required = false) String email,
                                 @RequestParam(required = false)LocalDate dob,
                                 @RequestParam(required = false)String password){
        TouristService.updateTourist(touristId,fname,lname,email, dob, password);

    }


}
