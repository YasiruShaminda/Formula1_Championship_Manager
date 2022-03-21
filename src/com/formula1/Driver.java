package com.formula1;

import java.io.Serializable;

/**
 * The Driver class represents each driver in the Championship Manager.
 *
 * @author Yasiru Luvishewa
 */
public abstract class Driver implements Serializable {
    String name;
    String country;
    String team;

    /**
     * This constructs a Driver with main details
     * @param name The name of the driver.
     * @param country The country of the driver.
     * @param team The team of the driver.
     */
    public Driver( String name, String country, String team)
    {
        this.name = name;
        this.country = country;
        this.team = team;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public void setTeam(String team)
    {
        this.team = team;
    }

    public String getName()
    {
        return name;
    }

    public String getCountry()
    {
        return country;
    }

    public String getTeam()
    {
        return team;
    }

}