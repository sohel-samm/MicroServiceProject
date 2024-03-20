package com.lcwd.user.service.userservice.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.user.service.userservice.entities.User;
import com.lcwd.user.service.userservice.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.userservice.repositories.UserRepository;
import com.lcwd.user.service.userservice.services.UserService;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        String uid=UUID.randomUUID().toString();
        user.setUserId(uid);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {

        return userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("given user id not found"));
    
    }

    @Override
    public void deleteUser(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    @Override
    public User updatUser(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatUser'");
    }
    
}
