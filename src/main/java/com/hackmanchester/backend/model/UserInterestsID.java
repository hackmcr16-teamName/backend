package com.hackmanchester.backend.model;

import java.util.List;

/**
 * Created by tony on 30/10/2016.
 */
public class UserInterestsID extends UserInterests
{
    private int id;

    public UserInterestsID(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
