
package org.chorke.ficon.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.chorke.ficon.gui.listeners.workers.CreateUpdateRecordSwingWorker;
import org.chorke.ficon.gui.panels.RecordPanel;
import org.chorke.ficon.gui.utils.BundleUtils;
import org.chorke.gui.utils.worker.SwingWorkerWithWaitingDialog;

/**
 *
 * @author Chorke
 */
class CreateUpdateRecordListener implements ActionListener{

    private final boolean create;
    private final RecordPanel panel;

    CreateUpdateRecordListener(boolean create, RecordPanel panel) {
        this.create = create;
        this.panel = panel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        CreateUpdateRecordSwingWorker worker = new CreateUpdateRecordSwingWorker(create, panel);
        worker.setCancelString(BundleUtils.getLocalizedString("buttons.cancel"));
        if(create){
            System.out.println("create");
            worker.setDialogMessage(BundleUtils.getLocalizedMessage("record.creating"));
        } else {
            System.out.println("update");
            worker.setDialogMessage(BundleUtils.getLocalizedMessage("record.updating"));
        }
        worker.execute(true, SwingWorkerWithWaitingDialog.HIDE_AFTER_DONE);
    }
}
