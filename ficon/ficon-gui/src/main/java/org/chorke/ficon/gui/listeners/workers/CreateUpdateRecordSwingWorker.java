
package org.chorke.ficon.gui.listeners.workers;

import java.math.BigDecimal;
import java.text.ParseException;
import javax.swing.JOptionPane;
import org.chorke.ficon.api.objects.TransactionRecord;
import org.chorke.ficon.gui.panels.RecordPanel;
import org.chorke.ficon.gui.utils.ExceptionUtils;
import org.chorke.ficon.gui.utils.GuiUtils;
import org.chorke.ficon.gui.utils.Session;
import org.chorke.ficon.gui.utils.Utils;
import org.chorke.ficon.gui.utils.exceptions.ObjectManipulationException;
import org.chorke.ficon.gui.windows.WindowUtils;
import org.chorke.gui.utils.worker.SwingWorkerWithWaitingDialog;

/**
 *
 * @author Chorke
 */
public class CreateUpdateRecordSwingWorker extends SwingWorkerWithWaitingDialog<TransactionRecord, Void>{

    private final boolean create;
    private final RecordPanel panel;

    public CreateUpdateRecordSwingWorker(boolean create, RecordPanel panel) {
        this.create = create;
        this.panel = panel;
    }
    
    @Override
    public TransactionRecord doYourJob() throws Exception {
        if (Utils.getActualSession().getActualAccount() == null) {
            GuiUtils.showLocalizedMessageDialog("account.not.set",
                    null, "account.not.set.title",
                    null, JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        if (create) {
            return createAction();
        } else {
            return updateAction();
        }
    }

    private TransactionRecord createAction() throws ParseException, ObjectManipulationException{
        Session ses = Utils.getActualSession();
        TransactionRecord record = new TransactionRecord(ses.getActualAccount().getId());
        setUpRecord(record);
        return ses.createRecord(record);
    }

    private TransactionRecord updateAction() throws ParseException, ObjectManipulationException{
        Session ses = Utils.getActualSession();
        TransactionRecord record = ses.getActualRecord();
        if(record == null){
            if (Utils.getActualSession().getActualAccount() == null) {
                GuiUtils.showLocalizedMessageDialog("record.not.set",
                        null, "record.not.set.title",
                        null, JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
        }
        setUpRecord(record);
        return ses.updateRecord(record);
    }
    
    private void setUpRecord(TransactionRecord record) throws ParseException{
        record.setName(panel.getRecordsName());
        record.setDescription(panel.getRecordsDescription());
        record.setAmount(new BigDecimal(panel.getAmount()));
        record.setTransactionTime(panel.getTime());
    }

    @Override
    @SuppressWarnings(value = "UseSpecificCatch")
    public void jobIsDone() {
        try {
            TransactionRecord record = get();
            if(record != null){
                Utils.getActualSession().addRecordToActualAccount(record);
            }
            WindowUtils.getWindowOfComponent(panel).dispose();
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
