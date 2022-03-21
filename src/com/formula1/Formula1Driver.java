package com.formula1;

import static java.lang.String.format;

import java.io.Serializable;
import java.util.Comparator;

/**
 * The Formula1Driver class represents each Formula1 driver in the Formula1 championship.
 *
 * @author Yasiru Luvishewa
 */
public class Formula1Driver extends Driver implements Serializable
{
    public static final String R = "\u001B[0m";     //String color Rest
    public static final String B = "\033[0;34m";    //String color BLUE //"\033[0;34m"

    int fstPos;
    int scndPos;
    int trdPos;
    int raceCount;
    int driverPoints;

    /**
     * This constructs a Formula1Driver with driver details.
     * @param name The name of the driver.
     * @param country The country of the driver.
     * @param team  The team name of the driver.
     * @param fstPos The first positions count of the driver.
     * @param scndPos The second positions count of the driver.
     * @param trdPos The third positions count of the driver.
     * @param driverPoints The total points earned by the driver.
     * @param raceCount The count of races participated by the driver.
     */
    public Formula1Driver(String name, String country, String team, int fstPos, int scndPos, int trdPos, int driverPoints, int raceCount)
    {
        super(name, country, team);
        this.fstPos = fstPos;
        this.scndPos = scndPos;
        this.trdPos = trdPos;
        this.driverPoints = driverPoints;
        this.raceCount = raceCount;
    }

    public void setFstPos(int fstPos) {
        this.fstPos = fstPos;
    }

    public void setScndPos(int scndPos) {
        this.scndPos = scndPos;
    }

    public void setTrdPos(int trdPos) {
        this.trdPos = trdPos;
    }

    public void setDriverPoints(int driverPoints) {
        this.driverPoints = driverPoints;
    }

    public void setRaceCount(int raceCount) {
        this.raceCount = raceCount;
    }

    public int getFstPos() {
        return fstPos;
    }

    public int getScndPos() {
        return scndPos;
    }

    public int getTrdPos() {
        return trdPos;
    }

    public int getDriverPoints() {
        return driverPoints;
    }

    public int getRaceCount() {
        return raceCount;
    }


    @Override
    public String toString()
    {
        return  format(B+"|"+R+" %-20s"+B+"|"+R+" %-15s"+B+"|"+R+" %-15s"+B+"|"+R+"%12d "+B+"|"+R+"%12d "+B+"|"+R+"%12d "+B+"|"+R+" %15d "+B+"|"+R+"%15d "+B+"|", name,country,team,fstPos,scndPos,trdPos,driverPoints,raceCount)
                + "\n+---------------------+----------------+----------------+-------------+-------------+-------------+-----------------+----------------+"+R;

    }

    public static Comparator<Formula1Driver> fstPosComparator = new Comparator<Formula1Driver>()
    {
        @Override
        public int compare(Formula1Driver d1, Formula1Driver d2)
        {
            int driver1FstPos = d1.getFstPos();
            int driver2FstPos = d2.getFstPos();
            return driver2FstPos-driver1FstPos;
        }
    };

    public static Comparator<Formula1Driver> pointsComparator = new Comparator<Formula1Driver>()
    {
        @Override
        public int compare(Formula1Driver d1, Formula1Driver d2)
        {
            int driver1Points = d1.getDriverPoints();
            int driver2Points = d2.getDriverPoints();
            return driver2Points-driver1Points;
        }
    };


}
