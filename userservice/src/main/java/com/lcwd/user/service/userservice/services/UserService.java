package com.lcwd.user.service.userservice.services;

import java.util.List;

import com.lcwd.user.service.userservice.entities.User;

public interface UserService {
    
    //user operations

    //create
    User saveUser(User user);
    List<User> getAllUser();
    //get single user
    User getUser(String userId);
    //delete
    void deleteUser(User user);
    //update
    User updatUser(User user);
}
