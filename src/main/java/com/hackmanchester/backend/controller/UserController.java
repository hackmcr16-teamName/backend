package com.hackmanchester.backend.controller;

import com.hackmanchester.backend.model.User;
import com.hackmanchester.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public User getAllUsers()
    {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getUser()
    {

    }
}
