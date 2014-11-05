
package org.chorke.ficon.backend.services;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.sql.DataSource;
import org.chorke.ficon.api.exceptions.AccountServiceException;
import org.chorke.ficon.api.objects.Account;
import org.chorke.ficon.api.objects.TransactionRecord;
import org.chorke.ficon.api.services.AccountService;
import org.chorke.ficon.backend.sql.SQLBuilderAccountsService;
import org.chorke.ficon.backend.sql.SQLBuilderAccountsService.StatementTypeAccounts;
import org.chorke.ficon.backend.sql.SQLBuilderTransactionRecordsService;
import org.chorke.ficon.backend.sql.SQLBuilderTransactionRecordsService.StatementTypeTransactionRecrod;
import org.chorke.ficon.backend.sql.metadata.AccountsMetaData;

/**
 *
 * @author Chorke
 */
public class AccountServiceImpl extends BasicService implements AccountService{

    public AccountServiceImpl(DataSource dataSource) {
        super(dataSource);
    }
    @Override
    public void createNewAccount(Account account) throws AccountServiceException {
        checkAccount(account, true);
        Connection con = null;
        SQLBuilderAccountsService builder = null;
        boolean endExpected = false;
        try{
            con = getConnection(false);
            builder = new SQLBuilderAccountsService(con, StatementTypeAccounts.TYPE_INSERT);
            builder.setDescription(account.getDescription());
            builder.setName(account.getName());
            builder.setUserID(account.getUsersID());
            Long id = executeInsertAndGetID(builder);
            con.commit();
            endExpected = true;
            account.setId(id);
        } catch (SQLException ex){
            endExpected = true;
            rollback(con, "Error rollbackAccountwhile creating new account.", AccountServiceException.class);
            throw new AccountServiceException("Error while creating new account: " 
                    + account, ex);
        } finally {
            if(!endExpected){
                rollback(con, "Transaction has not been commited.", AccountServiceException.class);
            }
            saveClose(builder, con);
        }
    }

    @Override
    public void deleteAccount(Account account) throws AccountServiceException {
        checkAccountOnNullAndId(account, false);
        Connection con = null;
        SQLBuilderAccountsService builderDeleteAccounts = null;
        SQLBuilderAccountsService builderUpdateRecords = null;
        SQLBuilderAccountsService builderDeleteRecords = null;
        boolean endExpected = false;
        try{
            con = getConnection(false);
            builderUpdateRecords = new SQLBuilderAccountsService(con, StatementTypeAccounts.TYPE_UPDATE_RECORDS_BEFORE_DELETE);
            builderDeleteRecords = new SQLBuilderAccountsService(con, StatementTypeAccounts.TYPE_DELETE_RECORDS_SUB_QUERY);
            builderDeleteAccounts = new SQLBuilderAccountsService(con, StatementTypeAccounts.TYPE_DELETE);
            builderUpdateRecords.setId(account.getId());
            builderDeleteRecords.setId(account.getId());
            builderDeleteAccounts.setId(account.getId());
            
            builderUpdateRecords.build().executeUpdate();
            builderDeleteRecords.build().executeUpdate();
            builderDeleteAccounts.build().executeUpdate();
            con.commit();
            endExpected = true;
        } catch (SQLException ex){
            endExpected = true;
            rollback(con, "Error while deleting account.", AccountServiceException.class);
            throw new AccountServiceException("Error while deleting account: " 
                    + account, ex);
        } finally {
            if(!endExpected){
                rollback(con, "Transaction has not been commited.", AccountServiceException.class);
            }
            saveClose(builderUpdateRecords, builderDeleteRecords, builderDeleteAccounts, con);
        }
    }

    @Override
    public void updateAccount(Account account) throws AccountServiceException {
        checkAccount(account, false);
        Connection con = null;
        SQLBuilderAccountsService builder = null;
        boolean endExpected = false;
        try{
            con = getConnection(false);
            Account fromDB = getBasicAccount(account.getId());
            if(fromDB == null){
                throw new AccountServiceException("Account is not in DB.");
            }
            if(areDifferent(account.getUsersID(), fromDB.getUsersID(), true)){
                throw new AccountServiceException("Account's userID has been changed.");
            }
            builder = new SQLBuilderAccountsService(con, StatementTypeAccounts.TYPE_UPDATE);
            if(areDifferent(account.getDescription(), fromDB.getDescription(), false)){
                builder.setDescription(account.getDescription());
            }
            if(areDifferent(account.getName(), fromDB.getName(), false)){
                builder.setName(account.getName());
            }
            builder.setId(account.getId());
            PreparedStatement ps;
            try{
                ps = builder.build();
            } catch (IllegalStateException ex){
                endExpected = true;
                return;
            }
            int updCount = ps.executeUpdate();
            if(updCount != 1){
                throw new AccountServiceException("Expected update count is 1, but was " + updCount);
            }
            con.commit();
            endExpected = true;
        } catch (SQLException ex){
            endExpected = true;
            rollback(con, "Error while updating account.", AccountServiceException.class);
            throw new AccountServiceException("Error while updating account: "
                    + account, ex);
        } finally {
            if(!endExpected){
                rollback(con, "Transaction has not been committed.", AccountServiceException.class);
            }
            saveClose(builder, con);
        }
    }

