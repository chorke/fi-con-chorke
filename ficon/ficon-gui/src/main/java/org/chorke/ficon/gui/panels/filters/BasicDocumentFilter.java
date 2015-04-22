
package org.chorke.ficon.gui.panels.filters;

import java.awt.Toolkit;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author Chorke
 */
public abstract class BasicDocumentFilter extends DocumentFilter {

    private StringBuilder getStringBuilder(FilterBypass fb) throws BadLocationException {
        Document doc = fb.getDocument();
        return new StringBuilder(doc.getText(0, doc.getLength()));
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        StringBuilder sb = getStringBuilder(fb);
        sb.insert(offset, string);
        if (pass(sb.toString())) {
            super.insertString(fb, offset, string, attr);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        StringBuilder sb = getStringBuilder(fb);
        sb.delete(offset, offset + length);
        if (pass(sb.toString())) {
            super.remove(fb, offset, length);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        StringBuilder sb = getStringBuilder(fb);
        sb.replace(offset, offset + length, text);
        if (pass(sb.toString())) {
            super.replace(fb, offset, length, text, attrs);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    protected abstract boolean pass(String str);
}
