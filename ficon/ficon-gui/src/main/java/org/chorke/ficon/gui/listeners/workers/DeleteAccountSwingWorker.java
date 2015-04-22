
package org.chorke.ficon.gui.listeners.workers;

import javax.swing.JOptionPane;
import org.chorke.ficon.api.objects.Account;
import org.chorke.ficon.gui.utils.ExceptionUtils;
import org.chorke.ficon.gui.utils.GuiUtils;
import org.chorke.ficon.gui.utils.Session;
import org.chorke.ficon.gui.utils.Utils;
import org.chorke.gui.utils.worker.SwingWorkerWithWaitingDialog;

/**
 *
 * @author Chorke
 */
public class DeleteAccountSwingWorker extends SwingWorkerWithWaitingDialog<Void, Void>{
    
    @Override
    public Void doYourJob() throws Exception {
        Session ses = Utils.getActualSession();
        Account account = ses.getActualAccount();
        if(account == null){
            GuiUtils.showLocalizedMessageDialog("account.not.set", null, "account.not.set.title",
                    null, JOptionPane.INFORMATION_MESSAGE);
        } else {
            int ret = GuiUtils.showLocalizedConfirmDialog("account.confirm.delete",
                    account.getName(), "account.delete", null);
            if(ret == JOptionPane.YES_OPTION){
                ses.deleteActualAccount();
            }
        }
        return null;
    }

    @Override
    @SuppressWarnings(value = "UseSpecificCatch")
    public void jobIsDone() {
        try {
            get();
        } catch (Throwable t) {
            ExceptionUtils.handleThrowable(t, true);
        }
    }

    @Override
    public void cancelInvoked() {
        try {
            Utils.getActualSession().cancelAllDBOperations();
        } catch (Throwable t) {
            ExceptionUtils.handleThrowable(t, true);
        }
    }
}