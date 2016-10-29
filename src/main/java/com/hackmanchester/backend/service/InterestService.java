package com.hackmanchester.backend.service;

import com.hackmanchester.backend.model.Interest;

import java.util.List;

/**
 * Created by tony on 29/10/2016.
 */
public interface InterestService
{
    int insert(Interest interest);
    Interest getInterest(int id);
    List<Interest> getAllInterest();
    void deleteInterest(int id);
    void updateInterest(Interest interest);
}
