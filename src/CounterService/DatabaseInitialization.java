package CounterService;

import dataaccess.DBConnection;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DatabaseInitialization {

    public static void main(String[] args) {
//        createTablesCustomer();
//        createTablesPet();
//        createTablesActivites();
//        createTablesReservedCustomer();
        createTablesCustomer2();
        initializeDb(true);
    }

    public static void reNew() {
//        createTablesCustomer();
    createTablesCustomer2();
//        createTablesReservedCustomer();
        initializeDb(false);
    }

//Customer
//    private static void createTablesCustomer() {
//        try (Connection conn = DBConnection.getConnection();
//                Statement stm = conn.createStatement()) {
//            try {
//                stm.executeUpdate("DROP TABLE customers");
//            } catch (SQLException ex) {
//            }
//
//            try {
//                stm.executeUpdate("CREATE TABLE Customers (IdNumber INT NOT NULL,"
//                        + " Firstname VARCHAR(50) NOT NULL,"
//                        + " Lastname VARCHAR(50) NOT NULL, "
//                        + " phoneNumber INT NOT NULL, "
//                        + " PRIMARY KEY (IdNumber,phoneNumber))");
////                        + "FOREIGN KEY (phoneNumber))");
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//    Pet

    private static void createTablesCustomer2() {
        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            try {
                stm.executeUpdate("DROP TABLE customers2");
            } catch (SQLException ex) {
            }

            try {
                stm.executeUpdate("CREATE TABLE Customers2 (IdNumber INT NOT NULL,"
                        + " Firstname VARCHAR(50) ,"
                        + " Lastname VARCHAR(50) , "
                        + " phoneNumber INT NOT NULL, "
                        + " pet_name VARCHAR(50) NOT NULL,"
                        + " pet_Age CHAR(2),"
                        + " pet_Type VARCHAR(6) NOT NULL,"
                        + " Activities VARCHAR(20),"
                        + " Room VARCHAR(20),"
                        + " Status VARCHAR(10),"
                        + " Amount INT,"
                        + " PRIMARY KEY (IdNumber,phoneNumber))");
//                        + "FOREIGN KEY (phoneNumber))");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

//    private static void createTablesPet() {
//        try (Connection conn = DBConnection.getConnection();
//                Statement stm = conn.createStatement()) {
//            try {
//                stm.executeUpdate("DROP TABLE pet");
//            } catch (SQLException ex) {
//
//            }
//
//            try {
//                stm.executeUpdate("CREATE TABLE Pet(pet_name VARCHAR(50) NOT NULL,"
//                        + "petAge CHAR(2),"
//                        + "petType VARCHAR(6) NOT NULL,"
//                        + "ownerPhoneNumber INT NOT NULL,"
//                        + "PRIMARY KEY(ownerPhoneNumber))");
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    //Activites
//    private static void createTablesActivites() {
//        try (Connection conn = DBConnection.getConnection();
//                Statement stm = conn.createStatement()) {
//            try {
//                stm.executeUpdate("DROP TABLE activites");
//            } catch (SQLException ex) {
//
//            }
//
//            try {
//                stm.executeUpdate("CREATE TABLE activites(IdNumber INT NOT NULL, "
//                        + "pet_name VARCHAR(50) NOT NULL,"
//                        + "Activity VARCHAR(100) NOT NULL,"
//                        + "PRIMARY KEY (IdNumber)) ");
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
////ReservedCustomer
//    private static void createTablesReservedCustomer() {
//        try (Connection conn = DBConnection.getConnection();
//                Statement stm = conn.createStatement()) {
//            try {
//                stm.executeUpdate("DROP TABLE ReservedCustomer");
//            } catch (SQLException ex) {
//            }
//            //เอาตารางcustomerมารวม มีid,first,last,phonenum
//            //เอาตารางActivityที่จองมาใส่ มีid,petname,Act  
//            try {
//                stm.executeUpdate("CREATE TABLE ReservedCustomer (IdNumber INT NOT NULL,"
//                        + " resRoom VARCHAR(20), "
//                        + " amount INT NOT NULL ,"
//                        + " status VARCHAR(10),"
//                        + " PRIMARY KEY (IdNumber))");
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }

    private static void initializeDb(boolean show) {

        String sqlCustomer2 = "INSERT INTO customers2 VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmC2 = conn.prepareStatement(sqlCustomer2)) {
            Scanner sc;
            
            try {
                if (show) {
                    System.out.println("\n--- Import Customer2 ---");
                    sc = new Scanner(new File("file/customer2"));
                    String line;
                    try {
                        while ((line = sc.nextLine()) != null) {
                            String[] temp = line.split(",");
                            stmC2.setInt(1, Integer.parseInt(temp[0]));
                            stmC2.setString(2, temp[1]);
                            stmC2.setString(3, temp[2]);
                            stmC2.setInt(4, Integer.parseInt(temp[3]));
                            stmC2.setString(5, temp[4]);
                            stmC2.setString(6, temp[5]);
                            stmC2.setInt(7, Integer.parseInt(temp[6]));
                            stmC2.setString(8, temp[7]);
                            stmC2.setString(9, temp[8]);
                            stmC2.setString(10, temp[9]);
                            stmC2.setInt(11, Integer.parseInt(temp[10]));
                            stmC2.executeUpdate();
                            if (show) {
                                System.out.println("Insert: " + line);
                            }
                        }
                    } catch (NoSuchElementException ex) {

                    }
                }
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

//        String sqlCustomer = "INSERT INTO customers VALUES(?,?,?,?)";
//
//        try (Connection conn = DBConnection.getConnection();
//                PreparedStatement stmC = conn.prepareStatement(sqlCustomer)) {
//            Scanner sc;
//
//            try {
//                if (show) {
//                    System.out.println("\n--- Import Customer ---");
//                    sc = new Scanner(new File("file/customers"));
//                    String line;
//
//                    try {
//                        while ((line = sc.nextLine()) != null) {
//                            String[] temp = line.split(",");
//                            stmC.setLong(1, Long.parseLong(temp[0]));
//                            stmC.setString(2, temp[1]);
//                            stmC.setString(3, temp[2]);
//                            stmC.setString(4, temp[3]);
//                            stmC.executeUpdate();
//                            if (show) {
//                                System.out.println("Insert: " + line);
//                            }
//                        }
//                    } catch (NoSuchElementException ex) {
//
//                    }
//                }
//            } catch (FileNotFoundException ex) {
//                System.out.println(ex.getMessage());
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        //Pet
//        String sqlPet = "INSERT INTO pet VALUES(?,?,?,?)";
//        try (Connection conn = DBConnection.getConnection();
//                PreparedStatement stmP = conn.prepareStatement(sqlPet)) {
//            Scanner sc;
//            try {
//                if (show) {
//                    System.out.println("\n--- Import Pet ---");
//                    sc = new Scanner(new File("file/pet"));
//                    String line;
//
//                    try {
//                        while ((line = sc.nextLine()) != null) {
//                            String[] temp = line.split(",");
//                            stmP.setString(1, temp[0]);
//                            stmP.setString(2, temp[1]);
//                            stmP.setString(3, temp[2]);
//                            stmP.executeUpdate();
//                            if (show) {
//                                System.out.println("Insert: " + line);
//                            }
//                        }
//                    } catch (NoSuchElementException ex) {
//                    }
//                }
//
//            } catch (FileNotFoundException ex) {
//                System.out.println(ex.getMessage());
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        //Activity
//        String sqlActivity = "INSERT INTO activites VALUES(?,?,?)";
//        try (Connection conn = DBConnection.getConnection();
//                PreparedStatement stmAC = conn.prepareStatement(sqlActivity)) {
//            Scanner sc;
//            try {
//                if (show) {
//                    System.out.println("\n--- Import Activity ---");
//                    sc = new Scanner(new File("file/activity"));
//                    String line;
//
//                    try {
//                        while ((line = sc.nextLine()) != null) {
//                            String[] temp = line.split(",");
//                            stmAC.setLong(1, Long.parseLong(temp[0]));
//                            stmAC.setString(2, temp[1]);
//                            stmAC.setString(3, temp[2]);
//
//                            stmAC.executeUpdate();
//                            if (show) {
//                                System.out.println("Insert: " + line);
//                            }
//                        }
//                    } catch (NoSuchElementException ex) {
//                    }
//                }
//
//            } catch (FileNotFoundException ex) {
//                System.out.println(ex.getMessage());
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        //ReservedCustomer
//        String sqlReservedCustomer = "INSERT INTO ReservedCustomer VALUES(?,?,?,?)";
//        try (Connection conn = DBConnection.getConnection();
//                PreparedStatement stmRC = conn.prepareStatement(sqlReservedCustomer)) {
//            Scanner sc;
//            try {
//                if (show) {
//                    System.out.println("\n--- Import ReservedCustomer ---");
//                    sc = new Scanner(new File("file/reserved"));
//                    String line;
//                    try {
//                        while ((line = sc.nextLine()) != null) {
//                            String[] temp = line.split(",");
//                            stmRC.setInt(1, Integer.parseInt(temp[0]));
//                            stmRC.setString(2, temp[1]);
//                            stmRC.setInt(3, Integer.parseInt(temp[2]));
//                            stmRC.setString(4, temp[3]);
//                            stmRC.executeUpdate();
//                            if (show) {
//                                System.out.println("Insert: " + line);
//                            }
//                        }
//                    } catch (NoSuchElementException ex) {
//                    }
//                }
//
//            } catch (FileNotFoundException ex) {
//                System.out.println(ex.getMessage());
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }

