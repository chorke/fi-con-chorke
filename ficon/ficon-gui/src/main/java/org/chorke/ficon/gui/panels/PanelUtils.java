
package org.chorke.ficon.gui.panels;

/**
 *
 * @author Chorke
 */
public class PanelUtils {

    private PanelUtils() {}

    public static AccountManipulationPanel getAccountPanel(){
        return new AccountManipulationPanel();
    }
    
    public static LogInPanel getLogInPanel(){
        return new LogInPanel();
    }
    
    public static MenuPanel getMenuPanel(){
        return new MenuPanel();
    }
    
    public static RecordPanel getRecordPanel(boolean editable){
        return new RecordPanel(editable);
    }
    
    public static AccountPanel getAccountInformationPanel(boolean editable){
        return new AccountPanel(editable);
    }
    
    public static NewUserPanel getNewUserPanel(){
        return new NewUserPanel();
    }
    
    public static SelectAccountPanel getSelectAccountPanel(){
        return new SelectAccountPanel();
    }
}
