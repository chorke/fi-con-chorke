
package org.chorke.ficon.api.test.services;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.chorke.ficon.api.exceptions.UserServiceException;
import org.chorke.ficon.api.objects.Account;
import org.chorke.ficon.api.objects.TransactionRecord;
import org.chorke.ficon.api.objects.User;
import org.chorke.ficon.api.services.UserService;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Abstract test for UserService. When implementing UserService interface 
 * all what you need to do to test it is to extend this class and implement
 * abstract methods. 
 * 
 * @author Chorke
 */
public abstract class UserServiceAbstractTest extends AbstractServiceTest<UserService, User>{

    /**
     * Creates user. Method calls associated {@code befor}
     * method, create method of service and associated {@code after} method.
     * Depends on standard create method of service.
     * 
     * @param user
     * @throws UserServiceException 
     * @see #beforeCreateNewUser(org.chorke.ficon.api.objects.User) 
     * @see #afterCreateNewUser(java.lang.Exception, org.chorke.ficon.api.objects.User) 
     * @see UserService#createNewUser(org.chorke.ficon.api.objects.User) 
     */
    protected final void doCreateNewUser(User user) throws UserServiceException{
        beforeCreateNewUser(user);
        try{
            service.createNewUser(user);
            afterCreateNewUser(null, user);
        } catch (UserServiceException | IllegalArgumentException ex){
            afterCreateNewUser(ex, user);
            throw ex;
        }
    }

    /**
     * Deletes user. Method calls associated {@code befor}
     * method, delete method of service and associated {@code after} method.
     * Depends on standard delete method of service.
     * 
     * @param user
     * @throws UserServiceException 
     * @see #beforeDeleteUser(org.chorke.ficon.api.objects.User) 
     * @see #afterDeleteUser(java.lang.Exception, org.chorke.ficon.api.objects.User) 
     * @see UserService#deleteUser(org.chorke.ficon.api.objects.User) 
     */
    protected final void doDeleteUser(User user) throws UserServiceException{
        beforeDeleteUser(user);
        try{
            service.deleteUser(user);
            afterDeleteUser(null, user);
        } catch (UserServiceException | IllegalArgumentException ex){
            afterDeleteUser(ex, user);
            throw ex;
        }
    }

    /**
     * Retunrs user. Method calls associated {@code befor}
     * method, get method of service and associated {@code after} method.
     * Depends on standard get method of service.
     * 
     * @param id
     * @return
     * @throws UserServiceException 
     * @see #beforeGetUser(java.lang.Long) 
     * @see #afterGetUser(java.lang.Exception, java.lang.Long) 
     * @see UserService#getUser(java.lang.Long) 
     */
    protected final User doGetUser(Long id) throws UserServiceException{
        beforeGetUser(id);
        try{
            User ret = service.getUser(id);
            afterGetUser(null, id);
            return ret;
        } catch (UserServiceException | IllegalArgumentException ex){
            afterGetUser(ex, id);
            throw ex;
        }
    }

    /**
     * Returns all names of users. Method calls associated {@code befor}
     * method, get-users-names method of service and associated {@code after} method.
     * Depends on standard get-users-names method of service.
     * 
     * @return
     * @throws UserServiceException 
     * @see #beforeGetUsersNames() 
     * @see #afterGetUsersNames(java.lang.Exception) 
     * @see UserService#getUsersNames() 
     */
    protected final Map<Long, String> doGetUsersNames() throws UserServiceException{
        beforeGetUsersNames();
        try{
            Map<Long, String> ret = service.getUsersNames();
            afterGetUsersNames(null);
            return ret;
        } catch (UserServiceException | IllegalArgumentException ex){
            afterGetUsersNames(ex);
            throw ex;
        }
    }

    /**
     * Loads accounts of user. Method calls associated {@code befor}
     * method, load method of service and associated {@code after} method.
     * Depends on standard load method of service.
     * 
     * @param user
     * @return
     * @throws UserServiceException 
     * @see #beforeLoadUsersAccounts(org.chorke.ficon.api.objects.User) 
     * @see #afterLoadUsersAccounts(java.lang.Exception, org.chorke.ficon.api.objects.User) 
     * @see UserService#loadUsersAccounts(org.chorke.ficon.api.objects.User) 
     */
    protected final User doLoadUsersAccounts(User user) throws UserServiceException{
        beforeLoadUsersAccounts(user);
        try{
            User ret = service.loadUsersAccounts(user);
            afterLoadUsersAccounts(null, user);
            return ret;
        } catch (UserServiceException | IllegalArgumentException ex){
            afterLoadUsersAccounts(ex, user);
            throw ex;
        }
    }

