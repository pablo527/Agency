package com.user.service.service;

import com.user.service.entity.User;
import com.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    UserRepository repository;

   @Autowired
    RestTemplate restTemplate;

    @Override
    public User getUserById(Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User createUser(User user) {

        return repository.save(user);
    }

    @Override
    public List getCars(long userId) {
        String url = "http://localhost:8002/car/user/";
        return restTemplate.getForObject(url + userId, List.class);
    }
}
