
package org.chorke.ficon.api.services;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Properties;
import org.chorke.ficon.api.exceptions.AccountServiceException;
import org.chorke.ficon.api.objects.Account;

/**
 *
 * @author Chorke
 */
public interface AccountService {

    /**
     * Creates new account.
     * 
     * @param account account to be created
     * @throws AccountServiceException 
     * @throws IllegalArgumentException if {@code account} has some inappropriate field
     *      or is {@code null}
     */
    void createNewAccount(Account account) throws AccountServiceException;
    
    /**
     * Deletes account.
     * 
     * @param account account to be deleted
     * @throws AccountServiceException 
     * @throws IllegalArgumentException if {@code account} has some inappropriate field
     *      or is {@code null}
     */
    void deleteAccount(Account account) throws AccountServiceException;
    
    /**
     * Updates account.
     * 
     * @param account account to be updated
     * @throws AccountServiceException 
     * @throws IllegalArgumentException if {@code account} has some inappropriate field
     *      or is {@code null}
     */
    void updateAccount(Account account) throws AccountServiceException;
    
    /**
     * Returns account with id {@code id} without transaction history.
     * 
     * @param id id of account
     * @return account without trasnaction history
     * @throws AccountServiceException 
     * @throws IllegalArgumentException if {@code id} is {@code null}
     */
    Account getBasicAccount(Long id) throws AccountServiceException;
    
    /**
     * Returns account with id {@code id} and full transaction history.
     * 
     * @param id id of account
     * @return account with full transaction history
     * @throws AccountServiceException 
     * @throws IllegalArgumentException if {@code id} is {@code null}
     */
    Account getFullAccount(Long id) throws AccountServiceException;
    
    /**
     * Loads all transaction from account's history.
     * 
     * @param account account
     * @return account with its transaction history
     * @throws AccountServiceException 
     * @throws IllegalArgumentException if {@code account} is {@code null} or has
     *      some inappropriate field (e.g. null ID, nonempty actual transaction history)
     */
    Account loadTransactionHistory(Account account) throws AccountServiceException;
    
    /**
     * Load tarnsaction history of account {@code account} according to specified
     * properties {@code props}.
     * 
     * @param account account
     * @param props load properties
     * @return {@code account} with its transaction history
     * @throws AccountServiceException 
     * @throws IllegalArgumentException if {@code account} is {@code null} or has
     *      some inappropriate field (e.g. null ID, nonempty actual transaction history)
     */
    Account loadTransactionHistory(Account account, Properties props) throws AccountServiceException;
    
    /**
     * Transfers money from account {@code from} to account {@code to}.
     * 
     * @param from source account (withdraw)
     * @param to destination account (deposit)
     * @param ammount ammount of money (if negative source and destination accounts
     * will be swapped)
     * @throws AccountServiceException 
     * @throws IllegalArgumentException if some argument has either inappropriate
     *      field or is null.
     */
    void transferMoney(Account from, Account to, BigDecimal ammount) throws AccountServiceException;
    
    /**
     * Returns IDs and names of all accounts of user with ID {@code usersID}.
     * 
     * @param usersID ID of user
     * @return IDs and names of accounts
     * @throws AccountServiceException 
     * @throws IllegalArgumentException if {@code usersID} is {@code null}
     */
    Map<Long, String> getAccountsName(Long usersID) throws AccountServiceException;
}
