package com.car.service.controller;

import com.car.service.entity.Car;
import com.car.service.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    ICarService service;

    @GetMapping("{id}")
    public ResponseEntity<Car> getUserById(@PathVariable("id")Long id){
        Car car = service.getCarById(id);

        if (car == null) ResponseEntity.notFound().build();
        return  ResponseEntity.ok(car);
    }

    @GetMapping()
    public ResponseEntity<List<Car>> getUsers(){
        List<Car> cars = service.getAllCars();
        if (cars.isEmpty()) ResponseEntity.noContent().build();
        return  ResponseEntity.ok(cars);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Car>> getCarsByUser(@PathVariable("userId") Long id){
        List<Car> cars = service.getByUserId(id);
        if (cars.isEmpty()) ResponseEntity.noContent().build();
        return  ResponseEntity.ok(cars);
    }

    @PostMapping
    public ResponseEntity<Car> createUser(@RequestBody Car car){

        return ResponseEntity.ok(service.createCar(car));
    }
}
