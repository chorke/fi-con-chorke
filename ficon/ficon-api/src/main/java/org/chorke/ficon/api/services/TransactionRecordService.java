
package org.chorke.ficon.api.services;

import org.chorke.ficon.api.objects.TransactionRecord;

/**
 *
 * @author Chorke
 */
public interface TransactionRecordService {
    
    /**
     * Creats new record of transactions.
     * 
     * @param record record to be created
     */
    void createNewTransactionRecord(TransactionRecord record);
    
    /**
     * Updates record of transaction.
     * 
     * @param record record to be updated
     */
    void updateTransactionRecord(TransactionRecord record);
    
    /**
     * Return record of transaction with specified ID.
     * 
     * @param id ID of transaction
     * @return transactions record
     */
    TransactionRecord getTransactionRecord(Long id);
    
    /**
     * Deletes record of transaction.
     * 
     * @param record record to be deleted.
     */
    void deleteTransactionRecord(TransactionRecord record);
    
    
}
