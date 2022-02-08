package registration;
import java.sql.Connection;
import java.util.*;
import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hemanpreet
 */
public class AWSconnection {
   
 
    public Connection createConnnection() throws SQLException {
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String DBL_URL = "jdbc:mysql://testdatabseamz.c67bp1ccfgcn.us-east-1.rds.amazonaws.com:3306/TestUser";
    String User = "Michael";
    String Pass = "admin#123";
    
    //Create connection clas object
    Connection conn = null;
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Attempting to connect to database...");
            
            conn = DriverManager.getConnection(DBL_URL, User, Pass);
            System.out.println("Connected to Database...");
        } catch (SQLException |ClassNotFoundException ex) {
            Logger.getLogger(AWSconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    return conn;
    }
  
}
