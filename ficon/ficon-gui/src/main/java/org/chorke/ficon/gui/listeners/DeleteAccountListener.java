
package org.chorke.ficon.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.chorke.ficon.gui.listeners.workers.DeleteAccountSwingWorker;
import org.chorke.ficon.gui.utils.BundleUtils;
import org.chorke.gui.utils.worker.SwingWorkerWithWaitingDialog;

/**
 *
 * @author Chorke
 */
class DeleteAccountListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        DeleteAccountSwingWorker worker = new DeleteAccountSwingWorker();
        worker.setCancelString(BundleUtils.getLocalizedString("buttons.cancel"));
        worker.setDialogMessage(BundleUtils.getLocalizedMessage("account.deleting"));
        worker.execute(true, SwingWorkerWithWaitingDialog.HIDE_AFTER_DONE);
    }
}
