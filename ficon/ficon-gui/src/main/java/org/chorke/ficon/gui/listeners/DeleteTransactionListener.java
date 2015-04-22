
package org.chorke.ficon.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.chorke.ficon.gui.listeners.workers.DeleteRecordSwingWorker;
import org.chorke.ficon.gui.utils.BundleUtils;
import org.chorke.gui.utils.worker.SwingWorkerWithWaitingDialog;

/**
 *
 * @author Chorke
 */
class DeleteTransactionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        DeleteRecordSwingWorker worker = new DeleteRecordSwingWorker();
        worker.setCancelString(BundleUtils.getLocalizedString("buttons.cancel"));
        worker.setDialogMessage(BundleUtils.getLocalizedMessage("record.deleting"));
        worker.execute(true, SwingWorkerWithWaitingDialog.HIDE_AFTER_DONE);
    }
}
