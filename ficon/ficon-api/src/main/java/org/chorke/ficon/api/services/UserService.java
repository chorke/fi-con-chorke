
package org.chorke.ficon.api.services;

import java.util.Map;
import org.chorke.ficon.api.exceptions.UserServiceException;
import org.chorke.ficon.api.objects.User;

/**
 *
 * @author Chorke
 */
public interface UserService {

    /**
     * Creates new user.
     * 
     * @param user
     * @throws UserServiceException if some error occurs
     * @throws IllegalArgumentException if user has some inapproriate fields
     */
    void createNewUser(User user) throws UserServiceException;
    
    /**
     * Updates user in DB. Updates only user's name.
     * 
     * @param user user with new values to be set
     * @throws UserServiceException if some error occurs or user is not in DB
     * @throws IllegalArgumentException if user has some inapproriate fields
     */
    void updateUser(User user) throws UserServiceException;
    
    /**
     * Deletes user from DB.
     * 
     * @param user user to be deleted
     * @throws UserServiceException if some error occurs
     * @throws IllegalArgumentException if user's ID is {@code null}
     */
    void deleteUser(User user) throws UserServiceException;
    
    /**
     * Returns user with specified ID without accounts.
     * 
     * @param id ID of user
     * @return user with ID {@code id} without accounts
     * @throws UserServiceException if some error occurs
     * @throws IllegalArgumentException if {@code id} is {@code null}
     */
    User getUser(Long id) throws UserServiceException;
    
    /**
     * Loads all accounts of user. Accounts will be without transaction history.
     * 
     * @param user user of which accounts should be loaded
     * @return user with its accounts
     * @throws UserServiceException
     * @throws IllegalArgumentException if {@code user} is {@code null} or 
     *      has some inappropriate field
     * @see AccountService#getBasicAccount(java.lang.Long) 
     */
    User loadUsersAccounts(User user)throws UserServiceException;
    
    /**
     * Returns names of all users and their ID.
     * 
     * @return map with ID as key and name of user as value
     * @throws UserServiceException id some error occurs
     */
    Map<Long, String> getUsersNames() throws UserServiceException;
    
    
}
