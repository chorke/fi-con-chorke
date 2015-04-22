
package org.chorke.ficon.gui.windows;

import org.chorke.ficon.gui.panels.PanelUtils;
import org.chorke.ficon.gui.utils.BundleUtils;

/**
 *
 * @author Chorke
 */
public class LogInWindow extends BasicWindow{

    LogInWindow() {
        super(true);
    }
    
    @Override
    void init(){
        setTitle(BundleUtils.getLocalizedString("win.login.title"));
        setResizable(false);
        add(PanelUtils.getLogInPanel());
    }

    @Override
    boolean disposingWindow() {
        return true;
    }
}
