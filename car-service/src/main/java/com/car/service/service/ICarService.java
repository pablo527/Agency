package com.car.service.service;

import com.car.service.entity.Car;

import java.util.List;

public interface ICarService {
    Car getCarById(Long id);
    List<Car> getAllCars();
    Car createCar(Car user);
    List<Car> getByUserId (Long userId);
}
