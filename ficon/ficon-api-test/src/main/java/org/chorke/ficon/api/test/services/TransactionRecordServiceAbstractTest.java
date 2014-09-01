
package org.chorke.ficon.api.test.services;

import org.chorke.ficon.api.exceptions.TransactionRecordServiceException;
import org.chorke.ficon.api.objects.TransactionRecord;
import org.chorke.ficon.api.services.TransactionRecordService;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Abstract test for TransactionRecordService. When implementing 
 * TransactionRecordService interface 
 * all what you need to do to test it, is to extend this class and implement
 * abstract methods. 
 * 
 * @author Chorke
 */
public abstract class TransactionRecordServiceAbstractTest 
    extends AbstractServiceTest<TransactionRecordService, TransactionRecord>{

    /**
     * Creates new transaction record. Method calls associated {@code befor}
     * method, create method of service and associated {@code after} method.
     * Depends on standard create method of service.
     * 
     * @param record record to be created
     * @throws TransactionRecordServiceException
     * @see #beforeCreateNewTransactionRecord(org.chorke.ficon.api.objects.TransactionRecord) 
     * @see #afterCreateNewTransactionRecord(org.chorke.ficon.api.objects.TransactionRecord) 
     */
    protected final void doCreateNewTransactionRecord(TransactionRecord record)
            throws TransactionRecordServiceException{
        beforeCreateNewTransactionRecord(record);
        try{
            service.createNewTransactionRecord(record);
            afterCreateNewTransactionRecord(null, record);
        } catch (TransactionRecordServiceException | IllegalArgumentException ex){
            afterCreateNewTransactionRecord(ex, record);
            throw ex;
        }
    }
    
    /**
     * Updates transaction record. Method calls associated {@code befor}
     * method, update method of service and associated {@code after} method.
     * Depends on standard update method of service.
     * 
     * @param record record to be updated
     * @throws TransactionRecordServiceException
     * @see #beforeUpdateTransactionRecord(org.chorke.ficon.api.objects.TransactionRecord) 
     * @see #afterUpdateTransactionRecord(org.chorke.ficon.api.objects.TransactionRecord) 
     */
    protected final void doUpdateTransactionRecord(TransactionRecord record)
            throws TransactionRecordServiceException{
        beforeUpdateTransactionRecord(record);
        try{
            service.updateTransactionRecord(record);
            afterUpdateTransactionRecord(null, record);
        } catch (TransactionRecordServiceException | IllegalArgumentException ex){
            afterUpdateTransactionRecord(ex, record);
            throw ex;
        }
    }
    
    /**
     * Returns transaction record. Method calls associated {@code befor}
     * method, get method of service and associated {@code after} method.
     * Depends on standard get method of service.
     * 
     * @param id ID of record
     * @throws TransactionRecordServiceException
     * @see #beforeGetTransactionRecord(java.lang.Long) 
     * @see #afterGetTransactionRecord(java.lang.Long) 
     */
    protected final TransactionRecord doGetTransactionRecord(Long id)
            throws TransactionRecordServiceException{
        beforeGetTransactionRecord(id);
        try{
            TransactionRecord rec = service.getTransactionRecord(id);
            afterGetTransactionRecord(null, id);
            return rec;
        } catch (TransactionRecordServiceException | IllegalArgumentException ex){
            afterGetTransactionRecord(ex, id);
            throw ex;
        }
    }
    
    /**
     * Deletes transaction record. Method calls associated {@code befor}
     * method, delete method of service and associated {@code after} method.
     * Depends on standard delete method of service.
     * 
     * @param record record to be deleted
     * @throws TransactionRecordServiceException
     * @see #beforeDeleteTransactionRecord(org.chorke.ficon.api.objects.TransactionRecord) 
     * @see #afterDeleteTransactionRecord(org.chorke.ficon.api.objects.TransactionRecord) 
     */
    protected final void doDeleteTransactionRecord(TransactionRecord record)
            throws TransactionRecordServiceException{
        beforeDeleteTransactionRecord(record);
        try{
            service.deleteTransactionRecord(record);
            afterDeleteTransactionRecord(null, record);
        } catch (TransactionRecordServiceException | IllegalArgumentException ex){
            afterDeleteTransactionRecord(ex, record);
            throw ex;
        }
    }
    
    /**
     * This method is called closely before calling create method of service with 
     * parameter {@code record}.
     * 
     * @param record 
     */
    protected abstract void beforeCreateNewTransactionRecord(TransactionRecord record);
    /**
     * This method is called immediately after calling create method of service with 
     * parameter {@code record}.
     * 
     * @param thrown exception that has been thrown during operation
     * @param record 
     */
    protected abstract void afterCreateNewTransactionRecord(Exception thrown, TransactionRecord record);
    
    /**
     * This method is called closely before calling update method of service with 
     * parameter {@code record}.
     * 
     * @param record 
     */
    protected abstract void beforeUpdateTransactionRecord(TransactionRecord record);
    /**
     * This method is called immediately after calling update method of service with 
     * parameter {@code record}.
     * 
     * @param thrown exception that has been thrown during operation
     * @param record 
     */
    protected abstract void afterUpdateTransactionRecord(Exception thrown, TransactionRecord record);
    
    /**
     * This method is called closely before calling get method of service with 
     * parameter {@code id}.
     * 
     * @param id 
     */
    protected abstract void beforeGetTransactionRecord(Long id);
    /**
     * This method is called immediately after calling get method of service with 
     * parameter {@code id}.
     * 
     * @param thrown exception that has been thrown during operation
     * @param id
     */
    protected abstract void afterGetTransactionRecord(Exception thrown, Long id);
    
    /**
     * This method is called closely before calling delete method of service with 
     * parameter {@code record}.
     * 
     * @param record 
     */
    protected abstract void beforeDeleteTransactionRecord(TransactionRecord record);
    /**
     * This method is called immediately after calling delete method of service with 
     * parameter {@code record}.
     * 
     * @param thrown exception that has been thrown during operation
     * @param record 
     */
    protected abstract void afterDeleteTransactionRecord(Exception thrown, TransactionRecord record);
    
    
}
