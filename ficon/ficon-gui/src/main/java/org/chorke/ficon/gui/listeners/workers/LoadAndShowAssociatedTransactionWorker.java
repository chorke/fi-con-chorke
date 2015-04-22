
package org.chorke.ficon.gui.listeners.workers;

import javax.swing.JOptionPane;
import org.chorke.ficon.api.objects.TransactionRecord;
import org.chorke.ficon.gui.panels.PanelUtils;
import org.chorke.ficon.gui.panels.RecordPanel;
import org.chorke.ficon.gui.utils.BundleUtils;
import org.chorke.ficon.gui.utils.ExceptionUtils;
import org.chorke.ficon.gui.utils.GuiUtils;
import org.chorke.ficon.gui.utils.Utils;
import org.chorke.ficon.gui.windows.WindowUtils;
import org.chorke.gui.utils.worker.SwingWorkerWithWaitingDialog;

/**
 *
 * @author Chorke
 */
public class LoadAndShowAssociatedTransactionWorker 
            extends SwingWorkerWithWaitingDialog<TransactionRecord, Void>{

    @Override
    public TransactionRecord doYourJob() throws Exception {
        TransactionRecord rec = Utils.getActualSession().getActualRecord();
        if(rec == null){
            GuiUtils.showLocalizedMessageDialog("record.not.set", null,
                "record.not.set.title", null,
                JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        Long id = rec.getAssociatedTransactionID();
        if(id == null){
            GuiUtils.showLocalizedMessageDialog("associated.transaction.no.id", null,
                "win.transaction.title", null,
                JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        return Utils.getActualSession().getTransactionRecordFromDB(id);
    }

    @Override
    @SuppressWarnings("UseSpecificCatch")
    public void jobIsDone() {
        try{
            TransactionRecord record = get();
            if(record == null){
                return;
            }
            RecordPanel panel = PanelUtils.getRecordPanel(false);
            panel.fillRecordsInfo(record);
            WindowUtils.getSimpleWindow(panel, BundleUtils.getLocalizedString(
                        "win.transaction.title"))
                    .setVisible(true);
        } catch (Throwable ex){
            ExceptionUtils.handleThrowable(ex, true);
        }
    }

    @Override
    public void cancelInvoked(){
        try{
            Utils.getActualSession().cancelAllDBOperations();
        } catch (Throwable t){
            ExceptionUtils.handleThrowable(t, true);
        }
    }
}
