package com.user.service.service;

import com.user.service.entity.User;
import com.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    UserRepository repository;

    @Override
    public User getUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> null);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User createUser(User user) {

        return repository.save(user);
    }
}
