
package org.chorke.ficon.gui.listeners.workers;

import javax.swing.JOptionPane;
import org.chorke.ficon.gui.components.ListItem;
import org.chorke.ficon.gui.panels.LogInPanel;
import org.chorke.ficon.gui.utils.ExceptionUtils;
import org.chorke.ficon.gui.utils.GuiUtils;
import org.chorke.ficon.gui.utils.Session;
import org.chorke.ficon.gui.utils.Utils;
import org.chorke.gui.utils.worker.SwingWorkerWithWaitingDialog;

/**
 *
 * @author Chorke
 */
public class DeleteUserSwingWorker extends SwingWorkerWithWaitingDialog<Boolean, Void>{

    private final LogInPanel panel;

    public DeleteUserSwingWorker(LogInPanel panel) {
        this.panel = panel;
    }
    
    @Override
    public Boolean doYourJob() throws Exception {
        Session ses = Utils.getActualSession();
        ListItem<Long, String> item = panel.getSelectedItem();
        if(item == null){
            GuiUtils.showLocalizedMessageDialog("user.not.set", null, "user.not.set.title",
                    null, JOptionPane.INFORMATION_MESSAGE);
            return Boolean.FALSE;
        } else {
            int ret = GuiUtils.showLocalizedConfirmDialog("user.confirm.delete",
                    item.getValue(), "user.delete", null);
            if(ret == JOptionPane.YES_OPTION){
                ses.deleteUser(item.getKey());
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        }
    }

    @Override
    @SuppressWarnings(value = "UseSpecificCatch")
    public void jobIsDone() {
        try {
            if(get()){
                Utils.getActualSession().userDeleted();
            }
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
