
package org.chorke.ficon.gui.listeners;

import org.chorke.ficon.gui.panels.LogInPanel;
import org.chorke.ficon.gui.utils.GuiUtils.EventType;
import org.chorke.gui.utils.events.GlobalEvent;
import org.chorke.gui.utils.events.GlobalEventListener;

/**
 *
 * @author Chorke
 */
public class UserListChangedListener implements GlobalEventListener{

    private final LogInPanel panel;

    UserListChangedListener(LogInPanel panel) {
        this.panel = panel;
    }
    
    @Override
    public void handleGlobalEvent(GlobalEvent event) {
        if(event.getEventType() == EventType.USER_LIST_CHANGED){
            panel.prepareList();
        }
    }
}
