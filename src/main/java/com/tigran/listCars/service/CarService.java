package com.tigran.listCars.service;

import com.tigran.listCars.entity.Car;
import com.tigran.listCars.jpaRepo.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class CarService {

    @Autowired
    private CarRepository carRepository;


    public List<Car> getAllCars() {
        List<Car> allCars = carRepository.findAll();
        return allCars;
    }

    public void saveCar(Car car) {

        Car byBrandYearPrice = carRepository.findByLink(car.getLink());
        if (byBrandYearPrice == null) {
            log.info("your car was added successfully");
            carRepository.save(car);
        } else {
            log.warn("this car was already added");
        }

    }

}
