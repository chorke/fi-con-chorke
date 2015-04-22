package org.chorke.ficon.gui.panels;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.PlainDocument;
import org.chorke.ficon.api.objects.Account;
import org.chorke.ficon.api.objects.TransactionRecord;
import org.chorke.ficon.api.services.AccountService.LoadProperties;
import org.chorke.ficon.gui.components.ListItem;
import org.chorke.ficon.gui.listeners.ListenersUtils;
import org.chorke.ficon.gui.panels.filters.NumberDocumentFilter;
import org.chorke.ficon.gui.utils.BundleUtils;
import org.chorke.ficon.gui.utils.Utils;
import org.chorke.gui.utils.panels.DateChooser;

/**
 *
 * @author Chorke
 */
public class AccountManipulationPanel extends BasicPanel {

    private AccountPanel accountInfo;
    private JList<ListItem<Long, DisplayableRecord>> listOfRecords;
    private DefaultListModel<ListItem<Long, DisplayableRecord>> listModel;
    private JScrollPane recordsPane;
    private DateChooser fromDate;
    private DateChooser toDate;
    private JCheckBox noTimeRestriction;
    private JTextField minAmount;
    private JTextField maxAmount;
    private JTextField nameLike;
    private JButton loadHistory;
    
    private JLabel fromDateLabel;
    private JLabel toDateLabel;
    private JLabel minAmountLabel;
    private JLabel maxAmountLabel;
    private JLabel nameLikeLabel;
    private JLabel recordsLabel;

    AccountManipulationPanel() {
        super();
        init();
    }

