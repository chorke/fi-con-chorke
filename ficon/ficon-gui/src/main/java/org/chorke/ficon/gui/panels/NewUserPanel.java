
package org.chorke.ficon.gui.panels;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import org.chorke.ficon.gui.listeners.ListenersUtils;
import org.chorke.ficon.gui.utils.BundleUtils;

/**
 *
 * @author Chorke
 */
public class NewUserPanel extends BasicPanel {

    private JButton addButton;
    private JButton cancelButton;
    private JTextField nameField;
    
    NewUserPanel() {
        super();
        init();
    }
    
    private void init(){
        addButton = new JButton(BundleUtils.getLocalizedString("buttons.create"));
        addButton.addActionListener(ListenersUtils.createUserListener(this));
        
        cancelButton = new JButton(BundleUtils.getLocalizedString("buttons.cancel"));
        cancelButton.addActionListener(ListenersUtils.showLogInWindowListener());
        
        nameField = new JTextField();
        
        GroupLayout gl = new GroupLayout(this);
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);
        gl.setHorizontalGroup(gl.createParallelGroup(Alignment.CENTER)
                .addComponent(nameField)
                .addGroup(gl.createSequentialGroup()
                    .addComponent(addButton)
                    .addComponent(cancelButton)));
        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(nameField)
                .addGroup(gl.createParallelGroup()
                    .addComponent(addButton)
                    .addComponent(cancelButton)));
        gl.linkSize(addButton, cancelButton);
        setLayout(gl);
    }
    
    public String getEnteredName(){
        return nameField.getText();
    }
}
