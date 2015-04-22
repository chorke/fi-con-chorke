
package org.chorke.ficon.gui.listeners.workers;

import javax.swing.JOptionPane;
import org.chorke.ficon.api.objects.User;
import org.chorke.ficon.gui.panels.NewUserPanel;
import org.chorke.ficon.gui.utils.ExceptionUtils;
import org.chorke.ficon.gui.utils.GuiUtils;
import org.chorke.ficon.gui.utils.Utils;
import org.chorke.ficon.gui.windows.WindowUtils;
import org.chorke.gui.utils.worker.SwingWorkerWithWaitingDialog;

/**
 *
 * @author Chorke
 */
public class CreateUserSwingWorker extends SwingWorkerWithWaitingDialog<Boolean, Void>{

    private final NewUserPanel panel;

    public CreateUserSwingWorker(NewUserPanel panel) {
        this.panel = panel;
    }

    @Override
    public Boolean doYourJob() throws Exception {
        String name = panel.getEnteredName();
        if(name == null || name.isEmpty()){
            GuiUtils.showLocalizedMessageDialog("user.name.not.set", null, 
                    "user.name.not.set.title", null, JOptionPane.INFORMATION_MESSAGE);
            return Boolean.FALSE;
        }
        User user = new User();
        user.setName(name);
        Utils.getActualSession().createUser(user);
        return Boolean.TRUE;
    }
    

    @Override
    @SuppressWarnings("UseSpecificCatch")
    public void jobIsDone() {
        try{
            if(get()){
                Utils.getActualSession().userCreated();
                WindowUtils.disposeWindowOfComponet(panel);
            }
        } catch (Throwable t){
            ExceptionUtils.handleThrowable(t, true);
        }
    }

    @Override
    public void cancelInvoked() {
        Utils.getActualSession().cancelAllDBOperations();
    }
}
