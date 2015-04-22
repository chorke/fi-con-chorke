
package org.chorke.ficon.backend.services;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.chorke.ficon.api.exceptions.TransactionRecordServiceException;
import org.chorke.ficon.api.objects.TransactionRecord;
import org.chorke.ficon.api.services.TransactionRecordService;
import org.chorke.ficon.backend.sql.SQLBuilderTransactionRecordsService;
import org.chorke.ficon.backend.sql.SQLBuilderTransactionRecordsService.StatementTypeTransactionRecrod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Chorke
 */
public class TransactionRecordServiceImpl extends BasicService implements TransactionRecordService{

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionRecordServiceImpl.class);
    
    public TransactionRecordServiceImpl(DataSource dataSource) {
        super(dataSource);
    }
    @Override
    public void createNewTransactionRecord(TransactionRecord record) throws TransactionRecordServiceException {
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("Trying to create a record: {}.", record);
        }
        checkRecord(record, true);
        Connection con = null;
        SQLBuilderTransactionRecordsService builder = null;
        boolean endExpected = false;
        try{
            con = getConnection(false);
            builder = new SQLBuilderTransactionRecordsService(con, StatementTypeTransactionRecrod.TYPE_INSERT);
            builder.setAccountID(record.getAccountID());
            builder.setAmount(record.getAmount());
            builder.setAssociatedTransactionID(record.getAssociatedTransactionID());
            builder.setDesctiption(record.getDescription());
            builder.setName(record.getName());
            builder.setTransactionTime(record.getTransactionTime());
            PreparedStatement ps = builder.build();
            Long id = executeInsertAndGetID(builder);
            con.commit();
            endExpected = true;
            record.setId(id);
        } catch (SQLException ex){
            endExpected = true;
            LOGGER.error("Error while create record - rollback.", ex);
            rollback(con, "Error while creating new record.", TransactionRecordServiceException.class);
            throw new TransactionRecordServiceException("Error while creating new record: "
                    + ex.getMessage(), ex);
        } finally {
            if(!endExpected){
                LOGGER.error("Uncommitted transaction [new record] - rollback.");
                rollback(con, "Transaction has not been committed.", TransactionRecordServiceException.class);
            }
            saveClose(builder, con);
        }
    }

    @Override
    public void updateTransactionRecord(TransactionRecord record) throws TransactionRecordServiceException {
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("Trying to update a record: {}.", record);
        }
        checkRecord(record, false);
        Connection con = null;
        SQLBuilderTransactionRecordsService builder = null;
        boolean endExpected = false;
        try{
            con = getConnection(false);
            TransactionRecord inDB = getTransactionRecord(record.getId());
            if(inDB == null){
                throw new TransactionRecordServiceException("Record is not in DB: " + record);
            }
            if(areDifferent(inDB.getAccountID(), record.getAccountID(), true)){
                throw new TransactionRecordServiceException("Account's ID has been changed.");
            }
            builder = new SQLBuilderTransactionRecordsService(con, StatementTypeTransactionRecrod.TYPE_UPDATE);
            if(areDifferent(inDB.getAmount(), record.getAmount(), true)){
                builder.setAmount(record.getAmount());
            }
            if(areDifferent(inDB.getAssociatedTransactionID(),
                    record.getAssociatedTransactionID(), false)){
                builder.setAssociatedTransactionID(record.getAssociatedTransactionID());
            }
            if(areDifferent(inDB.getDescription(), record.getDescription(), false)){
                builder.setDesctiption(record.getDescription());
            }
            if(areDifferent(record.getName(), inDB.getName(), false)){
                builder.setName(record.getName());
            }
            if(areDifferent(record.getTransactionTime(), inDB.getTransactionTime(), true)){
                builder.setTransactionTime(record.getTransactionTime());
            }
            builder.setId(record.getId());
            executeUpdate(builder);
            con.commit();
            endExpected = true;
        } catch (SQLException ex){
            endExpected = true;
            LOGGER.error("Error while updating record - rollback.", ex);
            rollback(con, "Error while updating record.", TransactionRecordServiceException.class);
            throw new TransactionRecordServiceException("Error while updating record: "
                    + ex.getMessage(), ex);
        } finally {
            if(!endExpected){
                LOGGER.error("Uncommitted transaction [update record] - rollback.");
                rollback(con, "Transaction has not been committed.", TransactionRecordServiceException.class);
            }
            saveClose(builder, con);
        }
    }

    @Override
    public TransactionRecord getTransactionRecord(Long id) throws TransactionRecordServiceException {
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("Trying to get a record: {}.", id);
        }
        checkRecordsID(id, false);
        try(Connection con = getConnection(true);
            SQLBuilderTransactionRecordsService builder = 
                    new SQLBuilderTransactionRecordsService(con, StatementTypeTransactionRecrod.TYPE_SELECT)){
            builder.setId(id);
            ResultSet userSet = builder.build().executeQuery();
            TransactionRecord fromDB = getRecordFromResultSet(userSet);
            if(userSet.next()){
                LOGGER.error("Multiple ID in one table [records table].");
                throw new TransactionRecordServiceException("Multiple ID in one table.");
            }
            return fromDB;
        } catch (SQLException ex){
            LOGGER.error("Error while getting record - rollback.", ex);
            throw new TransactionRecordServiceException("Error while getting record: "
                    + ex.getMessage(), ex);
        }
    }

    @Override
    public void deleteTransactionRecord(TransactionRecord record) throws TransactionRecordServiceException {
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("Trying to delete a record: {}.", record);
        }
        checkRecordOnNullAndId(record, false);
        Connection con = null;
        SQLBuilderTransactionRecordsService builderDelete = null;
        SQLBuilderTransactionRecordsService builderUpdate = null;
        boolean endExpected = false;
        try{
            con = getConnection(false);
            builderDelete = new SQLBuilderTransactionRecordsService(con,
                    StatementTypeTransactionRecrod.TYPE_DELETE);
            builderDelete.setId(record.getId());
            builderUpdate = new SQLBuilderTransactionRecordsService(con,
                    StatementTypeTransactionRecrod.TYPE_UPDATE_RECORDS_BEFORE_DELETE);
            builderUpdate.setId(record.getId());
            
            builderUpdate.build().executeUpdate();
            builderDelete.build().executeUpdate();
            con.commit();
            endExpected = true;
        } catch (SQLException ex){
            endExpected = true;
            LOGGER.error("Error while deleting record - rollback.", ex);
            rollback(con, "Error while deleting record.", TransactionRecordServiceException.class);
            throw new TransactionRecordServiceException("Error while deleting record: "
                    + ex.getMessage(), ex);
        } finally {
            if(!endExpected){
                LOGGER.error("Uncommitted transaction [delete record] - rollback.");
                rollback(con, "Transaction has not been committed.", TransactionRecordServiceException.class);
            }
            saveClose(builderUpdate, builderDelete, con);
        }
    }
    
    private void checkRecord(TransactionRecord record, boolean isNewRecord){
        checkRecordOnNullAndId(record, isNewRecord);
        checkString(record.getName(), true, true, true, "Invalid record: " + record.getName());
        checkOnNull(record.getAccountID(), "Record's accountID is null");
        checkOnNull(record.getAmount(), "Record's amount is null.");
        if(record.getAmount().compareTo(BigDecimal.ZERO) == 0){
            throw new IllegalArgumentException("Amount is zero.");
        }
        checkOnNull(record.getTransactionTime(), "Record's time is null.");
    }
    
    private void checkRecordOnNullAndId(TransactionRecord record, boolean isNew){
        checkRecordOnNull(record);
        checkRecordsID(record.getId(), isNew);
    }
    
    private void checkRecordsID(Long id, boolean shouldBeNull){
        checkId(id, shouldBeNull, "Record's ID is set.", "Record's ID is null.");
    }
    
    private void checkRecordOnNull(TransactionRecord record){
        checkOnNull(record, "Record cannot be null.");
    }
}
