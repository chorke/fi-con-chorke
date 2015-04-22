
package org.chorke.ficon.gui.utils;

import java.awt.Component;
import javax.swing.JOptionPane;
import org.chorke.gui.utils.events.GedUtils;
import org.chorke.gui.utils.events.GlobalEventListener;


/**
 *
 * @author Chorke
 */
public class GuiUtils {

    public static interface EventType {
        public static final int ACCOUNT_CHANGED = 0;
        public static final int RECORD_CHANGED = 1;
        public static final int HISTORY_LOADED = 2;
        public static final int LOG_IN = 3;
        public static final int LOG_OUT = 4;
        public static final int USER_LIST_CHANGED = 5;
        public static final int EXIT_APPLICATION = 6;
        
        static final int[] ALL_EVENTS = new int[] {ACCOUNT_CHANGED, RECORD_CHANGED,
            HISTORY_LOADED, LOG_IN, LOG_OUT, USER_LIST_CHANGED, EXIT_APPLICATION};
    }
    
    private GuiUtils(){}
    
    static{
        GedUtils.initGEDThread();
    }
    
    public static void registerForGlobalEvents(GlobalEventListener listener, int eventType){
        GedUtils.register(listener, eventType);
    }
    
    public static void registerForGlobalEvents(GlobalEventListener listener){
        for(int i : EventType.ALL_EVENTS){
            GedUtils.register(listener, i);
        }
    }
    
    public static void unregisterForGlobalEvents(GlobalEventListener listener, int eventType){
        GedUtils.unregister(listener, eventType);
    }
    
    public static void unregisterForGlobalEvents(GlobalEventListener listener){
        for(int i : EventType.ALL_EVENTS){
            GedUtils.unregister(listener, i);
        }
    }
    
    static void fireAccountChangeEvent(Object source){
        GedUtils.fireEvent(source, EventType.ACCOUNT_CHANGED);
    }
    
    static void fireRecordChangeEvent(Object source){
        GedUtils.fireEvent(source, EventType.RECORD_CHANGED);
    }
    
    static void fireLogInEvent(Object source){
        GedUtils.fireEvent(source, EventType.LOG_IN);
    }
    
    static void fireLogOutEvent(Object source){
        GedUtils.fireEvent(source, EventType.LOG_OUT);
    }
    
    static void fireDeleteUser(Object source){
        GedUtils.fireEvent(source, EventType.LOG_OUT);
    }
    
    static void fireExitApplicationEvent(Object source){
        GedUtils.fireEvent(source, EventType.EXIT_APPLICATION);
    }
    
    static void fireUserListChangedEvent(Object source){
        GedUtils.fireEvent(source, EventType.USER_LIST_CHANGED);
    }
    
    static void fireHistoryLoadedEvent(Object source){
        GedUtils.fireEvent(source, EventType.HISTORY_LOADED);
    }
    
    public static int showLocalizedConfirmDialog(
            String messageKey, String additionalMessage, String titleKey,
            Component parentComponent){
        Object[] options = {BundleUtils.getLocalizedString("buttons.yes"),
                    BundleUtils.getLocalizedString("buttons.no"),
                    BundleUtils.getLocalizedString("buttons.cancel")};
        int option = JOptionPane.showOptionDialog(
                parentComponent,
                BundleUtils.getLocalizedMessage(messageKey)
                    + System.lineSeparator()
                    + (additionalMessage == null ? "" : additionalMessage),
                BundleUtils.getLocalizedString(titleKey),
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);
        if(option == 0){
            return JOptionPane.YES_OPTION;
        }
        if(option == 1){
            return JOptionPane.NO_OPTION;
        }
        if(option == 2){
            return JOptionPane.CANCEL_OPTION;
        }
        return option;
    }
    
    public static void showLocalizedMessageDialog(String messageKey, String additionalMessage,
            String titleKey, Component parentComponent, int messageType){
        JOptionPane.showMessageDialog(
                parentComponent,
                BundleUtils.getLocalizedMessage(messageKey)
                + System.lineSeparator()
                + (additionalMessage == null ? "" : additionalMessage),
                BundleUtils.getLocalizedString(titleKey),
                messageType);
    }
}
