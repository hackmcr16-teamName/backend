package com.hackmanchester.backend.controller;

import com.hackmanchester.backend.model.Interest;
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
    public InterestController() {}

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Interest> getInterests()
    {
        return null;
    }
}