    /**
     * Updates user. Method calls associated {@code befor}
     * method, update method of service and associated {@code after} method.
     * Depends on standard update method of service.
     * 
     * @param user
     * @throws UserServiceException 
     * @see #beforeUpdateUser(org.chorke.ficon.api.objects.User) 
     * @see #afterUpdateUser(java.lang.Exception, org.chorke.ficon.api.objects.User) 
     * @see UserService#updateUser(org.chorke.ficon.api.objects.User) 
     */
    protected final void doUpdateUser(User user) throws UserServiceException{
        beforeUpdateUser(user);
        try{
            service.updateUser(user);
            afterUpdateUser(null, user);
        } catch (UserServiceException | IllegalArgumentException ex){
            afterUpdateUser(ex, user);
            throw ex;
        }
    }

    /**
     * This method is executed closely before calling create method of service.
     * 
     * @param user 
     */
    protected abstract void beforeCreateNewUser(User user);
    /**
     * This method is executed immediately after calling create method of service.
     * 
     * @param thrown exception that has been thrown during operation
     * @param user 
     */
    protected abstract void afterCreateNewUser(Exception thrown, User user);

    /**
     * This method is executed closely before calling delete method of service.
     * 
     * @param user 
     */
    protected abstract void beforeDeleteUser(User user);
    /**
     * This method is executed immediately after calling delete method of service.
     * 
     * @param thrown exception that has been thrown during operation
     * @param user 
     */
    protected abstract void afterDeleteUser(Exception thrown, User user);

    /**
     * This method is executed closely before calling get method of service.
     * 
     * @param id 
     */
    protected abstract void beforeGetUser(Long id);
    /**
     * This method is executed immediately after calling get method of service.
     * 
     * @param thrown exception that has been thrown during operation
     * @param id 
     */
    protected abstract void afterGetUser(Exception thrown, Long id);

    /**
     * This method is executed closely before calling getUsersNames method of service.
     * 
     */
    protected abstract void beforeGetUsersNames();
    /**
     * This method is executed immediately after calling getUsersNames method of service.
     * 
     * @param thrown exception that has been thrown during operation
     */
    protected abstract void afterGetUsersNames(Exception thrown);

    /**
     * This method is executed closely before calling load method of service.
     * 
     * @param user 
     */
    protected abstract void beforeLoadUsersAccounts(User user);
    /**
     * This method is executed immediately after calling load method of service.
     * 
     * @param thrown exception that has been thrown during operation
     * @param user 
     */
    protected abstract void afterLoadUsersAccounts(Exception thrown, User user);

    /**
     * This method is executed closely before calling update method of service.
     * 
     * @param user 
     */
    protected abstract void beforeUpdateUser(User user);
    /**
     * This method is executed immediately after calling update method of service.
     * 
     * @param thrown exception that has been thrown during operation
     * @param user 
     */
    protected abstract void afterUpdateUser(Exception thrown, User user);

    /**
     * Saves accounts. Saves them independetly of any service.
     * 
     * @param accounts 
     */
    protected abstract void saveAccounts(List<Account> accounts);
    
    /**
     * Saves transactions. Saves them independently of any service.
     * @param transactions 
     */
    protected abstract void saveTransactions(List<TransactionRecord> transactions);
    
    /**
     * Returns all accounts of user with id {@code id}. Accounts are loaded 
     * independently of any service.
     * 
     * @param id  
     * @return all accounts of user
     */
    protected abstract List<Account> getAccountsOfUser(Long id);
    
    /**
     * Returns all stored accounts in DB. Accounts are loaded independently of
     * any service.
     * 
     * @return all accounts
     */
    protected abstract List<Account> getAllStoredAccounts();
    
    /**
     * Loads all transactions of account with id {@code id}. Transactions are
     * loaded independently of any service.
     * 
     * @param id
     * @return all transaction of account
     */
    protected abstract List<TransactionRecord> getTransactionsOfAccount(Long id);
    
