
package org.chorke.ficon.gui.listeners;

import java.awt.event.ActionListener;
import org.chorke.ficon.gui.panels.AccountManipulationPanel;
import org.chorke.ficon.gui.panels.AccountPanel;
import org.chorke.ficon.gui.panels.LogInPanel;
import org.chorke.ficon.gui.panels.NewUserPanel;
import org.chorke.ficon.gui.panels.RecordPanel;
import org.chorke.ficon.gui.panels.SelectAccountPanel;
import org.chorke.ficon.gui.utils.BundleUtils;
import org.chorke.gui.utils.events.GlobalEventListener;

/**
 *
 * @author Chorke
 */
public class ListenersUtils {

    static final String CANCEL_STRING = BundleUtils.getLocalizedString("buttons.cancel");


    private ListenersUtils() {}

    public static ActionListener logInListener(LogInPanel panel){
        return new LogInAction(panel);
    }
    
    public static ActionListener selectAccountListener(SelectAccountPanel panel){
        return new SelectAccountListener(panel);
    }
    
    public static ActionListener showSelectAccountWindowListener(){
        return new ShowSelectAccountWindowListener();
    }
    
    public static ActionListener showNewAccountWindowListener(){
        return new ShowNewAccountWindowListener();
    }
    
    public static ActionListener showUpdateAccountWindowListener(){
        return new ShowUpdateAccountWindowListener();
    }
    
    public static ActionListener deleteAccountListener(){
        return new DeleteAccountListener();
    }
    
    public static ActionListener showNewTransactionWindowListener(){
        return new ShowNewTransactionWindowListener();
    }
    
    public static ActionListener deleteTransactionListener(){
        return new DeleteTransactionListener();
    }
    
    public static ActionListener showUpdateTransactionWindowListener(){
        return new ShowUpdateTransactionWindowListener();
    }
    
    public static ActionListener showAssociatedTransactionListener(){
        return new ShowAssociatedTransactionListener();
    }
    
    public static ActionListener showTransferMoneyWindowListener(){
        return new ShowTransferMoneyWindowListener();
    }
    
    public static ActionListener loadHistoryListener(AccountManipulationPanel panel){
        return new LoadHistoryListener(panel);
    }
    
    public static ActionListener logOutListener(){
        return new LogOutListener();
    }
    
    public static ActionListener showLogInWindowListener(){
        return new LogOutListener();
    }
    
    public static ActionListener showAddUserWindowListener(){
        return new ShowNewUserWindowListener();
    }
    
    public static ActionListener createUserListener(NewUserPanel panel){
        return new CreateUserListener(panel);
    }
    
    public static ActionListener deleteUserListener(LogInPanel panel) {
        return new DeleteUserListener(panel);
    }
    
    public static ActionListener exitListener(){
        return new ExitListener();
    }
    
    public static ActionListener createUpdateAccountListener(boolean create, AccountPanel infoPanel){
        return new CreateUpdateAccountListener(create, infoPanel);
    }
    
    public static GlobalEventListener recordSelectedListener(RecordPanel record){
        return new RecordSelectedListener(record);
    }
    
    public static GlobalEventListener accountChangedListener(AccountManipulationPanel panel){
        return new AccountChangedListener(panel);
    }
    
    public static GlobalEventListener historyLoadedListener(AccountManipulationPanel panel){
        return new HistoryLoadedListener(panel);
    }
    
    public static GlobalEventListener userListChangedListener(LogInPanel panel){
        return new UserListChangedListener(panel);
    }
    
    public static ActionListener disposeWindowListener(){
        return new DisposeWindowListener();
    }

    public static ActionListener createUpdateRecordListener(boolean create, RecordPanel transactionPanel) {
        return new CreateUpdateRecordListener(create, transactionPanel);
    }
}

    