
package org.chorke.ficon.api.objects;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Registered user of application.
 * 
 * @author Chorke
 */
public class User {
    
    /**
     * User's ID.
     */
    private Long id;
    
    /**
     * User's name.
     */
    private String name;
    
    /**
     * Set of user's accounts.
     */
    private Set<Account> accounts;

    /**
     * Creates new {@link User} instance.
     */
    public User() {
        accounts = new HashSet<>();
    }

    /**
     * Returns user's ID.
     * 
     * @return user's ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets user's ID. ID can be set only once.
     * 
     * @param id id to be set
     * @throws IllegalStateException if ID has been already set
     */
    public void setId(long id) {
        if(this.id != null){
            throw new IllegalStateException("Id already set");
        }
        this.id = new Long(id);
    }

    /**
     * Sets user's name.
     * 
     * @param name name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns user's name.
     * 
     * @return name of user
     */
    public String getName() {
        return name;
    }

    /**
     * Returns set of user's accounts.
     * 
     * @return user's accounts.
     */
    public Set<Account> getAccounts() {
        return Collections.unmodifiableSet(accounts);
    }
    
    /**
     * Add new {@link Account} for user.
     * 
     * @param account account to be added
     * @throws IllegalArgumentException if user's ID in account is different
     *      then ID of this user
     */
    public void addAccount(Account account){
        if(account.getUsersID() == null || id == null
                || account.getUsersID().longValue() != id.longValue()){
            throw new IllegalArgumentException("Account " + account + " does not "
                    + "belong to this user (user's ID: " + id + 
                    ", user's ID in account: " + account.getUsersID() + ").");
        }
        accounts.add(account);
    }
    
    /**
     * Removes {@link Account} from user.
     * 
     * @param account account to be removed
     */
    public void removeAccount(Account account){
        accounts.remove(account);
    }
    
    /**
     * Clears account records for this user (e.g. user signs out).
     */
    public void accountsListNoMoreNeeded(){
        for(Account ac : accounts){
            ac.transactionHistoryNoMoreNeeded();
        }
        accounts.clear();
    }
}