
package org.chorke.ficon.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.chorke.ficon.gui.listeners.workers.CreateUpdateAccountSwingWorker;
import org.chorke.ficon.gui.panels.AccountPanel;
import org.chorke.ficon.gui.utils.BundleUtils;
import org.chorke.gui.utils.worker.SwingWorkerWithWaitingDialog;

/**
 *
 * @author Chorke
 */
class CreateUpdateAccountListener implements ActionListener{
    
    private boolean create;
    private AccountPanel infoPanel;

    CreateUpdateAccountListener(boolean create, AccountPanel infoPanel) {
        this.create = create;
        this.infoPanel = infoPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CreateUpdateAccountSwingWorker worker = new CreateUpdateAccountSwingWorker(create, infoPanel);
        worker.setCancelString(BundleUtils.getLocalizedString("buttons.cancel"));
        if(create){
            System.out.println("create");
            worker.setDialogMessage(BundleUtils.getLocalizedMessage("account.creating"));
        } else {
            System.out.println("update");
            worker.setDialogMessage(BundleUtils.getLocalizedMessage("account.updating"));
        }
        worker.execute(true, SwingWorkerWithWaitingDialog.HIDE_AFTER_DONE);
    }
}
