package com.hackmanchester.backend.service;

import com.hackmanchester.backend.model.Interest;
import com.hackmanchester.backend.model.User;
import com.hackmanchester.backend.model.UserInterests;

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
    void addUserInterestList(int userID, List<Interest> interests);
    UserInterests getUsersInterests(int id);
    List<UserInterests> getUsersWithSimilarInterests(int id);
}
