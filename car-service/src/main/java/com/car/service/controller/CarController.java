package com.car.service.controller;

import com.car.service.entity.Car;
import com.car.service.service.CarServiceImpl;
import com.car.service.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarServiceImpl service;

    @GetMapping("{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id")long id){
        Car car = service.getCarById(id);

        if (car == null) ResponseEntity.notFound().build();
        return  ResponseEntity.ok(car);
    }

    @GetMapping()
    public ResponseEntity<List<Car>> getCars(){
        List<Car> cars = service.getAllCars();
        if (cars.isEmpty()) ResponseEntity.noContent().build();
        return  ResponseEntity.ok(cars);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Car>> getCarsByUser(@PathVariable("userId") long id){
        List<Car> cars = service.findByUserId(id);
        if (cars.isEmpty()) ResponseEntity.noContent().build();
        return  ResponseEntity.ok(cars);
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car){

        return ResponseEntity.ok(service.createCar(car));
    }
}
