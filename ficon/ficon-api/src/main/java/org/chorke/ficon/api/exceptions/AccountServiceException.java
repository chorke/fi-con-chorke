
package org.chorke.ficon.api.exceptions;

import java.sql.SQLException;

/**
 *
 * @author Chorke
 */
public class AccountServiceException extends SQLException {

    /**
     * Creates a new instance of <code>AccountServiceException</code> without detail message.
     */
    public AccountServiceException() {
    }


    /**
     * Constructs an instance of <code>AccountServiceException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public AccountServiceException(String msg) {
        super(msg);
    }
    
    /**
     * Creates new instance.
     * 
     * @param cause reason
     */
    public AccountServiceException(Throwable cause) {
        super(cause);
    }

    /**
     * Creates new instance.
     * 
     * @param reason message
     * @param cause reason
     */
    public AccountServiceException(String reason, Throwable cause) {
        super(reason, cause);
    }
}
