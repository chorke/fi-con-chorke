
package org.chorke.ficon.gui.utils;

import java.io.PrintStream;
import java.sql.SQLException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;
import org.chorke.ficon.api.exceptions.AccountServiceException;
import org.chorke.ficon.api.exceptions.TransactionRecordServiceException;
import org.chorke.ficon.api.exceptions.UserServiceException;
import org.chorke.ficon.gui.utils.exceptions.IllegalAccountOperationException;
import org.chorke.ficon.gui.utils.exceptions.ObjectManipulationException;

/**
 *
 * @author Chorke
 */
public class ExceptionUtils {

    public static void handleThrowable(Throwable t, boolean useGui) {
        String messageKey = "win.unknown.exception.thrown";
        String titleKey = "win.message.error";
        int messageType = JOptionPane.ERROR_MESSAGE;
        if (t instanceof UserServiceException) {
            messageKey = "win.user.service.exception.thrown";
        } else if (t instanceof AccountServiceException) {
            messageKey = "win.account.service.exception.thrown";
        } else if (t instanceof TransactionRecordServiceException) {
            messageKey = "win.transaction.record.service.exception.thrown";
        } else if (t instanceof SQLException) {
            messageKey = "win.sql.exception.thrown";
        } else if (t instanceof IllegalArgumentException) {
            messageKey = "win.illegal.argument.exception.thrown";
            messageType = JOptionPane.WARNING_MESSAGE;
        } else if (t instanceof CancellationException) {
            messageKey = "win.dialog.cancelled";
            messageType = JOptionPane.INFORMATION_MESSAGE;
            titleKey = "win.dialog.cancelled.title";
        } else if (
                   (t instanceof ExecutionException)
                || (t instanceof ObjectManipulationException)
                || (t instanceof IllegalAccountOperationException)
                ) {
            handleThrowable(t.getCause(), useGui);
            return;
        } else if (t instanceof IllegalArgumentException) {
            messageKey = "win.illegal.argument.exception.thrown";
        }
        if(useGui){
            GuiUtils.showLocalizedMessageDialog(
                    messageKey, (t == null ? null : t.getMessage()),
                    titleKey, null, messageType);
        } else {
            printFullStacktrace(t, System.out);
        }
        t.printStackTrace(); // TODO - remove this line
    }

    private static void printFullStacktrace(Throwable t, PrintStream out) {
        synchronized(out){
            final String cause = BundleUtils.getLocalizedString("exception.cause");
            while(t != null){
                out.println(t);
                for(StackTraceElement el : t.getStackTrace()){
                    out.println("\tat " + el);
                }
                for(Throwable sup : t.getSuppressed()){
                    printFullStacktrace(sup, out);
                }
                t = t.getCause();
                if(t != null){
                    out.println(cause + ": " + t);
                }
            }
        }
    }
}
