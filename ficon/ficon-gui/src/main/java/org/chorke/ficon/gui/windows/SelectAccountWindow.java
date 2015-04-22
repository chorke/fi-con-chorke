
package org.chorke.ficon.gui.windows;

import org.chorke.ficon.gui.panels.PanelUtils;
import org.chorke.ficon.gui.utils.BundleUtils;

/**
 *
 * @author Chorke
 */
public class SelectAccountWindow extends BasicWindow{

    SelectAccountWindow(boolean exitOnClose) {
        super(exitOnClose);
    }

    @Override
    boolean disposingWindow() {
        return true;
    }

    @Override
    void init() {
        setTitle(BundleUtils.getLocalizedString("win.select.account.title"));
        setResizable(false);
        add(PanelUtils.getSelectAccountPanel());
    }
}
