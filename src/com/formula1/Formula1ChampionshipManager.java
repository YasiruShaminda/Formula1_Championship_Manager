package com.formula1;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.*;

public class Formula1ChampionshipManager implements Serializable,ChampionshipManager
{
    /**
     *Set console text colors and
     *console text background colors
     */
    public static final String R = "\u001B[0m";     //String color Rest
    public static final String B = "\033[0;34m";    //String color BLUE
    public static final String Y = "\033[0;93m";    //String color Yellow High Intensity //Yellow "\u001B[33m"
    public static final String C = "\033[0;96m";    //String color Cyan High Intensity
    public static final String P = "\u001B[35m";    //String color Purple
    public static final String BC = "\u001B[30m";   //String color Black
    public static final String BB = "\033[1;30m";   //String BLACK Bold
    public static final String W = "\u001B[37m";    //String color White
    public static final String BlB = "\033[44m";    //Background color Blue
    public static final String PB = "\u001B[45m";   //Background color Purple
//  Color codes :https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println


    /**
     * Format the Date inputs and
     * validate the date inputs
     */
    private static final Locale defaultFormattingLocale = Locale.getDefault(Locale.Category.FORMAT);
    private static final String defaultDateFormat = DateTimeFormatterBuilder.getLocalizedDateTimePattern(FormatStyle.SHORT, null, IsoChronology.INSTANCE, defaultFormattingLocale);
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(defaultDateFormat, defaultFormattingLocale);
//  For read date input: https://stackoverflow.com/questions/27580655/how-to-set-a-date-as-input-in-java

    String driverName;
    String teamName;
    String driverCountry;
    int fstPos;
    int scndPos;
    int trdPos;
    int driverPoints;
    int raceCount;

    static ArrayList<Formula1Driver> F1Driver = new ArrayList<Formula1Driver>();
    static ArrayList<Formula1Race> F1Race = new ArrayList<Formula1Race>();

    static int[] pointArr = {25,18,15,12,10,8,6,4,2,1};
    static ArrayList<Formula1Driver> raceDrivers = new ArrayList<Formula1Driver>(10);

    static Scanner input = new Scanner (System.in);

    public static void main (String [] args)
    {
        Formula1ChampionshipManager formula1ChampionshipManager = new Formula1ChampionshipManager();

        formula1ChampionshipManager.loadInfo();

        String option;

        boolean looper = true;
        while(looper)
        {
            System.out.println( "\n"+P+"---------------------------------------------------------------------------------\n"+
                    "---------------------------"+PB+"------ "+BC+"M E N U"+P+" ------"+R+P+"---------------------------------\n"+
                    "---------------------------------------------------------------------------------"+R);
            System.out.println(
                            " | "+ PB +BC+" A "+R+" : Create a new driver\n"
                            + " | "+ PB +BC+" B "+R+" : Delete a driver\n"
                            + " | "+ PB +BC+" C "+R+" : Change the driver\n"
                            + " | "+ PB +BC+" D "+R+" : Display Statistics(driver)\n"
                            + " | "+ PB +BC+" E "+R+" : Display Formula1 Driver table\n"
                            + " | "+ PB +BC+" F "+R+" : Add a race\n"
                            + " | "+ PB +BC+" G "+R+" : Save information\n"
                            + " | "+ PB +BC+" H "+R+" : Run User Interface\n"
                            + " | "+ PB +BC+" X "+R+" : Exit the Program");
            System.out.println(P+"---------------------------------------------------------------------------------"+R);
            System.out.print("Enter Your Choice : ");
            option = input.next().toUpperCase();
            System.out.println("---------------------------------------------------------------------------------");

            if (option.equals("X"))
            {
                looper = false;
                formula1ChampionshipManager.saveInfo();
            }
            else
                formula1ChampionshipManager.processIt(option);
        }
    }

    /**
     * Check the selected option from the menu and
     * executes the corresponding method.
     * @param option the option selected by the user from the menu
     */
    void processIt(String option)
    {
            if (option.equals("A"))
                createDriver();
            else if (option.equals("B"))
                deleteDriver();
            else if (option.equals("C"))
                changeDriver();
            else if (option.equals("D"))
                displayDriverStatistics();
            else if (option.equals("E"))
                displayDriverTable();
            else if (option.equals("F"))
                addrace();
            else if (option.equals("G"))
                saveInfo();
            else if (option.equals("H"))
                runGUI();
            else
                System.out.println(Y+" >> Please enter valid value"+R);

    }


