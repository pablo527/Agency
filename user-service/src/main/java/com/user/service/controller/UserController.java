package com.user.service.controller;

import com.user.service.entity.User;
import com.user.service.models.Car;
import com.user.service.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService service;

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id")Long id){
        User user = service.getUserById(id);

        if (user == null) ResponseEntity.notFound().build();
       return  ResponseEntity.ok(user);
    }

    @GetMapping()
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = service.getAllUsers();
        if (users.isEmpty()) ResponseEntity.noContent().build();
        return  ResponseEntity.ok(users);
    }
    @GetMapping("/car/{userId}")
    public ResponseEntity<List<Car>> listCars(@PathVariable("userId") long userId){
        User user = service.getUserById(userId);
        if (user == null) ResponseEntity.notFound().build();
        return ResponseEntity.ok(service.getCars(userId));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        String name = user.getName();
        System.out.println(name);
      return ResponseEntity.ok(service.createUser(user));
    }


}
