
package org.chorke.ficon.api.exceptions;

import java.sql.SQLException;

/**
 *
 * @author Chorke
 */
public class TransactionRecordServiceException extends SQLException {

    /**
     * Creates a new instance of <code>TransactionRecordServiceException</code> without detail message.
     */
    public TransactionRecordServiceException() {
    }


    /**
     * Constructs an instance of <code>TransactionRecordServiceException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public TransactionRecordServiceException(String msg) {
        super(msg);
    }
    
    /**
     * Creates new instance.
     * 
     * @param cause reason
     */
    public TransactionRecordServiceException(Throwable cause) {
        super(cause);
    }

    /**
     * Creates new instance.
     * 
     * @param reason message
     * @param cause reason
     */
    public TransactionRecordServiceException(String reason, Throwable cause) {
        super(reason, cause);
    }
}