    /**
     * Runs when the user inputs "A" as menu option.
     * Allows the user to add new drivers.
     * Adding new drivers to the F1Drivers Arraylist.
     */
    @Override
    public void createDriver()
    {
        try {
            while (true)
            {
                System.out.print("Enter Driver's Name : ");
                driverName = input.next();
                System.out.print("Enter Drivers' Team Name: ");
                teamName = input.next();

                boolean loop = false;
                for (Formula1Driver driver : F1Driver)
                {
                    if (driver.getTeam().equalsIgnoreCase(teamName))
                    {
                        loop = true;
                        break;
                    }
                }
                if (loop)
                {
                    System.out.println(Y+ ">> " + teamName + " Team Already Added With a Driver!" +R);
                    continue;
                } else
                {
                    break;
                }
            }

            // reads new driver's country, position counts, totalPoints and raceCounts from user

            System.out.print("Enter Driver's Country : ");
            driverCountry = input.next();
            System.out.print("Enter First Position Count : ");
            fstPos = input.nextInt();
            System.out.print("Enter Second Position Count : ");
            scndPos = input.nextInt();
            System.out.print("Enter Third Position Count : ");
            trdPos = input.nextInt();
            System.out.print("Enter Driver's Total points : ");
            driverPoints = input.nextInt();

            while (true)
            {
                System.out.print("Enter Driver's Total Races : ");
                raceCount = input.nextInt();


                if ((fstPos+scndPos+trdPos) < raceCount)    //check if the sum of first,second,third positions are less than the race count.
                    break;
                else
                    System.out.println(Y+" >> Race count cannot be less than the sum of the first, second and third places" +R);
            }
            input.nextLine();

            // Create new driver object from Formula1Driver class and store it on F1Driver Arraylist.
            F1Driver.add(new Formula1Driver(driverName, driverCountry, teamName, fstPos, scndPos, trdPos, driverPoints, raceCount));

            System.out.println(C+"\n >> New Driver Added Successfully!"+R);

        }catch (Exception e)
        {
            System.out.println(Y+" >> Please enter valid values"+R);
        }
    }


    /**
     * Runs when the user inputs "B" as menu option.
     * Allows the user to Delete drivers.
     * Deleting drivers from F1Drivers Arraylist.
     */
    @Override
    public void deleteDriver()
    {
        Iterator <Formula1Driver> itr = F1Driver.iterator();

        try
        {
            System.out.print("Enter Driver's Name: ");
            String driverName = input.next();

            //Checks if the entered driver name already in the F1Driver Arraylist and delete it.
            while (itr.hasNext())
            {
                Formula1Driver Dr1 = itr.next();
                if (Dr1.getName().equals(driverName))
                {
                    itr.remove();
                    System.out.println(C+" >> Driver Removed Successfully!"+R);
                    break;
                }
            }
        }catch (Exception e)
        {
            System.out.println(Y+"Please enter a valid value"+R);
        }
    }


    /**
     * Runs when the user inputs "C" as menu option.
     * Allows the user to change drivers already in the F1Driver Arraylist.
     */
    @Override
    public void changeDriver()
    {
        try
        {
            System.out.print("Enter Driver's Name: ");
            driverName = input.next();
            for (int i = 0; i < F1Driver.size(); i++)
            {
                // Checks the driver name entered by the user with the driver names entered in the F1Driver arraylist and
                // replaces it with the new data.

                if (F1Driver.get(i).getName().equalsIgnoreCase(driverName))
                {
                    System.out.println("Enter New Driver's Name For Team " + F1Driver.get(i).getTeam() +" : ");
                    String newDriverName = input.next();

                    System.out.print("Enter Driver's Country : ");
                    driverCountry = input.next();
                    System.out.print("Enter First Position Count : ");
                    fstPos = input.nextInt();
                    System.out.print("Enter Second Position Count : ");
                    scndPos = input.nextInt();
                    System.out.print("Enter Third Position Count : ");
                    trdPos = input.nextInt();
                    System.out.print("Enter Driver's Total points : ");
                    driverPoints = input.nextInt();

                    while (true)
                    {
                        System.out.print("Enter Driver's Total Races : ");
                        raceCount = input.nextInt();

                        if ((fstPos+scndPos+trdPos) <= raceCount)
                            break;
                        else
                            System.out.println(Y+"Race count cannot be less than the sum of the first, second and third places" +R);
                    }

                    // Updates the Driver object with new data
                    F1Driver.get(i).setName(newDriverName);
                    F1Driver.get(i).setCountry(driverCountry);
                    F1Driver.get(i).setFstPos(fstPos);
                    F1Driver.get(i).setScndPos(scndPos);
                    F1Driver.get(i).setTrdPos(trdPos);
                    F1Driver.get(i).setDriverPoints(driverPoints);
                    F1Driver.get(i).setRaceCount(raceCount);

                    System.out.println(C+" >> New Driver Name Updated!"+R);
                    break;
                }
            }
        }catch (Exception e){
            System.out.println(Y+" >> Driver doesn't exist"+R);
        }
    }