    /**
     * Loads all transactions stored in DB. Transactions are
     * loaded independently of any service.
     * 
     * @return all transactions
     */
    protected abstract List<TransactionRecord> getAllStoredTransactions();
    
    /**
     * Deletes transaction stroed in DB. Transaction is
     * removed independently of any service.
     * 
     * @param tr 
     */
    protected abstract void deleteTransaction(TransactionRecord tr);
    
    /**
     * Removes account stored in DB. Account is
     * removed independently of any service.
     * 
     * @param ac 
     */
    protected abstract void deleteAccount(Account ac);
    
      ///////////////////////////////
     //////////// tests ////////////
    ///////////////////////////////
    
    //////////// create ////////////
    @Test(expected = IllegalArgumentException.class)
    public void createNullArgument() throws UserServiceException {
        doCreateNewUser(null);
        fail("null argumen");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void createIdAlreadySet() throws UserServiceException {
        User us = getUser(Long.MIN_VALUE, "user", null);
        doCreateNewUser(us);
        fail("id already set");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void createNullName() throws UserServiceException {
        User us = getUser(null, null, null);
        doCreateNewUser(us);
        fail("null name");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void createEmptyName() throws UserServiceException {
        User us = getUser(null, "", null);
        doCreateNewUser(us);
        fail("empty name");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void createAccountsPresent() throws UserServiceException {
        User us = getUser(null, "user",
                new HashSet<>(
                        Arrays.asList(
                            getAccount(null, 1L, "name", "desc", null)
                        )
                    )
                );
        doCreateNewUser(us);
        fail("Accounts present. Either user's ID has been already set or "
                + "accounts have wrong user's ID");
    }
    
    @Test
    public void createOkArgument() throws UserServiceException{
        User us = getUser(null, "user", null);
        doCreateNewUser(us);
        if(us.getId() == null){
            fail("Id has not been set");
        }
        User usCopy = getUser(us.getId(), "user", null);
        User inDB = getObject(us.getId());
        deepEquals(inDB, usCopy);
    }
    
    //////////// update ////////////
    @Test(expected = IllegalArgumentException.class)
    public void updateNullArgument() throws UserServiceException{
        doUpdateUser(null);
        fail("null argument");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void updateNullID() throws UserServiceException{
        User us = getUser(null, "user", null);
        doUpdateUser(us);
        fail("null id");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void updateNullName() throws UserServiceException{
        User us = getUser(1L, null, null);
        doUpdateUser(us);
        fail("null name");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void updateEmptyName() throws UserServiceException{
        User us = getUser(1L, "", null);
        doUpdateUser(us);
        fail("empty name");
    }
    
    @Test(expected = UserServiceException.class)
    public void updateOkArgumentUserNotInDB() throws UserServiceException{
        User us = getUser(null, "user1", null);
        saveObject(us);
        User usToUpdate = getUser(us.getId() + 1, "user2", null);
        try{
            doUpdateUser(usToUpdate);
            fail("user not is DB");
        } catch (UserServiceException ex){
            User usClone = getUser(us.getId(), "user1", null);
            deepListUserEquals(getAllObjects(), Arrays.asList(usClone));
            throw ex;
        }
    }
    
    @Test
    public void updateOkArgumen() throws UserServiceException{
        User us = getUser(null, "user1", null);
        saveObject(us);
        User usToUpdate = getUser(us.getId(), "name", null);
        doUpdateUser(usToUpdate);
        User usToUpdateCopy = getUser(us.getId(), "name", null);
        User fromDB = getObject(us.getId());
        deepEquals(usToUpdateCopy, fromDB);
    }
    
    //////////// delete ////////////
    
    @Test(expected = IllegalArgumentException.class)
    public void deleteNullArgument() throws UserServiceException{
        doDeleteUser(null);
        fail("null argument");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void deleteNullID() throws UserServiceException{
        User us = getUser(null, "user", null);
        doDeleteUser(us);
        fail("null id");
    }
    
    @Test
    public void deleteNotInDB() throws UserServiceException{
        User us = getUser(null, "user", null);
        saveObject(us);
        User usToDelete = getUser(us.getId() + 1, "user2", null);
        doDeleteUser(usToDelete);
        deepListUserEquals(getAllObjects(), Arrays.asList(us));
    }
    
    @Test
    public void deleteOkArgumentNoAccounts() throws UserServiceException{
        User us = getUser(null, "user", null);
        User us1 = getUser(null, "user1", null);
        User us2 = getUser(null, "user2", null);
        saveObject(us);
        saveObject(us1);
        saveObject(us2);
        User usToDelete = getUser(us.getId(), null, null);
        doDeleteUser(usToDelete);
        if(getObject(us.getId()) != null){
            fail("user has not been deleted");
        }
        deepListUserEquals(getAllObjects(), Arrays.asList(us1, us2));
    }
    
    @Test
    public void deleteOkArgumentWithAccountsAndHistory() throws UserServiceException{
        User us = getUser(null, "user", null);
        User us1 = getUser(null, "user1", null);
        User us2 = getUser(null, "user2", null);
        saveObject(us);
        saveObject(us1);
        saveObject(us2);
        
        Account us_ac1 = getAccount(null, us.getId(), "usac1", "desc usac1", null);
        Account us_ac2 = getAccount(null, us.getId(), "usac2", "desc usac2", null);
        Account us1_ac1 = getAccount(null, us1.getId(), "us1ac1", "desc us1ac1", null);
        Account us1_ac2 = getAccount(null, us1.getId(), "us1ac2", "desc us1ac2", null);
        Account us2_ac1 = getAccount(null, us2.getId(), "us2ac1", "desc us2ac1", null);
        Account us2_ac2 = getAccount(null, us2.getId(), "us2ac2", "desc us2ac2", null);
        saveAccounts(Arrays.asList(us_ac1, us_ac2, us1_ac1, us1_ac2, us2_ac1, us2_ac2));
        us.addAccount(us_ac1);
        us.addAccount(us_ac2);
        us1.addAccount(us1_ac1);
        us1.addAccount(us1_ac2);
        us2.addAccount(us2_ac1);
        us2.addAccount(us2_ac2);
        
        
        TransactionRecord us_ac1_tr1 = 
                getTransactionRecord(null, us_ac1.getId(),
                "usac1tr1", "desc usac1tr1", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 1));
        TransactionRecord us_ac1_tr2 = 
                getTransactionRecord(null, us_ac1.getId(),
                "usac1tr2", "desc usac1tr2", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 2));
        TransactionRecord us_ac2_tr1 = 
                getTransactionRecord(null, us_ac2.getId(),
                "usac2tr1", "desc usac2tr1", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 3));
        TransactionRecord us_ac2_tr2 = 
                getTransactionRecord(null, us_ac2.getId(),
                "usac2tr2", "desc usac2tr2", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 4));
        TransactionRecord us1_ac1_tr1 = 
                getTransactionRecord(null, us1_ac1.getId(),
                "us1ac1tr1", "desc us1ac1tr1", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 5));
        TransactionRecord us1_ac1_tr2 = 
                getTransactionRecord(null, us1_ac1.getId(),
                "us1ac1tr2", "desc us1ac1tr2", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 6));
        TransactionRecord us1_ac2_tr1 = 
                getTransactionRecord(null, us1_ac2.getId(),
                "us1ac2tr1", "desc us1ac2tr1", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 7));
        TransactionRecord us1_ac2_tr2 = 
                getTransactionRecord(null, us1_ac2.getId(),
                "us1ac2tr2", "desc us1ac2tr2", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 8));
        TransactionRecord us2_ac1_tr1 = 
                getTransactionRecord(null, us2_ac1.getId(),
                "us2ac1tr1", "desc us2ac1tr1", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 9));
        TransactionRecord us2_ac1_tr2 = 
                getTransactionRecord(null, us2_ac1.getId(),
                "us2ac1tr2", "desc us2ac1tr2", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 10));
        TransactionRecord us2_ac2_tr1 = 
                getTransactionRecord(null, us2_ac2.getId(),
                "us2ac2tr1", "desc us2ac2tr1", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 11));
        TransactionRecord us2_ac2_tr2 = 
                getTransactionRecord(null, us2_ac2.getId(),
                "us2ac2tr2", "desc us2ac2tr2", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 12));
        saveTransactions(Arrays.asList(
                us_ac1_tr1, us_ac1_tr2,
                us_ac2_tr1, us_ac2_tr2,
                us1_ac1_tr1, us1_ac1_tr2,
                us1_ac2_tr1, us1_ac2_tr2,
                us2_ac1_tr1, us2_ac1_tr2,
                us2_ac2_tr1, us2_ac2_tr2));
        us_ac1.addTransaction(us_ac1_tr1);
        us_ac1.addTransaction(us_ac1_tr2);
        us_ac2.addTransaction(us_ac2_tr1);
        us_ac2.addTransaction(us_ac2_tr2);
        
        us1_ac1.addTransaction(us1_ac1_tr1);
        us1_ac1.addTransaction(us1_ac1_tr2);
        us1_ac2.addTransaction(us1_ac2_tr1);
        us1_ac2.addTransaction(us1_ac2_tr2);
        
        us2_ac1.addTransaction(us2_ac1_tr1);
        us2_ac1.addTransaction(us2_ac1_tr2);
        us2_ac2.addTransaction(us2_ac2_tr1);
        us2_ac2.addTransaction(us2_ac2_tr2);
        
        User usToDelete = getUser(us.getId(), null, null);
        doDeleteUser(usToDelete);
        if(getObject(us.getId()) != null){
            fail("user has not been deleted");
        }
        deepListUserEquals(getAllObjects(), Arrays.asList(us1, us2));
        
        deepListAccountsEquals(getAllStoredAccounts(),
                Arrays.asList(us1_ac1, us1_ac2, us2_ac1, us2_ac2));
        
        deepListTransactionsEquals(getAllStoredTransactions(),
                Arrays.asList(
                    us1_ac1_tr1, us1_ac1_tr2,
                    us1_ac2_tr1, us1_ac2_tr2,
                    us2_ac1_tr1, us2_ac1_tr2,
                    us2_ac2_tr1, us2_ac2_tr2));
    }
    
    //////////// get ////////////
    
    @Test(expected = IllegalArgumentException.class)
    public void getNullArgument() throws UserServiceException{
        doGetUser(null);
        fail("null argument");
    }
    
    @Test
    public void getEmptyDB() throws UserServiceException{
        assertNull("DB is empty", doGetUser(1L));
    }
    
    @Test
    public void getUserNotInDB() throws UserServiceException{
        User us = getUser(null, "name", null);
        saveObject(us);
        User fromDB = doGetUser(us.getId() + 1);
        assertNull("user is not in DB", fromDB);
    }
    
    @Test
    public void getOkArgument() throws UserServiceException{
        User us = getUser(null, "name", null);
        saveObject(us);
        User usCopy = getUser(us.getId(), "name", null);
        User fromDB = doGetUser(us.getId());
        deepEquals(usCopy, fromDB);
    }
    
    //////////// load accounts ////////////
    
    @Test(expected = IllegalArgumentException.class)
    public void loadAccountsNullArgument() throws UserServiceException{
        doLoadUsersAccounts(null);
        fail("null argument");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void loadAccountsNullUsersIDNothingInDB() throws UserServiceException{
        User us = getUser(null, "user", null);
        doLoadUsersAccounts(us);
        fail("null id");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void loadAccountsNullUsersID() throws UserServiceException{
        User us = getUser(null, "name", null);
        saveObject(us);
        User toLoad = getUser(null, "coolname", null);
        doLoadUsersAccounts(toLoad);
    }
    
    @Test
    public void loadAccountsOkArgument() throws UserServiceException{
        User us1 = getUser(null, "name1", null);
        User us2 = getUser(null, "name2", null);
        User us3 = getUser(null, "name3", null);
        saveObject(us1);
        saveObject(us2);
        saveObject(us3);
        
        Account us1_ac1 = getAccount(null, us1.getId(), "us1_ac1", "decs1", null);
        Account us1_ac2 = getAccount(null, us1.getId(), "us1_ac2", "decs2", null);
        Account us2_ac1 = getAccount(null, us2.getId(), "us2_ac1", "decs3", null);
        Account us2_ac2 = getAccount(null, us2.getId(), "us2_ac2", "decs4", null);
        
        // do not add accounts to the users
        
        saveAccounts(Arrays.asList(us1_ac1, us1_ac2, us2_ac1, us2_ac2));
        
        TransactionRecord us1_ac1_tr1 = getTransactionRecord(null, us1_ac1.getId(),
                "us1_ac1_tr1", "desc", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 1));
        TransactionRecord us1_ac1_tr2 = getTransactionRecord(null, us1_ac1.getId(),
                "us1_ac1_tr2", "desc", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 2));
        TransactionRecord us1_ac2_tr1 = getTransactionRecord(null, us1_ac2.getId(),
                "us1_ac2_tr1", "desc", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 3));
        TransactionRecord us1_ac2_tr2 = getTransactionRecord(null, us1_ac2.getId(),
                "us1_ac2_tr2", "desc", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 4));
        TransactionRecord us2_ac1_tr1 = getTransactionRecord(null, us2_ac1.getId(),
                "us2_ac1_tr1", "desc", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 5));
        TransactionRecord us2_ac1_tr2 = getTransactionRecord(null, us2_ac1.getId(),
                "us2_ac1_tr2", "desc", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 6));
        TransactionRecord us2_ac2_tr1 = getTransactionRecord(null, us2_ac2.getId(),
                "us2_ac2_tr1", "desc", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 7));
        TransactionRecord us2_ac2_tr2 = getTransactionRecord(null, us2_ac2.getId(),
                "us2_ac2_tr2", "desc", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 8));
        
        // do not add transactions to the accounts
        // we will use account later and they should not have any transaction
        
        saveTransactions(Arrays.asList(
                us1_ac1_tr1, us1_ac1_tr2,
                us1_ac2_tr1, us1_ac2_tr2,
                us2_ac1_tr1, us2_ac1_tr2,
                us2_ac2_tr1, us2_ac2_tr2));
        
        checkUsersAccounts(us3, null);
        checkUsersAccounts(us1, Arrays.asList(us1_ac1, us1_ac2));
        checkUsersAccounts(us2, Arrays.asList(us2_ac1, us2_ac2));
        
        deleteAccount(us2_ac2);
        deleteTransaction(us2_ac2_tr1);
        deleteTransaction(us2_ac2_tr2);
        
        checkUsersAccounts(us3, null);
        checkUsersAccounts(us1, Arrays.asList(us1_ac1, us1_ac2));
        checkUsersAccounts(us2, Arrays.asList(us2_ac1));
    }
    
    //////////// get names ////////////
    
    @Test
    public void getNamesEmptyDB() throws UserServiceException{
        Map<Long, String> names = doGetUsersNames();
        assertNotNull("Returned map should not be null.", names);
        assertTrue("DB is empty. Returned map should be empty too.", names.isEmpty());
    }
    
    @Test
    public void getNamesOk() throws UserServiceException{
        User us1 = getUser(null, "userOne", null);
        User us2 = getUser(null, "userTwo", null);
        User us3 = getUser(null, "userThree", null);
        saveObject(us1);
        saveObject(us2);
        saveObject(us3);
        
        Map<Long, String> expected = new HashMap<>();
        expected.put(us1.getId(), us1.getName());
        expected.put(us2.getId(), us2.getName());
        expected.put(us3.getId(), us3.getName());
        Map<Long, String> fromDB = doGetUsersNames();
        deepMapEquals(fromDB, expected);
        
        //removed one user
        deleteObject(us2);
        expected.remove(us2.getId());
        fromDB = doGetUsersNames();
        deepMapEquals(fromDB, expected);
        
        //added new user
        User us4 = getUser(null, "userFour", null);
        saveObject(us4);
        expected.put(us4.getId(), us4.getName());
        fromDB = doGetUsersNames();
        deepMapEquals(fromDB, expected);
    }
    
    private void checkUsersAccounts(User toLoad, Collection<Account> expected) throws UserServiceException{
        Set<Account> expectedWithoutTransactions = new HashSet<>();
        if(expected != null && !expected.isEmpty()){
            for(Account ac : expected){
                expectedWithoutTransactions.add(
                        getAccount(ac.getId(), ac.getUsersID(), ac.getName(), ac.getDescription(), null));
            }
        }
        // only account should be changed, even if user has null name
        // (e.g. name has been set but not saved)
        User copyToLoad = getUser(toLoad.getId(), toLoad.getName() == null ? "diff" : null, null);
        User expectedUser = getUser(toLoad.getId(), copyToLoad.getName(), expectedWithoutTransactions);
        User fromDB = doLoadUsersAccounts(copyToLoad);
        deepEquals(fromDB, expectedUser);
    }
}
