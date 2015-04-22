
package org.chorke.ficon.gui.windows;

import java.awt.Component;
import java.awt.Container;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.chorke.ficon.api.objects.Account;
import org.chorke.ficon.api.objects.TransactionRecord;

/**
 *
 * @author Chorke
 */
public class WindowUtils {

    private static final List<Window> windows = new ArrayList<>();
    
    private WindowUtils(){} //private constructor
    
    public static MainWindow getMainWindow(){
        MainWindow w = new MainWindow();
        windows.add(w);
        return w;
    }
    
    public static LogInWindow getLogInWindow(){
        LogInWindow w = new LogInWindow();
        windows.add(w);
        return w;
    }
    
    public static SelectAccountWindow getSelectAccountWindow(){
        SelectAccountWindow w = new SelectAccountWindow(false);
        windows.add(w);
        return w;
    }
    
    public static AccountWindow getAccountWindow(Account account){
        AccountWindow w = new AccountWindow(account);
        windows.add(w);
        return w;
    }
    
    public static RecordWindow getRecordWindowWindow(TransactionRecord record){
        RecordWindow w = new RecordWindow(record);
        windows.add(w);
        return w;
    }
    
    public static JFrame getSimpleWindow(JPanel content){
        return getSimpleWindow(content, null);
    }
    
    public static JFrame getSimpleWindow(JPanel content, String title){
        return getSimpleWindow(content, title, false, JFrame.DISPOSE_ON_CLOSE);
    }
    
    public static JFrame getSimpleWindow(JPanel content,
            String title, boolean resizable, int defaultCloseOperation){
        JFrame frame = new JFrame(title);
        frame.add(content);
        frame.setResizable(resizable);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(defaultCloseOperation);
        return frame;
    }
    
    public static void closeAllWindows(){
        for(Window w : windows){
            if(w != null && w.isDisplayable()){
                w.dispose();
            }
        }
    }
    
    public static void disposeWindowOfComponet(Component c){
        if(c == null){
            return;
        }
        Window w = getWindowOfComponent(c);
        if(w != null){
            w.dispose();
        }
    }
    
    public static Window getWindowOfComponent(Component c){
        if(c == null){
            return null;
        }
        Container container = c.getParent();
        while(container != null && !(container instanceof Window)){
            container = container.getParent();
        }
        return (Window)container;
    }
}