    /**
     * Runs when the user inputs "D" as menu option.
     * Allows the user to get the details of any single driver.
     * Displaying a selected driver from F1Driver Arraylist.
     */
    @Override
    public void displayDriverStatistics()
    {
        try
        {
            System.out.print("Enter Driver's Name: ");
            String driverName = input.next();
            for (int i = 0; i <= F1Driver.size(); i++)
            {
                // Checks the driver name entered by the user with the driver names entered in the F1Driver arraylist and
                // displays the details of the user entered driver.

                if (F1Driver.get(i).getName().equalsIgnoreCase(driverName))
                {
                    System.out.println(C+"\n >> Driver Statistics of "+ driverName +R);
                    tableHeader();
                    System.out.println(F1Driver.get(i));
                    break;
                }
            }
        }catch (Exception e){
            System.out.println(Y+" >> Driver doesn't exist"+R);
        }
    }

    /**
     * Runs when the user inputs "E" as menu option.
     * Displaying all drivers stored in F1Drivers Arraylist.
     */
    @Override
    public void displayDriverTable()
    {
        int driversCount = 0;
        int carCount = 0;

        if (F1Driver.size()==0)
            System.out.println(Y+" >> No Records Yet"+R);
        else {
            sortDriverTable();
            System.out.println(C+" >> Formula 1 Championship Driver Table"+R);
            tableHeader();
            for (int i = 0; i < F1Driver.size(); i++)
            {
                System.out.println(F1Driver.get(i));
                driversCount++;
                carCount++;
            }
            System.out.println(" | Total Drivers : "+ driversCount);
            System.out.println(" | Total Cars : "+ carCount);
        }
    }


    /**
     * Sorts the driver table by
     * first positions and
     * driver points
     */
    public void sortDriverTable()
    {
        Collections.sort(F1Driver, Formula1Driver.fstPosComparator);    // First sort driver data by First Position
        Collections.sort(F1Driver, Formula1Driver.pointsComparator);    // Then sort driver data by Total Points
    }

    /**
     * Prints the Header of driver Table
     */
    static void tableHeader()
    {
        System.out.println(B+"+---------------------+----------------+----------------+-------------+-------------+-------------+-----------------+----------------+");
        System.out.format("|"+BC+BlB+" %-20s"+B+"|"+BC+BlB+" %-15s"+B+"|"+BC+BlB+" %-15s"+B+"|"+BC+BlB+" %-12s"+B+"|"+BC+BlB+" %-12s"+B+"|"+BC+BlB+" %-12s"+B+"|"+BC+BlB+" %-15s "+B+"|"+BC+BlB+" %-15s"+B+"|", "Name", "Country", "Team", "1st Pos.", "2nd Pos.", "3rd Pos.", "Total Points", "Total Races");
        System.out.println("\n|====================================================================================================================================|"+R);
    }