    @Override
    public Account getBasicAccount(Long id) throws AccountServiceException {
        checkAccountID(id, false);
        try(Connection con = getConnection(true);
                SQLBuilderAccountsService builder = 
                        new SQLBuilderAccountsService(con, StatementTypeAccounts.TYPE_SELECT)){
            builder.setId(id);
            ResultSet rs = builder.build().executeQuery();
            Account ac = getAccountFromResultSet(rs);
            if(rs.next()){
                throw new AccountServiceException("Multiple key in DB.");
            }
            return ac;
        } catch (SQLException ex){
            throw new AccountServiceException("Error while getting account with id: " + id, ex);
        }
    }

    @Override
    public Account getFullAccount(Long id) throws AccountServiceException {
        Account ac = getBasicAccount(id);
        if(ac == null){
            return null;
        }
        return loadTransactionHistory(ac);
    }

    @Override
    public Account loadTransactionHistory(Account account) throws AccountServiceException {
        return loadTransactionHistory(account, null);
    }

    @Override
    public Account loadTransactionHistory(Account account, Properties props) throws AccountServiceException {
        checkAccountOnNullAndId(account, false);
        if(!account.getTransactions().isEmpty()){
            throw new IllegalArgumentException("Account's history already loaded.");
        }
        try(Connection con = getConnection(true);
                SQLBuilderAccountsService builder = 
                        new SQLBuilderAccountsService(con, StatementTypeAccounts.TYPE_LOAD_HISTORY)){
            builder.setId(account.getId());
            builder.setLoadProperties(props);
            ResultSet rs = builder.build().executeQuery();
            TransactionRecord rec;
            while((rec = getRecordFromResultSet(rs)) != null){
                account.addTransaction(rec);
            }
            return account;
        } catch (SQLException ex){
            throw new AccountServiceException("Error while loading transaction history.", ex);
        }
    }