    private void init() {
        accountInfo = PanelUtils.getAccountInformationPanel(false);
        
        listModel = new DefaultListModel<>();
        listOfRecords = new JList<>(listModel);
        listOfRecords.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listOfRecords.addListSelectionListener(new SelectionChangedListener());
        recordsPane = new JScrollPane(listOfRecords);
        
        fromDate = new DateChooser(Utils.getActualSession().getLocale());
        toDate = new DateChooser(Utils.getActualSession().getLocale());
        
        noTimeRestriction = new JCheckBox(
                BundleUtils.getLocalizedString("labels.no.time.restriction"), false);
        
        minAmount = new JTextField();
        PlainDocument docMin = new PlainDocument();
        docMin.setDocumentFilter(new NumberDocumentFilter());
        minAmount.setDocument(docMin);
        maxAmount = new JTextField();
        PlainDocument docMax = new PlainDocument();
        docMax.setDocumentFilter(new NumberDocumentFilter());
        maxAmount.setDocument(docMax);
        
        nameLike = new JTextField();
        
        loadHistory = new JButton(BundleUtils.getLocalizedString("buttons.load.history"));
        loadHistory.addActionListener(ListenersUtils.loadHistoryListener(this));
        
        fromDateLabel = new JLabel(BundleUtils.getLocalizedString("labels.date.from"));
        toDateLabel = new JLabel(BundleUtils.getLocalizedString("labels.date.to"));
        minAmountLabel = new JLabel(BundleUtils.getLocalizedString("labels.amount.min"));
        maxAmountLabel = new JLabel(BundleUtils.getLocalizedString("labels.amount.max"));
        nameLikeLabel = new JLabel(BundleUtils.getLocalizedString("labels.name.like"));
        recordsLabel = new JLabel(BundleUtils.getLocalizedString("labels.records.history"));
        
        GroupLayout gl = new GroupLayout(this);
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);
        gl.setHorizontalGroup(gl.createParallelGroup(Alignment.LEADING, false)
                .addComponent(accountInfo)
                .addGroup(gl.createParallelGroup()
                    .addGroup(gl.createSequentialGroup()
                        .addGroup(gl.createParallelGroup()
                            .addComponent(fromDateLabel)
                            .addComponent(fromDate))
                        .addGroup(gl.createParallelGroup()
                            .addComponent(toDateLabel)
                            .addComponent(toDate)))
                    .addComponent(noTimeRestriction)
                    .addGroup(gl.createSequentialGroup()
                        .addGroup(gl.createParallelGroup()
                            .addComponent(minAmountLabel)
                            .addComponent(minAmount))
                        .addGroup(gl.createParallelGroup()
                            .addComponent(maxAmountLabel)
                            .addComponent(maxAmount)))
                    .addGroup(gl.createSequentialGroup()
                        .addGroup(gl.createParallelGroup()
                            .addComponent(nameLikeLabel)
                            .addComponent(nameLike))
                        .addGroup(gl.createSequentialGroup()
                            .addComponent(loadHistory))))
                .addGroup(gl.createParallelGroup()
                    .addComponent(recordsLabel)
                    .addComponent(recordsPane, 300, 300, 300)));
        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(accountInfo)
                .addGroup(gl.createParallelGroup()
                    .addGroup(gl.createSequentialGroup()
                        .addComponent(fromDateLabel)
                        .addComponent(fromDate, 25, 25, 25))
                    .addGroup(gl.createSequentialGroup()
                        .addComponent(toDateLabel)
                        .addComponent(toDate, 25, 25, 25)))
                .addComponent(noTimeRestriction)
                .addGroup(gl.createParallelGroup()
                    .addGroup(gl.createSequentialGroup()
                        .addComponent(minAmountLabel)
                        .addComponent(minAmount, 25, 25, 25))
                    .addGroup(gl.createSequentialGroup()
                        .addComponent(maxAmountLabel)
                        .addComponent(maxAmount, 25, 25, 25)))
                .addGroup(gl.createParallelGroup(Alignment.TRAILING)
                    .addGroup(gl.createSequentialGroup()
                        .addComponent(nameLikeLabel)
                            .addComponent(nameLike, 25, 25, 25))
                    .addComponent(loadHistory))
                .addComponent(recordsLabel)
                .addComponent(recordsPane, 170, 170, 170));
        setLayout(gl);
    }

    public void fillAccountsInfo(Account account) {
        accountInfo.fillAccountInfo(account);
        fillAccountsRecords(account);
    }

    public void fillAccountsRecords(Account account) {
        listModel.removeAllElements();
        List<TransactionRecord> records;
        if(account == null){
            records = new ArrayList<>();
        } else {
            records = new ArrayList<>(account.getTransactions());
            Collections.sort(records);
        }
        for (TransactionRecord tr : records) {
            listModel.addElement(new ListItem<>(tr.getId(), new DisplayableRecord(tr)));
        }
    }
    
    public Properties getLoadProperties(){
        Properties prop = new Properties();
        if(!noTimeRestriction.isSelected()){
            prop.put(LoadProperties.FROM_DATE, fromDate.getActualDate());
            prop.put(LoadProperties.TO_DATE, toDate.getActualDate());
        }
        String str = minAmount.getText();
        if(str != null && !str.isEmpty()){
            prop.put(LoadProperties.MIN_AMOUNT, new BigDecimal(str));
        }
        str = maxAmount.getText();
        if(str != null && !str.isEmpty()){
            prop.put(LoadProperties.MAX_AMOUNT, new BigDecimal(str));
        }
        str = nameLike.getText();
        if(str != null && !str.isEmpty()){
            prop.put(LoadProperties.NAME_LIKE, str);
        }
        return prop;
    }
    
    private class SelectionChangedListener implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            ListItem<Long, DisplayableRecord> item = listOfRecords.getSelectedValue();
            if(item == null){
                Utils.getActualSession().setActualRecord(null);
            } else {
                Utils.getActualSession().setActualRecord(item.getValue().original);
            }
        }
    }
    
    private static class DisplayableRecord {

        private TransactionRecord original;

        public DisplayableRecord(TransactionRecord original) {
            this.original = original;
        }

        @Override
        public String toString() {
            if (original == null) {
                return "null";
            }
            DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT,
                    Utils.getActualSession().getLocale());
            format.setCalendar(original.getTransactionTime());
            return "[" + format.format(original.getTransactionTime().getTime())
                    + "]    " + original.getName();
        }
    }
}