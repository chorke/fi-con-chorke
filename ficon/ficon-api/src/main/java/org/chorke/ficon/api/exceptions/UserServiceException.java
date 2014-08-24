
package org.chorke.ficon.api.exceptions;

import java.sql.SQLException;

/**
 *
 * @author Chorke
 */
public class UserServiceException extends SQLException {

    /**
     * Creates a new instance of
     * <code>UserServiceException</code> without detail message.
     */
    public UserServiceException() {}

    /**
     * Constructs an instance of
     * <code>UserServiceException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public UserServiceException(String msg) {
        super(msg);
    }

    /**
     * Creates new instance.
     * 
     * @param cause reason
     */
    public UserServiceException(Throwable cause) {
        super(cause);
    }

    /**
     * Creates new instance.
     * 
     * @param reason message
     * @param cause reason
     */
    public UserServiceException(String reason, Throwable cause) {
        super(reason, cause);
    }
}
