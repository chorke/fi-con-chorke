
package org.chorke.ficon.gui.utils.exceptions;

/**
 *
 * @author Chorke
 */
public class ObjectManipulationException extends Exception{

    public ObjectManipulationException() {
    }

    public ObjectManipulationException(String message) {
        super(message);
    }

    public ObjectManipulationException(Throwable cause) {
        super(cause);
    }

    public ObjectManipulationException(String message, Throwable cause) {
        super(message, cause);
    }
}
