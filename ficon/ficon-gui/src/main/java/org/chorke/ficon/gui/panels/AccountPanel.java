
package org.chorke.ficon.gui.panels;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.text.PlainDocument;
import org.chorke.ficon.api.objects.Account;
import org.chorke.ficon.gui.panels.filters.LengthDocumentFilter;
import org.chorke.ficon.gui.utils.BundleUtils;
import org.chorke.ficon.gui.utils.Utils.MaxLength;

/**
 *
 * @author Chorke
 */
public class AccountPanel extends BasicPanel{

    private boolean editable;
    private JTextField accountName;
    private JTextArea accountDescription;
    private JTextField accountCurrency;
    
    private JLabel accountNameLabel;
    private JLabel accountDescriptionLabel;
    private JLabel accountCurrencyLabel;
    
    AccountPanel(boolean editable) {
        super();
        this.editable = editable;
        init();
    }
    
    private void init(){
        accountName = new JTextField();
        accountName.setEditable(editable);
        PlainDocument doc = new PlainDocument();
        doc.setDocumentFilter(new LengthDocumentFilter(MaxLength.NAME_ACCOUNT));
        accountName.setDocument(doc);
        
        accountDescription = new JTextArea();
        accountDescription.setEditable(editable);
        
        accountDescription.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        accountDescription.setWrapStyleWord(true);
        accountDescription.setLineWrap(true);
        
        accountCurrency = new JTextField();
        accountCurrency.setEditable(editable);
        
        if(!editable){
            accountName.setBorder(null);
            accountName.setBackground(getBackground());
            Font f = accountName.getFont();
            accountName.setFont(new Font(f.getName(), f.getStyle(), 25));

            accountDescription.setBackground(getBackground());
        
            accountCurrency.setBorder(null);
            accountCurrency.setBackground(getBackground());
        }
        
        accountCurrencyLabel = new JLabel(BundleUtils.getLocalizedString("labels.currency"));
        accountDescriptionLabel = new JLabel(BundleUtils.getLocalizedString("labels.description"));
        accountNameLabel = new JLabel(BundleUtils.getLocalizedString("labels.name"));
        
        GroupLayout gl = new GroupLayout(this);
        gl.setAutoCreateContainerGaps(false);
        gl.setAutoCreateGaps(true);
        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup()
                    .addGroup(gl.createSequentialGroup()
                        .addComponent(accountNameLabel)
                        .addComponent(accountName))
                    .addGroup(gl.createSequentialGroup()
                        .addComponent(accountCurrencyLabel)
                        .addComponent(accountCurrency)))
                .addGroup(gl.createSequentialGroup()
                    .addComponent(accountDescriptionLabel)
                    .addComponent(accountDescription, 90, 90, 90)));
        gl.setHorizontalGroup(gl.createParallelGroup()
                .addGroup(gl.createSequentialGroup()
                    .addGroup(gl.createParallelGroup()
                        .addComponent(accountNameLabel)
                        .addComponent(accountName))
                    .addGroup(gl.createParallelGroup()
                        .addComponent(accountCurrencyLabel)
                        .addComponent(accountCurrency, 50, 50, 50)))
                .addComponent(accountDescriptionLabel)
                .addComponent(accountDescription, 250, 300, 350));
        setLayout(gl);
    }
    
    public void fillAccountInfo(Account account){
        if (account == null) { // creating new account or no account has been set
            if(editable){
                accountName.setText("");
                accountDescription.setText("");
                accountCurrency.setText("");
            } else {
                accountName.setText(EMPTY_TEXT);
                accountDescription.setText(EMPTY_TEXT);
                accountCurrency.setText("[" + EMPTY_TEXT + "]");
            }
        } else { // update
            accountName.setText(account.getName());
            accountDescription.setText(account.getDescription());
            if(editable){
                accountCurrency.setText(account.getCurrency().getCurrencyCode());
                accountCurrency.setEditable(false); // account's currency should not be editable
            } else {
                accountCurrency.setText("[" + account.getCurrency().getCurrencyCode() + "]");
            }
        }
    }
    
    public String getAccountsName(){
        return accountName.getText();
    }
    
    public String getAccountsDescription(){
        return accountDescription.getText();
    }
    
    public String getCurrency(){
        return accountCurrency.getText();
    }
}
