package com.example.demo.Address;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AddressConfig {
    /*@Bean
    CommandLineRunner commandLineRunner(AddressRepository repository){
        return args -> {
            Address address1= new Address(
                    3.14,
                    5.18,
                    "Boussouf",
                    "Constantine",
                    25100,
                    "Algeria"
            );
            Address address2= new Address(
                    3.17,
                    7.20,
                    "Faubour",
                    "Constantine",
                    25000,
                    "Algeria"
            );

            repository.saveAll(List.of(address1,address2));
        };}*/
}
