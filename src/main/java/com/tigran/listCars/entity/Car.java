package com.tigran.listCars.entity;

import com.tigran.listCars.dto.CarDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@Data
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "year")
    private int year;
    @Column(name = "price")
    private double price;
    @Column(name = "link")
    private String link;

    public Car(CarDto dto) {
        this.brand = dto.getBrand();
        this.year = dto.getYear();
        this.price = dto.getPrice();
        this.link=dto.getLink();
    }
}
