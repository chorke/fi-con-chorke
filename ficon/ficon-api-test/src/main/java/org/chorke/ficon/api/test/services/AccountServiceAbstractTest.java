
package org.chorke.ficon.api.test.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.chorke.ficon.api.exceptions.AccountServiceException;
import org.chorke.ficon.api.objects.Account;
import org.chorke.ficon.api.objects.TransactionRecord;
import org.chorke.ficon.api.services.AccountService;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Abstract test for AccountService. When implementing AccountService interface 
 * all what you need to do to test it is to extend this class and implement
 * abstract methods. 
 * 
 * @author Chorke
 */
public abstract class AccountServiceAbstractTest
    extends AbstractServiceTest<AccountService, Account>{

    /**
     * Creates account. Method calls associated {@code befor}
     * method, create method of service and associated {@code after} method.
     * Depends on standard create method of service.
     * 
     * @param account
     * @throws AccountServiceException 
     * @see #beforeCreateNewAccount(org.chorke.ficon.api.objects.Account) 
     * @see #afterCreateNewAccount(java.lang.Exception, org.chorke.ficon.api.objects.Account) 
     * @see AccountService#createNewAccount(org.chorke.ficon.api.objects.Account) 
     */
    protected final void doCreateNewAccount(Account account)
            throws AccountServiceException{
        try{
            beforeCreateNewAccount(account);
            service.createNewAccount(account);
            afterCreateNewAccount(null, account);
        } catch (AccountServiceException | IllegalArgumentException ex){
            afterCreateNewAccount(ex, account);
            throw ex;
        }
    }

    /**
     * Deletes account. Method calls associated {@code befor}
     * method, delete method of service and associated {@code after} method.
     * Depends on standard delete method of service.
     * 
     * @param account
     * @throws AccountServiceException 
     * @see #beforeDeleteAccount(org.chorke.ficon.api.objects.Account) 
     * @see #afterDeleteAccount(java.lang.Exception, org.chorke.ficon.api.objects.Account) 
     * @see AccountService#deleteAccount(org.chorke.ficon.api.objects.Account) 
     */
    protected final void doDeleteAccount(Account account)
            throws AccountServiceException{
        try{
            beforeDeleteAccount(account);
            service.deleteAccount(account);
            afterDeleteAccount(null, account);
        } catch (AccountServiceException | IllegalArgumentException ex){
            afterDeleteAccount(ex, account);
            throw ex;
        }
    }

    /**
     * Returns names of all accounts. Method calls associated {@code befor}
     * method, get-accounts-names method of service and associated {@code after} method.
     * Depends on standard get-account-names method of service.
     * 
     * @param usersID
     * @return
     * @throws AccountServiceException 
     * @see #beforeGetAccountsName(java.lang.Long) 
     * @see #afterGetAccountsName(java.lang.Exception, java.lang.Long) 
     * @see AccountService#getAccountsNames(java.lang.Long) 
     */
    protected final Map<Long, String> doGetAccountsName(Long usersID)
            throws AccountServiceException{
        try{
            beforeGetAccountsName(usersID);
            Map<Long, String> ret = service.getAccountsNames(usersID);
            afterGetAccountsName(null, usersID);
            return ret;
        } catch (AccountServiceException | IllegalArgumentException ex){
            afterGetAccountsName(ex, usersID);
            throw ex;
        }
    }

    /**
     * Returns account. Method calls associated {@code befor}
     * method, get-basic-account method of service and associated {@code after} method.
     * Depends on standard get-basic-account method of service.
     * 
     * @param id
     * @return
     * @throws AccountServiceException 
     * @see #beforeGetBasicAccount(java.lang.Long) 
     * @see #afterGetBasicAccount(java.lang.Exception, java.lang.Long) 
     * @see AccountService#getBasicAccount(java.lang.Long) 
     */
    protected final Account doGetBasicAccount(Long id)
            throws AccountServiceException{
        try{
            beforeGetBasicAccount(id);
            Account ret = service.getBasicAccount(id);
            afterGetBasicAccount(null, id);
            return ret;
        } catch (AccountServiceException | IllegalArgumentException ex){
            afterGetBasicAccount(ex, id);
            throw ex;
        }
    }

    /**
     * Returns account. Method calls associated {@code befor}
     * method, get-full-account method of service and associated {@code after} method.
     * Depends on standard get-full-account method of service.
     * 
     * @param id
     * @return
     * @throws AccountServiceException 
     * @see #beforeGetFullAccount(java.lang.Long) 
     * @see #afterGetFullAccount(java.lang.Exception, java.lang.Long) 
     * @see AccountService#getFullAccount(java.lang.Long) 
     */
    protected final Account doGetFullAccount(Long id)
            throws AccountServiceException{
        try{
            beforeGetFullAccount(id);
            Account ret = service.getFullAccount(id);
            afterGetFullAccount(null, id);
            return ret;
        } catch (AccountServiceException | IllegalArgumentException ex){
            afterGetFullAccount(ex, id);
            throw ex;
        }
    }

    /**
     * Loads transaction history of account. Method calls associated {@code befor}
     * method, load method of service and associated {@code after} method.
     * Depends on standard load method of service.
     * 
     * @param account
     * @return
     * @throws AccountServiceException 
     * @see #beforeLoadTransactionHistory(org.chorke.ficon.api.objects.Account) 
     * @see #afterLoadTransactionHistory(java.lang.Exception, org.chorke.ficon.api.objects.Account, java.util.Properties) 
     * @see AccountService#loadTransactionHistory(org.chorke.ficon.api.objects.Account) 
     */
    protected final Account doLoadTransactionHistory(Account account)
            throws AccountServiceException{
        try{
            beforeLoadTransactionHistory(account);
            Account ret = service.loadTransactionHistory(account);
            afterLoadTransactionHistory(null, account);
            return ret;
        } catch (AccountServiceException | IllegalArgumentException ex){
            afterLoadTransactionHistory(ex, account);
            throw ex;
        }
    }

    /**
     * Loads transaction history of account. Method calls associated {@code befor}
     * method, load-with-properties method of service and associated {@code after} method.
     * Depends on standard load-with-properties method of service.
     * 
     * @param account
     * @param properties
     * @return
     * @throws AccountServiceException 
     * @see #beforeLoadTransactionHistory(org.chorke.ficon.api.objects.Account, java.util.Properties) 
     * @see #afterLoadTransactionHistory(java.lang.Exception, org.chorke.ficon.api.objects.Account, java.util.Properties) 
     * @see AccountService#loadTransactionHistory(org.chorke.ficon.api.objects.Account, java.util.Properties) 
     */
    protected final Account doLoadTransactionHistory(Account account, Properties properties)
            throws AccountServiceException{
        try{
            beforeLoadTransactionHistory(account, properties);
            Account ret = service.loadTransactionHistory(account, properties);
            afterLoadTransactionHistory(null, account, properties);
            return ret;
        } catch (AccountServiceException | IllegalArgumentException ex){
            afterLoadTransactionHistory(ex, account, properties);
            throw ex;
        }
    }

    /**
     * Transfers money from one account to another account. Method calls associated {@code befor}
     * method, transfer method of service and associated {@code after} method.
     * Depends on standard transfer method of service.
     * 
     * @param fromAccount
     * @param toAccount
     * @param amount
     * @throws AccountServiceException 
     * @see #beforeTransferMoney(org.chorke.ficon.api.objects.Account, org.chorke.ficon.api.objects.Account, java.math.BigDecimal) 
     * @see #afterTransferMoney(java.lang.Exception, org.chorke.ficon.api.objects.Account, org.chorke.ficon.api.objects.Account, java.math.BigDecimal) 
     * @see AccountService#transferMoney(org.chorke.ficon.api.objects.Account, org.chorke.ficon.api.objects.Account, java.math.BigDecimal) 
     */
    protected final void doTransferMoney(Account fromAccount, Account toAccount, BigDecimal amount)
            throws AccountServiceException{
        try{
            beforeTransferMoney(fromAccount, toAccount, amount);
            service.transferMoney(fromAccount, toAccount, amount);
            afterTransferMoney(null, fromAccount, toAccount, amount);
        } catch (AccountServiceException | IllegalArgumentException ex){
            afterTransferMoney(ex, fromAccount, toAccount, amount);
            throw ex;
        }
    }

    /**
     * Updates account. Method calls associated {@code befor}
     * method, update method of service and associated {@code after} method.
     * Depends on standard update method of service.
     * 
     * @param account
     * @throws AccountServiceException 
     * @see #beforeUpdateAccount(org.chorke.ficon.api.objects.Account) 
     * @see #afterUpdateAccount(java.lang.Exception, org.chorke.ficon.api.objects.Account) 
     * @see AccountService#updateAccount(org.chorke.ficon.api.objects.Account) 
     */
    protected final void doUpdateAccount(Account account)
            throws AccountServiceException{
        try{
            beforeUpdateAccount(account);
            service.updateAccount(account);
            afterUpdateAccount(null, account);
        } catch (AccountServiceException | IllegalArgumentException ex){
            afterUpdateAccount(ex, account);
            throw ex;
        }
    }

    /**
     * This method is executed closely before calling create method of service.
     * 
     * @param account 
     */
    protected abstract void beforeCreateNewAccount(Account account);
    /**
     * This method is executed immediately after calling create method of service.
     * 
     * @param thrown exception that has been thrown during operation
     * @param account 
     */
    protected abstract void afterCreateNewAccount(Exception thrown, Account account);

    /**
     * This method is executed closely before calling delete method of service.
     * 
     * @param account 
     */
    protected abstract void beforeDeleteAccount(Account account);
    /**
     * This method is executed immediately after calling delete method of service.
     * 
     * @param thrown exception that has been thrown during operation
     * @param account 
     */
    protected abstract void afterDeleteAccount(Exception thrown, Account account);

    /**
     * This method is executed closely before calling getAccountsNames method of service.
     * 
     * @param usersID 
     */
    protected abstract void beforeGetAccountsName(Long usersID);
    /**
     * This method is executed immediately after calling getAccountsNames method of service.
     * 
     * @param thrown exception that has been thrown during operation
     * @param usersID 
     */
    protected abstract void afterGetAccountsName(Exception thrown, Long usersID);

    /**
     * This method is executed closely before calling getBsicAccount method of service.
     * 
     * @param id 
     */
    protected abstract void beforeGetBasicAccount(Long id);
    /**
     * This method is executed immediately after calling getBasicAccount method of service.
     * 
     * @param thrown exception that has been thrown during operation
     * @param id 
     */
    protected abstract void afterGetBasicAccount(Exception thrown, Long id);

    /**
     * This method is executed closely before calling getFullAccount method of service.
     * 
     * @param id 
     */
    protected abstract void beforeGetFullAccount(Long id);
    /**
     * This method is executed immediately after calling getFullAccount method of service.
     * 
     * @param thrown exception that has been thrown during operation
     * @param id 
     */
    protected abstract void afterGetFullAccount(Exception thrown, Long id);

    /**
     * This method is executed closely before calling 
     * loadTransactionHistory-with-load-properties method of service.
     * 
     * @param account
     * @param properties 
     */
    protected abstract void beforeLoadTransactionHistory(Account account, Properties properties);
    /**
     * This method is executed immediately after calling 
     * loadTransactionHistory-with-load-properties method of service.
     * 
     * @param thrown exception that has been thrown during operation
     * @param account
     * @param properties 
     */
    protected abstract void afterLoadTransactionHistory(Exception thrown, Account account, Properties properties);

    /**
     * This method is executed closely before calling loadTransactionHistory method of service.
     * 
     * @param account 
     */
    protected abstract void beforeLoadTransactionHistory(Account account);
    /**
     * This method is executed immediately after calling loadTransactionHistory method of service.
     * 
     * @param thrown exception that has been thrown during operation
     * @param account 
     */
    protected abstract void afterLoadTransactionHistory(Exception thrown, Account account);

    /**
     * This method is executed closely before calling transferMoney method of service.
     * 
     * @param fromAccount
     * @param toAccount
     * @param amount 
     */
    protected abstract void beforeTransferMoney(Account fromAccount, Account toAccount, BigDecimal amount);
    /**
     * This method is executed immediately after calling transferMoney method of service.
     * 
     * @param thrown exception that has been thrown during operation
     * @param fromAccount
     * @param toAccount
     * @param amount 
     */
    protected abstract void afterTransferMoney(Exception thrown, Account fromAccount, Account toAccount, BigDecimal amount);

    /**
     * This method is executed closely before calling update method of service.
     * 
     * @param account 
     */
    protected abstract void beforeUpdateAccount(Account account);
    /**
     * This method is executed immediately after calling update method of service.
     * 
     * @param thrown exception that has been thrown during operation
     * @param account 
     */
    protected abstract void afterUpdateAccount(Exception thrown, Account account);
    
    /**
     * Returns transaction history of account with ID {@code id}.
     * History is loaded independently of service, so it does not depends 
     * on any service. 
     * 
     * @param id
     * @return 
     */
    protected abstract List<TransactionRecord> getTransactionHistoryOfAccount(Long id);
    
    /**
     * Saves transaction history of account.
     * History is saved independently of service, so it does not depends 
     * on any service. 
     * 
     * @param records
     */
    protected abstract void saveTransactionHistory(List<TransactionRecord> records);
    
      ////////////////////////////////////////////////////////////////
     ///////////////////          tests          ////////////////////
    ////////////////////////////////////////////////////////////////
    
    @Test(expected = IllegalArgumentException.class)
    public void createNullArgument() throws AccountServiceException{
        doCreateNewAccount(null);
        fail("null argument");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void createNonNullID() throws AccountServiceException{
        Account ac = getAccount(1L, 1L, "nonnullid", null, null);
        doCreateNewAccount(ac);
        fail("non-null id");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void createNullName() throws AccountServiceException{
        Account ac = getAccount(null, 1L, null, null, null);
        doCreateNewAccount(ac);
        fail("null name");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void createEmptyName() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "", null, null);
        doCreateNewAccount(ac);
        fail("empty name");
    }
    
    @Test
    public void createOKAccountNoTransactionHistory() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "okaccount", "this account should be OK", null);
        doCreateNewAccount(ac);
        Account inDB = getObject(ac.getId());
        deepEquals(ac, inDB);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void createOKAccountWithTransactionHistory() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "okaccount", "this account should be ok",
                Arrays.asList(
                    getTransactionRecord(1L, 1L, "name1", "des1", null, BigDecimal.ZERO, new GregorianCalendar()),
                    getTransactionRecord(2L, 1L, "name2", "des2", null, BigDecimal.ZERO, new GregorianCalendar())
                    )
                );
        doCreateNewAccount(ac);
        fail("Cannot create acount with nonempty transaction history. "
                + "Either account's ID has been set or transaction records have wrong "
                + "accountID.");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void deleteNullArgument() throws AccountServiceException{
        doDeleteAccount(null);
        fail("null argument");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void deleteNullID() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "name", "des", null);
        doDeleteAccount(ac);
        fail("null id");
    }
    
    @Test
    public void deleteOkArgument() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "name", "des", null);
        saveObject(ac);
        doDeleteAccount(ac);
        if(getObject(ac.getId()) != null){
            fail("object has not been deleted");
        }
    }
    
    @Test
    public void deleteOkArgumentWithTransactionHistrory() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "name", "des", null);
        saveObject(ac);
        saveTransactionHistory(Arrays.asList(
                    getTransactionRecord(null, ac.getId(), "name1", "des1", null, BigDecimal.ZERO, new GregorianCalendar()),
                    getTransactionRecord(null, ac.getId(), "name2", "des2", null, BigDecimal.ZERO, new GregorianCalendar())
                    )
                );
        doDeleteAccount(ac);
        if(getObject(ac.getId()) != null){
            fail("object has not been deleted");
        }
        if(!getTransactionHistoryOfAccount(ac.getId()).isEmpty()){
            fail("transaction hostory has not been deleted");
        }
    }
    
    @Test
    public void deleteOkArgumentNothingInDB() throws AccountServiceException{
        Account ac = getAccount(1L, 1L, "name", "des", null);
        doDeleteAccount(ac);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void updateNullArgumen() throws AccountServiceException{
        doUpdateAccount(null);
        fail("null argument");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void updateNullID() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "okname", "desc", null);
        doUpdateAccount(ac);
        fail("null id");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void updateNullName() throws AccountServiceException{
        Account ac = getAccount(1L, 1L, null, "desc", null);
        doUpdateAccount(ac);
        fail("null name");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void updateEmptyName() throws AccountServiceException{
        Account ac = getAccount(1L, 1L, "", "desc", null);
        doUpdateAccount(ac);
        fail("empty name");
    }
    
    @Test
    public void updateOkArgumentNameChanged() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "namebefore", "description before update", null);
        saveObject(ac);
        ac.setName("nameafter");
        doUpdateAccount(ac);
        deepEquals(ac, getObject(ac.getId()));
    }
    
    @Test
    public void updateOkArgumentDescriptionChanged() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "namebefore", "description before update", null);
        saveObject(ac);
        ac.setDescription("desription after update");
        doUpdateAccount(ac);
        deepEquals(ac, getObject(ac.getId()));
    }
    
    @Test
    public void updateOkArgumentDescriptionChangedToEmpty() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "namebefore", "description before update", null);
        saveObject(ac);
        ac.setDescription("");
        doUpdateAccount(ac);
        deepEquals(ac, getObject(ac.getId()));
    }
    
    @Test
    public void updateOkArgumentDescriptionChangedToNull() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "namebefore", "description before update", null);
        saveObject(ac);
        ac.setDescription(null);
        doUpdateAccount(ac);
        deepEquals(ac, getObject(ac.getId()));
    }
    
    @Test
    public void updateOkArgumentNameAndDescriptionChanged() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "namebefore", "description before update", null);
        saveObject(ac);
        ac.setName("nameafter");
        ac.setDescription("desription after update");
        doUpdateAccount(ac);
        deepEquals(ac, getObject(ac.getId()));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void getBasicNullArgument() throws AccountServiceException{
        doGetBasicAccount(null);
        fail("null argument");
    }
    
    @Test
    public void getBasicEmptyDB() throws AccountServiceException{
        assertNull(doGetBasicAccount(1L));
    }
    
    @Test
    public void getBasicWrongID() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "name", "description of the account", null);
        saveObject(ac);
        Account fromDB = doGetBasicAccount(ac.getId() + 1);
        assertNull(fromDB);
    }
    
    @Test
    public void getBasicGoodID() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "name", "description of the account", null);
        saveObject(ac);
        Account fromDB = doGetBasicAccount(ac.getId());
        deepEquals(fromDB, ac);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void getFullNullArgument() throws AccountServiceException{
        doGetFullAccount(null);
        fail("null argument");
    }
    
    @Test
    public void getFullEmptyDB() throws AccountServiceException{
        assertNull(doGetBasicAccount(1L));
    }
    
    @Test
    public void getFullWrongID() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "name", "description of the account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    getTransactionRecord(null, ac.getId(), "name1", "des1", null, BigDecimal.ZERO, new GregorianCalendar()),
                    getTransactionRecord(null, ac.getId(), "name2", "des2", null, BigDecimal.ZERO, new GregorianCalendar())
                    );
        saveTransactionHistory(trHistory);
        ac.addTransaction(trHistory.get(0));
        ac.addTransaction(trHistory.get(1));
        Account fromDB = doGetBasicAccount(ac.getId() + 1);
        assertNull(fromDB);
    }
    
    @Test
    public void getFullGoodID() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "name", "description of the account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    getTransactionRecord(null, ac.getId(), "name1", "des1", null, BigDecimal.ZERO, new GregorianCalendar()),
                    getTransactionRecord(null, ac.getId(), "name2", "des2", null, BigDecimal.ZERO, new GregorianCalendar())
                    );
        saveTransactionHistory(trHistory);
        ac.addTransaction(trHistory.get(0));
        ac.addTransaction(trHistory.get(1));
        Account fromDB = doGetBasicAccount(ac.getId());
        deepEquals(fromDB, ac);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void loadSimpleNullArgument() throws AccountServiceException{
        doLoadTransactionHistory(null);
        fail("null argumen");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void loadSimpleNullID() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "name", "description", null);
        doLoadTransactionHistory(ac);
        fail("null id of account");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void loadSimpleTransactionHistoryPresent() throws AccountServiceException{
        Account ac = getAccount(1L, 1L, "name", "description", Arrays.asList(
                    getTransactionRecord(1L, 1L, "name1", "des1", null, BigDecimal.ZERO, new GregorianCalendar()),
                    getTransactionRecord(2L, 1L, "name2", "des2", null, BigDecimal.ZERO, new GregorianCalendar())
                    )
                );
        doLoadTransactionHistory(ac);
        fail("transaction history present");
    }
    
    @Test
    public void loadSimpleEmptyDB() throws AccountServiceException{
        Account ac = getAccount(1L, 1L, "name", "desc", null);
        Account fromDB = doLoadTransactionHistory(ac);
        //in case that load returns same instance
        //method should not change account's name and description (i.e. new name
        //has been set but account has not been updated in DB yet)
        Account acCopy = getAccount(1L, 1L, "name", "desc", null);
        deepEquals(acCopy, fromDB);
    }
    
    @Test
    public void loadSimpleWrongID() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "name", "description of the account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    getTransactionRecord(null, ac.getId(), "name1", "des1", null, BigDecimal.ZERO, new GregorianCalendar()),
                    getTransactionRecord(null, ac.getId(), "name2", "des2", null, BigDecimal.ZERO, new GregorianCalendar())
                    );
        saveTransactionHistory(trHistory);
        Account ac2 = getAccount(2L, 2L, "name2", "description two", null);
        Account ac2Copy = getAccount(2L, 2L, "name2", "description two", null);
        Account fromDB = doLoadTransactionHistory(ac2);
        deepEquals(fromDB, ac2Copy);
    }
    
    @Test
    public void loadSimpleNoTransactionHistory() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "name", "description", null);
        saveObject(ac);
        Account acShallowCopy = getAccount(ac.getId(), 1L, null, null, null);
        Account acShallowCopyToLoad = getAccount(ac.getId(), 1L, null, null, null);
        Account fromDB = doLoadTransactionHistory(acShallowCopyToLoad);
        //no field should be changed, even with null name
        deepEquals(fromDB, acShallowCopy);
    }
    
    @Test
    public void loadSimpleWithTransactionHistory() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "name", "description of the account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    getTransactionRecord(null, ac.getId(), "name1", "des1", null, BigDecimal.ZERO, new GregorianCalendar()),
                    getTransactionRecord(null, ac.getId(), "name2", "des2", null, BigDecimal.ZERO, new GregorianCalendar())
                    );
        saveTransactionHistory(trHistory);
        Account acShallowCopy = getAccount(ac.getId(), 1L, null, null, trHistory);
        Account acShallowCopyToLoad = getAccount(ac.getId(), 1L, null, null, null);
        Account fromDB = doLoadTransactionHistory(acShallowCopyToLoad);
        //no field should be changed (except transaction history), even with null name
        deepEquals(fromDB, acShallowCopy);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void loadWithPropsNullAccount() throws AccountServiceException{
        doLoadTransactionHistory(null, null);
        fail("null account");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void loadWithPropsNullID() throws AccountServiceException{
        Account ac = getAccount(null, 1L, null, null, null);
        doLoadTransactionHistory(ac, null);
        fail("null ID");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void loadWithPropsTransactionHistoryPresent() throws AccountServiceException{
        Account ac = getAccount(1L, 1L, "name", "description", Arrays.asList(
                    getTransactionRecord(1L, 1L, "name1", "des1", null, BigDecimal.ZERO, new GregorianCalendar()),
                    getTransactionRecord(2L, 1L, "name2", "des2", null, BigDecimal.ZERO, new GregorianCalendar())
                    )
                );
        doLoadTransactionHistory(ac, null);
        fail("transaction history present");
    }
    
    @Test
    public void loadWithPropsEmptyDB() throws AccountServiceException{
        Account ac = getAccount(1L, 1L, "name", "desc", null);
        Account fromDB = doLoadTransactionHistory(ac, null);
        //in case that load returns same instance
        //method should not change account's name and description (i.e. new name
        //has been set but account has not been updated in DB yet)
        Account acCopy = getAccount(1L, 1L, "name", "desc", null);
        deepEquals(acCopy, fromDB);
        //empty props
        fromDB = doLoadTransactionHistory(acCopy, new Properties());
        deepEquals(acCopy, fromDB);
    }
    
    @Test
    public void loadwithPropsWrongID() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "name", "description of the account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    getTransactionRecord(null, ac.getId(), "name1", "des1", null, BigDecimal.ZERO, new GregorianCalendar()),
                    getTransactionRecord(null, ac.getId(), "name2", "des2", null, BigDecimal.ZERO, new GregorianCalendar())
                    );
        saveTransactionHistory(trHistory);
        Account ac2 = getAccount(2L, 2L, "name2", "description two", null);
        Account ac2Copy = getAccount(2L, 2L, "name2", "description two", null);
        //null props
        Account fromDB = doLoadTransactionHistory(ac2, null);
        deepEquals(fromDB, ac2Copy);
        //empty props
        fromDB = doLoadTransactionHistory(ac2, new Properties());
        deepEquals(fromDB, ac2Copy);
    }
    
    @Test
    public void loadWithPropsNoTransactionHistory() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "name", "description", null);
        saveObject(ac);
        Account acShallowCopy = getAccount(ac.getId(), 1L, null, null, null);
        Account acShallowCopyToLoad = getAccount(ac.getId(), 1L, null, null, null);
        //null props
        Account fromDB = doLoadTransactionHistory(acShallowCopyToLoad, null);
        //no field should be changed, even with null name
        deepEquals(fromDB, acShallowCopy);
        //empty props
        fromDB = doLoadTransactionHistory(acShallowCopyToLoad, new Properties());
        deepEquals(fromDB, acShallowCopy);
    }
    
    @Test
    public void loadWithPropsWithTransactionHistory() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "name", "description of the account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    getTransactionRecord(null, ac.getId(), "name1", "des1", null, BigDecimal.ZERO, new GregorianCalendar()),
                    getTransactionRecord(null, ac.getId(), "name2", "des2", null, BigDecimal.ZERO, new GregorianCalendar())
                    );
        saveTransactionHistory(trHistory);
        Account acShallowCopy = getAccount(ac.getId(), 1L, null, null, trHistory);
        Account acShallowCopyToLoad = getAccount(ac.getId(), 1L, null, null, null);
        //null props
        Account fromDB = doLoadTransactionHistory(acShallowCopyToLoad, null);
        //no field should be changed (except transaction history), even with null name
        deepEquals(fromDB, acShallowCopy);
        //empty props
        fromDB = doLoadTransactionHistory(acShallowCopyToLoad, new Properties());
        deepEquals(fromDB, acShallowCopy);
    }
    
      ////////////////////////////////////////////
     //////////// one prop (5 cases) ////////////
    ////////////////////////////////////////////
    
    @Test
    public void loadWithPropsFromDate() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "name1", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "name2", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 40)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "name3", "des3", null, new BigDecimal("30"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 21, 14, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "name4", "des4", null, new BigDecimal("40"),
                        new GregorianCalendar(2014, Calendar.NOVEMBER, 20, 14, 30)),
                    //4
                    getTransactionRecord(null, ac.getId(),
                        "name5", "des5", null, new BigDecimal("50"),
                        new GregorianCalendar(2015, Calendar.NOVEMBER, 20, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.FROM_DATE,
                new GregorianCalendar(2014, Calendar.JANUARY, 21, 14, 30));
        checkLoadWithProps(ac, trHistory.subList(2, 5), prop);
    }
    
    @Test
    public void loadWithPropsToDate() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "name1", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "name2", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 31)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "name3", "des3", null, new BigDecimal("30"),
                        new GregorianCalendar(2014, Calendar.MAY, 4, 4, 7)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "name4", "des4", null, new BigDecimal("40"),
                        new GregorianCalendar(2015, Calendar.JULY, 2, 4, 3))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.TO_DATE,
                new GregorianCalendar(2014, Calendar.MAY, 4, 4, 7));
        checkLoadWithProps(ac, trHistory.subList(0, 3), prop);
    }
    
    @Test
    public void loadWithPropsMaxAmount() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "name1", "des1", null, new BigDecimal("-40"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 3)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "name2", "des2", null, new BigDecimal("-20"),
                        new GregorianCalendar(2014, Calendar.FEBRUARY, 3, 14, 30)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "name3", "des3", null, new BigDecimal("60"),
                        new GregorianCalendar(2014, Calendar.MARCH, 20, 14, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "name4", "des4", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JULY, 2, 4, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.MAX_AMOUNT, new BigDecimal("20"));
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(0), trHistory.get(1),
                trHistory.get(3)), prop);
        
        prop.put(AccountService.LoadProperties.MAX_AMOUNT, new BigDecimal("-20"));
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(0), trHistory.get(1)), prop);
    }
    
    @Test
    public void loadWithPropsMinAmount() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "name1", "des1", null, new BigDecimal("-40"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 3)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "name2", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.FEBRUARY, 3, 14, 30)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "name3", "des3", null, new BigDecimal("60"),
                        new GregorianCalendar(2014, Calendar.MARCH, 20, 14, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "name4", "des4", null, new BigDecimal("-50"),
                        new GregorianCalendar(2014, Calendar.JULY, 2, 4, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.MIN_AMOUNT, new BigDecimal("40"));
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(2)), prop);
        
        prop.put(AccountService.LoadProperties.MIN_AMOUNT, new BigDecimal("-40"));
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(0), trHistory.get(1),
                trHistory.get(2)), prop);
    }
    
    @Test
    public void loadWithPropsNameLike() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "name1", "des1", null, new BigDecimal("40"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 3)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "name2", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.FEBRUARY, 3, 14, 30)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "name13", "des3", null, new BigDecimal("60"),
                        new GregorianCalendar(2014, Calendar.MARCH, 20, 14, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "name14", "des4", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JULY, 2, 4, 30)),
                    //4
                    getTransactionRecord(null, ac.getId(),
                        "name*", "des5", null, new BigDecimal("50"),
                        new GregorianCalendar(2014, Calendar.JULY, 1, 4, 30)),
                    //5
                    getTransactionRecord(null, ac.getId(),
                        "name?", "des6", null, new BigDecimal("100"),
                        new GregorianCalendar(2014, Calendar.JUNE, 2, 4, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.NAME_LIKE, "name1");
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(0)), prop);
        
        prop.put(AccountService.LoadProperties.NAME_LIKE, "name1*");
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(0), trHistory.get(2), trHistory.get(3)), prop);
        
        prop.put(AccountService.LoadProperties.NAME_LIKE, "name*");
        checkLoadWithProps(ac, trHistory, prop);
        
        prop.put(AccountService.LoadProperties.NAME_LIKE, "*");
        checkLoadWithProps(ac, trHistory, prop);
        
        prop.put(AccountService.LoadProperties.NAME_LIKE, "name?");
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(0), trHistory.get(1),
                trHistory.get(4), trHistory.get(5)), prop);
        
        prop.put(AccountService.LoadProperties.NAME_LIKE, "name/*");
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(4)), prop);
        
        prop.put(AccountService.LoadProperties.NAME_LIKE, "name/?");
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(5)), prop);
    }
    
      ////////////////////////
     ///// end one prop /////
    ////////////////////////
    
      //////////////////////////////////////////////
     //////////// two props (10 cases) ////////////
    //////////////////////////////////////////////
    
    @Test
    public void loadWithPropsFromToDate() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "name1", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "name2", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "name3", "des3", null, new BigDecimal("30"),
                        new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "name4", "des4", null, new BigDecimal("40"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 20, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.FROM_DATE,
                new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3));
        prop.put(AccountService.LoadProperties.TO_DATE,
                new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30));
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(1), trHistory.get(2)), prop);
    }
    
    @Test
    public void loadWithPropsFromDateMaxAmount() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "name1", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "name2", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "name3", "des3", null, new BigDecimal("40"),
                        new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "name4", "des4", null, new BigDecimal("30"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 20, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.FROM_DATE,
                new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3));
        prop.put(AccountService.LoadProperties.MAX_AMOUNT,
                new BigDecimal("30"));
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(1), trHistory.get(3)), prop);
    }
    
    @Test
    public void loadWithPropsFromDateMinAmount() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "name1", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "name2", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "name3", "des3", null, new BigDecimal("40"),
                        new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "name4", "des4", null, new BigDecimal("30"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 20, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.FROM_DATE,
                new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3));
        prop.put(AccountService.LoadProperties.MIN_AMOUNT,
                new BigDecimal("30"));
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(2), trHistory.get(3)), prop);
    }
    
    @Test
    public void loadWithPropsFromDateNameLike() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "rent1", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "rent2", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "payroll", "des3", null, new BigDecimal("30"),
                        new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "rent3", "des4", null, new BigDecimal("40"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 20, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.FROM_DATE,
                new GregorianCalendar(2014, Calendar.JUNE, 18, 1, 3));
        prop.put(AccountService.LoadProperties.NAME_LIKE,
                "rent*");
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(1), trHistory.get(3)), prop);
    }
    
    @Test
    public void loadWithPropsToDateMaxAmount() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "rent1", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "rent2", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "payroll", "des3", null, new BigDecimal("30"),
                        new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "rent3", "des4", null, new BigDecimal("40"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 20, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.TO_DATE,
                new GregorianCalendar(2015, Calendar.JUNE, 18, 1, 3));
        prop.put(AccountService.LoadProperties.MAX_AMOUNT,
                new BigDecimal("25"));
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(1), trHistory.get(0)), prop);
    }
    
    @Test
    public void loadWithPropsToDateMinAmount() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "rent1", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "rent2", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "payroll", "des3", null, new BigDecimal("30"),
                        new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "rent3", "des4", null, new BigDecimal("40"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 20, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.TO_DATE,
                new GregorianCalendar(2015, Calendar.JUNE, 18, 1, 3));
        prop.put(AccountService.LoadProperties.MIN_AMOUNT,
                new BigDecimal("25"));
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(2)), prop);
    }
    
    @Test
    public void loadWithPropsToDateNameLike() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "rent1", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "rent2", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "rent12", "des3", null, new BigDecimal("30"),
                        new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "rent3", "des4", null, new BigDecimal("40"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 20, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.TO_DATE,
                new GregorianCalendar(2015, Calendar.JUNE, 18, 1, 3));
        prop.put(AccountService.LoadProperties.NAME_LIKE,
                "rent?");
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(1), trHistory.get(0)), prop);
    }
    
    @Test
    public void loadWithPropsMaxMinAmount() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "rent1", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "rent2", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "payroll", "des3", null, new BigDecimal("30"),
                        new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "rent3", "des4", null, new BigDecimal("40"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 20, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.MIN_AMOUNT,
                new BigDecimal("10.001"));
        prop.put(AccountService.LoadProperties.MAX_AMOUNT,
                new BigDecimal("29.999"));
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(1)), prop);
    }
    
    @Test
    public void loadWithPropsMaxAmountNameLike() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "rent1", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "rent1", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "payroll", "des3", null, new BigDecimal("30"),
                        new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "rent3", "des4", null, new BigDecimal("40"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 20, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.NAME_LIKE,
                "rent1");
        prop.put(AccountService.LoadProperties.MAX_AMOUNT,
                new BigDecimal("30"));
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(1), trHistory.get(0)), prop);
    }
    
    @Test
    public void loadWithPropsMinAmountNameLike() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "rent1", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "rent2", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "payroll", "des3", null, new BigDecimal("30"),
                        new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "rent3", "des4", null, new BigDecimal("40"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 20, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.NAME_LIKE,
                "*");
        prop.put(AccountService.LoadProperties.MIN_AMOUNT,
                new BigDecimal("25"));
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(2), trHistory.get(3)), prop);
    }
    
     ////////////////////////
     ///// end two prop /////
    ////////////////////////
    
      ////////////////////////////////////////////////
     //////////// three props (10 cases) ////////////
    ////////////////////////////////////////////////
    
    @Test
    public void loadWithPropsFromToDateMaxAmount() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "rent1", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "rent2", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "payroll", "des3", null, new BigDecimal("30"),
                        new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "rent3", "des4", null, new BigDecimal("40"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 20, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.FROM_DATE,
                new GregorianCalendar(2014, Calendar.JUNE, 18, 1, 3));
        prop.put(AccountService.LoadProperties.TO_DATE,
                new GregorianCalendar(2015, Calendar.AUGUST, 28, 2, 3));
        prop.put(AccountService.LoadProperties.MAX_AMOUNT,
                new BigDecimal("25"));
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(1)), prop);
    }
    
    @Test
    public void loadWithPropsFromToDateMinAmount() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "rent1", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "rent2", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "payroll", "des3", null, new BigDecimal("30"),
                        new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "rent3", "des4", null, new BigDecimal("40"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 20, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.FROM_DATE,
                new GregorianCalendar(2014, Calendar.JANUARY, 18, 1, 3));
        prop.put(AccountService.LoadProperties.TO_DATE,
                new GregorianCalendar(2015, Calendar.AUGUST, 18, 2, 3));
        prop.put(AccountService.LoadProperties.MIN_AMOUNT,
                new BigDecimal("20.001"));
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(2)), prop);
    }
    
    @Test
    public void loadWithPropsFromToDateNameLike() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "rent1", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "rent2", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "payroll", "des3", null, new BigDecimal("30"),
                        new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "rent3", "des4", null, new BigDecimal("40"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 20, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.FROM_DATE,
                new GregorianCalendar(2014, Calendar.JANUARY, 18, 1, 3));
        prop.put(AccountService.LoadProperties.TO_DATE,
                new GregorianCalendar(2015, Calendar.AUGUST, 18, 2, 3));
        prop.put(AccountService.LoadProperties.NAME_LIKE,
                "pay*");
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(2)), prop);
    }
    
    @Test
    public void loadWithPropsFromDateMaxMinAmount() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "rent1", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "rent2", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "payroll", "des3", null, new BigDecimal("30"),
                        new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "rent3", "des4", null, new BigDecimal("40"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 20, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.FROM_DATE,
                new GregorianCalendar(2014, Calendar.JANUARY, 21, 1, 3));
        prop.put(AccountService.LoadProperties.MAX_AMOUNT,
                new BigDecimal("32"));
        prop.put(AccountService.LoadProperties.MIN_AMOUNT,
                new BigDecimal("20.001"));
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(2)), prop);
    }
    
    @Test
    public void loadWithPropsFromDateMaxAmountNameLike() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "rent1", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "rent2", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "payroll", "des3", null, new BigDecimal("30"),
                        new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "rent3", "des4", null, new BigDecimal("40"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 20, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.FROM_DATE,
                new GregorianCalendar(2014, Calendar.JANUARY, 21, 1, 3));
        prop.put(AccountService.LoadProperties.MAX_AMOUNT,
                new BigDecimal("31"));
        prop.put(AccountService.LoadProperties.NAME_LIKE,
                "*");
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(1), trHistory.get(2)), prop);
    }
    
    @Test
    public void loadWithPropsFromDateMinAmountNameLike() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "rent1", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "rent2", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "payroll", "des3", null, new BigDecimal("30"),
                        new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "rent3", "des4", null, new BigDecimal("40"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 20, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.FROM_DATE,
                new GregorianCalendar(2014, Calendar.JANUARY, 21, 1, 3));
        prop.put(AccountService.LoadProperties.MIN_AMOUNT,
                new BigDecimal("22"));
        prop.put(AccountService.LoadProperties.NAME_LIKE,
                "?????");
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(3)), prop);
    }
    
    @Test
    public void loadWithPropsToDateMaxMinAmount() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "rent1", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "rent2", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "payroll", "des3", null, new BigDecimal("30"),
                        new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "rent3", "des4", null, new BigDecimal("40"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 20, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.TO_DATE,
                new GregorianCalendar(2015, Calendar.JANUARY, 19, 1, 3));
        prop.put(AccountService.LoadProperties.MAX_AMOUNT,
                new BigDecimal("20"));
        prop.put(AccountService.LoadProperties.MIN_AMOUNT,
                new BigDecimal("20"));
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(1)), prop);
    }
    
    @Test
    public void loadWithPropsToDateMaxAmountNameLike() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "rent", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "rent", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "payroll", "des3", null, new BigDecimal("30"),
                        new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "rent", "des4", null, new BigDecimal("40"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 20, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.TO_DATE,
                new GregorianCalendar(2015, Calendar.JANUARY, 21, 0, 0));
        prop.put(AccountService.LoadProperties.MAX_AMOUNT,
                new BigDecimal("19.001"));
        prop.put(AccountService.LoadProperties.NAME_LIKE,
                "rent");
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(0)), prop);
    }
    
    @Test
    public void loadWithPropsToDateMinAmountNameLike() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "rent", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "rent", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "payroll", "des3", null, new BigDecimal("30"),
                        new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "rent", "des4", null, new BigDecimal("40"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 20, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.TO_DATE,
                new GregorianCalendar(2015, Calendar.JANUARY, 21, 0, 0));
        prop.put(AccountService.LoadProperties.MIN_AMOUNT,
                new BigDecimal("20.001"));
        prop.put(AccountService.LoadProperties.NAME_LIKE,
                "rent");
        checkLoadWithProps(ac, new ArrayList<TransactionRecord>(), prop);
    }
    
    @Test
    public void loadWithPropsMaxMinAmountNameLike() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "rent", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "rent", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "payroll", "des3", null, new BigDecimal("30"),
                        new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "rent", "des4", null, new BigDecimal("40"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 20, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.MIN_AMOUNT,
                new BigDecimal("19.001"));
        prop.put(AccountService.LoadProperties.MAX_AMOUNT,
                new BigDecimal("39.999"));
        prop.put(AccountService.LoadProperties.NAME_LIKE,
                "rent");
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(0)), prop);
    }
    
      ///////////////////////////
     ///// end three props /////
    ///////////////////////////
    
      //////////////////////////////////////////////
     //////////// four props (5 cases) ////////////
    //////////////////////////////////////////////
    
    @Test
    public void loadWithPropsFromToDateMinMaxAmount() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        saveObject(ac);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "rent", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "rent1", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "payroll", "des3", null, new BigDecimal("30"),
                        new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "rent", "des4", null, new BigDecimal("60"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 20, 14, 30)),
                    //4
                    getTransactionRecord(null, ac.getId(),
                        "payroll2", "des5", null, new BigDecimal("50"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 22, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.FROM_DATE,
                new GregorianCalendar(2014, Calendar.JANUARY, 21, 0, 0));
        prop.put(AccountService.LoadProperties.TO_DATE,
                new GregorianCalendar(2015, Calendar.AUGUST, 21, 0, 0));
        prop.put(AccountService.LoadProperties.MAX_AMOUNT,
                new BigDecimal("50"));
        prop.put(AccountService.LoadProperties.MIN_AMOUNT,
                new BigDecimal("20"));
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(1), trHistory.get(2)), prop);
    }
    
    @Test
    public void loadWithPropsFromToDateMinAmountNameLike() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "rent", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "rent1", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "payroll", "des3", null, new BigDecimal("30"),
                        new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "rent", "des4", null, new BigDecimal("60"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 20, 14, 30)),
                    //4
                    getTransactionRecord(null, ac.getId(),
                        "payroll2", "des5", null, new BigDecimal("50"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 22, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.FROM_DATE,
                new GregorianCalendar(2014, Calendar.JANUARY, 21, 0, 0));
        prop.put(AccountService.LoadProperties.TO_DATE,
                new GregorianCalendar(2015, Calendar.AUGUST, 23, 0, 0));
        prop.put(AccountService.LoadProperties.NAME_LIKE,
                "payroll?");
        prop.put(AccountService.LoadProperties.MIN_AMOUNT,
                new BigDecimal("25"));
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(4)), prop);
    }
    
    @Test
    public void loadWithPropsFromToDateMaxAmountNameLike() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "rent", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "rent1", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "payroll", "des3", null, new BigDecimal("30"),
                        new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "rent", "des4", null, new BigDecimal("60"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 20, 14, 30)),
                    //4
                    getTransactionRecord(null, ac.getId(),
                        "payroll2", "des5", null, new BigDecimal("50"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 22, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.FROM_DATE,
                new GregorianCalendar(2014, Calendar.JANUARY, 19, 0, 0));
        prop.put(AccountService.LoadProperties.TO_DATE,
                new GregorianCalendar(2015, Calendar.AUGUST, 20, 15, 0));
        prop.put(AccountService.LoadProperties.NAME_LIKE,
                "rent*");
        prop.put(AccountService.LoadProperties.MAX_AMOUNT,
                new BigDecimal("31"));
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(0), trHistory.get(1)), prop);
    }
    
    @Test
    public void loadWithPropsFromDateMinMaxAmountNameLike() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "rent", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "rent1", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "payroll", "des3", null, new BigDecimal("30"),
                        new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "rent", "des4", null, new BigDecimal("60"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 20, 14, 30)),
                    //4
                    getTransactionRecord(null, ac.getId(),
                        "payroll2", "des5", null, new BigDecimal("50"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 22, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.FROM_DATE,
                new GregorianCalendar(2014, Calendar.JANUARY, 21, 0, 0));
        prop.put(AccountService.LoadProperties.MAX_AMOUNT,
                new BigDecimal("60"));
        prop.put(AccountService.LoadProperties.NAME_LIKE,
                "payroll?");
        prop.put(AccountService.LoadProperties.MIN_AMOUNT,
                new BigDecimal("25"));
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(2)), prop);
    }
    
    @Test
    public void loadWithPropsToDateMinMaxAmountNameLike() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "rent", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "rent1", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "payroll", "des3", null, new BigDecimal("30"),
                        new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "rent", "des4", null, new BigDecimal("60"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 20, 14, 30)),
                    //4
                    getTransactionRecord(null, ac.getId(),
                        "payroll2", "des5", null, new BigDecimal("50"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 22, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.MAX_AMOUNT,
                new BigDecimal("31"));
        prop.put(AccountService.LoadProperties.TO_DATE,
                new GregorianCalendar(2015, Calendar.JANUARY, 21, 0, 0));
        prop.put(AccountService.LoadProperties.NAME_LIKE,
                "r*");
        prop.put(AccountService.LoadProperties.MIN_AMOUNT,
                new BigDecimal("20"));
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(1)), prop);
    }
    
      //////////////////////////
     ///// end four props /////
    //////////////////////////
    
      ////////////////////////////////////
     //////////// five props ////////////
    ////////////////////////////////////
    
    @Test
    public void loadWithPropsFromToDateMinMaxAmountNameLike() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "account", "test account", null);
        List<TransactionRecord> trHistory = Arrays.asList(
                    //0
                    getTransactionRecord(null, ac.getId(), 
                        "rent", "des1", null, new BigDecimal("10"),
                        new GregorianCalendar(2014, Calendar.JANUARY, 20, 14, 30)),
                    //1
                    getTransactionRecord(null, ac.getId(), 
                        "rent1", "des2", null, new BigDecimal("20"),
                        new GregorianCalendar(2014, Calendar.JUNE, 20, 14, 3)),
                    //2
                    getTransactionRecord(null, ac.getId(), 
                        "payroll", "des3", null, new BigDecimal("30"),
                        new GregorianCalendar(2015, Calendar.JANUARY, 20, 4, 30)),
                    //3
                    getTransactionRecord(null, ac.getId(),
                        "rent", "des4", null, new BigDecimal("60"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 20, 14, 30)),
                    //4
                    getTransactionRecord(null, ac.getId(),
                        "payroll2", "des5", null, new BigDecimal("50"),
                        new GregorianCalendar(2015, Calendar.AUGUST, 22, 14, 30))
                    );
        saveTransactionHistory(trHistory);
        Properties prop = new Properties();
        prop.put(AccountService.LoadProperties.FROM_DATE,
                new GregorianCalendar(2014, Calendar.JANUARY, 21, 0, 0));
        prop.put(AccountService.LoadProperties.TO_DATE,
                new GregorianCalendar(2015, Calendar.AUGUST, 21, 0, 0));
        prop.put(AccountService.LoadProperties.MAX_AMOUNT,
                new BigDecimal("60"));
        prop.put(AccountService.LoadProperties.MIN_AMOUNT,
                new BigDecimal("30"));
        prop.put(AccountService.LoadProperties.NAME_LIKE,
                "re??");
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(3)), prop);
    }
    
      //////////////////////////
     ///// end five props /////
    //////////////////////////
    
    @Test(expected = IllegalArgumentException.class)
    public void transferFirstArgumentNull() throws AccountServiceException{
        Account ac = getAccount(1L, 1L, "name", "description", null);
        doTransferMoney(null, ac, BigDecimal.ONE);
        fail("null first argument");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void transferSecondArgumentNull() throws AccountServiceException{
        Account ac = getAccount(1L, 1L, "name", "description", null);
        doTransferMoney(ac, null, BigDecimal.ONE);
        fail("null second argument");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void transferThirdArgumentNull() throws AccountServiceException{
        Account from = getAccount(1L, 1L, "from", "from account", null);
        Account to = getAccount(2L, 1L, "to", "to account", null);
        doTransferMoney(from, to, null);
        fail("null third argument argument");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void transferFromAndToHaveSameID() throws AccountServiceException{
        Account from = getAccount(1L, 1L, "from", "from account", null);
        Account to = getAccount(1L, 1L, "to", "to account", null);
        doTransferMoney(from, to, BigDecimal.ONE);
        fail("from and to have same ID");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void transferZeroAmount() throws AccountServiceException{
        Account from = getAccount(1L, 1L, "from", "from account", null);
        Account to = getAccount(2L, 1L, "to", "to account", null);
        doTransferMoney(from, to, BigDecimal.ZERO);
        fail("nothing to transfer");
    }
    
    @Test
    public void transferOkArgumentsEmptyHistory() throws AccountServiceException{
        Account from = getAccount(1L, 1L, "from", "from account", null);
        Account to = getAccount(2L, 1L, "to", "to account", null);
        doTransferMoney(from, to, BigDecimal.TEN);
        
        assertEquals(0, BigDecimal.TEN.negate().compareTo(from.getBalance()));
        assertEquals(0, BigDecimal.TEN.compareTo(to.getBalance()));
        assertEquals(from.getTransactions().size(), 1);
        assertEquals(to.getTransactions().size(), 1);
        
        TransactionRecord deposit = to.getTransactions().get(0);
        TransactionRecord withdraw = from.getTransactions().get(0);
        TransactionRecord depositCopy = getTransactionRecord(
                deposit.getId(), deposit.getAccountID(), deposit.getName(),
                deposit.getDescription(), deposit.getAssociatedTransactionID(),
                deposit.getAmount(), deposit.getTransactionTime());
        TransactionRecord withdrawCopy = getTransactionRecord(
                withdraw.getId(), withdraw.getAccountID(), withdraw.getName(),
                withdraw.getDescription(), withdraw.getAssociatedTransactionID(),
                withdraw.getAmount(), withdraw.getTransactionTime());
        
        List<TransactionRecord> fromHistory = getTransactionHistoryOfAccount(from.getId());
        List<TransactionRecord> toHistory = getTransactionHistoryOfAccount(to.getId());
        deepListTransactionsEquals(fromHistory, Arrays.asList(withdrawCopy));
        deepListTransactionsEquals(toHistory, Arrays.asList(depositCopy));
    }
    
    @Test
    public void transferOkArgumentsWithHistory() throws AccountServiceException{
        Account from = getAccount(1L, 1L, "from", "from account", null);
        Account to = getAccount(2L, 1L, "to", "to account", null);
        TransactionRecord fromAccountRecord = getTransactionRecord(
                null, 1L, "oldfrom", "old transaction", null, BigDecimal.ONE, new GregorianCalendar());
        TransactionRecord toAccountRecord = getTransactionRecord(
                null, 2L, "oldto", "old transaction", null, BigDecimal.TEN, new GregorianCalendar());
        saveTransactionHistory(Arrays.asList(fromAccountRecord, toAccountRecord));
        from.addTransaction(fromAccountRecord);
        to.addTransaction(toAccountRecord);
        
        doTransferMoney(from, to, BigDecimal.TEN);
        
        assertEquals(0, BigDecimal.ONE.subtract(BigDecimal.TEN).compareTo(from.getBalance()));
        assertEquals(0, BigDecimal.TEN.add(BigDecimal.TEN).compareTo(to.getBalance()));
        assertEquals(from.getTransactions().size(), 2);
        assertEquals(to.getTransactions().size(), 2);
        
        TransactionRecord deposit = to.getTransactions().get(1);
        if(toAccountRecord.getId().equals(deposit.getId())){
            deposit = to.getTransactions().get(0);
        }
        TransactionRecord withdraw = from.getTransactions().get(1);
        if(fromAccountRecord.getId().equals(withdraw.getId())){
            withdraw = from.getTransactions().get(0);
        }
        TransactionRecord depositCopy = getTransactionRecord(
                deposit.getId(), deposit.getAccountID(), deposit.getName(),
                deposit.getDescription(), deposit.getAssociatedTransactionID(),
                deposit.getAmount(), deposit.getTransactionTime());
        TransactionRecord withdrawCopy = getTransactionRecord(
                withdraw.getId(), withdraw.getAccountID(), withdraw.getName(),
                withdraw.getDescription(), withdraw.getAssociatedTransactionID(),
                withdraw.getAmount(), withdraw.getTransactionTime());
        
        List<TransactionRecord> fromHistory = getTransactionHistoryOfAccount(from.getId());
        List<TransactionRecord> toHistory = getTransactionHistoryOfAccount(to.getId());
        deepListTransactionsEquals(fromHistory, Arrays.asList(withdrawCopy, fromAccountRecord));
        deepListTransactionsEquals(toHistory, Arrays.asList(depositCopy, toAccountRecord));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void getNamesNullArgument() throws AccountServiceException{
        doGetAccountsName(null);
        fail("null argument");
    }
    
    @Test
    public void getNamesUserWithoutAccounts() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "name", "desc", null);
        saveObject(ac);
        Map map = doGetAccountsName(2L);
        assertNotNull(map);
        assertTrue(map.isEmpty());
    }
    
    @Test
    public void getNamesEmptyDB() throws AccountServiceException{
        Map map = doGetAccountsName(1L);
        assertNotNull(map);
        assertTrue(map.isEmpty());
    }
    
    @Test
    public void getNamesOkArgument() throws AccountServiceException{
        Account ac1 = getAccount(null, 1L, "name1", "desc1", null);
        Account ac2 = getAccount(null, 1L, "name2", "desc2", null);
        saveObject(ac1);
        saveObject(ac2);
        Map<Long, String> fromDB = doGetAccountsName(1L);
        Map<Long, String> expected = new HashMap<>();
        expected.put(ac1.getId(), ac1.getName());
        expected.put(ac2.getId(), ac2.getName());
        for(Long key : fromDB.keySet()){
            String name = fromDB.get(key);
            assertEquals(name, expected.get(key));
        }
    }
    
    private void checkLoadWithProps(Account accountToBeLoaded,
            List<TransactionRecord> expectedTransactionHistory, Properties loadProps)
                throws AccountServiceException{
        Account toLoad = getAccount(accountToBeLoaded.getId(),
                accountToBeLoaded.getUsersID(), null, null, null);
        Account expected = getAccount(accountToBeLoaded.getId(),
                accountToBeLoaded.getUsersID(), null, null, expectedTransactionHistory);
        Account fromDB = doLoadTransactionHistory(toLoad, loadProps);
        deepEquals(fromDB, expected);
    }
}
