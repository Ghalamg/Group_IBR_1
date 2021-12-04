package MyRentalTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import myrental.Customer;
import myrental.Rental;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class testSearchCustomer {
    public static Customer customer[] = new Customer[4];
     File customers = new File("usersDatabase.txt");
    
    
    public testSearchCustomer() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws FileNotFoundException {
         Scanner input = new Scanner(customers);
        Customer costumer=new Customer();
        costumer.customerDatabase(customers, input);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testSearchCustomer(){
        String username="ahmed22";
        String password="gh12345";

        Customer instance = new Customer();
        boolean expectedResult = true;
        boolean result = instance.searchCustomer(username, password);
        assertEquals(expectedResult,result);
    }

} //End of class
