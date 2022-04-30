package com.car.service.repository;

import com.car.service.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRespository extends JpaRepository<Car,Long> {
    List<Car> findByUserId(Long userId);
}
