package com.hackmanchester.backend.repo;

import com.hackmanchester.backend.model.Interest;
import com.hackmanchester.backend.model.User;

import java.util.List;

/**
 * Created by ben on 29/10/16.
 */
public interface UserRepo
{

    User addUser(User user);
    User getUser(int id);
    List<User> getAllUsers();
    void deleteUser(int id);
    void updateUser(User user);
    void addUserInterest(int userID, Interest interest);
    List<Interest> getUsersInterests(int id);
    List<User> getUsersWithSimilarInterests(int id);
}
