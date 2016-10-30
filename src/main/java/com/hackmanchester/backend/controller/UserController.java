package com.hackmanchester.backend.controller;

import com.hackmanchester.backend.model.Interest;
import com.hackmanchester.backend.model.User;
import com.hackmanchester.backend.model.UserInterests;
import com.hackmanchester.backend.model.UserInterestsID;
import com.hackmanchester.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/users/interests/{id}", method = RequestMethod.GET)
    public List<UserInterests> getAllSimilarInterests(@PathVariable int id)
    {
        return userService.getUsersWithSimilarInterests(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getUser(@RequestBody int id)
    {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public UserInterestsID addUser(@RequestBody UserInterests userInterests)
    {
        User user = new User(0, userInterests.getName(), userInterests.getTelephone(), userInterests.getBranchID(), userInterests.getBase64Image());
        List<Interest> interests = userInterests.getInterests();

        User newUser = userService.addUser(user);

        userService.addUserInterestList(newUser.getUserID(), interests);

        UserInterestsID newUserInterests = new UserInterestsID(newUser.getUserID());
        newUserInterests.setName(userInterests.getName());
        newUserInterests.setTelephone(userInterests.getTelephone());
        newUserInterests.setInterests(interests);
        newUserInterests.setBase64Image(userInterests.getBase64Image());
        newUserInterests.setBranchID(userInterests.getBranchID());

        return newUserInterests;
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
