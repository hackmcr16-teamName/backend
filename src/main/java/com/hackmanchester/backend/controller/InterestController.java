package com.hackmanchester.backend.controller;

import com.hackmanchester.backend.model.Interest;
import com.hackmanchester.backend.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tony on 29/10/2016.
 */
@RestController
public class InterestController
{
    @Autowired
    private InterestService interestService;

    public InterestController() {}

    @RequestMapping(value = "/Interest", method = RequestMethod.GET)
    public List<Interest> getInterests()
    {
        return interestService.getAllInterest();
    }

    @RequestMapping(value = "/Interest", method = RequestMethod.POST)
    public void addInterest(@RequestBody Interest interest)
    {
        if(interest == null)
            throw new NullPointerException("Interest object passed to addInterest() in InterestController is NULL.");

        interestService.insert(interest);
    }

    @RequestMapping(value = "/Interest", method = RequestMethod.PUT)
    public void updateInterest(@RequestBody Interest interest)
    {
        if(interest == null)
            throw new NullPointerException("Interest object passed to updateInterest() in InterestController is NULL.");

        interestService.updateInterest(interest);
    }

    @RequestMapping(value = "/Interest", method = RequestMethod.DELETE)
    public void deleteInterest(@RequestBody Interest interest)
    {
        if(interest == null)
            throw new NullPointerException("Interest object passed to deleteInterest() in InterestController is NULL.");

        interestService.deleteInterest(interest.getInterestID());
    }

}
