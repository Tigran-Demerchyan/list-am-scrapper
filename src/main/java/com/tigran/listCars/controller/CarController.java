package com.tigran.listCars.controller;

import com.tigran.listCars.dto.CarDto;
import com.tigran.listCars.entity.Car;
import com.tigran.listCars.scrapper.CarScrapper;
import com.tigran.listCars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cars")
public class CarController {


    @Autowired
    public CarService carService;


    @GetMapping
    public List<CarDto> getAllCars() {
        List<Car> allCars = carService.getAllCars();

        List<CarDto> carDtos = allCars.stream()
                .map(c -> new CarDto(c))
                .collect(Collectors.toList());
        return carDtos;
    }

    @PostMapping("/save")
    public void addCar() throws IOException {

        CarScrapper scrapper = new CarScrapper();
        List<CarDto> allCars = scrapper.getAllCars();

        allCars.stream()
                .map(dto -> new Car(dto))
                .forEach(car -> carService.saveCar(car));

    }
}
