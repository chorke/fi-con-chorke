
package org.chorke.ficon.gui.panels.filters;

/**
 *
 * @author Chorke
 */
public class NumberDocumentFilter extends BasicDocumentFilter {
    
    @Override
    protected boolean pass(String str) {
        if (str == null || str.isEmpty() 
                || "+".equals(str) || "-".equals(str)) {
            return true;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}
