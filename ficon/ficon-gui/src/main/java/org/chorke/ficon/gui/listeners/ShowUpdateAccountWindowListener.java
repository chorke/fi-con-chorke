
package org.chorke.ficon.gui.listeners;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.chorke.ficon.api.objects.Account;
import org.chorke.ficon.gui.utils.GuiUtils;
import org.chorke.ficon.gui.utils.Utils;
import org.chorke.ficon.gui.windows.WindowUtils;

/**
 *
 * @author Chorke
 */
class ShowUpdateAccountWindowListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Account ac = Utils.getActualSession().getActualAccount();
        if(ac == null){
            GuiUtils.showLocalizedMessageDialog("account.not.set", null, "account.not.set.title",
                    WindowUtils.getWindowOfComponent((Component)e.getSource()),
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            WindowUtils.getAccountWindow(ac).setVisible(true);
        }
    }
}
