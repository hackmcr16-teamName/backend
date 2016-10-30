package com.hackmanchester.backend.controller;

import com.hackmanchester.backend.model.User;
import com.hackmanchester.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tony on 30/10/2016.
 */
@RestController
public class UserController
{
    @Autowired
    private UserService userService;

    public UserController() {}

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getUser(@RequestBody int id)
    {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public User addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user)
    {
         userService.updateUser(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.DELETE)
    public void deleteUser(@RequestBody int id)
    {
        userService.deleteUser(id);
    }
}
