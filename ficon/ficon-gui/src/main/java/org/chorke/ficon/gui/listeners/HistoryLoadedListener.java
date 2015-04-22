
package org.chorke.ficon.gui.listeners;

import org.chorke.ficon.gui.panels.AccountManipulationPanel;
import org.chorke.ficon.gui.utils.Utils;
import org.chorke.gui.utils.events.GlobalEvent;
import org.chorke.gui.utils.events.GlobalEventListener;

/**
 *
 * @author Chorke
 */
class HistoryLoadedListener implements GlobalEventListener {
    private final AccountManipulationPanel panel;

    HistoryLoadedListener(final AccountManipulationPanel panel) {
        this.panel = panel;
    }

    @Override
    public void handleGlobalEvent(GlobalEvent event) {
        panel.fillAccountsRecords(Utils.getActualSession().getActualAccount());
    }

}
