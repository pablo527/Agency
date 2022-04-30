package com.car.service.service;

import com.car.service.entity.Car;
import com.car.service.repository.CarRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements  ICarService{

    @Autowired
    CarRespository repository;

    @Override
    public Car getCarById(long id) {
        return repository.findById(id)
                .orElseThrow(()-> null);
    }

    @Override
    public List<Car> getAllCars() {
        return repository.findAll();
    }

    @Override
    public Car createCar(Car user) {
        return repository.save(user);
    }

    public List<Car> findByUserId(long userId) {
        return repository.findByUserId(userId);
    }
}
