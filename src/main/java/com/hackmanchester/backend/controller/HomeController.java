package com.hackmanchester.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by tony on 29/10/2016.
 */
@Controller
public class HomeController
{
    public HomeController() {}

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome()
    {
        return "index";
    }
}
