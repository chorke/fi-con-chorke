
package org.chorke.ficon.api.test.services;

import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Chorke
 */
public abstract class AbstractServiceTest<S, O> {

     /**
     * testing service
     */
    protected S service;
    
    /**
     * Set up test.
     */
    @Before
    public void setUp(){
        service = getInstance();
        setUpTest();
    }
    
    /**
     * Tear down test.
     */
    @After
    public void tearDown(){
        tearDownTest();
        service = null;
    }
    
    /**
     * Set up testing class.
     */
    @BeforeClass
    public static void setUpClass(){
        System.out.println("Setting up abstract class. Nothing to do. "
                + "You probably see this message because you do not have "
                + "no method anotated with @BeforeClass or its name is not "
                + "\"setUpClass\" (if it so then ignore this message).");
    }
    
    /**
     * Tear down testing class.
     */
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
    
    /**
     * Returns new instance of testing class.
     * 
     * @return testing class intance
     */
    protected abstract S getInstance();
    
    /**
     * Returns object which is managed by testing service.
     * Object is recieved in another way then standard get method of service
     * (e.g. directly from RDBMS, caching, Mock object,...) so result does not depend
     * on service.
     * 
     * @param id ID of object
     * @return 
     */
    protected abstract O getObject(Long id);
    
    /**
     * Returns all abjects which are managed by testing service.
     * Objects are recieved in another way then standard get method of service
     * (e.g. directly from RDBMS, caching, Mock object,...) so result does not depend
     * on service.
     * 
     * @return 
     */
    protected abstract Collection<O> getAllObjects();
    
    /**
     * Saves object which is managed by testing service.
     * Object is saved in another way then standard save method of service
     * (e.g. directly to RDBMS, caching, Mock object,...) so result does not depend
     * on service.
     * 
     * @param obj object to be saved
     */
    protected abstract void saveObject(O obj);
}
