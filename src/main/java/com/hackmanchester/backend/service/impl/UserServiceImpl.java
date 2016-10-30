package com.hackmanchester.backend.service.impl;

import com.hackmanchester.backend.model.User;
import com.hackmanchester.backend.repo.UserRepo;
import com.hackmanchester.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tony on 30/10/2016.
 */
@Service("userService")
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepo userRepo;

    public User getUser(int id)
    {
        return userRepo.getUser(id);
    }

    public List<User> getAllUsers()
    {
        return userRepo.getAllUsers();
    }

    public User addUser(User user)
    {
        return userRepo.addUser(user);
    }

    public void updateUser(User user)
    {
        userRepo.addUser(user);
    }

    public void deleteUser(int id)
    {
        userRepo.deletUser(id);
    }
}
