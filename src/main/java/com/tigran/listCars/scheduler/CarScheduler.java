package com.tigran.listCars.scheduler;

import com.tigran.listCars.controller.CarController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class CarScheduler {

    @Autowired
    private CarController carController;

    @Scheduled(fixedRate = 50_000)
    public void saveCar() throws IOException {
        carController.addCar();
    }
}
