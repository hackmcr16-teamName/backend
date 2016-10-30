package com.hackmanchester.backend.service.impl;

import com.hackmanchester.backend.model.Interest;
import com.hackmanchester.backend.repo.InterestRepo;
import com.hackmanchester.backend.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tony on 29/10/2016.
 */
@Service("interestService")
public class InterestServiceImpl implements InterestService
{
    @Autowired
    private InterestRepo interestRepo;

    public int insert(Interest interest)
    {
        return interestRepo.insert(interest);
    }

    public Interest getInterest(int id)
    {
        return interestRepo.getInterest(id);
    }

    public List<Interest> getAllInterest()
    {
        return interestRepo.getAllInterest();
    }

    public void deleteInterest(int id)
    {
        interestRepo.deleteInterest(id);
    }

    public void updateInterest(Interest interest)
    {
        interestRepo.updateInterest(interest);
    }
}
