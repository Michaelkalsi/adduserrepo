package registration;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hemanpreet
 */
public class Homepage {
    public static void main(String [] args) throws SQLException{
    
        AWSconnection object1 = new AWSconnection();
        
       // object1.createConnnection();
       AWSCrud query1 = new AWSCrud();
        query1.createTable();
            query1.addUser();
                //query1.viewalldata();
                  //query1.viewage();
                  //query1.deleteid();
                        //query1.choosedeleteid();
                            //query1.update();
                            
                            //CustomerDetails obj2 = new CustomerDetails();
                            //obj2.setAge(17);
    }
}
