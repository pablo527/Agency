package com.user.service.service;

import com.user.service.entity.User;
import com.user.service.models.Car;

import java.util.List;

public interface IUserService {
    User getUserById(Long id);
    List<User> getAllUsers();
    User createUser(User user);
    List<Car> getCars(long userId);
    Car saveCar(long userId, Car car);
}
