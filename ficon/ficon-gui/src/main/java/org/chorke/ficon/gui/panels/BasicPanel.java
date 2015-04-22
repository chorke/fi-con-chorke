
package org.chorke.ficon.gui.panels;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.swing.JPanel;
import org.chorke.ficon.gui.utils.GuiUtils;
import org.chorke.gui.utils.events.GlobalEventListener;

/**
 *
 * @author Chorke
 */
public class BasicPanel extends JPanel{

    protected static final String EMPTY_TEXT = "---";
    
    protected static final Integer ALL_EVENTS_KEY = null;
    
    private Map<Integer, Set<GlobalEventListener>> globalListeners = new HashMap<>();

    BasicPanel() {
        super();
    }
    
    public void addGlobalEventListener(GlobalEventListener listener){
        if(listener != null){
            addListenerInternal(ALL_EVENTS_KEY, listener);
            GuiUtils.registerForGlobalEvents(listener);
        }
    }
    
    public void addGlobalEventListener(GlobalEventListener listener, int eventType){
        if(listener != null){
            addListenerInternal(eventType, listener);
            GuiUtils.registerForGlobalEvents(listener, eventType);
        }
    }
    
    private void addListenerInternal(Integer key, GlobalEventListener listener){
        Set<GlobalEventListener> set = globalListeners.get(key);
        if(set == null){
            set = new HashSet<>();
            globalListeners.put(key, set);
        }
        set.add(listener);
    }
    
    public void removeGlobalEventListener(GlobalEventListener listener){
        removeListenerInternal(listener, null, true);
    }
    
    public void removeGlobalEventListener(GlobalEventListener listener, int eventType){
        removeListenerInternal(listener, eventType, true);
    }
    
    /**
     * 
     * @param listener
     * @param eventType
     * @param removeIfEmptySet because of java.util.ConcurrentModificationException
     */
    private void removeListenerInternal(GlobalEventListener listener, Integer eventType,
            boolean removeIfEmptySet){
        if(listener != null){
            Set<GlobalEventListener> set = globalListeners.get(eventType);
            if(set != null){
                set.remove(listener);
                if(removeIfEmptySet && set.isEmpty()){
                    globalListeners.remove(eventType);
                }
            }
            if(eventType == ALL_EVENTS_KEY){
                GuiUtils.unregisterForGlobalEvents(listener);
            } else {
                GuiUtils.unregisterForGlobalEvents(listener, eventType);
            }
        }
    }
    
    public Map<Integer, Set<GlobalEventListener>> getAllGlobalEventListeners(){
        return globalListeners;
    }

    @Override
    public void removeNotify() {
        for(Entry<Integer, Set<GlobalEventListener>> e : globalListeners.entrySet()){
            for(GlobalEventListener l : e.getValue()){
                removeListenerInternal(l, e.getKey(), false);
            }
        }
        globalListeners.clear();
        super.removeNotify();
    }
}