    /**
     * Runs when the user inputs "F" as menu option.
     * Allows user to add a completed Formula1 Driver Race.
     * Stores that entered race data in F1Race Arraylist.
     */
    @Override
    public void addrace()
    {

        //SimpleDateFormat dateInput = new SimpleDateFormat("dd-MM-yyyy");
        LocalDate raceDate;
        while(true)
        {
            // Get date input by user and validates it.
            System.out.println("Date Of Race : Enter with this format (mm/dd/yy) ");
            String inputDate = input.next();
            try{
                raceDate = LocalDate.parse(inputDate, dateFormatter);
                break;
            }catch (DateTimeParseException e)
            {
                System.out.println(Y+"Invalid Date : "+ inputDate +R);
            }
        }

        System.out.println("Enter Race Location : ");
        String raceLocation = input.next();
        System.out.println("Enter Circuit Name :");
        String raceCircuit = input.next();

        for (int i = 0; i < 10; i++)
        {
            // Get driver names by user for the finish positions of the completed race.
            System.out.print("Enter Driver Name of Position "+ (i+1) +" : ");
            String driverName = input.next().toUpperCase();

            for (int j = 0; j < F1Driver.size(); j++)
            {
                if (F1Driver.get(j).getName().equalsIgnoreCase(driverName))
                {
                    if (!(Arrays.asList(raceDrivers).contains(driverName)))
                    {
                        raceDrivers.add(F1Driver.get(j));
                        break;
                    }else
                    {
                        System.out.println(Y+" >> Name Already Entered Before!"+R);
                        i--;
                        break;
                    }
                }
                if (j == F1Driver.size()-1 )
                {
                    System.out.println(Y+" >> Driver doesn't exist"+R);
                    i--;
                }
            }
        }
        pointCalc(raceDrivers);

        // Create a new Race object from Formula1Race class and add it into the F1Race Arraylist
        F1Race.add(new Formula1Race(raceDate, raceLocation, raceCircuit, raceDrivers));
        System.out.println(C+"\n >> Race Added Successfully!"+R);
        System.out.println(C+" >> Formula 1 Driver Table Updated Successfully!"+R);
    }


    /**
     * According to the race data entered by the user,
     * points are added to the drivers according to the positions obtained.
     * Increases race count by 1 for participated drivers.
     * Increases first, second, and third position counts by 1.
     * @param drivers Get participated driver list from addRace method as Arraylist named "drivers"
     */
    public void pointCalc(ArrayList drivers)
    {
        // Calculates the points, first,Second,third positions and race counts of the participated drivers.
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < F1Driver.size(); j++)
            {
                if (F1Driver.get(j).equals(drivers.get(i)))                {
                    F1Driver.get(j).setDriverPoints(F1Driver.get(j).getDriverPoints() + pointArr[i]);
                    F1Driver.get(j).setRaceCount(F1Driver.get(j).getRaceCount() + 1);

                    if ((i+1) == 1)
                        F1Driver.get(j).setFstPos(F1Driver.get(j).getFstPos()+1);
                    else if ((i+1) == 2)
                        F1Driver.get(j).setScndPos(F1Driver.get(j).getScndPos()+1);
                    else if ((i+1) == 3)
                        F1Driver.get(j).setTrdPos(F1Driver.get(j).getTrdPos()+1);
                    break;
                }
            }
        }
    }

    /**
     * Runs when the user inputs "G" as menu option.
     * Allows user to save entered data into a external file.
     * Calls the "writeFile" Method.
     */
    @Override
    public void saveInfo()
    {
        writeFile(new File("F1DriverData.ser"), F1Driver);
        writeFile(new File("F1RaceData.ser"), F1Race);
    }

    /**
     * Allows user to save entered data into a external file.
     * Saving data automatically when user exit from the programme.
     * @param writer Get the Pathname of the data saving file
     * @param arrList Get the relevent Arraylist to save.
     */
    public void writeFile(File writer, ArrayList arrList)
    {
        try{
            FileOutputStream writeData = new FileOutputStream(writer);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(arrList);
            writeStream.flush();
            writeStream.close();

            System.out.println(C+" >> "+ writer +" File Updated!"+R);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * Loads previous data from external files.
     * Automatically loads data from file when starts the programme.
     */
    public void loadInfo()
    {
        try {
            FileInputStream readData = new FileInputStream("F1DriverData.ser");
            ObjectInputStream readStream = new ObjectInputStream(readData);
            F1Driver = (ArrayList<Formula1Driver>) readStream.readObject();
            readStream.close();

            readData = new FileInputStream("F1RaceData.ser");
            readStream = new ObjectInputStream(readData);
            F1Race = (ArrayList<Formula1Race>) readStream.readObject();
            readStream.close();

            System.out.println(C+"\n >> Previous Records Loaded Successfully!"+R);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * Runs when the user inputs "H" as menu option.
     * Allows user to open the F1ChampionshipManager UserInterface.
     * Runs the "F1ChampionshipManagerGUI" GUI file.
     */
    public void runGUI()
    {
        String[] args = new String[0];
        F1ChampionshipManagerGUI.main(args);
        System.out.println(C+" >> Opening..."+R);
        System.out.println(C+" >> F1 Championship Manager GUI Loaded!"+R);
    }
}
