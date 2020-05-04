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
        createTablesCustomer2();
        initializeDb(true);
    }

    public static void reNew() {
    createTablesCustomer2();
        initializeDb(false);
    }

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
                        + " Amount INT)");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

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



