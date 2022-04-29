package com.user.service.service;

import com.user.service.entity.User;

import java.util.List;

public interface IUserService {
    User getUserById(Long id);
    List<User> getAllUsers();
    User createUser(User user);
}
