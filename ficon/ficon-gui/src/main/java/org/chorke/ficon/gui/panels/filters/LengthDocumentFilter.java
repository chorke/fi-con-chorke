
package org.chorke.ficon.gui.panels.filters;

/**
 *
 * @author Chorke
 */
public class LengthDocumentFilter extends BasicDocumentFilter{

    private final int maxLength;

    public LengthDocumentFilter(int maxLength) {
        this.maxLength = maxLength;
    }
    
    @Override
    protected boolean pass(String str) {
        return str == null ? true : (str.length() <= maxLength);
    }
}
