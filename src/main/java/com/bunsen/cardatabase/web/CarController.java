package com.bunsen.cardatabase.web;

import com.bunsen.cardatabase.domain.Car;
import com.bunsen.cardatabase.domain.CarRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/cars")
    public Iterable<Car> getCars(){
        return carRepository.findAll();
    }
}
