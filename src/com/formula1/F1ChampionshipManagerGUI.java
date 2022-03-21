package com.formula1;



import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * This F1ChampionshipManagerGUI class implements the GUI of the Formula1 Championship Manager.
 *
 * @author yasiru Luvishewa
 */
public class F1ChampionshipManagerGUI implements ActionListener
{
    JPanel topPanel;
    JPanel leftPanel;
    JPanel midPanel;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel4;
    JPanel searchPanel;

    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JLabel label8;
    JLabel label9;
    JLabel label10;
    JLabel label11;
    JLabel label12;
    JLabel label13;
    JLabel label14;
    JLabel label15;
    JLabel label16;
    JLabel label17;
    JLabel label18;
    JLabel label19;


    JButton searchButton;
    JButton pointsAscButton;
    JButton fposDscButton;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;

    JTextField searchField;
    JTextField locationField;
    JTextField circuitField;


    JTable driverTable;
    JTable completedRaceTable;
    JTable newRaceTable;
    JTable allRaceTable;
    JTable driverSearchTable;

    JScrollPane scrollPane1;
    JScrollPane scrollPane2;
    JScrollPane scrollPane3;
    JScrollPane scrollPane4;
    JScrollPane scrollPane5;

    JLayeredPane layeredPane;

    LocalDate randomRaceDate;

    ImageIcon image1 = new ImageIcon("F1Logo2.png");  //get F1Logo image
    ImageIcon image2 = new ImageIcon("profile2.png"); //get Profile image

    ArrayList <Formula1Driver> raceDriversData = new ArrayList<Formula1Driver>(10);
    ArrayList <Formula1Driver> finalPositions = new ArrayList<Formula1Driver>(10);

    Formula1ChampionshipManager F1CM = new Formula1ChampionshipManager();

    public static void main(String [] args)
    {
        new F1ChampionshipManagerGUI();
    }

