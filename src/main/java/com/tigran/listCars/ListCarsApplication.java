package com.tigran.listCars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ListCarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListCarsApplication.class, args);
	}

}
