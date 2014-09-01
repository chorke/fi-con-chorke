
package org.chorke.ficon.api.test.services;

import java.util.Map;
import org.chorke.ficon.api.exceptions.UserServiceException;
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
}
