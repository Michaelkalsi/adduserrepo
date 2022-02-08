package registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*if user is trying to delete a record--> if that specific record is not present print sout 
check database and report it 
//tackle primary key unqiue
 *
 * @author Hemanpreet
 */
public class AWSCrud {

    public void createTable() throws SQLException {

        //Step1: Create an objectt of connection class
        AWSconnection object1 = new AWSconnection();
        Connection connection = object1.createConnnection();

        try {

            System.out.println("CReating a table");
            //create table query
            Statement stmt = connection.createStatement();
            String createtab = "CREATE TABLE UserTestData "
                    + "(AccountId INTEGER not NULL, "
                    + " firstName VARCHAR(255), "
                    + " lastName VARCHAR(255), "
                    + " age INTEGER(30));";
            stmt.executeUpdate(createtab);
            System.out.println("Table created successfully...");

            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(AWSCrud.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addUser() throws SQLException {

        //Create object of the connection class
        AWSconnection object1 = new AWSconnection();
        Connection conn = object1.createConnnection();
        try {

            System.out.println("Adding user to the database...");
            Statement stmt = conn.createStatement();

            String sqladd = "INSERT INTO `UserTestData`"
                    + " (`AccountID`,`firstName`,`lastName`,`age`)"
                    + " VALUES (11,'Chn','ngs',33);";

            String sqladdtwo = "INSERT INTO UserTestData"
                    + "(AccountId, firstName , lastName , age)"
                    + "VALUES (12, 'Fn', 'lke', 36);";

            stmt.executeUpdate(sqladdtwo);
            //   stmt.executeQuery(sqladd);
            System.out.println("User added...");

        } catch (SQLException ex) {
            Logger.getLogger(AWSCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }
    }

    public void viewalldata() throws SQLException {

        AWSconnection object1 = new AWSconnection();

        Connection conn = null;
        try {

            conn = object1.createConnnection();
            PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM TestTable;");
            //stmnt.executeQuery();
            ResultSet print = stmnt.executeQuery();
            //Setstirng if need i.e put the parameter values

            //get values from db using get 
            System.out.println("Id" + "  " + "firstName  " + "lastname   " + "   age");
            while (print.next()) {
                int AccountId = print.getInt("AccountId");
                String firstName = print.getString("firstName");
                String lastName = print.getString("lastName");
                int age = print.getInt("age");

                System.out.println(AccountId + "     " + firstName + "       " + lastName + "             " + age);
            }
            System.out.println(print);
        } catch (SQLException ex) {
            Logger.getLogger(AWSCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }

    }

    public void viewage() throws SQLException {
        AWSconnection object1 = new AWSconnection();
        Connection conn = null;
        try {
            conn = object1.createConnnection();
            //create query using prepared Statement
            PreparedStatement stmnt = conn.prepareStatement("Select * From TestTable Where age = ? ;");
            //Setstrin to give the value to the stmnt qury
            stmnt.setInt(1, 21);

            //Execute
            stmnt.executeQuery();
            //print the data obtained from query using resultset
            ResultSet print = stmnt.executeQuery();
            System.out.println("Id" + "  " + "firstName  " + "lastname   " + "   age");

            while (print.next()) {
                int AccountId = print.getInt("AccountId");
                String firstName = print.getString("firstName");
                String lastName = print.getString("lastName");
                int age = print.getInt("age");
                System.out.println(AccountId + "     " + firstName + "       " + lastName + "             " + age);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AWSCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }

    }

    public void deleteid() throws SQLException {

        AWSconnection object1 = new AWSconnection();
        Connection conn = null;
        try {
            conn = object1.createConnnection();
            //create query using prepared Statement
            PreparedStatement stmnt = conn.prepareStatement("Delete From TestTable Where AccountId = ? ;");
            //Setstrin to give the value to the stmnt qury
            stmnt.setInt(1, 3);
            stmnt.executeUpdate();

            System.out.println("Data deleted");

        } catch (SQLException ex) {
            Logger.getLogger(AWSCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }
    }

    public void choosedeleteid() throws SQLException {
        //Create object of connection class
        AWSconnection object1 = new AWSconnection();
        Connection conn = null;
        try {
            conn = object1.createConnnection();
            //show all the account id available in database 
            PreparedStatement stmn = conn.prepareStatement("SELECT AccountId FROM TestTable;");
            // stmn.executeQuery();
            ResultSet print = stmn.executeQuery();
            System.out.println("All Account Id's present in table are:");
            while (print.next()) {
                int AccountId = print.getInt("AccountId");
                System.out.println(AccountId);
            }
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the AccountId you wanna delete");
            int idinput = scan.nextInt();
            PreparedStatement stmnt2 = conn.prepareStatement("Delete FROM TestTable where AccountId = ? ;");
            stmnt2.setInt(1, idinput);
            stmnt2.executeUpdate();
            System.out.println("Data deleted with Accountid:" + idinput);

            //View left id'is in datatable
            PreparedStatement stmnt3 = conn.prepareStatement("SELECT AccountId FROM TestTable;");
            // stmn.executeQuery();
            ResultSet printtwo = stmnt3.executeQuery();
            System.out.println("All Account Id's left after deletion are:");
            while (printtwo.next()) {
                int AccountId = printtwo.getInt("AccountId");
                System.out.println(AccountId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AWSCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }
    }

    public void update() throws SQLException {
        AWSconnection object1 = new AWSconnection();
        Connection conn = null;
        try {
            conn = object1.createConnnection();
            // 
            PreparedStatement stmnt = conn.prepareStatement("UPDATE TestTable SET age = ? Where AccountId = ?;");
            // stmnt.executeQuery();
            stmnt.setInt(1, 44);
            stmnt.setInt(2, 8);
            stmnt.executeUpdate();
            System.out.println("Query Executed Successfully...");

        } catch (SQLException ex) {
            Logger.getLogger(AWSCrud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
            System.out.println("Connection closed...");
        }
    }

}
