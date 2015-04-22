package org.chorke.ficon.gui;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.SwingUtilities;
import org.chorke.ficon.gui.utils.Session;
import org.chorke.ficon.gui.utils.Utils;
import org.chorke.ficon.gui.windows.WindowUtils;

/**
 *
 *
 */
public class Main {
    
    public static void main( String[] args ) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                prepareApp();
                runApp();
            }
        });
    }
    
    private static void prepareApp(){
        Utils.setSession(new Session(Session.Locales.sk_SK));
    }
    
    private static void runApp(){
        WindowUtils.getLogInWindow().setVisible(true);
    }
}
