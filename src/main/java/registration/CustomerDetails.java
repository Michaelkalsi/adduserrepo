/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registration;

/**
 *
 * @author Hemanpreet
 */
public class CustomerDetails {
    boolean verify;
   private int age;
    private String firstName;
    private String lastName;
   private String email;

     public CustomerDetails() {
        //To change body of generated methods, choose Tools | Templates.
    }

     public CustomerDetails(int age, String firstName, String lastName, String email) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

  

    public int getAge() {
        return age;
    }

    public boolean setAge(int age) {
        //boolean verify;
        
        if(age >= 18 && age <= 100){
        this.age = age;
        verify = true;
            System.out.println(age + "is valid");
        }
        else{
            verify = false;
            System.out.println( age + "age is not valid");
        }
        return verify;
    }

    public String getFirstName() {
        return firstName;
    }

    public boolean setFirstName(String firstName) {
        if(!(firstName.contains(" ")) || !(firstName.contains("1"))  ){
            return verify = false;
        }
        
            
        else{
                this.firstName = firstName;
                return verify = true;
                }
        
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        boolean verify;
        if(email.endsWith("@gmail.com") || email.endsWith("@mnsu.edu")){
            this.email = email;
            verify = true;
        }
        else if(email.contains(" ")){
            verify = false;
        }
        else{
            verify = false;
            
            }
        return verify;
    }
    
    
  
   
}
