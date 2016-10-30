package com.hackmanchester.backend.service.impl;

import com.hackmanchester.backend.model.Interest;
import com.hackmanchester.backend.model.User;
import com.hackmanchester.backend.model.UserInterests;
import com.hackmanchester.backend.repo.UserRepo;
import com.hackmanchester.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        userRepo.deleteUser(id);
    }

    public void addUserInterestList(int userID, List<Interest> interests)
    {
        for(Interest interest : interests)
            userRepo.addUserInterest(userID, interest);
    }

    public UserInterests getUsersInterests(int id)
    {
        UserInterests userIntr = new UserInterests();
        User user = getUser(id);

        userIntr.setName(user.getName());
        userIntr.setTelephone(user.getTelNo());
        userIntr.setInterests(userRepo.getUsersInterests(id));
        userIntr.setBranchID(user.getBranchID());
        userIntr.setBase64Image(user.getBase64Image());

        return userIntr;
    }

    @Transactional
    public List<UserInterests> getUsersWithSimilarInterests(int id)
    {
        List<User> users = userRepo.getUsersWithSimilarInterests(id);
        List<UserInterests> usersIntr = new ArrayList<UserInterests>();

        UserInterests userInterests = getUsersInterests(id);

        for(int i = 0; i < users.size(); i++)
        {

            String name = users.get(i).getName();
            String telephone = users.get(i).getTelNo();
            List<Interest> interests = userInterests.getInterests();
            String base64Image = users.get(i).getBase64Image();
            int brandID = users.get(i).getBranchID();

            usersIntr.add(new UserInterests(name, telephone, interests, base64Image, brandID));
        }

        return usersIntr;
    }
}
