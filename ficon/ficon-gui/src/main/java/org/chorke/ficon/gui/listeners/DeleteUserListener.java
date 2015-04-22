
package org.chorke.ficon.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.chorke.ficon.gui.listeners.workers.DeleteUserSwingWorker;
import org.chorke.ficon.gui.panels.LogInPanel;
import org.chorke.ficon.gui.utils.BundleUtils;
import org.chorke.gui.utils.worker.SwingWorkerWithWaitingDialog;

/**
 *
 * @author Chorke
 */
public class DeleteUserListener implements ActionListener{

    private final LogInPanel panel;

    DeleteUserListener(LogInPanel panel) {
        this.panel = panel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        DeleteUserSwingWorker worker = new DeleteUserSwingWorker(panel);
        worker.setCancelString(BundleUtils.getLocalizedString("buttons.cancel"));
        worker.setDialogMessage("user.deleting");
        worker.execute(true, SwingWorkerWithWaitingDialog.HIDE_AFTER_JOB);
    }

}
