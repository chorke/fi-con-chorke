
package org.chorke.ficon.gui.listeners;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.chorke.ficon.gui.utils.Utils;
import org.chorke.ficon.gui.windows.WindowUtils;

/**
 *
 * @author Chorke
 */
class LogOutListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Utils.getActualSession().logOutUser();
        WindowUtils.disposeWindowOfComponet((Component) e.getSource());
        WindowUtils.getLogInWindow().setVisible(true);
    }
}
