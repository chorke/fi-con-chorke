
package org.chorke.ficon.gui.panels;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.PlainDocument;
import org.chorke.ficon.api.objects.TransactionRecord;
import org.chorke.ficon.gui.panels.filters.LengthDocumentFilter;
import org.chorke.ficon.gui.panels.filters.NumberDocumentFilter;
import org.chorke.ficon.gui.utils.BundleUtils;
import org.chorke.ficon.gui.utils.Utils;
import org.chorke.ficon.gui.utils.Utils.MaxLength;
import org.chorke.gui.utils.panels.DateChooser;

/**
 *
 * @author Chorke
 */
public class RecordPanel extends BasicPanel{

//    private TransactionRecord record;
    
    private DateFormat formatter;
    
    private JTextField name;
    private JLabel nameLabel;
    private JTextArea description;
    private JLabel descriptionLabel;
    private JTextField amount;
    private JLabel amountLabel;
    private JComponent time;
    private JLabel timeLabel;
    private JLabel associatedTransaction;
    private JLabel associatedTransactionLabel;
    
    private final boolean editable;
    
    RecordPanel(boolean editable){
        super();
        this.editable = editable;
        init();
    }
    
    private void init(){
        name = new JTextField();
        name.setEditable(editable);
        PlainDocument doc = new PlainDocument();
        doc.setDocumentFilter(new LengthDocumentFilter(MaxLength.NAME_RECORD));
        name.setDocument(doc);
        
        amount = new JTextField();
        amount.setEditable(editable);
        
        description = new JTextArea();
        if(editable){
            time = new DateChooser(Utils.getActualSession().getLocale(), true);
            
            doc = new PlainDocument();
            doc.setDocumentFilter(new NumberDocumentFilter());
            amount.setDocument(doc);
        } else {
            time = new JLabel();
            
            description.setBackground(getBackground());
            
            name.setBorder(null);
            name.setBackground(getBackground());
            
            amount.setBorder(null);
            amount.setBackground(getBackground());
        }
        
        associatedTransaction = new JLabel();
        
        nameLabel = new JLabel(BundleUtils.getLocalizedString("labels.name"));
        amountLabel = new JLabel(BundleUtils.getLocalizedString("labels.amount"));
        timeLabel = new JLabel(BundleUtils.getLocalizedString("labels.date"));
        associatedTransactionLabel = new JLabel(BundleUtils.getLocalizedString("labels.associated.transaction"));
        descriptionLabel = new JLabel(BundleUtils.getLocalizedString("labels.description"));
        
        JScrollPane descriptionPane = new JScrollPane(description);
        
        GroupLayout gl = new GroupLayout(this);
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);
        gl.setHorizontalGroup(gl.createParallelGroup(Alignment.LEADING, false)
                .addGroup(gl.createSequentialGroup()
                    .addGroup(gl.createParallelGroup()
                        .addComponent(nameLabel)
                        .addComponent(timeLabel)
                        .addComponent(amountLabel)
                        .addComponent(associatedTransactionLabel))
                    .addGroup(gl.createParallelGroup()
                        .addComponent(name)
                        .addComponent(time)
                        .addComponent(amount)
                        .addComponent(associatedTransaction)))
                .addGroup(gl.createParallelGroup()
                    .addComponent(descriptionLabel)
                    .addComponent(descriptionPane, 300, 300, 300)));
        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup()
                    .addComponent(name, 20, 20, 20)
                    .addComponent(nameLabel))
                .addGroup(gl.createParallelGroup()
                    .addComponent(time)
                    .addComponent(timeLabel))
                .addGroup(gl.createParallelGroup()
                    .addComponent(amount)
                    .addComponent(amountLabel))
                .addGroup(gl.createParallelGroup()
                    .addComponent(associatedTransaction)
                    .addComponent(associatedTransactionLabel))
                .addGroup(gl.createSequentialGroup()
                    .addComponent(descriptionLabel)
                    .addComponent(descriptionPane, 70, 70, 400)));
        gl.linkSize(SwingConstants.VERTICAL, name, nameLabel, time, timeLabel,
                amount, amountLabel, associatedTransaction, associatedTransactionLabel,
                descriptionLabel);
        setLayout(gl);
        
        formatter = DateFormat.getDateTimeInstance(
                DateFormat.SHORT, DateFormat.LONG, Utils.getActualSession().getLocale());
    }
    
    public void fillRecordsInfo(TransactionRecord record){
        if(record == null){
            name.setText(EMPTY_TEXT);
            if(editable){
                ((DateChooser)time).setActualDate(
                        new GregorianCalendar(Utils.getActualSession().getLocale()));
            } else {
                ((JLabel)time).setText(EMPTY_TEXT);
            }
            amount.setText(EMPTY_TEXT);
            associatedTransaction.setText(EMPTY_TEXT);
            description.setText(EMPTY_TEXT);
        } else {
            name.setText(record.getName());
            if(editable){
                ((DateChooser)time).setActualDate(record.getTransactionTime() == null
                        ? new GregorianCalendar(Utils.getActualSession().getLocale())
                        : record.getTransactionTime());
            } else {
                ((JLabel)time).setText(record.getTransactionTime() == null
                        ? formatter.format(EMPTY_TEXT)
                        : formatter.format(record.getTransactionTime().getTime()));
            }
            BigDecimal bd = record.getAmount();
            if(bd == null){
                amount.setText(editable ? "" : EMPTY_TEXT);
            } else {
                Currency c = Utils.getActualSession().getActualAccount().getCurrency();
                amount.setText(bd.setScale(c.getDefaultFractionDigits(), RoundingMode.HALF_UP)
                        .toEngineeringString() 
                            + (editable ?  "" : " " + c));
            }
            if(record.getAssociatedTransactionID() == null){
                associatedTransaction.setText(EMPTY_TEXT);
            } else {
                associatedTransaction.setText(BundleUtils.getLocalizedString("yes"));
            }
            description.setText(record.getDescription());
        }
    }
    
    public String getRecordsName(){
        return name.getText();
    }
    
    public String getRecordsDescription(){
        return description.getText();
    }
    
    public String getAmount(){
        return amount.getText();
    }
    
    public Calendar getTime() throws ParseException{
        if(editable){
            return ((DateChooser)time).getActualDate();
        } else {
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(formatter.parse(((JLabel)time).getText()));
            return cal;
        }
    }
}
