package org.chorke.ficon.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.chorke.ficon.gui.listeners.workers.LoadHistorySwingWorker;
import org.chorke.ficon.gui.panels.AccountManipulationPanel;
import org.chorke.ficon.gui.utils.BundleUtils;
import org.chorke.gui.utils.worker.SwingWorkerWithWaitingDialog;


/**
 *
 * @author Chorke
 */
class LoadHistoryListener implements ActionListener {

    private final AccountManipulationPanel panel;

    public LoadHistoryListener(AccountManipulationPanel panel) {
        this.panel = panel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        LoadHistorySwingWorker worker = new LoadHistorySwingWorker(panel);
        worker.setCancelString(ListenersUtils.CANCEL_STRING);
        worker.setDialogMessage(BundleUtils.getLocalizedMessage("loading.accounts.history"));
        worker.execute(true, SwingWorkerWithWaitingDialog.HIDE_AFTER_DONE);
    }
}
