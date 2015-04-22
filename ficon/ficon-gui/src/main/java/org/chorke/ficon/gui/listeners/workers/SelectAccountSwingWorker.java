
package org.chorke.ficon.gui.listeners.workers;

import javax.swing.JOptionPane;
import org.chorke.ficon.api.objects.Account;
import org.chorke.ficon.gui.panels.SelectAccountPanel;
import org.chorke.ficon.gui.utils.ExceptionUtils;
import org.chorke.ficon.gui.utils.GuiUtils;
import org.chorke.ficon.gui.utils.Utils;
import org.chorke.ficon.gui.windows.WindowUtils;
import org.chorke.gui.utils.worker.SwingWorkerWithWaitingDialog;

/**
 *
 * @author Chorke
 */
public class SelectAccountSwingWorker extends SwingWorkerWithWaitingDialog<Account, Void>{

    private final SelectAccountPanel panel;

    public SelectAccountSwingWorker(SelectAccountPanel panel) {
        this.panel = panel;
    }

    @Override
    public Account doYourJob() throws Exception {
        Long id = panel.getSelectedAccountID();
        if(id == null){
            GuiUtils.showLocalizedMessageDialog("account.not.set", null,
                    "account.not.set.title", null, JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        return Utils.getActualSession().getAccount(id);
    }

    @SuppressWarnings("UseSpecificCatch")
    @Override
    public void jobIsDone() {
        try{
            Account ac = get();
            if(ac != null){
                Utils.getActualSession().setActualAccount(ac);
                WindowUtils.disposeWindowOfComponet(panel);
            }
        } catch (Throwable t){
            ExceptionUtils.handleThrowable(t, true);
        }
    }

    @Override
    public void cancelInvoked() {
        Utils.getActualSession().cancelAllDBOperations();
    }
}
