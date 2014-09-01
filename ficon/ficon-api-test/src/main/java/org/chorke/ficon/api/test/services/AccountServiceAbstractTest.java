
package org.chorke.ficon.api.test.services;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Properties;
import org.chorke.ficon.api.exceptions.AccountServiceException;
import org.chorke.ficon.api.objects.Account;
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
     * @see AccountService#getAccountsName(java.lang.Long) 
     */
    protected final Map<Long, String> doGetAccountsName(Long usersID)
            throws AccountServiceException{
        try{
            beforeGetAccountsName(usersID);
            Map<Long, String> ret = service.getAccountsName(usersID);
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
     * This method is executed closely before calling getAccountsName method of service.
     * 
     * @param usersID 
     */
    protected abstract void beforeGetAccountsName(Long usersID);
    /**
     * This method is executed immediately after calling getAccountsName method of service.
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
}
