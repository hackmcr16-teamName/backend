package com.hackmanchester.backend.model;

import java.util.List;

/**
 * Created by tony on 30/10/2016.
 */
public class UserInterests
{
    private String name;
    private String telephone;
    private List<Interest> interests;
    private String base64Image;

    public UserInterests()
    {

    }

    public UserInterests(String name, String telephone, List<Interest> interests, String base64Image)
    {
        this.name = name;
        this.telephone = telephone;
        this.interests = interests;
        this.base64Image = base64Image;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public List<Interest> getInterests()
    {
        return interests;
    }

    public void setInterests(List<Interest> interests)
    {
        this.interests = interests;
    }

    public String getBase64Image()
    {
        return base64Image;
    }

    public void setBase64Image(String base64Image)
    {
        this.base64Image = base64Image;
    }
}
