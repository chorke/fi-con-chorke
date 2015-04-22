
package org.chorke.ficon.gui.listeners.workers;

import java.util.concurrent.ExecutionException;
import org.chorke.ficon.api.objects.User;
import org.chorke.ficon.gui.utils.ExceptionUtils;
import org.chorke.ficon.gui.utils.Utils;
import org.chorke.ficon.gui.windows.WindowUtils;
import org.chorke.gui.utils.worker.SwingWorkerWithWaitingDialog;

/**
 *
 * @author Chorke
 */
public class LogInWorker extends SwingWorkerWithWaitingDialog<User, Void>{
        
    private final Long userID;

    public LogInWorker(Long userID) {
        this.userID = userID;
    }

    @Override
    public User doYourJob() throws Exception {
        return Utils.getActualSession().getUserFromDB(userID);
    }

    @Override
    public void jobIsDone() {
        try{
            Utils.getActualSession().logInUser(get());
        } catch (ExecutionException | InterruptedException ex){
            ExceptionUtils.handleThrowable(ex, true);
        }
        System.out.println(Utils.getActualSession().getLoggedUser());//TODO - remove
        WindowUtils.getMainWindow().setVisible(true);
    }

    @Override
    public void cancelInvoked(){
        try{
            Utils.getActualSession().cancelAllDBOperations();
        } catch (Throwable t){
            ExceptionUtils.handleThrowable(t, true);
        }
    }
}
