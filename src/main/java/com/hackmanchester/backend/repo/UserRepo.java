package com.hackmanchester.backend.repo;

import com.hackmanchester.backend.model.User;

import java.util.List;

/**
 * Created by ben on 29/10/16.
 */
public interface UserRepo {

    int insert(User user);
    User getUser(int id);
    List<User> getAllUsers();
    void deletUser(int id);
    void updateUser(User user);
}
