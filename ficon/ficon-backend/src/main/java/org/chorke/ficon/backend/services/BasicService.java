
package org.chorke.ficon.backend.services;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.sql.DataSource;
import org.chorke.ficon.api.objects.Account;
import org.chorke.ficon.api.objects.TransactionRecord;
import org.chorke.ficon.api.objects.User;
import org.chorke.ficon.backend.sql.SQLBuilder;
import org.chorke.ficon.backend.sql.metadata.AccountsMetaData;
import org.chorke.ficon.backend.sql.metadata.TransactionRecordsMetaData;
import org.chorke.ficon.backend.sql.metadata.UsersMetaData;

/**
 *
 * @author Chorke
 */
public class BasicService {
    
    private static final Object LOCK = new Object();
    
    private final DataSource dataSource;
    
    public BasicService(DataSource dataSource) {
        if(dataSource == null){
            throw new IllegalArgumentException("Data source cannot be null");
        }
        this.dataSource = dataSource;
    }
    
    protected Connection getConnection(boolean autoCommit) throws SQLException{
        synchronized(LOCK){
            Connection c = dataSource.getConnection();
            c.setAutoCommit(autoCommit);
            return c;
        }
    }
    
    protected void saveClose(AutoCloseable... toClose){
        if(toClose == null || toClose.length == 0){
            return;
        }
        for(AutoCloseable ac : toClose){
            if(ac != null){
                try{
                    ac.close();
                } catch (Exception ex){
                    // ignore
                }
            }
        }
    }
    
    protected <T extends SQLException> void rollback(Connection con, String rollbackReason, Class<T> exception)
            throws T{
        if(con == null){ return; }
        try{
            con.rollback();
        } catch (SQLException ex){
            try{
                throw exception.getConstructor(String.class, Exception.class)
                        .newInstance("Unable to rollback transaction. Rollback reason: " 
                            + rollbackReason, ex);
            } catch (NoSuchMethodException 
                    | InstantiationException 
                    | IllegalAccessException 
                    | InvocationTargetException t){
                throw new Error("Unable co create exception.", t);
            }
        }
    }
    
    protected User getUserFromResultSet(ResultSet rs) throws SQLException{
        if(rs == null || !rs.next()){
            return null;
        }
        User us = new User();
        long id = rs.getLong(UsersMetaData.COLUMN_ID);
        if(!rs.wasNull()){
            us.setId(id);
        }
        us.setName(rs.getString(UsersMetaData.COLUMN_NAME));
        return us;
    }
    
    protected Account getAccountFromResultSet(ResultSet rs) throws SQLException{
        if(rs == null || !rs.next()){
            return null;
        }
        Account ac = new Account(rs.getLong(AccountsMetaData.COLUMN_USER_ID));
        ac.setDescription(rs.getString(AccountsMetaData.COLUMN_DESCRIPTION));
        ac.setName(rs.getString(AccountsMetaData.COLUMN_NAME));
        long id = rs.getLong(AccountsMetaData.COLUMN_ID);
        if(!rs.wasNull()){
            ac.setId(id);
        }
        return ac;
    }
    
    protected TransactionRecord getRecordFromResultSet(ResultSet rs) throws SQLException{
        if(rs == null || !rs.next()){
            return null;
        }
        TransactionRecord tr = new TransactionRecord(
                rs.getLong(TransactionRecordsMetaData.COLUMN_ACCOUNT_ID));
        tr.setAmount(rs.getBigDecimal(TransactionRecordsMetaData.COLUMN_AMOUNT));
        long id = rs.getLong(TransactionRecordsMetaData.COLUMN_ASSOCIATED_TRANSACTION_ID);
        if(rs.wasNull()){
            tr.setAssociatedTransactionID(null);
        } else {
            tr.setAssociatedTransactionID(id);
        }
        tr.setDescription(rs.getString(TransactionRecordsMetaData.COLUMN_DESCRIPTION));
        
        id = rs.getLong(TransactionRecordsMetaData.COLUMN_ID);
        if(!rs.wasNull()){
            tr.setId(id);
        }
        
        tr.setName(rs.getString(TransactionRecordsMetaData.COLUMN_NAME));
        
        Timestamp ts = rs.getTimestamp(TransactionRecordsMetaData.COLUMN_TRANSACTION_TIME);
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(ts.getTime());
        tr.setTransactionTime(cal);
        return tr;
    }
    
    protected void checkOnNull(Object o, String errMessage){
        if(o == null){
            throw new IllegalArgumentException(errMessage);
        }
    }
    
    protected void checkId(Long id, boolean shouldBeNull, String errIsNotNull, String errIsNull){
        if(shouldBeNull && id != null){
            throw new IllegalArgumentException(errIsNotNull);
        } else if(!shouldBeNull && id == null){
            throw new IllegalArgumentException(errIsNull);
        }
    }
    
    protected void checkString(String toCheck, boolean nonNull, boolean nonEmpty,
            boolean onlyAlphaNumeric, String errMesage){
        if(nonNull && toCheck == null){
            throw new IllegalArgumentException(errMesage + " [is null]");
        }
        if(nonEmpty){
            // could be null - that is OK
            if(toCheck != null && toCheck.isEmpty()){
                throw new IllegalArgumentException(errMesage + " [is empty]");
            }
        }
        if(onlyAlphaNumeric){
            if(toCheck != null){
                for(char c : toCheck.toCharArray()){
                    if(!Character.isLetterOrDigit(c)){
                        throw new IllegalArgumentException(errMesage + " [non-alpha-numeric]");
                    }
                }
            }
        }
    }
    
    protected <T> boolean areDifferent(Comparable<T> o1, T o2, boolean useCompareTo){
        if(o1 == null){
            return o2 != null;
        }
        if(useCompareTo){
            return o1.compareTo(o2) != 0;
        }
        return !o1.equals(o2);
    }
    
    protected Long executeInsertAndGetID(SQLBuilder builder) throws SQLException{
        PreparedStatement ps = builder.build();
        int updCount = ps.executeUpdate();
        if(updCount != 1){
            throw new SQLException("Expected update count is 1 but was " + updCount);
        }
        ResultSet keys = ps.getGeneratedKeys();
        if(keys == null || !keys.next()){
            throw new SQLException("No key.");
        }
        long id = keys.getLong(1);
        if(keys.wasNull()){
            throw new SQLException("Returned key is null.");
        }
        if(keys.next()){
            throw new SQLException("More than one key has been returned.");
        }
        return id;
    }
    
    protected void executeUpdate(SQLBuilder builder) throws SQLException{
        PreparedStatement ps;
        try{
            ps = builder.build();
        } catch (IllegalStateException ex){
            return;
        }
        int updCount = ps.executeUpdate();
        if(updCount != 1){
            throw new SQLException("Expected update count is 1 but was " + updCount);
        }
    }
}
