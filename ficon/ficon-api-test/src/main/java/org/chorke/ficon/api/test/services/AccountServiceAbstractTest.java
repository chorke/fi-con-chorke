
package org.chorke.ficon.api.test.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.chorke.ficon.api.exceptions.AccountServiceException;
import org.chorke.ficon.api.objects.Account;
import org.chorke.ficon.api.objects.TransactionRecord;
import org.chorke.ficon.api.services.AccountService;
import org.chorke.ficon.api.utils.ExchangeRateTable;
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
     * @param template
     * @throws AccountServiceException 
     * @see #beforeTransferMoney(org.chorke.ficon.api.objects.Account, org.chorke.ficon.api.objects.Account, java.math.BigDecimal) 
     * @see #afterTransferMoney(java.lang.Exception, org.chorke.ficon.api.objects.Account, org.chorke.ficon.api.objects.Account, java.math.BigDecimal) 
     * @see AccountService#transferMoney(org.chorke.ficon.api.objects.Account, org.chorke.ficon.api.objects.Account, java.math.BigDecimal) 
     */
    protected final void doTransferMoney(Account fromAccount, Account toAccount, TransactionRecord template,
            ExchangeRateTable table)
            throws AccountServiceException{
        try{
            beforeTransferMoney(fromAccount, toAccount, template, table);
            service.transferMoney(fromAccount, toAccount, template, table);
            afterTransferMoney(null, fromAccount, toAccount, template, table);
        } catch (AccountServiceException | IllegalArgumentException ex){
            afterTransferMoney(ex, fromAccount, toAccount, template, table);
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
     * @param template
     * @param table 
     */
    protected abstract void beforeTransferMoney(Account fromAccount, Account toAccount,
            TransactionRecord template, ExchangeRateTable table);
    /**
     * This method is executed immediately after calling transferMoney method of service.
     * 
     * @param thrown exception that has been thrown during operation
     * @param fromAccount
     * @param toAccount
     * @param template 
     * @param table 
     */
    protected abstract void afterTransferMoney(Exception thrown, Account fromAccount, Account toAccount,
            TransactionRecord template, ExchangeRateTable table);

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
     * Returns all transactions in DB. 
     * History is loaded independently of service, so it does not depends 
     * on any service. 
     * 
     * @return 
     */
    protected abstract List<TransactionRecord> getAllStoredTransactions();
    
    /**
     * Saves transaction history of account.
     * History is saved independently of service, so it does not depends 
     * on any service. 
     * 
     * @param records
     */
    protected abstract void saveTransactionHistory(List<TransactionRecord> records);
    
    /**
     * Updates transaction stroed in DB. Transaction is
     * updated independently of any service.
     * 
     * @param tr 
     */
    protected abstract void updateTransaction(TransactionRecord tr);
    
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
    
    @Test(expected = IllegalArgumentException.class)
    public void createIllegalNameStar() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "name1*", null, null);
        doCreateNewAccount(ac);
        fail("illegal name: non-alfa-numeric character *");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void createIllegalNameQuestionMark() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "name1?", null, null);
        doCreateNewAccount(ac);
        fail("illegal name: non-alfa-numeric character ?");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void createIllegalNamePercent() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "name1%", null, null);
        doCreateNewAccount(ac);
        fail("illegal name: non-alfa-numeric character %");
    }
    
    @Test
    public void createOKAccountNoTransactionHistory() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "okaccount", "this account should be OK?&*", null);
        doCreateNewAccount(ac);
        if(ac.getId() == null){
            fail("Id has not been set.");
        }
        Account inDB = getObject(ac.getId());
        Account acCopy = getAccount(ac.getId(), 1L, "okaccount", "this account should be OK?&*", null);
        deepEquals(acCopy, inDB, false);
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
    public void deleteNotInDB() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "name", "des", null);
        saveObject(ac);
        Account acToDelete = getAccount(ac.getId() + 1, 1L, "name", "des", null);
        doDeleteAccount(acToDelete);
        deepCollectionsAccountsEquals(getAllObjects(), Arrays.asList(ac), false);
    }
    
    @Test
    public void deleteOkArgumentWithTransactionHistrory() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "name", "des", null);
        Account ac1 = getAccount(null, 1L, "name1", "des1", null);
        Account ac2 = getAccount(null, 2L, "name2", "des2", null);
        saveObject(ac);
        saveObject(ac1);
        saveObject(ac2);
        TransactionRecord ac_tr1 = getTransactionRecord(null, ac.getId(), "name1", "des1", null,
                BigDecimal.ONE, new GregorianCalendar(2014, Calendar.JANUARY, 1));
        TransactionRecord ac_tr2 = getTransactionRecord(null, ac.getId(), "name2", "des2", null,
                BigDecimal.ONE, new GregorianCalendar(2014, Calendar.JANUARY, 2));
        TransactionRecord ac1_tr1 = getTransactionRecord(null, ac1.getId(), "name3", "des3", null,
                BigDecimal.ONE, new GregorianCalendar(2014, Calendar.JANUARY, 3));
        TransactionRecord ac1_tr2 = getTransactionRecord(null, ac1.getId(), "name4", "des4", null,
                BigDecimal.ONE, new GregorianCalendar(2014, Calendar.JANUARY, 4));
        TransactionRecord ac2_tr1 = getTransactionRecord(null, ac2.getId(), "name5", "des5", null,
                BigDecimal.ONE, new GregorianCalendar(2014, Calendar.JANUARY, 5));
        TransactionRecord ac2_tr2 = getTransactionRecord(null, ac2.getId(), "name6", "des6", null,
                BigDecimal.ONE, new GregorianCalendar(2014, Calendar.JANUARY, 6));
        
        saveTransactionHistory(Arrays.asList(ac_tr1, ac_tr2, ac1_tr1, ac1_tr2, ac2_tr1, ac2_tr2));
        ac_tr1.setAssociatedTransactionID(ac1_tr1.getId());
        ac1_tr1.setAssociatedTransactionID(ac_tr1.getId());
        ac2_tr1.setAssociatedTransactionID(ac2_tr2.getId());
        ac2_tr2.setAssociatedTransactionID(ac2_tr1.getId());
        updateTransaction(ac_tr1);
        updateTransaction(ac1_tr1);
        updateTransaction(ac2_tr1);
        updateTransaction(ac2_tr2);
        
        ac.addTransaction(ac_tr1);
        ac.addTransaction(ac_tr2);
        ac1.addTransaction(ac1_tr1);
        ac1.addTransaction(ac1_tr2);
        ac2.addTransaction(ac2_tr1);
        ac2.addTransaction(ac2_tr2);
        
        doDeleteAccount(ac);
        if(getObject(ac.getId()) != null){
            fail("object has not been deleted");
        }
        if(!getTransactionHistoryOfAccount(ac.getId()).isEmpty()){
            fail("transaction hostory has not been deleted");
        }
        
        deepCollectionsAccountsEquals(getAllObjects(), Arrays.asList(ac1, ac2), false);
        
        ac1_tr1.setAssociatedTransactionID(null);
        deepCollectionsTransactionsEquals(getAllStoredTransactions(),
                Arrays.asList(ac1_tr1, ac1_tr2, ac2_tr1, ac2_tr2));
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
    public void updateIllegalNameStar() throws AccountServiceException{
        Account ac = getAccount(1L, 1L, "name*", "desc", null);
        doUpdateAccount(ac);
        fail("illegal name: *");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void updateIllegalNameQuectionMark() throws AccountServiceException{
        Account ac = getAccount(1L, 1L, "na?me", "desc", null);
        doUpdateAccount(ac);
        fail("illegal name: *");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void updateIllegalNamePercent() throws AccountServiceException{
        Account ac = getAccount(1L, 1L, "%name", "desc", null);
        doUpdateAccount(ac);
        fail("illegal name: %");
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
        Account acCopy = getAccount(ac.getId(), 1L, "nameafter", "description before update", null);
        deepEquals(acCopy, getObject(ac.getId()), false);
    }
    
    @Test
    public void updateOkArgumentDescriptionChanged() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "namebefore", "description before update", null);
        saveObject(ac);
        ac.setDescription("desription after update?&*");
        doUpdateAccount(ac);
        Account acCopy = getAccount(ac.getId(), 1L, "namebefore", "desription after update?&*", null);
        deepEquals(acCopy, getObject(ac.getId()), false);
    }
    
    @Test
    public void updateOkArgumentDescriptionChangedToEmpty() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "namebefore", "description before update", null);
        saveObject(ac);
        ac.setDescription("");
        doUpdateAccount(ac);
        Account acCopy = getAccount(ac.getId(), 1L, "namebefore", "", null);
        deepEquals(acCopy, getObject(ac.getId()), false);
    }
    
    @Test
    public void updateOkArgumentDescriptionChangedToNull() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "namebefore", "description before update", null);
        saveObject(ac);
        ac.setDescription(null);
        doUpdateAccount(ac);
        Account acCopy = getAccount(ac.getId(), 1L, "namebefore", null, null);
        deepEquals(acCopy, getObject(ac.getId()), false);
    }
    
    @Test
    public void updateOkArgumentNameAndDescriptionChanged() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "namebefore", "description before update", null);
        saveObject(ac);
        ac.setName("nameafter");
        ac.setDescription("desription after update");
        doUpdateAccount(ac);
        Account acCopy = getAccount(ac.getId(), 1L, "nameafter", "desription after update", null);
        deepEquals(acCopy, getObject(ac.getId()), false);
    }
    
    @Test(expected = AccountServiceException.class)
    public void updateOkArgumentAccountNotInDB() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "namebefore", "description before update", null);
        saveObject(ac);
        Account acToUpdate = getAccount(ac.getId() + 1, 1L, "nameafter", "description after update", null);
        try {
            doUpdateAccount(acToUpdate);
            fail("account not in DB");
        } catch (AccountServiceException ex){
            Account acClone = getAccount(ac.getId(), 1L, "namebefore", "description before update", null);
            deepCollectionsAccountsEquals(Arrays.asList(acClone), getAllObjects(), false);
            throw ex;
        }
    }
    
    @Test(expected = AccountServiceException.class)
    public void updateOkArgumentUsersIDChanged() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "namebefore", "description before update", null);
        saveObject(ac);
        Account acToUpdate = getAccount(ac.getId(), ac.getUsersID() + 1,
                "nameafter", "description after update", null);
        try {
            doUpdateAccount(acToUpdate);
            fail("user's ID has been changed");
        } catch (AccountServiceException ex){
            Account acClone = getAccount(ac.getId(), 1L, "namebefore", "description before update", null);
            deepCollectionsAccountsEquals(Arrays.asList(acClone), getAllObjects(), false);
            throw ex;
        }
    }
    
    @Test(expected = AccountServiceException.class)
    public void updateOkArgumentCurrencyChanged() throws AccountServiceException{
        Currency eur = Currency.getInstance("EUR");
        Currency usd = Currency.getInstance("USD");
        Account ac = getAccount(null, 1L, eur, "namebefore", "description before update", null);
        saveObject(ac);
        Account acToUpdate = getAccount(ac.getId(), ac.getUsersID(), usd,
                "nameafter", "description after update", null);
        try {
            doUpdateAccount(acToUpdate);
            fail("currency has been changed");
        } catch (AccountServiceException ex){
            Account acClone = getAccount(ac.getId(), 1L, eur, "namebefore", "description before update", null);
            deepCollectionsAccountsEquals(Arrays.asList(acClone), getAllObjects(), false);
            throw ex;
        }
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
        deepEquals(fromDB, ac, false);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void getFullNullArgument() throws AccountServiceException{
        doGetFullAccount(null);
        fail("null argument");
    }
    
    @Test
    public void getFullEmptyDB() throws AccountServiceException{
        assertNull(doGetFullAccount(1L));
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
        Account fromDB = doGetFullAccount(ac.getId() + 1);
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
        Account fromDB = doGetFullAccount(ac.getId());
        deepEquals(fromDB, ac, true);
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
        deepEquals(acCopy, fromDB, true);
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
        Account ac2 = getAccount(ac.getId() + 1, 2L, "name2", "description two", null);
        Account ac2Copy = getAccount(ac.getId() + 1, 2L, "name2", "description two", null);
        Account fromDB = doLoadTransactionHistory(ac2);
        deepEquals(fromDB, ac2Copy, true);
    }
    
    @Test
    public void loadSimpleNoTransactionHistory() throws AccountServiceException{
        Account ac = getAccount(null, 1L, "name", "description", null);
        saveObject(ac);
        Account acShallowCopy = getAccount(ac.getId(), 1L, null, null, null);
        Account acShallowCopyToLoad = getAccount(ac.getId(), 1L, null, null, null);
        Account fromDB = doLoadTransactionHistory(acShallowCopyToLoad);
        //no field should be changed, even with null name
        deepEquals(fromDB, acShallowCopy, true);
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
        deepEquals(fromDB, acShallowCopy, true);
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
        deepEquals(acCopy, fromDB, true);
        //empty props
        fromDB = doLoadTransactionHistory(acCopy, new Properties());
        deepEquals(acCopy, fromDB, true);
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
        Account ac2 = getAccount(ac.getId() + 1, 2L, "name2", "description two", null);
        Account ac2Copy = getAccount(ac.getId() + 1, 2L, "name2", "description two", null);
        //null props
        Account fromDB = doLoadTransactionHistory(ac2, null);
        deepEquals(fromDB, ac2Copy, true);
        //empty props
        fromDB = doLoadTransactionHistory(ac2, new Properties());
        deepEquals(fromDB, ac2Copy, true);
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
        deepEquals(fromDB, acShallowCopy, true);
        //empty props
        fromDB = doLoadTransactionHistory(acShallowCopyToLoad, new Properties());
        deepEquals(fromDB, acShallowCopy, true);
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
        //null props
        Account acShallowCopyToLoad = getAccount(ac.getId(), 1L, null, null, null);
        Account fromDB = doLoadTransactionHistory(acShallowCopyToLoad, null);
        //no field should be changed (except transaction history), even with null name
        deepEquals(fromDB, acShallowCopy, true);
        //empty props
        acShallowCopyToLoad = getAccount(ac.getId(), 1L, null, null, null);
        fromDB = doLoadTransactionHistory(acShallowCopyToLoad, new Properties());
        deepEquals(fromDB, acShallowCopy, true);
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
                        new GregorianCalendar(2014, Calendar.JULY, 2, 4, 30))
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
        checkLoadWithProps(ac, Arrays.asList(trHistory.get(0), trHistory.get(1)), prop);
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
    
    private TransactionRecord templateAmountOne = getTransactionRecord(null, 1L, "transactionOne",
            "transfering money: amount 1€", null, BigDecimal.ONE, new GregorianCalendar());
    private TransactionRecord templateAmountTen = getTransactionRecord(null, 1L, "transactionTen",
            "transfering money: amount 10€", null, BigDecimal.TEN, new GregorianCalendar());
    
    @Test(expected = IllegalArgumentException.class)
    public void transferFirstArgumentNull() throws AccountServiceException{
        Account ac = getAccount(1L, 1L, "name", "description", null);
        doTransferMoney(null, ac, templateAmountOne, new ExchangeRateTable());
        fail("null first argument");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void transferSecondArgumentNull() throws AccountServiceException{
        Account ac = getAccount(1L, 1L, "name", "description", null);
        doTransferMoney(ac, null, templateAmountOne, new ExchangeRateTable());
        fail("null second argument");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void transferThirdArgumentNull() throws AccountServiceException{
        Account from = getAccount(1L, 1L, "from", "from account", null);
        Account to = getAccount(2L, 1L, "to", "to account", null);
        doTransferMoney(from, to, null, new ExchangeRateTable());
        fail("null third argument argument");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void transferForthArgumentNull() throws AccountServiceException{
        Account from = getAccount(1L, 1L, "from", "from account", null);
        Account to = getAccount(2L, 1L, "to", "to account", null);
        doTransferMoney(from, to, templateAmountOne, null);
        fail("null third argument argument");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void transferFromAndToHaveSameID() throws AccountServiceException{
        Account from = getAccount(1L, 1L, "from", "from account", null);
        Account to = getAccount(1L, 1L, "to", "to account", null);
        doTransferMoney(from, to, templateAmountOne, new ExchangeRateTable());
        fail("from and to have same ID");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void transferZeroAmount() throws AccountServiceException{
        Account from = getAccount(1L, 1L, "from", "from account", null);
        Account to = getAccount(2L, 1L, "to", "to account", null);
        TransactionRecord templateAmountZero = getTransactionRecord(null, 1L, "transactionZero",
            "transfering money: amount 0€", null, BigDecimal.ZERO, new GregorianCalendar());
        doTransferMoney(from, to, templateAmountZero, new ExchangeRateTable());
        fail("nothing to transfer");
    }
    
    @Test
    public void transferOkArgumentsEmptyHistory() throws AccountServiceException{
        Currency eur = Currency.getInstance("EUR");
        Currency usd = Currency.getInstance("USD");
        Account from = getAccount(null, 1L, eur, "from", "from account", null);
        Account to = getAccount(null, 1L, usd, "to", "to account", null);
        saveObject(from);
        saveObject(to);
        
        ExchangeRateTable table = new ExchangeRateTable();
        BigDecimal rate = new BigDecimal("1.34");
        table.addExchangeRate(eur, usd, rate);
        doTransferMoney(from, to, templateAmountTen, table);
        
        assertEquals(0, BigDecimal.TEN.negate().compareTo(from.getBalance()));
        assertEquals(0, table.exchange(eur, usd, BigDecimal.TEN).compareTo(to.getBalance()));
        assertEquals(from.getTransactions().size(), 1);
        assertEquals(to.getTransactions().size(), 1);
        
        TransactionRecord deposit = to.getTransactions().get(0);
        TransactionRecord withdraw = from.getTransactions().get(0);
        TransactionRecord depositCopy = getTransactionRecord(
                deposit.getId(), to.getId(), templateAmountTen.getName(),
                templateAmountTen.getDescription(), withdraw.getId(),
                table.exchange(eur, usd, templateAmountTen.getAmount()),
                templateAmountTen.getTransactionTime());
        TransactionRecord withdrawCopy = getTransactionRecord(
                withdraw.getId(), from.getId(), templateAmountTen.getName(),
                templateAmountTen.getDescription(), deposit.getId(),
                templateAmountTen.getAmount().negate(),
                templateAmountTen.getTransactionTime());
        
        List<TransactionRecord> fromHistory = getTransactionHistoryOfAccount(from.getId());
        List<TransactionRecord> toHistory = getTransactionHistoryOfAccount(to.getId());
        deepCollectionsTransactionsEquals(fromHistory, Arrays.asList(withdrawCopy));
        deepCollectionsTransactionsEquals(toHistory, Arrays.asList(depositCopy));
        //TODO - check transaction;
    }
    
    @Test
    public void transferOkArgumentsWithHistory() throws AccountServiceException{
        Currency eur = Currency.getInstance("EUR");
        Currency usd = Currency.getInstance("USD");
        Account from = getAccount(null, 1L, eur, "from", "from account", null);
        Account to = getAccount(null, 1L, usd, "to", "to account", null);
        
        saveObject(from);
        saveObject(to);
        
        ExchangeRateTable table = new ExchangeRateTable();
        BigDecimal rate = new BigDecimal("1.34");
        table.addExchangeRate(eur, usd, rate);
        
        TransactionRecord fromAccountRecord = getTransactionRecord(
                null, from.getId(), "oldfrom", "old transaction", null, BigDecimal.ONE, new GregorianCalendar());
        TransactionRecord toAccountRecord = getTransactionRecord(
                null, to.getId(), "oldto", "old transaction", null, BigDecimal.TEN, new GregorianCalendar());
        saveTransactionHistory(Arrays.asList(fromAccountRecord, toAccountRecord));
        from.addTransaction(fromAccountRecord);
        to.addTransaction(toAccountRecord);
        
        doTransferMoney(from, to, templateAmountTen, table);
        
        assertEquals(0, BigDecimal.ONE.subtract(BigDecimal.TEN).compareTo(from.getBalance()));
        assertEquals(0, BigDecimal.TEN.add(table.exchange(eur, usd, BigDecimal.TEN)).compareTo(to.getBalance()));
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
                deposit.getId(), to.getId(), templateAmountTen.getName(),
                templateAmountTen.getDescription(), withdraw.getId(),
                table.exchange(eur, usd, templateAmountTen.getAmount()),
                templateAmountTen.getTransactionTime());
        TransactionRecord withdrawCopy = getTransactionRecord(
                withdraw.getId(), from.getId(), templateAmountTen.getName(),
                templateAmountTen.getDescription(), deposit.getId(),
                templateAmountTen.getAmount().negate(), templateAmountTen.getTransactionTime());
        
        List<TransactionRecord> fromHistory = getTransactionHistoryOfAccount(from.getId());
        List<TransactionRecord> toHistory = getTransactionHistoryOfAccount(to.getId());
        deepCollectionsTransactionsEquals(fromHistory, Arrays.asList(withdrawCopy, fromAccountRecord));
        deepCollectionsTransactionsEquals(toHistory, Arrays.asList(depositCopy, toAccountRecord));
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
        assertNotNull("map should not be empty", map);
        assertTrue("map should be empty", map.isEmpty());
    }
    
    @Test
    public void getNamesOkArgument() throws AccountServiceException{
        Account ac1 = getAccount(null, 1L, "name1", "desc1", null);
        Account ac2 = getAccount(null, 1L, "name2", "desc2", null);
        Account ac3 = getAccount(null, 2L, "name3", "desc3", null);
        saveObject(ac1);
        saveObject(ac2);
        saveObject(ac3);
        Map<Long, String> fromDB = doGetAccountsName(1L);
        Map<Long, String> expected = new HashMap<>();
        expected.put(ac1.getId(), ac1.getName());
        expected.put(ac2.getId(), ac2.getName());
        deepMapEquals(fromDB, expected);
        
        deleteObject(ac1);
        expected.remove(ac1.getId());
        fromDB = doGetAccountsName(1L);
        deepMapEquals(fromDB, expected);
    }
    
    private void checkLoadWithProps(Account accountToBeLoaded,
            List<TransactionRecord> expectedTransactionHistory, Properties loadProps)
                throws AccountServiceException{
        Account toLoad = getAccount(accountToBeLoaded.getId(),
                accountToBeLoaded.getUsersID(), null, null, null);
        Account expected = getAccount(accountToBeLoaded.getId(),
                accountToBeLoaded.getUsersID(), null, null, expectedTransactionHistory);
        Account fromDB = doLoadTransactionHistory(toLoad, loadProps);
        deepEquals(fromDB, expected, true);
    }
}
