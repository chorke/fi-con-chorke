
package org.chorke.ficon.gui.panels;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import org.chorke.ficon.gui.listeners.ListenersUtils;
import org.chorke.ficon.gui.utils.BundleUtils;


/**
 *
 * @author Chorke
 */
public class MenuPanel extends BasicPanel{

    private JButton selectAccount;
    private JButton newAccount;
    private JButton updateAccount;
    private JButton deleteAccount;
    
    private JButton newTransaction;
    private JButton updateTransaction;
    private JButton deleteTransaction;
    private JButton showAssociatedTransaction;
    
    private JButton transferMoney;
    
    private JButton logout;
    private JButton exit;
    
    MenuPanel() {
        super();
        init();
    }
    
    private void init(){
        initButtons();
        final int gap = 25;
        GroupLayout gl = new GroupLayout(this);
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);
        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(selectAccount)
                .addComponent(newAccount)
                .addComponent(updateAccount)
                .addComponent(deleteAccount)
                .addGap(gap)
                .addComponent(newTransaction)
                .addComponent(updateTransaction)
                .addComponent(deleteTransaction)
                .addComponent(showAssociatedTransaction)
                .addGap(gap)
                .addComponent(transferMoney)
                .addGap(gap)
                .addComponent(logout)
                .addComponent(exit));
        gl.setHorizontalGroup(gl.createParallelGroup()
                .addComponent(selectAccount)
                .addComponent(newAccount)
                .addComponent(updateAccount)
                .addComponent(deleteAccount)
                .addComponent(newTransaction)
                .addComponent(updateTransaction)
                .addComponent(deleteTransaction)
                .addComponent(showAssociatedTransaction)
                .addComponent(transferMoney)
                .addComponent(logout)
                .addComponent(exit));
        gl.linkSize(selectAccount, newAccount, deleteAccount, updateAccount,
                newTransaction, updateTransaction, deleteTransaction,
                showAssociatedTransaction, transferMoney, logout, exit);
        setLayout(gl);
    }
    
    private void initButtons(){
        selectAccount = new JButton(BundleUtils.getLocalizedString("buttons.account.select"));
        newAccount = new JButton(BundleUtils.getLocalizedString("buttons.account.create.new"));
        updateAccount = new JButton(BundleUtils.getLocalizedString("buttons.account.update"));
        deleteAccount = new JButton(BundleUtils.getLocalizedString("buttons.account.delete"));
        newTransaction = new JButton(BundleUtils.getLocalizedString("buttons.transaction.new"));
        updateTransaction = new JButton(BundleUtils.getLocalizedString("buttons.transaction.update"));
        deleteTransaction = new JButton(BundleUtils.getLocalizedString("buttons.transaction.delete"));
        showAssociatedTransaction = new JButton(BundleUtils.getLocalizedString("buttons.transaction.show.associated"));
        transferMoney = new JButton(BundleUtils.getLocalizedString("buttons.transfer.money"));
        logout = new JButton(BundleUtils.getLocalizedString("buttons.logout"));
        exit = new JButton(BundleUtils.getLocalizedString("buttons.exit"));
        
        selectAccount.addActionListener(ListenersUtils.showSelectAccountWindowListener());
        newAccount.addActionListener(ListenersUtils.showNewAccountWindowListener());
        updateAccount.addActionListener(ListenersUtils.showUpdateAccountWindowListener());
        deleteAccount.addActionListener(ListenersUtils.deleteAccountListener());
        newTransaction.addActionListener(ListenersUtils.showNewTransactionWindowListener());
        updateTransaction.addActionListener(ListenersUtils.showUpdateTransactionWindowListener());
        deleteTransaction.addActionListener(ListenersUtils.deleteTransactionListener());
        showAssociatedTransaction.addActionListener(ListenersUtils.showAssociatedTransactionListener());
        transferMoney.addActionListener(ListenersUtils.showTransferMoneyWindowListener());
        logout.addActionListener(ListenersUtils.logOutListener());
        exit.addActionListener(ListenersUtils.exitListener());
    }
}
