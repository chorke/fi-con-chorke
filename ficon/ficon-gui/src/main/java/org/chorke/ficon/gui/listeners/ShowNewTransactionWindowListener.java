
package org.chorke.ficon.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.chorke.ficon.gui.utils.GuiUtils;
import org.chorke.ficon.gui.utils.Utils;
import org.chorke.ficon.gui.windows.WindowUtils;

/**
 *
 * @author Chorke
 */
class ShowNewTransactionWindowListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Utils.getActualSession().getActualAccount() == null){
            GuiUtils.showLocalizedMessageDialog("account.not.set", null,
                    "account.not.set.title", null, JOptionPane.INFORMATION_MESSAGE);
        } else {
            WindowUtils.getRecordWindowWindow(null).setVisible(true);
        }
    }
}
