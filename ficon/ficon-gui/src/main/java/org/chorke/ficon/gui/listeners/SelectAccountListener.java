
package org.chorke.ficon.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.chorke.ficon.gui.listeners.workers.SelectAccountSwingWorker;
import org.chorke.ficon.gui.panels.SelectAccountPanel;
import org.chorke.ficon.gui.utils.BundleUtils;
import org.chorke.gui.utils.worker.SwingWorkerWithWaitingDialog;

/**
 *
 * @author Chorke
 */
public class SelectAccountListener implements ActionListener{

    private final SelectAccountPanel panel;

    SelectAccountListener(SelectAccountPanel panel) {
        this.panel = panel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        SelectAccountSwingWorker worker = new SelectAccountSwingWorker(panel);
        worker.setCancelString(BundleUtils.getLocalizedString("buttons.cancel"));
        worker.setDialogMessage(BundleUtils.getLocalizedMessage("account.loading"));
        worker.execute(true, SwingWorkerWithWaitingDialog.HIDE_AFTER_DONE);
    }
}
