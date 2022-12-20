package com.example.demo.Tourist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class TouristConfig {
    /*@Bean
    CommandLineRunner commandLineRunner(TouristRepository repository){
        return args -> {
            Tourist sara= new Tourist(
                    "sara",
                    "manel",
                    "sara@gmail.com",
                    LocalDate.of(2000, Month.SEPTEMBER,2),
                    "sara123",
                    123456,
                    null
            );
            Tourist amina=new Tourist(
                    "amina",
                    "lakhdari",
                    "amina@gmail.com",
                    LocalDate.of(2000, Month.MAY, 2),
                    "sara123",
                    123456,
                    null
            );
            repository.saveAll(List.of(sara,amina));

        };
    }*/
}
