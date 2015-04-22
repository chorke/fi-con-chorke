package org.chorke.ficon.backend.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Collection;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import javax.sql.DataSource;
import org.apache.derby.jdbc.EmbeddedDataSource;
import org.chorke.ficon.api.objects.Account;
import org.chorke.ficon.api.objects.TransactionRecord;
import org.chorke.ficon.api.objects.User;
import org.chorke.ficon.backend.sql.metadata.AccountsMetaData;
import org.chorke.ficon.backend.sql.metadata.TransactionRecordsMetaData;
import org.chorke.ficon.backend.sql.metadata.UsersMetaData;

/**
 *
 * @author Chorke
 */
public class TestUtils {

    private static final String TEST_DB_NAME = "memory:testDB";
    
    private TestUtils() {
        //private constructor
    }
    private static Connection connection;

    static boolean dropDatabase() {
        System.out.println("Dropping database.");
        closeConnection(connection);
        try {
            connection = DriverManager.getConnection("jdbc:derby:" + TEST_DB_NAME + ";drop=true");
        } catch (SQLException ex) {
            if (!"08006".equals(ex.getSQLState())) {
                System.out.println("Error while dropping testing in-memory database.");
                ex.printStackTrace(System.out);
                return false;
            }
        }
        closeConnection(connection);
        connection = null;
        System.out.println("Database has been dropped.");
        return true;
    }

    private static void closeConnection(Connection con){
        try{
            con.close();
        } catch (SQLException ex){
            //ignore
        }
    }
    
    static boolean initDatabase() {
        System.out.println("Initializing database.");
        try {
            connection = DriverManager.getConnection("jdbc:derby:" + TEST_DB_NAME + ";create=true");
        } catch (SQLException ex) {
            System.out.println("Unable to create testing in-memory database.");
            ex.printStackTrace(System.out);
            return false;
        }
        System.out.println("Database has been initialized.");
        System.out.println("Creating tables.");
        try (Statement st = connection.createStatement()) {
            st.addBatch("CREATE TABLE " + UsersMetaData.TABLE_NAME + "("
                    + UsersMetaData.COLUMN_ID + " integer GENERATED ALWAYS AS IDENTITY,"
                    + UsersMetaData.COLUMN_NAME + " varchar(50) NOT NULL,"
                    + "PRIMARY KEY (" + UsersMetaData.COLUMN_ID + "))");
            st.addBatch("CREATE TABLE " + AccountsMetaData.TABLE_NAME + "("
                    + AccountsMetaData.COLUMN_ID + " integer GENERATED ALWAYS AS IDENTITY,"
                    + AccountsMetaData.COLUMN_USER_ID + " integer NOT NULL,"
                    + AccountsMetaData.COLUMN_CURRENCY + " varchar(3) NOT NULL,"
                    + AccountsMetaData.COLUMN_NAME + " varchar(50) NOT NULL,"
                    + AccountsMetaData.COLUMN_DESCRIPTION + " varchar(100),"
                    + "PRIMARY KEY (" + AccountsMetaData.COLUMN_ID + "))");
            st.addBatch("CREATE TABLE " + TransactionRecordsMetaData.TABLE_NAME + "("
                    + TransactionRecordsMetaData.COLUMN_ID + " integer GENERATED ALWAYS AS IDENTITY,"
                    + TransactionRecordsMetaData.COLUMN_ACCOUNT_ID + " integer NOT NULL,"
                    + TransactionRecordsMetaData.COLUMN_NAME + " varchar(50) NOT NULL,"
                    + TransactionRecordsMetaData.COLUMN_DESCRIPTION + " varchar(100),"
                    + TransactionRecordsMetaData.COLUMN_ASSOCIATED_TRANSACTION_ID + " integer,"
                    + TransactionRecordsMetaData.COLUMN_AMOUNT + " numeric(15,4) NOT NULL,"
                    + TransactionRecordsMetaData.COLUMN_TRANSACTION_TIME + " timestamp NOT NULL,"
                    + "PRIMARY KEY (" + TransactionRecordsMetaData.COLUMN_ID + "))");
            st.executeBatch();
        } catch (SQLException ex) {
            System.out.println("Error while creating tables.");
            ex.printStackTrace(System.out);
            return false;
        }
        System.out.println("Tables have been created successully");
        return true;
    }

