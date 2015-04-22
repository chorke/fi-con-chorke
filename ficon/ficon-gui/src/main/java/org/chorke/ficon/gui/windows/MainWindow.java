
package org.chorke.ficon.gui.windows;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.chorke.ficon.gui.listeners.ListenersUtils;
import org.chorke.ficon.gui.panels.AccountManipulationPanel;
import org.chorke.ficon.gui.panels.MenuPanel;
import org.chorke.ficon.gui.panels.PanelUtils;
import org.chorke.ficon.gui.panels.RecordPanel;
import org.chorke.ficon.gui.utils.GuiUtils.EventType;
import org.chorke.ficon.gui.utils.Utils;
import org.chorke.gui.utils.panels.NotesPanel;


/**
 *
 * @author Chorke
 */
public class MainWindow extends BasicWindow{

    private MenuPanel menu;
    private AccountManipulationPanel account;
    private RecordPanel record;
    private NotesPanel notes;
    
    MainWindow(){
        super(true);
    }
    
    @Override
    protected void init(){
        JPanel mainPanel = new JPanel();
        menu = PanelUtils.getMenuPanel();
        account = PanelUtils.getAccountPanel();
        account.addGlobalEventListener(ListenersUtils.accountChangedListener(account), EventType.ACCOUNT_CHANGED);
        account.addGlobalEventListener(ListenersUtils.historyLoadedListener(account), EventType.HISTORY_LOADED);
        account.fillAccountsInfo(null);
        account.fillAccountsRecords(null);
        record = PanelUtils.getRecordPanel(false);
        record.addGlobalEventListener(ListenersUtils.recordSelectedListener(record), EventType.RECORD_CHANGED);
        record.fillRecordsInfo(null);
        notes = new NotesPanel(null); // TODO set up file
        JScrollPane notesPane = new JScrollPane(notes);
        GroupLayout gl = new GroupLayout(mainPanel);
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);
        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(menu)
                .addComponent(account)
                .addGroup(gl.createParallelGroup(Alignment.LEADING, false)
                    .addComponent(notesPane)
                    .addComponent(record)));
        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(menu)
                .addComponent(account)
                .addGroup(gl.createSequentialGroup()
                    .addComponent(notesPane)
                    .addComponent(record)));
        mainPanel.setLayout(gl);
        JScrollPane pane = new JScrollPane(mainPanel);
        add(pane);
    }

    @Override
    boolean disposingWindow() {
        Utils.getActualSession().logOutUser();
        return true;
    }
}
