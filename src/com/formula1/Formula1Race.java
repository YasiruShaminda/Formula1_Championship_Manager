package com.formula1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The Formula1Race class represents each Race int the Formula1 Championship.
 *
 * @author Yasiru luvishewa
 */
public class Formula1Race implements Serializable
{

    LocalDate date;
    String location;
    String circuit;
    ArrayList <Formula1Driver> raceDrivers = new ArrayList<Formula1Driver>(10);

    /**
     * This constructs a F1 Race with race details.
     * @param date Date of the Race.
     * @param location Location of the Race.
     * @param circuit Circuit of the Race.
     * @param raceDrivers List of drivers who participated in the race.
     */
    public Formula1Race(LocalDate date, String location, String circuit, ArrayList raceDrivers) {
        this.date = date;
        this.location = location;
        this.circuit = circuit;
        this.raceDrivers = raceDrivers;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCircuit(String circuit) {
        this.circuit = circuit;
    }

    public void setDriverPositions(ArrayList raceDrivers) {
        this.raceDrivers = raceDrivers;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getCircuit() {
        return circuit;
    }

    public ArrayList<Formula1Driver> getDriverPositions() {
        return raceDrivers;
    }
}
