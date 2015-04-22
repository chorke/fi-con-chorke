
package org.chorke.ficon.backend.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.chorke.ficon.api.exceptions.UserServiceException;
import org.chorke.ficon.api.objects.Account;
import org.chorke.ficon.api.objects.User;
import org.chorke.ficon.api.services.UserService;
import org.chorke.ficon.backend.sql.SQLBuilderUsersService;
import org.chorke.ficon.backend.sql.SQLBuilderUsersService.StatementTypeUsers;
import org.chorke.ficon.backend.sql.metadata.UsersMetaData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Chorke
 */
public class UserServiceImpl extends BasicService implements UserService{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    
    public UserServiceImpl(DataSource dataSource) {
        super(dataSource);
    }
    
    @Override
    public void createNewUser(User user) throws UserServiceException {
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("Trying to create an user: {}.", user);
        }
        checkUser(user, true);
        Connection con = null;
        SQLBuilderUsersService builder = null;
        boolean endExpected = false;
        try{
            con = getConnection(false);
            builder = new SQLBuilderUsersService(con, StatementTypeUsers.TYPE_INSERT);
            builder.setName(user.getName());
            Long id = executeInsertAndGetID(builder);
            con.commit();
            endExpected = true;
            user.setId(id);
        } catch (SQLException ex){
            endExpected = true;
            LOGGER.error("Error while create user - rollback.", ex);
            rollback(con, "Error while creating new user.", UserServiceException.class);
            throw new UserServiceException("Error while creating new user: "
                    + ex.getMessage(), ex);
        } finally {
            if(!endExpected){
                LOGGER.error("Uncommitted transaction [new user] - rollback.");
                rollback(con, "Transaction has not been committed.", UserServiceException.class);
            }
            saveClose(builder, con);
        }
    }

    @Override
    public void updateUser(User user) throws UserServiceException {
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("Trying to update an user: {}.", user);
        }
        checkUser(user, false);
        Connection con = null;
        SQLBuilderUsersService builder = null;
        boolean endExpected = false;
        try{
            con = getConnection(false);
            User inDB = getUser(user.getId());
            if(inDB == null){
                throw new UserServiceException("User is not in DB.");
            }
            builder = new SQLBuilderUsersService(con, StatementTypeUsers.TYPE_UPDATE);
            builder.setId(user.getId());
            if(areDifferent(inDB.getName(), user.getName(), false)){
                builder.setName(user.getName());
            }
            executeUpdate(builder);
            con.commit();
            endExpected = true;
        } catch (SQLException ex){
            endExpected = true;
            LOGGER.error("Error while updating user - rollback.", ex);
            rollback(con, "Error while updating user.", UserServiceException.class);
            throw new UserServiceException("Error while updating user: "
                    + ex.getMessage(), ex);
        } finally {
            if(!endExpected){
                LOGGER.error("Uncommitted transaction [update user] - rollback.");
                rollback(con, "Transaction has not been committed.", UserServiceException.class);
            }
            saveClose(builder, con);
        }
    }

    @Override
    public void deleteUser(User user) throws UserServiceException {
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("Trying to delete an user: {}.", user);
        }
        checkUserOnNullAndId(user, false);
        Connection con = null;
        SQLBuilderUsersService builderUsers = null;
        SQLBuilderUsersService builderAccounts = null;
        SQLBuilderUsersService builderRecords = null;
        SQLBuilderUsersService builderUpdateRecords = null;
        boolean endExpected = false;
        try{
            con = getConnection(false);
            builderUsers = new SQLBuilderUsersService(con, StatementTypeUsers.TYPE_DELETE);
            builderUsers.setId(user.getId());
            builderAccounts = new SQLBuilderUsersService(con, StatementTypeUsers.TYPE_DELETE_ACCOUNT_SUBQUERY);
            builderAccounts.setId(user.getId());
            builderRecords = new SQLBuilderUsersService(con, StatementTypeUsers.TYPE_DELETE_RECORDS_SUBQUERY);
            builderRecords.setId(user.getId());
            builderUpdateRecords = new SQLBuilderUsersService(con, StatementTypeUsers.TYPE_UPDATE_RECORDS_BEFORE_DELETE);
            builderUpdateRecords.setId(user.getId());
            
            builderUpdateRecords.build().executeUpdate();
            builderRecords.build().executeUpdate();
            builderAccounts.build().executeUpdate();
            builderUsers.build().executeUpdate();
            con.commit();
            endExpected = true;
        } catch (SQLException ex){
            endExpected = true;
            LOGGER.error("Error while deleting user - rollback.", ex);
            rollback(con, "Error while deleting user and his accounts and transaction records.",
                    UserServiceException.class);
            throw new UserServiceException("Error while deleting user "
                    + "and his accounts and transaction records: "
                    + ex.getMessage(), ex);
        } finally {
            if(!endExpected){
                LOGGER.error("Uncommitted transaction [delete user] - rollback.");
                rollback(con, "Transaction has not been committed.", UserServiceException.class);
            }
            saveClose(builderUpdateRecords, builderRecords, builderAccounts, builderUsers, con);
        }
    }

    @Override
    public User getUser(Long id) throws UserServiceException {
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("Trying to get an user: {}.", id);
        }
        checkUsersID(id, false);
        try(Connection con = getConnection(true);
            SQLBuilderUsersService builder = 
                    new SQLBuilderUsersService(con, StatementTypeUsers.TYPE_SELECT)){
            builder.setId(id);
            ResultSet userSet = builder.build().executeQuery();
            User fromDB = getUserFromResultSet(userSet);
            if(userSet.next()){
                throw new UserServiceException("Multiple ID in one table.");
            }
            return fromDB;
        } catch (SQLException ex){
            LOGGER.error("Error while getting user.", ex);
            throw new UserServiceException("Error while getting user: "
                    + ex.getMessage(), ex);
        }
    }

    @Override
    public User loadUsersAccounts(User user) throws UserServiceException {
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("Trying to load user's accounts: {}.", user);
        }
        checkUserOnNullAndId(user, false);
        try(Connection con = getConnection(true);
            SQLBuilderUsersService builder = 
                    new SQLBuilderUsersService(con, StatementTypeUsers.TYPE_LOAD_ACCOUNTS)){
            builder.setId(user.getId());
            ResultSet accountSet = builder.build().executeQuery();
            Account ac;
            while((ac = getAccountFromResultSet(accountSet)) != null){
                user.addAccount(ac);
            }
            return user;
        } catch (SQLException ex){
            LOGGER.error("Error while loading user's accounts.", ex);
            throw new UserServiceException("Error while loading user's accounts: "
                    + ex.getMessage(), ex);
        }
    }

    @Override
    public Map<Long, String> getUsersNames() throws UserServiceException {
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("Trying to get names of all users.");
        }
        try(Connection con = getConnection(true);
            SQLBuilderUsersService builder = 
                    new SQLBuilderUsersService(con, StatementTypeUsers.TYPE_SELECT_USERS_NAMES)){
            Map<Long, String> users = new HashMap<>();
            ResultSet rs = builder.build().executeQuery();
            while(rs.next()){
                long id = rs.getLong(UsersMetaData.COLUMN_ID);
                if(rs.wasNull()){
                    throw new UserServiceException("User's ID is null.");
                }
                String name = rs.getString(UsersMetaData.COLUMN_NAME);
                if(name == null || name.isEmpty()){
                    throw new UserServiceException("User's name is illegal: '" + name + "'");
                }
                users.put(id, name);
            }
            return users;
        } catch (SQLException ex){
            LOGGER.error("Error while getting names of all users.", ex);
            throw new UserServiceException("Error while getting names: "
                    + ex.getMessage(), ex);
        }
    }
    
    private void checkUser(User user, boolean isNewUser){
        checkUserOnNullAndId(user, isNewUser);
        if(isNewUser && !user.getAccounts().isEmpty()){
            throw new IllegalArgumentException("New user cannot have accounts.");
        }
        checkString(user.getName(), true, true, true, "Invalid user name: " + user.getName());
    }
    
    private void checkUserOnNullAndId(User user, boolean isNew){
        checkUserOnNull(user);
        checkUsersID(user.getId(), isNew);
    }
    
    private void checkUsersID(Long id, boolean shouldBeNull){
        checkId(id, shouldBeNull, "User's ID is set.", "User's ID is null.");
    }
    
    private void checkUserOnNull(User user){
        checkOnNull(user, "User cannot be null.");
    }
}
