
package org.chorke.ficon.api.test.services;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Abstract test for AccountService. When implementing AccountService interface 
 * all what you need to do to test it is to extend this class and implements
 * abstract methods. 
 * 
 * @author Chorke
 */
public abstract class AccountServiceAbstractTest {

    @Before
    public void setUp(){
        setUpTest();
    }
    
    @After
    public void tearDown(){
        tearDownTest();
    }
    
    @BeforeClass
    public static void setUpClass(){
        System.out.println("Setting up abstract class. Nothing to do. "
                + "You probably see this message because you do not have "
                + "no method anotated with @BeforeClass or its name is not "
                + "\"setUpClass\" (if it so then ignore this message).");
    }
    
    @AfterClass
    public static void tearDownClass(){
        System.out.println("Tearing down abstract class. Nothing to do"
                + "You probably see this message because you do not have "
                + "no method anotated with @AfterClass or its name is not "
                + "\"tearDownClass\" (if it so then ignore this message).");
    }
    
    /**
     * Tear down single test.
     */
    protected abstract void tearDownTest();
    
    /**
     * Set up single test.
     */
    protected abstract void setUpTest();
    
    @Test
    public void test1(){
        System.out.println("test 1");
    }
    
    @Test
    public void test2(){
        System.out.println("test 2");
    }
}
