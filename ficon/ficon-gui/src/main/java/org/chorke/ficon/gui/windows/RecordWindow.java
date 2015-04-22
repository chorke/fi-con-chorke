
package org.chorke.ficon.gui.windows;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.chorke.ficon.api.objects.TransactionRecord;
import org.chorke.ficon.gui.listeners.ListenersUtils;
import org.chorke.ficon.gui.panels.PanelUtils;
import org.chorke.ficon.gui.panels.RecordPanel;
import org.chorke.ficon.gui.utils.BundleUtils;

/**
 *
 * @author Chorke
 */
public class RecordWindow extends BasicWindow{

    private RecordPanel transactionPanel;
    private JButton cancelButton;
    private JButton doActionButton;
    
    RecordWindow(TransactionRecord record) {
        super(false);
        if(record == null){
            doActionButton.setText(BundleUtils.getLocalizedString("buttons.create"));
            doActionButton.addActionListener(
                    ListenersUtils.createUpdateRecordListener(true, transactionPanel));
        } else {
            transactionPanel.fillRecordsInfo(record);
            doActionButton.setText(BundleUtils.getLocalizedString("buttons.save"));
            doActionButton.addActionListener(
                    ListenersUtils.createUpdateRecordListener(false, transactionPanel));
        }
    }
    
    @Override
    void init() {
        transactionPanel = PanelUtils.getRecordPanel(true);
        
        cancelButton = new JButton(BundleUtils.getLocalizedString("buttons.cancel"));
        cancelButton.addActionListener(ListenersUtils.disposeWindowListener());
        
        doActionButton = new JButton();
        
        JPanel mainPanel = new JPanel();
        GroupLayout gl = new GroupLayout(mainPanel);
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);
        gl.setHorizontalGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(transactionPanel)
                .addGroup(gl.createSequentialGroup()
                    .addComponent(cancelButton)
                    .addComponent(doActionButton)));
        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(transactionPanel)
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(cancelButton)
                    .addComponent(doActionButton)));
        mainPanel.setLayout(gl);
        add(mainPanel);
    }

    @Override
    boolean disposingWindow() {
        return true;
        //TODO
    }
}
