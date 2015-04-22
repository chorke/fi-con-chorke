
package org.chorke.ficon.gui.panels;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import org.chorke.ficon.gui.components.ListItem;
import org.chorke.ficon.gui.listeners.ListenersUtils;
import org.chorke.ficon.gui.utils.BundleUtils;
import org.chorke.ficon.gui.utils.ExceptionUtils;
import org.chorke.ficon.gui.utils.Utils;
import org.chorke.ficon.gui.utils.exceptions.ObjectManipulationException;

/**
 *
 * @author Chorke
 */
public class SelectAccountPanel extends BasicPanel {
    
    private JComboBox<ListItem<Long, String>> accounts;
    private DefaultComboBoxModel<ListItem<Long, String>> listModel;

    private JButton selectButton;
    private JButton cancelButton;
    
    SelectAccountPanel() {
        super();
        init();
    }

    private void init(){
        prepareList();
        selectButton = new JButton(BundleUtils.getLocalizedString("buttons.account.select"));
        selectButton.addActionListener(ListenersUtils.selectAccountListener(this));
        cancelButton = new JButton(BundleUtils.getLocalizedString("buttons.cancel"));
        cancelButton.addActionListener(ListenersUtils.disposeWindowListener());
        GroupLayout gl = new GroupLayout(this);
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);
        gl.setHorizontalGroup(gl.createParallelGroup()
                .addComponent(accounts)
                .addGroup(gl.createSequentialGroup()
                    .addComponent(selectButton)
                    .addComponent(cancelButton)));
        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(accounts, 25, 25, 25)
                .addGroup(gl.createParallelGroup(Alignment.CENTER)
                    .addComponent(selectButton)
                    .addComponent(cancelButton)));
        gl.linkSize(selectButton, cancelButton);
        setLayout(gl);
    }
    
    private void prepareList(){
        Map<Long, String> accs;
        try{
            accs = Utils.getActualSession().getAccountsOfActualUserFromDB();
        } catch (ObjectManipulationException ex){
            ExceptionUtils.handleThrowable(ex, true);
            accs = new HashMap<>();
        }
        listModel = new DefaultComboBoxModel<>();
        for(Entry<Long, String> e : accs.entrySet()){
            listModel.addElement(new ListItem<>(e.getKey(), e.getValue()));
        }
        accounts = new JComboBox<>(listModel);
    }
    
    @SuppressWarnings("unchecked")
    public Long getSelectedAccountID(){
        ListItem<Long, String> item = ((ListItem<Long, String>)listModel.getSelectedItem());
        return item == null ? null : item.getKey();
    }
}
