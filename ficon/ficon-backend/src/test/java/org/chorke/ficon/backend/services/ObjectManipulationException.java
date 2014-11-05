
package org.chorke.ficon.backend.services;

/**
 *
 * @author Chorke
 */
public class ObjectManipulationException extends RuntimeException {

    /**
     * Creates a new instance of <code>ObjectManipulationException</code> without detail message.
     */
    public ObjectManipulationException() {
    }


    /**
     * Constructs an instance of <code>ObjectManipulationException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ObjectManipulationException(String msg) {
        super(msg);
    }

    public ObjectManipulationException(Throwable cause) {
        super(cause);
    }

    public ObjectManipulationException(String message, Throwable cause) {
        super(message, cause);
    }
}
