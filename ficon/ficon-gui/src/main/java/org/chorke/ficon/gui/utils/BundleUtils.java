
package org.chorke.ficon.gui.utils;

import java.util.ResourceBundle;

/**
 *
 * @author Chorke
 */
public class BundleUtils {

    private static ResourceBundle bundleStrings = 
            ResourceBundle.getBundle("properties/I18N_strings", Utils.getActualSession().getLocale());
    private static ResourceBundle bundleMessages =
            ResourceBundle.getBundle("properties/I18N_messages", Utils.getActualSession().getLocale());
    
    private BundleUtils(){};
    
    public static String getLocalizedString(String key){
        return bundleStrings.getString(key);
    }
    
    public static String getLocalizedMessage(String key){
        return bundleMessages.getString(key);
    }
}
