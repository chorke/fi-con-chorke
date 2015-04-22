
package org.chorke.ficon.gui.listeners;

import org.chorke.ficon.gui.panels.RecordPanel;
import org.chorke.ficon.gui.utils.Utils;
import org.chorke.gui.utils.events.GlobalEvent;
import org.chorke.gui.utils.events.GlobalEventListener;

/**
 *
 * @author Chorke
 */
class RecordSelectedListener implements GlobalEventListener{

    private final RecordPanel recordPanel;

    RecordSelectedListener(RecordPanel recordPanel) {
        this.recordPanel = recordPanel;
    }
    
    @Override
    public void handleGlobalEvent(GlobalEvent event) {
        recordPanel.fillRecordsInfo(Utils.getActualSession().getActualRecord());
    }
}
