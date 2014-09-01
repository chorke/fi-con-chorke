
package org.chorke.ficon.api.services;

import org.chorke.ficon.api.exceptions.TransactionRecordServiceException;
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
     * @throws TransactionRecordServiceException if some arror occurs
     * @throws IllegalArgumentException if {@code record} has some inappropriate 
     *      fields
     */
    void createNewTransactionRecord(TransactionRecord record) throws TransactionRecordServiceException;
    
    /**
     * Updates record of transaction.
     * 
     * @param record record to be updated
     * @throws TransactionRecordServiceException if some arror occurs
     * @throws IllegalArgumentException if {@code record} has some inappropriate 
     *      fields
     */
    void updateTransactionRecord(TransactionRecord record) throws TransactionRecordServiceException;
    
    /**
     * Return record of transaction with specified ID.
     * 
     * @param id ID of transaction
     * @return transactions record
     * @throws TransactionRecordServiceException if some arror occurs
     */
    TransactionRecord getTransactionRecord(Long id) throws TransactionRecordServiceException;
    
    /**
     * Deletes record of transaction.
     * 
     * @param record record to be deleted
     * @throws TransactionRecordServiceException if some arror occurs
     * @throws IllegalArgumentException if {@code record} has some inappropriate 
     *      fields
     */
    void deleteTransactionRecord(TransactionRecord record) throws TransactionRecordServiceException;
    
    
}
