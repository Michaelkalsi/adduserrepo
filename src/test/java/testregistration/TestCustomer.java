/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testregistration;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import registration.AWSCrud;

import registration.CustomerDetails;

/**
 *
 * @author Hemanpreet
 */
public class TestCustomer {

    //DO BVA analysis n,n+1,n-1
    @Test
    public void testageonelesslower() {

        CustomerDetails obj2 = new CustomerDetails();
        boolean result = obj2.setAge(17);
        assertEquals("will this test pass or no", false, result);

    }

    @Test
    public void testageonelower() {

        CustomerDetails obj2 = new CustomerDetails();
        boolean result = obj2.setAge(18);
        assertEquals(true, result);

    }

    @Test
    public void testageonemorelower() {

        CustomerDetails obj2 = new CustomerDetails();
        boolean result = obj2.setAge(19);
        assertEquals(true, result);

    }

    @Test
    public void testemailsuffix() {
        CustomerDetails obj = new CustomerDetails();
        boolean result = obj.setEmail("hem an@gil.com");
        assertEquals(false, result);
    }

    @Test
    public void testfirstName() {
        CustomerDetails obj = new CustomerDetails();
        boolean result = obj.setFirstName("kalsi ");
        assertEquals(false, result);
    }

}
