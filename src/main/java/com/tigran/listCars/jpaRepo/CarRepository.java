package com.tigran.listCars.jpaRepo;

import com.tigran.listCars.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("from Car c where c.link=:link")
   Car findByLink (@Param("link")String link);
}
