
package org.chorke.ficon.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.chorke.ficon.gui.windows.WindowUtils;

/**
 *
 * @author Chorke
 */
class ShowNewAccountWindowListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        WindowUtils.getAccountWindow(null).setVisible(true);
    }
}
