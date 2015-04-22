
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
import org.chorke.ficon.gui.utils.GuiUtils.EventType;
import org.chorke.ficon.gui.utils.Utils;
import org.chorke.ficon.gui.utils.exceptions.ObjectManipulationException;


/**
 *
 * @author Chorke
 */
public class LogInPanel extends BasicPanel{

    private JComboBox<ListItem<Long, String>> list;
    private DefaultComboBoxModel<ListItem<Long, String>> listModel;
    private Map<Long, String> users;
    private JButton logInButton;
    private JButton addUserButton;
    private JButton deleteUserButton;
    
    LogInPanel() {
        super();
        init();
    }
    
    private void init(){
        list = new JComboBox<>();
        prepareList();
        logInButton = new JButton(BundleUtils.getLocalizedString("buttons.log.in"));
        logInButton.addActionListener(ListenersUtils.logInListener(this));
        
        addUserButton = new JButton(BundleUtils.getLocalizedString("buttons.user.add"));
        addUserButton.addActionListener(ListenersUtils.showAddUserWindowListener());
        
        deleteUserButton = new JButton(BundleUtils.getLocalizedString("buttons.user.delete"));
        deleteUserButton.addActionListener(ListenersUtils.deleteUserListener(this));
        
        GroupLayout gl = new GroupLayout(this);
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);
        gl.setHorizontalGroup(gl.createParallelGroup(Alignment.CENTER, false)
                .addComponent(list)
                .addGroup(gl.createSequentialGroup()
                    .addComponent(logInButton)
                    .addComponent(addUserButton)
                    .addComponent(deleteUserButton)));
        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(list)
                .addGroup(gl.createParallelGroup()
                    .addComponent(logInButton)
                    .addComponent(addUserButton)
                    .addComponent(deleteUserButton)));
        gl.linkSize(logInButton, addUserButton, deleteUserButton);
        setLayout(gl);
        addGlobalEventListener(ListenersUtils.userListChangedListener(this), EventType.USER_LIST_CHANGED);
    }
    
    public void prepareList(){
        prepareUsers();
        listModel = new DefaultComboBoxModel<>();
        for(Entry<Long, String> e : users.entrySet()){
            listModel.addElement(new ListItem<>(e.getKey(), e.getValue()));
        }
        list.setModel(listModel);
    }
    
    private void prepareUsers(){
        if(users != null){
            users.clear();
        }
        try{
            users = Utils.getActualSession().getApplicationUsersFromDB();
        } catch (ObjectManipulationException ex){
            ExceptionUtils.handleThrowable(ex, true);
            users = new HashMap<>();
        }
    }
    
    @SuppressWarnings("unchecked")
    public ListItem<Long, String> getSelectedItem(){
        return (ListItem<Long, String>)listModel.getSelectedItem();
    }
}