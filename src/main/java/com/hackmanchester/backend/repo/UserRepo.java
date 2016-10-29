package com.hackmanchester.backend.repo;

import com.hackmanchester.backend.model.User;

/**
 * Created by ben on 29/10/16.
 */
public interface UserRepo {

    void insert(User user);
    User getUser(int id);
    void deletUser(int id);
    void updateUser(User user);
}
