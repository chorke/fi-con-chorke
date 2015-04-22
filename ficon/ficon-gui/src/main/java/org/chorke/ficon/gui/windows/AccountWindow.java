
package org.chorke.ficon.gui.windows;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.chorke.ficon.api.objects.Account;
import org.chorke.ficon.gui.listeners.ListenersUtils;
import org.chorke.ficon.gui.panels.AccountPanel;
import org.chorke.ficon.gui.panels.PanelUtils;
import org.chorke.ficon.gui.utils.BundleUtils;

/**
 *
 * @author Chorke
 */
public class AccountWindow extends BasicWindow{

    private AccountPanel infoPanel;
    private JButton cancelButton;
    private JButton doActionButton;
    
    AccountWindow(Account account) {
        super(false);
        setResizable(false);
        
        if(account == null){
            doActionButton.setText(BundleUtils.getLocalizedString("buttons.create"));
            doActionButton.addActionListener(ListenersUtils.createUpdateAccountListener(true, infoPanel));
        } else {
            doActionButton.setText(BundleUtils.getLocalizedString("buttons.save"));
            doActionButton.addActionListener(ListenersUtils.createUpdateAccountListener(false, infoPanel));
        }
        
        infoPanel.fillAccountInfo(account);
    }
    
    @Override
    void init() {
        infoPanel = PanelUtils.getAccountInformationPanel(true);
        
        cancelButton = new JButton(BundleUtils.getLocalizedString("buttons.cancel"));
        cancelButton.addActionListener(ListenersUtils.disposeWindowListener());
        
        doActionButton = new JButton();
        
        JPanel mainPanel = new JPanel();
        GroupLayout gl = new GroupLayout(mainPanel);
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);
        gl.setHorizontalGroup(gl.createParallelGroup(Alignment.CENTER)
                .addComponent(infoPanel)
                .addGroup(gl.createSequentialGroup()
                    .addComponent(cancelButton)
                    .addComponent(doActionButton)));
        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(infoPanel)
                .addGroup(gl.createParallelGroup(Alignment.CENTER)
                    .addComponent(cancelButton)
                    .addComponent(doActionButton)));
        mainPanel.setLayout(gl);
        add(mainPanel);
    }
    
    @Override
    boolean disposingWindow() {
        return true;
        //TODO check if really close
    }
}
