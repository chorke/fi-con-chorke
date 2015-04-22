
package org.chorke.ficon.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.chorke.ficon.gui.listeners.workers.CreateUserSwingWorker;
import org.chorke.ficon.gui.panels.NewUserPanel;
import org.chorke.ficon.gui.utils.BundleUtils;
import org.chorke.gui.utils.worker.SwingWorkerWithWaitingDialog;

/**
 *
 * @author Chorke
 */
public class CreateUserListener implements ActionListener{

    private final NewUserPanel panel;

    CreateUserListener(NewUserPanel panel) {
        this.panel = panel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        CreateUserSwingWorker worker = new CreateUserSwingWorker(panel);
        worker.setCancelString(BundleUtils.getLocalizedString("buttons.cancel"));
        worker.setDialogMessage("user.creating");
        worker.execute(true, SwingWorkerWithWaitingDialog.HIDE_AFTER_JOB);
    }
}