    static boolean clearTables(){
        System.out.println("Clearing tables.");
        try(Statement st = connection.createStatement()){
            st.addBatch("DELETE FROM " + TransactionRecordsMetaData.TABLE_NAME);
            st.addBatch("DELETE FROM " + AccountsMetaData.TABLE_NAME);
            st.addBatch("DELETE FROM " + UsersMetaData.TABLE_NAME);
            st.executeBatch();
        } catch (SQLException ex){
            System.out.println("Error while clearing tables.");
            ex.printStackTrace(System.out);
            return false;
        }
        System.out.println("Clearing successful.");
        return true;
    }
    
    static DataSource getDataSource() {
        EmbeddedDataSource eds = new EmbeddedDataSource();
        eds.setDatabaseName(TEST_DB_NAME);
        return eds;
    }
    
    static void save(Account account) throws ObjectManipulationException{
        if(account == null){
            return;
        }
        String sql = "INSERT INTO " + AccountsMetaData.TABLE_NAME
                + " (" + AccountsMetaData.INSTANCE.getColumnNameAtPositionInInsert(1, true) + ","
                + AccountsMetaData.INSTANCE.getColumnNameAtPositionInInsert(2, true) + ","
                + AccountsMetaData.INSTANCE.getColumnNameAtPositionInInsert(3, true) + ","
                + AccountsMetaData.INSTANCE.getColumnNameAtPositionInInsert(4, true)
                + ") VALUES (?,?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setLong(AccountsMetaData.INSTANCE.getInsertColumnMapping(AccountsMetaData.COLUMN_USER_ID, true),
                    account.getUsersID());
            ps.setString(AccountsMetaData.INSTANCE.getInsertColumnMapping(AccountsMetaData.COLUMN_NAME, true),
                    account.getName());
            ps.setString(AccountsMetaData.INSTANCE.getInsertColumnMapping(AccountsMetaData.COLUMN_DESCRIPTION, true),
                    account.getDescription());
            ps.setString(AccountsMetaData.INSTANCE.getInsertColumnMapping(AccountsMetaData.COLUMN_CURRENCY, true),
                    account.getCurrency().getCurrencyCode());
            int updates = ps.executeUpdate();
            if(updates < 1){
                throw new ObjectManipulationException("Account has not been saved: " + account);
            } else if(updates != 1){
                throw new ObjectManipulationException("More lines have been updated.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            if(!rs.next()){
                throw new ObjectManipulationException("No key for acount: " + account);
            }
            account.setId(rs.getLong(1));
            if(rs.next()){
                throw new ObjectManipulationException("More keys have been generated.");
            }
        } catch (SQLException ex){
            throw new ObjectManipulationException("Error while inserting account: "
                    + account, ex);
        }
    }
    
    static void save(User user) throws ObjectManipulationException{
        if(user == null){
            return;
        }
        String sql = "INSERT INTO " + UsersMetaData.TABLE_NAME + " ("
                + UsersMetaData.INSTANCE.getColumnNameAtPositionInInsert(1, true)
                + ") VALUES (?)";
        try(PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, user.getName());
            int updates = ps.executeUpdate();
            if(updates < 1){
                throw new ObjectManipulationException("User has not been saved: " + user);
            } else if(updates != 1){
                throw new ObjectManipulationException("More lines have been updated.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            if(!rs.next()){
                throw new ObjectManipulationException("No key for user: " + user);
            }
            user.setId(rs.getLong(1));
            if(rs.next()){
                throw new ObjectManipulationException("More keys have been generated.");
            }
        } catch (SQLException ex){
            throw new ObjectManipulationException("Error while inserting user: "
                    + user, ex);
        }
    }
    
    static void save(TransactionRecord record) throws ObjectManipulationException{
        if(record == null){
            return;
        }
        String sql = "INSERT INTO " + TransactionRecordsMetaData.TABLE_NAME
                + " (" + TransactionRecordsMetaData.INSTANCE.getColumnNameAtPositionInInsert(1, true) + ","
                + TransactionRecordsMetaData.INSTANCE.getColumnNameAtPositionInInsert(2, true) + ","
                + TransactionRecordsMetaData.INSTANCE.getColumnNameAtPositionInInsert(3, true) + ","
                + TransactionRecordsMetaData.INSTANCE.getColumnNameAtPositionInInsert(4, true) + ","
                + TransactionRecordsMetaData.INSTANCE.getColumnNameAtPositionInInsert(5, true) + ","
                + TransactionRecordsMetaData.INSTANCE.getColumnNameAtPositionInInsert(6, true)
                + ") VALUES (?,?,?,?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setLong(1, record.getAccountID());
            ps.setString(2, record.getName());
            ps.setString(3, record.getDescription());
            if(record.getAssociatedTransactionID() == null){
                ps.setNull(4, Types.INTEGER);
            } else {
                ps.setLong(4, record.getAssociatedTransactionID());
            }
            ps.setBigDecimal(5, record.getAmount());
            ps.setTimestamp(6, 
                    new Timestamp(record.getTransactionTime().getTimeInMillis()),
                    record.getTransactionTime());
            int updates = ps.executeUpdate();
            if(updates < 1){
                throw new ObjectManipulationException("Record has not been saved: " + record);
            } else if(updates != 1){
                throw new ObjectManipulationException("More lines have been updated.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            if(!rs.next()){
                throw new ObjectManipulationException("No key for record: " + record);
            }
            record.setId(rs.getLong(1));
            if(rs.next()){
                throw new ObjectManipulationException("More keys have been generated.");
            }
        } catch (SQLException ex){
            throw new ObjectManipulationException("Error while inserting record: "
                    + record, ex);
        }
    }
    
    static void delete(Account account) throws ObjectManipulationException{
        if(account == null){
            return;
        }
        String sql = "DELETE FROM " + AccountsMetaData.TABLE_NAME + " WHERE "
                + AccountsMetaData.COLUMN_ID + "=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setLong(1, account.getId());
            int updates = ps.executeUpdate();
            if(updates < 1){
                throw new ObjectManipulationException("Account has not been deleted: " + account);
            } else if(updates != 1){
                throw new ObjectManipulationException("More lines have been deleted.");
            }
        } catch (SQLException ex){
            throw new ObjectManipulationException("Error while deleting account: "
                    + account, ex);
        }
    }
    
    static void delete(User user) throws ObjectManipulationException{
        if(user == null){
            return;
        }
        String sql = "DELETE FROM " + UsersMetaData.TABLE_NAME + " WHERE "
                + UsersMetaData.COLUMN_ID + "=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setLong(1, user.getId());
            int updates = ps.executeUpdate();
            if(updates < 1){
                throw new ObjectManipulationException("User has not been deleted: " + user);
            } else if(updates != 1){
                throw new ObjectManipulationException("More lines have been deleted.");
            }
        } catch (SQLException ex){
            throw new ObjectManipulationException("Error while deleting user: "
                    + user, ex);
        }
    }
    
    static void delete(TransactionRecord record) throws ObjectManipulationException{
        if(record == null){
            return;
        }
        String sql = "DELETE FROM " + TransactionRecordsMetaData.TABLE_NAME + " WHERE "
                + TransactionRecordsMetaData.COLUMN_ID + "=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setLong(1, record.getId());
            int updates = ps.executeUpdate();
            if(updates < 1){
                throw new ObjectManipulationException("Record has not been deleted: " + record);
            } else if(updates != 1){
                throw new ObjectManipulationException("More lines have been deleted.");
            }
        } catch (SQLException ex){
            throw new ObjectManipulationException("Error while deleting record: "
                    + record, ex);
        }
    }
    
    static void update(Account account) throws ObjectManipulationException{
        if(account == null){
            return;
        }
        String sql = "UPDATE " + AccountsMetaData.TABLE_NAME
                + " SET " + AccountsMetaData.COLUMN_NAME + "=?, " 
                        + AccountsMetaData.COLUMN_DESCRIPTION + "=?"
                + " WHERE " + AccountsMetaData.COLUMN_ID + "=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, account.getName());
            ps.setString(2, account.getDescription());
            ps.setLong(3, account.getId());
            int updates = ps.executeUpdate();
            if(updates < 1){
                throw new ObjectManipulationException("Account has not been updated: " + account);
            } else if(updates != 1){
                throw new ObjectManipulationException("More lines have been updated.");
            }
        } catch (SQLException ex){
            throw new ObjectManipulationException("Error while updating account: "
                    + account, ex);
        }
    }
    
    static void update(User user) throws ObjectManipulationException{
        if(user == null){
            return;
        }
        String sql = "UPDATE " + UsersMetaData.TABLE_NAME
                + " SET " + UsersMetaData.COLUMN_NAME + "=?"
                + " WHERE " + UsersMetaData.COLUMN_ID + "=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, user.getName());
            ps.setLong(2, user.getId());
            int updates = ps.executeUpdate();
            if(updates < 1){
                throw new ObjectManipulationException("User has not been updated: " + user);
            } else if(updates != 1){
                throw new ObjectManipulationException("More lines have been updated.");
            }
        } catch (SQLException ex){
            throw new ObjectManipulationException("Error while updating user: "
                    + user, ex);
        }
    }
    
    static void update(TransactionRecord record) throws ObjectManipulationException{
        if(record == null){
            return;
        }
        String sql = "UPDATE " + TransactionRecordsMetaData.TABLE_NAME
                + " SET " + TransactionRecordsMetaData.COLUMN_NAME + "=?, " 
                            + TransactionRecordsMetaData.COLUMN_DESCRIPTION + "=?, "
                            + TransactionRecordsMetaData.COLUMN_ASSOCIATED_TRANSACTION_ID +"=?, "
                            + TransactionRecordsMetaData.COLUMN_AMOUNT + "=?, "
                            + TransactionRecordsMetaData.COLUMN_TRANSACTION_TIME + "=?"
                + "WHERE " + TransactionRecordsMetaData.COLUMN_ID + "=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, record.getName());
            ps.setString(2, record.getDescription());
            if(record.getAssociatedTransactionID() == null){
                ps.setNull(3, Types.INTEGER);
            } else {
                ps.setLong(3, record.getAssociatedTransactionID());
            }
            ps.setBigDecimal(4, record.getAmount());
            ps.setTimestamp(5, new Timestamp(record.getTransactionTime().getTimeInMillis()),
                    record.getTransactionTime());
            ps.setLong(6, record.getId());
            int updates = ps.executeUpdate();
            if(updates < 1){
                throw new ObjectManipulationException("Record has not been updated: " + record);
            } else if(updates != 1){
                throw new ObjectManipulationException("More lines have been updated.");
            }
        } catch (SQLException ex){
            throw new ObjectManipulationException("Error while updating record: "
                    + record, ex);
        }
    }
    
    static Account getAccount(Long id) throws ObjectManipulationException{
        if(id == null){
            return null;
        }
        String sql = "SELECT * FROM " + AccountsMetaData.TABLE_NAME
                + " WHERE " + AccountsMetaData.COLUMN_ID + "=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            return getAccountFromResultSet(rs);
        } catch (SQLException ex){
            throw new ObjectManipulationException("Error while getting account: "
                    + id, ex);
        }
    }
    
    static User getUser(Long id) throws ObjectManipulationException{
        if(id == null){
            return null;
        }
        String sql = "SELECT * FROM " + UsersMetaData.TABLE_NAME
                + " WHERE " + UsersMetaData.COLUMN_ID + "=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            return getUserFromResultSet(rs);
        } catch (SQLException ex){
            throw new ObjectManipulationException("Error while getting user: "
                    + id, ex);
        }
    }
    
    static TransactionRecord getRecord(Long id) throws ObjectManipulationException{
        if(id == null){
            return null;
        }
        String sql = "SELECT * FROM " + TransactionRecordsMetaData.TABLE_NAME
                + " WHERE " + TransactionRecordsMetaData.COLUMN_ID + "=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            return getTransactionRecordFromResultSet(rs);
        } catch (SQLException ex){
            throw new ObjectManipulationException("Error while getting record: "
                    + id, ex);
        }
    }
    
    private static User getUserFromResultSet(ResultSet rs) throws SQLException{
        if(rs == null || !rs.next()){
            return null;
        }
        User us = new User();
        us.setId(rs.getLong(UsersMetaData.COLUMN_ID));
        us.setName(rs.getString(UsersMetaData.COLUMN_NAME));
        return us;
    }
    
    private static  Account getAccountFromResultSet(ResultSet rs) throws SQLException{
        if(rs == null || !rs.next()){
            return null;
        }
        Account ac = new Account(rs.getLong(AccountsMetaData.COLUMN_USER_ID),
                Currency.getInstance(rs.getString(AccountsMetaData.COLUMN_CURRENCY)));
        ac.setId(rs.getLong(AccountsMetaData.COLUMN_ID));
        ac.setName(rs.getString(AccountsMetaData.COLUMN_NAME));
        ac.setDescription(rs.getString(AccountsMetaData.COLUMN_DESCRIPTION));
        return ac;
    }
    
    private static TransactionRecord getTransactionRecordFromResultSet(ResultSet rs) throws SQLException{
        if(rs == null || !rs.next()){
            return null;
        }
        TransactionRecord tr = new TransactionRecord(rs.getLong(TransactionRecordsMetaData.COLUMN_ACCOUNT_ID));
        tr.setAmount(rs.getBigDecimal(TransactionRecordsMetaData.COLUMN_AMOUNT));
        tr.setAssociatedTransactionID(rs.getLong(TransactionRecordsMetaData.COLUMN_ASSOCIATED_TRANSACTION_ID));
        if(rs.wasNull()){
            tr.setAssociatedTransactionID(null);
        }
        tr.setDescription(rs.getString(TransactionRecordsMetaData.COLUMN_DESCRIPTION));
        tr.setId(rs.getLong(TransactionRecordsMetaData.COLUMN_ID));
        tr.setName(rs.getString(TransactionRecordsMetaData.COLUMN_NAME));
        GregorianCalendar cal = new GregorianCalendar();
        long time = rs.getTimestamp(TransactionRecordsMetaData.COLUMN_TRANSACTION_TIME, cal).getTime();
        cal.setTimeInMillis(time);
        tr.setTransactionTime(cal);
        return tr;
    }
    
    static Collection<User> getAllUsers() throws ObjectManipulationException{
        String sql = "SELECT * FROM " + UsersMetaData.TABLE_NAME;
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            Collection<User> col = new LinkedList<>();
            User us;
            while((us = getUserFromResultSet(rs)) != null){
                col.add(us);
            }
            return col;
        } catch (SQLException ex){
            throw new ObjectManipulationException("Error while getting all users.", ex);
        }
    }
    
    static Collection<Account> getAllAccounts() throws ObjectManipulationException{
        String sql = "SELECT * FROM " + AccountsMetaData.TABLE_NAME;
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            Collection<Account> col = new LinkedList<>();
            Account ac;
            while((ac = getAccountFromResultSet(rs)) != null){
                col.add(ac);
            }
            return col;
        } catch (SQLException ex){
            throw new ObjectManipulationException("Error while getting all accounts.", ex);
        }
    }
    
    static Collection<TransactionRecord> getAllRecords() throws ObjectManipulationException{
        String sql = "SELECT * FROM " + TransactionRecordsMetaData.TABLE_NAME;
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            Collection<TransactionRecord> col = new LinkedList<>();
            TransactionRecord tr;
            while((tr = getTransactionRecordFromResultSet(rs)) != null){
                col.add(tr);
            }
            return col;
        } catch (SQLException ex){
            throw new ObjectManipulationException("Error while getting all records.", ex);
        }
    }
}
