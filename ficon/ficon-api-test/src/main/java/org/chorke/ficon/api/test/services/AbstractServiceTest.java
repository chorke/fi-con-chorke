
package org.chorke.ficon.api.test.services;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.chorke.ficon.api.objects.Account;
import org.chorke.ficon.api.objects.TransactionRecord;
import org.chorke.ficon.api.objects.User;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
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
     * Saves object which is managed by testing service and sets its ID.
     * Object is saved in another way then standard save method of service
     * (e.g. directly to RDBMS, caching, Mock object,...) so result does not depend
     * on service. But object's id should not be set.
     * 
     * @param obj object to be saved
     */
    protected abstract void saveObject(O obj);
    
    /**
     * Removes object which is managed by testing service.
     * Object is removed in another way then standard delete method of service
     * (e.g. directly from RDBMS, caching, Mock object,...) so result does not depend
     * on service.
     * 
     * @param obj Object to be removed.
     */
    protected abstract void deleteObject(O obj);
    
    /**
     * Updates object which is managed by testing service.
     * Object is updated in another way then standard update method of service
     * (e.g. directly in RDBMS, caching, Mock object,...) so result does not depend
     * on service.
     * 
     * @param obj Object to be updated.
     */
    protected abstract void updateObject(O obj);
    
    protected User getUser(Long id, String name, Set<Account> accounts){
        User us = new User();
        if(id != null){
            us.setId(id);
        }
        us.setName(name);
        if(accounts != null){
            for(Account ac : accounts){
                us.addAccount(ac);
            }
        }
        return us;
    }
    
    protected Account getAccount(Long id, Long userID, String name,
            String description, List<TransactionRecord> records){
        Account ac = new Account(userID);
        if(id != null){
            ac.setId(id);
        }
        ac.setName(name);
        ac.setDescription(description);
        if(records != null){
            for(TransactionRecord tr : records){
                ac.addTransaction(tr);
            }
        }
        return ac;
    }
    
    protected TransactionRecord getTransactionRecord(Long id, Long accountID, 
            String name, String description, Long associatedTransID,
            BigDecimal amount, Calendar transactionTime){
        TransactionRecord tr = new TransactionRecord(accountID);
        if(id != null){
            tr.setId(id);
        }
        tr.setName(name);
        tr.setDescription(description);
        tr.setAssociatedTransactionID(associatedTransID);
        tr.setAmount(amount);
        tr.setTransactionTime(transactionTime);
        return tr;
    }
    
    protected void deepEquals(User u1, User u2, boolean checkAccounts, boolean checkTransactions){
        if(checkNullObjects(u1, u2)){
            return;
        }
        assertEquals(u1.getId(), u2.getId());
        assertEquals(u1.getName(), u2.getName());
        if(checkAccounts){
            deepCollectionsAccountsEquals(u1.getAccounts(), u2.getAccounts(), checkTransactions);
        }
    }
    
    protected void deepEquals(Account ac1, Account ac2, boolean checkTransactions){
        if(checkNullObjects(ac1, ac2)){
            return;
        }
        assertEquals(ac1.getDescription(), ac2.getDescription());
        assertEquals(ac1.getId(), ac2.getId());
        assertEquals(ac1.getName(), ac2.getName());
        assertEquals(ac1.getUsersID(), ac2.getUsersID());
        if(checkTransactions){
            deepCollectionsTransactionsEquals(ac1.getTransactions(), ac2.getTransactions());
        }
    }
    
    protected void deepEquals(TransactionRecord tr1, TransactionRecord tr2){
        if(checkNullObjects(tr1, tr2)){
            return;
        }
        assertEquals(tr1.getAccountID(), tr2.getAccountID());
        deepEquals(tr1.getAmount(), tr2.getAmount());
        assertEquals(tr1.getAssociatedTransactionID(), tr2.getAssociatedTransactionID());
        assertEquals(tr1.getDescription(), tr2.getDescription());
        assertEquals(tr1.getId(), tr2.getId());
        assertEquals(tr1.getName(), tr2.getName());
        deepEquals(tr1.getTransactionTime(), tr2.getTransactionTime());
    }
    
    protected void deepEquals(BigDecimal bd1, BigDecimal bd2){
        if(checkNullObjects(bd1, bd2)){
            return;
        }
        if(bd1.compareTo(bd2) != 0){
            fail("Values are not equals: " + bd1 + " <--> " + bd2);
        }
    }
    
    protected void deepEquals(Calendar c1, Calendar c2){
        if(checkNullObjects(c1, c2)){
            return;
        }
        if(c1.compareTo(c2) != 0){
            fail("Values are not equals: " + c1 + " <--> " + c2);
        }
    }
    
    /**
     * Only one user id is allowed in collection (it means only one {@code null}).
     * 
     * @param l1
     * @param l2 
     */
    protected void deepCollectionsAccountsEquals(Collection<Account> l1, Collection<Account> l2,
            boolean checkTransactions){
        if(checkNullAndSize(l1, l2)){
            return;
        }
        for(Account ac : l1){
            for(Account inl2 : l2){
                if(inl2.getId() == ac.getId()){
                    deepEquals(inl2, ac, checkTransactions);
                    break;
                }
            }
        }
    }
    
    /**
     * Only one user id is allowed in collection (it means only one {@code null}).
     * 
     * @param l1
     * @param l2 
     */
    protected void deepCollectionsTransactionsEquals(Collection<TransactionRecord> l1,
            Collection<TransactionRecord> l2){
        if(checkNullAndSize(l1, l2)){
            return;
        }
        for(TransactionRecord tr : l1){
            for(TransactionRecord inl2 : l2){
                if(inl2.getId() == tr.getId()){
                    deepEquals(inl2, tr);
                    break;
                }
            }
        }
    }
    
    /**
     * Only one user id is allowed in collection (it means only one {@code null}).
     * 
     * @param l1
     * @param l2 
     */
    protected void deepCollectionsUserEquals(Collection<User> l1, Collection<User> l2,
            boolean checkAccounts, boolean checkTransactions){
        if(checkNullAndSize(l1, l2)){
            return;
        }
        for(User us : l1){
            for(User inl2 : l2){
                if(inl2.getId() == us.getId()){
                    deepEquals(inl2, us, checkAccounts, checkTransactions);
                    break;
                }
            }
        }
    }
    
    protected void deepMapEquals(Map m1, Map m2){
        if(checkNullAndSize(m1, m2)){
            return;
        }
        for(Object key : m1.keySet()){
            Object m1Obj = m1.get(key);
            Object m2Obj = m2.get(key);
            assertEquals(m1Obj, m2Obj);
        }
    }
    
    /**
     * 
     * @param o1
     * @param o2
     * @return true, if both are null; false, if both are non-null; 
     *  fails (Assert.fail()) if only one is null
     */
    private boolean checkNullObjects(Object o1, Object o2){
        //same pointer or both null
        if(o1 == o2){
            return true;
        }
        //only one is null
        if(o1 == null || o2 == null){
            fail("Not equals " + o1 + "  " + o2);
        }
        return false;
    }
    
    /**
     * 
     * @param c1
     * @param c2
     * @return true, if both are null; false, if both are non-null; 
     *  fails (Assert.fail()) if only one is null or size of collections are
     *  not same
     */
    private boolean checkNullAndSize(Collection c1, Collection c2){
        if(checkNullObjects(c1, c2)){
            return true;
        }
        if(c1.size() != c2.size()){
            fail("Not equals " + c1 + "  " + c2);
        }
        return false;
    }
    
    /**
     * 
     * @param m1
     * @param m2
     * @return true, if both are null; false, if both are non-null; 
     *  fails (Assert.fail()) if only one is null or size of maps are
     *  not same
     */
    private boolean checkNullAndSize(Map m1, Map m2){
        if(checkNullObjects(m1, m2)){
            return true;
        }
        if(m1.size() != m2.size()){
            fail("Not equals " + m1 + "  " + m2);
        }
        return false;
    }
}
