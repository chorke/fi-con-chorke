
package org.chorke.ficon.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import org.chorke.ficon.gui.utils.Utils;

/**
 *
 * @author Chorke
 */
class ExitListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Utils.exitApplication((JButton) e.getSource());
    }
}