    @Override
    public void transferMoney(Account from, Account to, TransactionRecord template) throws AccountServiceException {
        checkAccountOnNullAndId(from, false);
        checkAccountOnNullAndId(to, false);
        checkOnNull(template, "Template cannot be null.");
        checkString(template.getName(), true, true, true, "Name cannot be null.");
        checkOnNull(template.getAmount(), "Amount cannot be null.");
        if(!areDifferent(template.getAmount(), BigDecimal.ZERO, true)){
            throw new IllegalArgumentException("Nothing to transfer. Ammount is zero.");
        }
        checkOnNull(template.getTransactionTime(), "Transaction time cannot be null.");
        if(!areDifferent(to.getId(), from.getId(), true)){
            throw new IllegalArgumentException("Nothing to transfer. From and to account have same ID.");
        }
        
        Connection con = null;
        SQLBuilderTransactionRecordsService builderFromInsert = null;
        SQLBuilderTransactionRecordsService builderToInsert = null;
        SQLBuilderTransactionRecordsService builderFromUpdate = null;
        SQLBuilderTransactionRecordsService builderToUpdate = null;
        SQLBuilderTransactionRecordsService builderFromSelect = null;
        SQLBuilderTransactionRecordsService builderToSelect = null;
        boolean endExpected = false;
        try{
            con = getConnection(false);
            builderFromInsert =
                    new SQLBuilderTransactionRecordsService(con, StatementTypeTransactionRecrod.TYPE_INSERT);
            builderToInsert =
                    new SQLBuilderTransactionRecordsService(con, StatementTypeTransactionRecrod.TYPE_INSERT);
            builderFromUpdate =
                    new SQLBuilderTransactionRecordsService(con, StatementTypeTransactionRecrod.TYPE_UPDATE);
            builderToUpdate =
                    new SQLBuilderTransactionRecordsService(con, StatementTypeTransactionRecrod.TYPE_UPDATE);
            builderFromInsert.setAccountID(from.getId());
            builderFromInsert.setAmount(template.getAmount().negate());
            builderFromInsert.setDesctiption(template.getDescription());
            builderFromInsert.setName(template.getName());
            builderFromInsert.setTransactionTime(template.getTransactionTime());
            builderFromInsert.setAssociatedTransactionID(null);
            
            builderToInsert.setAccountID(to.getId());
            builderToInsert.setAmount(template.getAmount());
            builderToInsert.setDesctiption(template.getDescription());
            builderToInsert.setName(template.getName());
            builderToInsert.setTransactionTime(template.getTransactionTime());
            builderToInsert.setAssociatedTransactionID(null);
            
            Long recordFromId = executeInsertAndGetID(builderFromInsert);
            Long recordToId = executeInsertAndGetID(builderToInsert);
            
            builderFromUpdate.setAssociatedTransactionID(recordToId);
            builderFromUpdate.setId(recordFromId);
            
            builderToUpdate.setAssociatedTransactionID(recordFromId);
            builderToUpdate.setId(recordToId);
            
            executeUpdate(builderToUpdate);
            executeUpdate(builderFromUpdate);
            
            builderFromSelect = new SQLBuilderTransactionRecordsService(con,
                    StatementTypeTransactionRecrod.TYPE_SELECT);
            builderToSelect = new SQLBuilderTransactionRecordsService(con,
                    StatementTypeTransactionRecrod.TYPE_SELECT);
            builderFromSelect.setId(recordFromId);
            builderToSelect.setId(recordToId);
            TransactionRecord fromRec = getRecordFromResultSet(builderFromSelect.build().executeQuery());
            TransactionRecord toRec = getRecordFromResultSet(builderToSelect.build().executeQuery());
            if(fromRec == null || toRec == null){
                throw new AccountServiceException("Some record has not been inserted.");
            }
            con.commit();
            endExpected = true;
            from.addTransaction(fromRec);
            to.addTransaction(toRec);
        } catch (SQLException ex){
            endExpected = true;
            rollback(con, "Error while transferring money", AccountServiceException.class);
            throw new AccountServiceException("Error while transfering money: "
                    + "from [" + from + "] to [" + to + "] transaction ["
                    + template + "]", ex);
        } finally {
            if(!endExpected){
                rollback(con, "Transaction has not been committed.", AccountServiceException.class);
            }
            saveClose(builderFromSelect, builderToSelect, 
                    builderFromInsert, builderFromUpdate,
                    builderToInsert, builderToUpdate,
                    con);
        }
    }

    @Override
    public Map<Long, String> getAccountsNames(Long usersID) throws AccountServiceException {
        checkOnNull(usersID, "User's ID cannot be null.");
        try(Connection con = getConnection(true);
            SQLBuilderAccountsService builder =
                    new SQLBuilderAccountsService(con, StatementTypeAccounts.TYPE_SELECT_NAMES)){
            builder.setUserID(usersID);
            ResultSet rs = builder.build().executeQuery();
            Map<Long, String> names = new HashMap<>();
            while(rs.next()){
                long id = rs.getLong(AccountsMetaData.COLUMN_ID);
                if(rs.wasNull()){
                    throw new AccountServiceException("Account's ID is null.");
                }
                String name = rs.getString(AccountsMetaData.COLUMN_NAME);
                if(name == null || name.isEmpty()){
                    throw new AccountServiceException("Account's name is illegal: '" + name + "'");
                }
                names.put(id, name);
            }
            return names;
        } catch (SQLException ex){
            throw new AccountServiceException("Error while getting accounts.", ex);
        }
    }
    
    private void checkAccount(Account account, boolean isNewAccount){
        checkAccountOnNullAndId(account, isNewAccount);
        if(isNewAccount && !account.getTransactions().isEmpty()){
            throw new IllegalArgumentException("New account cannot have records.");
        }
        checkString(account.getName(), true, true, true, "Invalid account name: " + account.getName());
    }
    
    private void checkAccountOnNullAndId(Account account, boolean isNew){
        checkAccountOnNull(account);
        checkAccountID(account.getId(), isNew);
    }
    
    private void checkAccountID(Long id, boolean shouldBeNull){
        checkId(id, shouldBeNull, "Account's ID is set.", "Account's ID is null.");
    }
    
    private void checkAccountOnNull(Account account){
        checkOnNull(account, "Account cannot be null.");
    }
}
