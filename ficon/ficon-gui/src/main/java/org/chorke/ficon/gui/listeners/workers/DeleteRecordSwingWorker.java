
package org.chorke.ficon.gui.listeners.workers;

import javax.swing.JOptionPane;
import org.chorke.ficon.api.objects.TransactionRecord;
import org.chorke.ficon.gui.utils.ExceptionUtils;
import org.chorke.ficon.gui.utils.GuiUtils;
import org.chorke.ficon.gui.utils.Session;
import org.chorke.ficon.gui.utils.Utils;
import org.chorke.gui.utils.worker.SwingWorkerWithWaitingDialog;

/**
 *
 * @author Chorke
 */
public class DeleteRecordSwingWorker extends SwingWorkerWithWaitingDialog<Void, Void>{
    
    @Override
    public Void doYourJob() throws Exception {
        Session ses = Utils.getActualSession();
        TransactionRecord record = ses.getActualRecord();
        if(record == null){
            GuiUtils.showLocalizedMessageDialog("record.not.set", null, "record.not.set.title",
                    null, JOptionPane.INFORMATION_MESSAGE);
        } else {
            int ret = GuiUtils.showLocalizedConfirmDialog("record.confirm.delete",
                    record.getName(), "record.delete", null);
            if(ret == JOptionPane.YES_OPTION){
                ses.deleteActualRecord();
            }
        }
        return null;
    }

    @Override
    @SuppressWarnings(value = "UseSpecificCatch")
    public void jobIsDone() {
        try {
            get();
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
