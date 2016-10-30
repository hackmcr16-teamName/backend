package com.hackmanchester.backend.service;

import com.hackmanchester.backend.model.User;

import java.util.List;

/**
 * Created by tony on 30/10/2016.
 */
public interface UserService
{
    User getUser(int id);
    List<User> getAllUsers();
    User addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
}
