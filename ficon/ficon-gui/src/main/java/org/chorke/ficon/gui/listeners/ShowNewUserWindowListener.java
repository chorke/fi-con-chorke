
package org.chorke.ficon.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import org.chorke.ficon.gui.panels.PanelUtils;
import org.chorke.ficon.gui.utils.BundleUtils;
import org.chorke.ficon.gui.windows.WindowUtils;

/**
 *
 * @author Chorke
 */
public class ShowNewUserWindowListener implements ActionListener{

    ShowNewUserWindowListener() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        WindowUtils.getSimpleWindow(PanelUtils.getNewUserPanel(),
                    BundleUtils.getLocalizedString("user.new"), false,
                    JFrame.DISPOSE_ON_CLOSE)
                .setVisible(true);
    }
    
}
