
package org.chorke.ficon.gui.listeners;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.chorke.ficon.gui.components.ListItem;
import org.chorke.ficon.gui.listeners.workers.LogInWorker;
import org.chorke.ficon.gui.panels.LogInPanel;
import org.chorke.ficon.gui.utils.GuiUtils;
import org.chorke.ficon.gui.windows.WindowUtils;
import org.chorke.gui.utils.worker.SwingWorkerWithWaitingDialog;

/**
 *
 * @author Chorke
 */
class LogInAction implements ActionListener {
    private final LogInPanel panel;

    LogInAction(LogInPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ListItem<Long, String> item = panel.getSelectedItem();
        Long id = item == null ? null : item.getKey();
        if(id == null){
            GuiUtils.showLocalizedMessageDialog("user.not.set", null, 
                    "user.not.set.title", null, JOptionPane.INFORMATION_MESSAGE);
        } else {
            WindowUtils.disposeWindowOfComponet((Component) e.getSource());
            LogInWorker w = new LogInWorker(id);
            w.setCancelString(ListenersUtils.CANCEL_STRING);
            w.execute(true, SwingWorkerWithWaitingDialog.HIDE_AFTER_JOB);
        }
    }
}
