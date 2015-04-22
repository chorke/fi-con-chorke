package org.chorke.ficon.gui.listeners.workers;

import javax.swing.JOptionPane;
import org.chorke.ficon.api.objects.Account;
import org.chorke.ficon.gui.panels.AccountManipulationPanel;
import org.chorke.ficon.gui.utils.ExceptionUtils;
import org.chorke.ficon.gui.utils.GuiUtils;
import org.chorke.ficon.gui.utils.Utils;
import org.chorke.gui.utils.worker.SwingWorkerWithWaitingDialog;

/**
 *
 * @author Chorke
 */
public class LoadHistorySwingWorker extends SwingWorkerWithWaitingDialog<Void, Void> {

    private final AccountManipulationPanel panel;

    public LoadHistorySwingWorker(AccountManipulationPanel panel) {
        this.panel = panel;
    }
    
    @Override
    public Void doYourJob() throws Exception {
        Account account = Utils.getActualSession().getActualAccount();
        if (account == null) {
            GuiUtils.showLocalizedMessageDialog("account.not.set",
                    null, "account.not.set.title",
                    null, JOptionPane.INFORMATION_MESSAGE);
        } else {
            account.transactionHistoryNoMoreNeeded();
            Utils.getActualSession().loadHistoryOfAccount(panel.getLoadProperties());
        }
        return null;
    }

    @Override
    @SuppressWarnings(value = "UseSpecificCatch")
    public void jobIsDone() {
        try {
            get();
            Utils.getActualSession().setActualRecord(null);
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
