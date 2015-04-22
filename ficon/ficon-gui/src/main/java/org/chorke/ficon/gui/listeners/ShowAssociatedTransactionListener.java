
package org.chorke.ficon.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.chorke.ficon.gui.listeners.workers.LoadAndShowAssociatedTransactionWorker;
import org.chorke.ficon.gui.utils.BundleUtils;
import org.chorke.gui.utils.worker.SwingWorkerWithWaitingDialog;

/**
 *
 * @author Chorke
 */
class ShowAssociatedTransactionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        LoadAndShowAssociatedTransactionWorker worker = new LoadAndShowAssociatedTransactionWorker();
        worker.setCancelString(ListenersUtils.CANCEL_STRING);
        worker.setDialogMessage(BundleUtils.getLocalizedMessage("wait.load.transaction"));
        worker.execute(true, SwingWorkerWithWaitingDialog.HIDE_AFTER_JOB);
    }
}