    public F1ChampionshipManagerGUI()
    {
        Border border = BorderFactory.createLineBorder(Color.red,3);

        textFields();
        buttons();
        labels();
        driverTable();
        panels();


        JFrame frame = new JFrame();    //creates a frame
        frame.setTitle("F1ChampionshipManager GUI");    //sets title of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //exit out of application
        frame.setLayout(new BorderLayout()); //set frame with BorderLayout manger
        frame.getRootPane().setBorder(border);
        frame.setSize(1280,768);  //sets the x-dimensions,and y-dimensions of frame
        frame.getContentPane().setBackground(Color.gray);   //set background color
        frame.setVisible(true);                      //make frame visible
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(midPanel,BorderLayout.CENTER);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * Initialize the textfields
     */
    public void textFields()
    {
        searchField = new JTextField();
        searchField.setBounds(20,60,280,30);

        locationField = new JTextField();
        locationField.setBounds(40,40,200,30);

        circuitField = new JTextField();
        circuitField.setBounds(300,40,200,30);
    }

    /**
     * Initialize the Jlabels
     */
    public void labels()
    {
        label1 = new JLabel();
        label1.setText("Formula 1 Championship Manager");
        label1.setBounds(15,0,1100,150);
        label1.setIcon(image1);
        label1.setFont(new Font("Arimo",Font.ITALIC,40));
        label1.setIconTextGap(150);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setForeground(Color.WHITE);

        label2 = new JLabel();
        label2.setText(">> Formula 1 Driver Statistics <<");
        label2.setBounds(241,20,500,50);
        label2.setFont(new Font("Arimo",Font.PLAIN,30));
        label2.setForeground(Color.red);

        label3 = new JLabel();
        label3.setText(">> Random Completed Race <<");
        label3.setBounds(250,20,500,50);
        label3.setFont(new Font("Arimo",Font.PLAIN,30));
        label3.setForeground(Color.red);

        label4 = new JLabel();
        label4.setText(">> Add New Race <<");
        label4.setBounds(340,20,500,50);
        label4.setFont(new Font("Arimo",Font.PLAIN,30));
        label4.setForeground(Color.red);

        label5 = new JLabel();
        label5.setText(">> All Completed Race <<");
        label5.setBounds(300,20,500,50);
        label5.setFont(new Font("Arimo",Font.PLAIN,30));
        label5.setForeground(Color.red);


        label7 = new JLabel();
        label7.setText("Location");
        label7.setBounds(40,15,100,20);
        label7.setFont(new Font("Poppins",Font.BOLD,15));
        label7.setForeground(Color.gray);

        label8 = new JLabel();
        label8.setText("Circuit");
        label8.setBounds(300,15,100,20);
        label8.setFont(new Font("Poppins",Font.BOLD,15));
        label8.setForeground(Color.gray);

        label9 = new JLabel();
        label9.setBorder(BorderFactory.createLineBorder(new Color(48,48,48)));
        label9.setBounds(40,100,860,100);
        label9.add(label7);
        label9.add(label8);
        label9.add(locationField);
        label9.add(circuitField);

        label17 = new JLabel();
        label17.setText(">> Driver Statistics <<");
        label17.setBounds(300,20,500,50);
        label17.setFont(new Font("Arimo",Font.PLAIN,30));
        label17.setForeground(Color.red);

        label18 = new JLabel();
        label18.setText("- Enter Something to Search ! -");
        label18.setBounds(250,250,500,50);
        label18.setFont(new Font("Arimo",Font.PLAIN,30));
        label18.setForeground(Color.WHITE);

        label19 = new JLabel();
        label19.setText("- Driver doesn't exist ! -");
        label19.setBounds(300,250,500,50);
        label19.setFont(new Font("Arimo",Font.PLAIN,30));
        label19.setForeground(Color.WHITE);
    }

    /**
     * Initialize the JButtons
     */
    public void buttons()
    {
        searchButton = new JButton("Search");
        searchButton.setBounds(35,100,250,30);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanels(searchPanel);
                if (!searchField.getText().isEmpty())
                {
                    for (int i = 0; i < Formula1ChampionshipManager.F1Driver.size(); i++)
                    {
                        if (Formula1ChampionshipManager.F1Driver.get(i).getName().equalsIgnoreCase(searchField.getText()))
                        {
                            driverSearch(i);
                            searchPanel.removeAll();
                            searchPanel.add(label17);
                            searchPanel.add(label16);
                            searchPanel.add(scrollPane4);
                            searchPanel.repaint();
                            searchPanel.revalidate();
                            break;
                        }
                        if (i == Formula1ChampionshipManager.F1Driver.size()-1)
                        {
                            searchPanel.removeAll();
                            searchPanel.add(label17);
                            searchPanel.add(label19);
                            searchPanel.repaint();
                            searchPanel.revalidate();
                        }
                    }
                }
                else
                {
                    searchPanel.removeAll();
                    searchPanel.add(label17);
                    searchPanel.add(label18);
                    searchPanel.repaint();
                    searchPanel.revalidate();
                }
            }
        });


        button1 = new JButton("Driver Statistics");
        button1.setBounds(20,200,280,40);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.remove(scrollPane1);
                switchPanels(panel1);
                F1CM.loadInfo();
                driverTable();
                panel1.add(scrollPane1);
            }
        });

        pointsAscButton = new JButton("Ascending : Points");
        pointsAscButton.setBounds(40,120,200,30);
        pointsAscButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableSorter(driverTable, 6, "A");
            }
        });

        fposDscButton = new JButton("Descending : 1st Position");
        fposDscButton.setBounds(250,120,200,30);
        fposDscButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableSorter(driverTable, 3, "D");
            }
        });

        button5 = new JButton("Update Table");
        button5.setBounds(740,120,150,30);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                driverTable();
                panel1.add(scrollPane1);
            }
        });


        button2 = new JButton("Add Completed Race");
        button2.setBounds(20,280,280,40);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearData();
                completedRace();
                switchPanels(panel2);
                panel2.remove(label9);
                panel2.add(label3);
                panel2.add(label9);
                panel2.add(button6);
                panel2.add(scrollPane2);

            }
        });

        button3 = new JButton("Add New Race");
        button3.setBounds(20,360,280,40);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearData();
                newRace();
                switchPanels(panel3);
                panel3.remove(label9);
                panel3.add(label4);
                panel3.add(label9);
                panel3.add(button7);
                panel3.add(scrollPane5);
            }
        });

        button4 = new JButton("All Races");
        button4.setBounds(20,440,280,40);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel4.removeAll();
                allRaces();
                switchPanels(panel4);
                panel4.add(label5);
                panel4.add(scrollPane3);
            }
        });


        button6 = new JButton("+ Add Random Race");
        button6.setBounds(720,140,150,30);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomDriverGenerator(6);
                F1CM.pointCalc(raceDriversData);
                Formula1ChampionshipManager.F1Race.add(new Formula1Race(randomRaceDate, locationField.getText(), circuitField.getText(), raceDriversData));
                F1CM.saveInfo();
                panel2.add(scrollPane2);
            }
        });

        button7 = new JButton("+ Add New Random Race");
        button7.setBounds(700,140,180,30);
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomDriverGenerator(7);
                F1CM.pointCalc(finalPositions);
                Formula1ChampionshipManager.F1Race.add(new Formula1Race(randomRaceDate, locationField.getText(), circuitField.getText(), finalPositions));
                F1CM.saveInfo();
                panel3.add(scrollPane5);
            }
        });
    }

    /**
     * Clears the data of JTextFields (locationField and circuitField)
     */
    public void clearData()
    {
        locationField.setText("Default Location");
        circuitField.setText("Default Circuit");
    }

    /**
     * Displays the details of the driver that the user searched for.
     * Creates a table to display the all races participated by the driver.
     * @param i The index of searched driver
     */
    public void driverSearch(int i)
    {
        driverSearchTable = new JTable();
        DefaultTableModel searchTableModel = (DefaultTableModel) driverSearchTable.getModel();

        // set column names of table
        String[] columnNames = {"Date", "Location", "Circuit", "Position"};
        searchTableModel.setColumnIdentifiers(columnNames);

        //get driver's data from F1Driver Arraylist
        String name = Formula1ChampionshipManager.F1Driver.get(i).getName();
        String country =  Formula1ChampionshipManager.F1Driver.get(i).getCountry();
        String team =  Formula1ChampionshipManager.F1Driver.get(i).getTeam();
        int fpos =  Formula1ChampionshipManager.F1Driver.get(i).getFstPos();
        int spos =  Formula1ChampionshipManager.F1Driver.get(i).getScndPos();
        int tpos =  Formula1ChampionshipManager.F1Driver.get(i).getTrdPos();
        int points =  Formula1ChampionshipManager.F1Driver.get(i).getDriverPoints();
        int raceCount =  Formula1ChampionshipManager.F1Driver.get(i).getRaceCount();

        for (int j = 0; j < Formula1ChampionshipManager.F1Race.size(); j++)
        {
            for (int k = 0; k < 10; k++)
            {
                // checks if driver participated into the races and displays that data on table.
                if (Formula1ChampionshipManager.F1Race.get(j).getDriverPositions().get(k).getName().equalsIgnoreCase(name))
                {
                    LocalDate date = Formula1ChampionshipManager.F1Race.get(j).getDate();
                    String location = Formula1ChampionshipManager.F1Race.get(j).getLocation();
                    String circuit = Formula1ChampionshipManager.F1Race.get(j).getCircuit();
                    int position = (k+1);

                    Object[] data = {date, location,circuit, position};
                    searchTableModel.addRow(data);
                }
            }
        }
        searchLabels(name, country, team, fpos, spos, tpos, points, raceCount);

        tableSorter(driverSearchTable, 0, "D");
        driverSearchTable.setBackground(Color.gray);
        driverSearchTable.setEnabled(false);
        scrollPane4 = new JScrollPane(driverSearchTable);
        scrollPane4.setBounds(500,80,400,450);
    }

    /**
     * Displaying the details of drivers that the user used for.
     * @param name  The name of the driver.
     * @param country The country of the driver.
     * @param team The team name of the driver.
     * @param fpos The first positions count of the driver.
     * @param spos The second positions count of the driver.
     * @param tpos The third positions count of the driver.
     * @param points The total points earned by the driver.
     * @param raceCount The count of races participated by the driver.
     */
    public void searchLabels(String name, String country, String team, int fpos, int spos, int tpos, int points, int raceCount)
    {
        label10 = new JLabel();
        label10.setBounds(10,10,400,150);
        label10.setText("<html>Name : "+ name+ "<br>Country : "+ country + "<br>Team : " + team + "</html>");
        label10.setFont(new Font("Arimo",Font.PLAIN,20));
        label10.setForeground(Color.WHITE);
        label10.setBackground(Color.red);
        label10.setOpaque(true);
        label10.setIcon(image2);
        label10.setIconTextGap(40);
        label10.setHorizontalAlignment(JLabel.CENTER);

        label11 = new JLabel();
        label11.setText("Total Points : " + points);
        label11.setFont(new Font("Poppins",Font.BOLD,18));
        label11.setForeground(new Color(180,180,180));
        label11.setBounds(35,180,350,50);
        label11.setBorder(new MatteBorder(0,0,1,0, new Color(45,45,45)));
        label11.setHorizontalAlignment(JLabel.CENTER);

        label12 = new JLabel();
        label12.setText("No. of First Positions : " + fpos);
        label12.setFont(new Font("Poppins",Font.BOLD,18));
        label12.setForeground(new Color(180,180,180));
        label12.setBounds(35,230,350,50);
        label12.setBorder(new MatteBorder(0,0,1,0, new Color(45,45,45)));
        label12.setHorizontalAlignment(JLabel.CENTER);

        label13 = new JLabel();
        label13.setText("No. of Second Positions : " + spos);
        label13.setFont(new Font("Poppins",Font.BOLD,18));
        label13.setForeground(new Color(180,180,180));
        label13.setBounds(35,280,350,50);
        label13.setBorder(new MatteBorder(0,0,1,0, new Color(45,45,45)));
        label13.setHorizontalAlignment(JLabel.CENTER);

        label14 = new JLabel();
        label14.setText("No. of Third Positions : " + tpos);
        label14.setFont(new Font("Poppins",Font.BOLD,18));
        label14.setForeground(new Color(180,180,180));
        label14.setBounds(35,330,350,50);
        label14.setBorder(new MatteBorder(0,0,1,0, new Color(45,45,45)));
        label14.setHorizontalAlignment(JLabel.CENTER);

        label15 = new JLabel();
        label15.setText("Total Races : " + raceCount);
        label15.setFont(new Font("Poppins",Font.BOLD,18));
        label15.setForeground(new Color(180,180,180));
        label15.setBounds(35,380,350,50);
        label15.setHorizontalAlignment(JLabel.CENTER);

        label16 = new JLabel();
        label16.setBorder(BorderFactory.createLineBorder(new Color(48,48,48)));
        label16.setBounds(40,80,420,450);
        label16.add(label10);
        label16.add(label11);
        label16.add(label12);
        label16.add(label13);
        label16.add(label14);
        label16.add(label15);
    }


    /**
     * Displays the all details of drivers on DriverTable
     * Allows user to Ascending table data by driver points.
     * Allows user to Descending table data by First Position count.
     */
    public void driverTable()
    {
        driverTable =  new JTable();
        DefaultTableModel driverTableModel = (DefaultTableModel) driverTable.getModel();

        String[] columnNames = {"Name", "Country", "Team", "1st Positions", "2nd Positions", "3rd Positions", "Total Points", "Race Count"};
        driverTableModel.setColumnIdentifiers(columnNames);


        for (int i = 0; i < Formula1ChampionshipManager.F1Driver.size(); i++)
        {
            String name =  Formula1ChampionshipManager.F1Driver.get(i).getName();
            String country =  Formula1ChampionshipManager.F1Driver.get(i).getCountry();
            String team =  Formula1ChampionshipManager.F1Driver.get(i).getTeam();
            int fpos =  Formula1ChampionshipManager.F1Driver.get(i).getFstPos();
            int spos =  Formula1ChampionshipManager.F1Driver.get(i).getScndPos();
            int tpos =  Formula1ChampionshipManager.F1Driver.get(i).getTrdPos();
            int points =  Formula1ChampionshipManager.F1Driver.get(i).getDriverPoints();
            int raceCount =  Formula1ChampionshipManager.F1Driver.get(i).getRaceCount();

            Object [] data = {name,country,team,fpos,spos,tpos,points,raceCount};
            driverTableModel.addRow(data);
        }

        tableSorter(driverTable, 6, "D");
        driverTable.setBackground(Color.gray);
        driverTable.setEnabled(false);
        scrollPane1 = new JScrollPane(driverTable);
        scrollPane1.setBounds(40, 170, 860, 315);
    }


    /**
     * Creates a table with random generated, completed race details
     * Allows user to generate random completed race
     */
    public void completedRace()
    {
        completedRaceTable = new JTable();
        DefaultTableModel raceTableModel = (DefaultTableModel) completedRaceTable.getModel();
        String[] columnNames = {"Date", "Position", "Name", "Team"};
        raceTableModel.setColumnIdentifiers(columnNames);

        randomDateGenerator();

        for (int i = 0; i< raceDriversData.size(); i++)
        {
            Object[] data = {randomRaceDate, (i+1), raceDriversData.get(i).getName(), raceDriversData.get(i).getTeam()};
            raceTableModel.addRow(data);
        }

        completedRaceTable.setBackground(Color.gray);
        completedRaceTable.setEnabled(false);
        scrollPane2 = new JScrollPane(completedRaceTable);
        scrollPane2.setBounds(40, 300, 860, 185);
    }


    /**
     * Creates a table with completely random generated race with details
     * (with winning probabilities)
     * Allows user to generate a completely random, completed race
     */
    public void newRace()
    {
        newRaceTable = new JTable();
        DefaultTableModel newRaceTableModel = (DefaultTableModel) newRaceTable.getModel();

        String[] columnNames = {"Date", "Name", "Team", "Start Position", "Finish Position"};
        newRaceTableModel.setColumnIdentifiers(columnNames);

        randomDateGenerator();

        if (!(raceDriversData.size() == 0))
        {
            int random = (int) ((Math.random()*(99))+0);

            // Deciding the first position according to the given probabilities.
            if (random < 40)
                switchArrayItems(raceDriversData.get(0));
            else if (random < 70)
                switchArrayItems(raceDriversData.get(1));
            else if (random < 80)
                switchArrayItems(raceDriversData.get(2));
            else if (random < 90)
                switchArrayItems(raceDriversData.get(3));
            else if (random < 92)
                switchArrayItems(raceDriversData.get(4));
            else if (random < 94)
                switchArrayItems(raceDriversData.get(5));
            else if (random < 96)
                switchArrayItems(raceDriversData.get(6));
            else if (random < 98)
                switchArrayItems(raceDriversData.get(7));
            else if (random < 100)
                switchArrayItems(raceDriversData.get(8));

        }

        // Displaying the details of random generated race in a table
        for(int i = 0; i < finalPositions.size(); i++)
        {
            for (int j = 0; j < raceDriversData.size(); j++)
            {
                if(finalPositions.get(i).getName().equals(raceDriversData.get(j).getName()))
                {
                    Object[] data = {randomRaceDate, finalPositions.get(i).getName(), finalPositions.get(i).getTeam(), (j + 1), (i + 1)};
                    newRaceTableModel.addRow(data);
                    break;
                }
            }
        }

        newRaceTable.setBackground(Color.gray);
        newRaceTable.setEnabled(false);
        scrollPane5 = new JScrollPane(newRaceTable);
        scrollPane5.setBounds(40, 300, 860, 185);
    }

    /**
     * Set the winner into the 0th index of the array
     * Shuffle the rest of driver positions
     * @param driver get driver who decided as winner
     */
    public void switchArrayItems(Formula1Driver driver)
    {
        finalPositions.removeAll(finalPositions);
        finalPositions.addAll(raceDriversData);
        Collections.shuffle(finalPositions);
        int itemIndex = finalPositions.indexOf(driver);
        finalPositions.remove(itemIndex);
        finalPositions.add(0,driver);
    }

    /**
     * Displaying all the races with details
     */
    public void allRaces()
    {
        allRaceTable = new JTable();
        DefaultTableModel allRaceTableModel = (DefaultTableModel) allRaceTable.getModel();
        String[] columnNames = {"Date", "Location", "Circuit", "Name", "Postion", "Team", "Points"};
        allRaceTableModel.setColumnIdentifiers(columnNames);

        for (int i = 0; i < Formula1ChampionshipManager.F1Race.size(); i++)
        {
            LocalDate date = Formula1ChampionshipManager.F1Race.get(i).getDate();
            String location = Formula1ChampionshipManager.F1Race.get(i).getLocation();
            String circuit = Formula1ChampionshipManager.F1Race.get(i).getCircuit();

            for (int j = 0; j < Formula1ChampionshipManager.F1Race.get(i).getDriverPositions().size(); j++)
            {
                Object[] data =
                        {date, location, circuit,
                        Formula1ChampionshipManager.F1Race.get(i).getDriverPositions().get(j).getName(),
                        (j+1),
                        Formula1ChampionshipManager.F1Race.get(i).getDriverPositions().get(j).getTeam(),
                        Formula1ChampionshipManager.F1Race.get(i).getDriverPositions().get(j).getDriverPoints()
                        };
                allRaceTableModel.addRow(data);
            }
        }

        tableSorter(allRaceTable, 0, "A");
        allRaceTable.setBackground(Color.gray);
        allRaceTable.setEnabled(false);
        scrollPane3 = new JScrollPane(allRaceTable);
        scrollPane3.setBounds(40,100,860,385);
    }

    /**
     * Intialize the JPanels
     */
    public void panels()
    {
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,960,618);


        topPanel = new JPanel();    //creates a new panel for top
        topPanel.setLayout(null);
        topPanel.setBackground(new Color(31,31,31));   //set topPanel color to green
        topPanel.setPreferredSize(new Dimension(1280,150));   //sets the x-dimensions, y-dimensions, width and height of topPanel
        topPanel.add(label1);

        leftPanel = new JPanel();
        leftPanel.setBackground(new Color(33,33,33));
        leftPanel.setLayout(null);
        leftPanel.setPreferredSize(new Dimension(320,100));
        leftPanel.add(searchField);
        leftPanel.add(searchButton);
        leftPanel.add(button1);
        leftPanel.add(button2);
        leftPanel.add(button3);
        leftPanel.add(button4);

        midPanel = new JPanel();
        midPanel.setLayout(null);
        midPanel.setPreferredSize(new Dimension(960,618));
        midPanel.add(layeredPane);


        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(35,35,35));
        panel1.setBounds(0,0,960,618);
        panel1.add(label2);
        panel1.add(pointsAscButton);
        panel1.add(fposDscButton);
        panel1.add(button5);
        panel1.add(scrollPane1);
        layeredPane.add(panel1);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(new Color(35,35,35));
        panel2.setBounds(0,0,960,618);
        layeredPane.add(panel2);

        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBackground(new Color(35,35,35));
        panel3.setBounds(0,0,960,618);
        layeredPane.add(panel3);

        panel4 = new JPanel();
        panel4.setLayout(null);
        panel4.setBackground(new Color(35,35,35));
        panel4.setBounds(0,0,960,618);
        layeredPane.add(panel4);


        searchPanel = new JPanel();
        searchPanel.setLayout(null);
        searchPanel.setBackground(new Color(35,35,35));
        searchPanel.setBounds(0,0,960,618);
        layeredPane.add(searchPanel);


    }

    /**
     * Switch between multiple JPanels
     * @param panel The Panel which wants to switch
     */
    public void switchPanels(JPanel panel)
    {
        layeredPane.removeAll();
        layeredPane.add(panel);
        layeredPane.repaint();
        layeredPane.revalidate();

        // https://youtu.be/JtTy9CnBIyM
    }

    /**
     * Sorts the table columns by Ascending and Descending
     * @param table Table for sorting
     * @param index index of column for sorting
     * @param order sorting order (Ascending as A or Descending as D)
     */
    public void tableSorter(JTable table, int index, String order)
    {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();

        int columnIndexToSort = index;

        if (order.equals("A"))
            sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
        else
            sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));

        sorter.setSortKeys(sortKeys);
        sorter.sort();

        //https://www.codejava.net/java-se/swing/6-techniques-for-sorting-jtable-you-should-know
    }

    /**
     * Generates random drivers for random positions
     * @param button The clicked button
     */
    public void randomDriverGenerator(int button)
    {
        raceDriversData.removeAll(raceDriversData);

        for (int i = 0; i < 10; i++)
        {
            int random = (int) ((Math.random()*(Formula1ChampionshipManager.F1Driver.size()-1))+0);
            Formula1Driver driver = Formula1ChampionshipManager.F1Driver.get(random);

            if (!raceDriversData.contains(driver))
            {
                raceDriversData.add(driver);
            }

            else
                i--;
        }

        if (button == 6)
            completedRace();
        else if (button == 7)
            newRace();

    }

    /**
     * Generates random dates
     */
    public void randomDateGenerator()
    {
        Random random = new Random();
        int startDay = (int) LocalDate.of(2018, 1, 1).toEpochDay();
        int endDay = (int) LocalDate.now().toEpochDay();
        long randomDay = startDay + random.nextInt(endDay - startDay);

        randomRaceDate = LocalDate.ofEpochDay(randomDay);

        //https://stackoverflow.com/questions/3985392/generate-random-date-of-birth
    }
}
