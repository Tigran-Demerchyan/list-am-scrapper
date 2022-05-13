package com.tigran.listCars.dto;

import com.tigran.listCars.entity.Car;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarDto {
    private String brand;
    private int year;
    private double price;
    private String link;

    public CarDto(Car car) {
        this.brand = car.getBrand();
        this.year = car.getYear();
        this.price = car.getPrice();
        this.link=car.getLink();
    }
}
