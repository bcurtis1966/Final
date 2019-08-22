package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    CarRepository repository;

    @Override
    public void run(String... strings) throws Exception{
        Car car;
        car = new Car("1999", "Honda", "Pilot");
        repository.save(car);
        car = new Car("2015", "Chevy", "Camaro");
        repository.save(car);
        car = new Car("2019", "VW", "Bug");
        repository.save(car);
    }

}
