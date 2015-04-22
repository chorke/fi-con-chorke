
package org.chorke.ficon.gui.utils.exceptions;

/**
 *
 * @author Chorke
 */
public class IllegalAccountOperationException extends Exception {

    public IllegalAccountOperationException() {
    }

    public IllegalAccountOperationException(String message) {
        super(message);
    }

    public IllegalAccountOperationException(Throwable cause) {
        super(cause);
    }

    public IllegalAccountOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
