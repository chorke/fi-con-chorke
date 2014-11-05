
package org.chorke.ficon.api.objects;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Locale;

/**
 * Transaction record.
 * 
 * @author Chorke
 */
public class TransactionRecord {

    /**
     * Transaction's ID.
     */
    private Long id;
    /**
     * ID of account that this transaction belong to. 
     */
    private final Long accountID; 
    /**
     * Transaction's name
     */
    private String name;
    /**
     * Description of transaction.
     */
    private String description;
    /**
     * Assoctiated transaction's ID. E.g. when this transaction is part
     * of transfer transaction.
     */
    private Long associatedTransactionID;
    /**
     * Amount of money for this transaction.
     */
    private BigDecimal amount;
    /**
     * Time of transaction.
     */
    private Calendar transactionTime;
    
    /**
     * Creates new instance of {@link TransactionRecord} and associates
     * transaction with specific account. 
     * 
     * @param accountID ID of account
     * @throws IllegalArgumentException if {@code accountID} is {@code null}
     */
    public TransactionRecord(Long accountID){
        if(accountID == null){
            throw new IllegalArgumentException("Account ID cannot be null. "
                    + "Transaction has to be associated with some account.");
        }
        this.accountID = accountID;
        amount = BigDecimal.ZERO;
    }
    /**
     * Returns transaction's ID.
     * 
     * @return transaction's ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets transaction's ID. Id can be set only once. 
     * 
     * @param id ID to be set
     * @throws IllegalStateException if transaction's ID has been already set
     */
    public void setId(Long id) {
        if(this.id != null){
            throw new IllegalStateException("ID already set");
        }
        this.id = id;
    }

    /**
     * Returns transaction's name.
     * 
     * @return transaction's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets transation's name.
     * 
     * @param name name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns description of this transaction.
     * 
     * @return description of transaction
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description for this transaction.
     * 
     * @param description decsription to be set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns ID of associated transaction (e.g. when this transaction
     * is part of transfer transaction).
     * 
     * @return ID of associated transaction
     */
    public Long getAssociatedTransactionID() {
        return associatedTransactionID;
    }

    /**
     * Sets ID of associated transaction (e.g. when this transaction is 
     * part of transfer transaction).
     * 
     * @param associatedTransactionID ID to be set
     */
    public void setAssociatedTransactionID(Long associatedTransactionID) {
        this.associatedTransactionID = associatedTransactionID;
    }

    /**
     * Returns amount of money in this transactions.
     * 
     * @return amount of money
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets amount of money in this transaction.
     * 
     * @param amount amount to be set
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Returns ID of account that this transaction belong to. 
     * 
     * @return account's ID
     */
    public Long getAccountID() {
        return accountID;
    }

    /**
     * Set time for this transaction.
     * 
     * @param transactionTime time to be set
     */
    public void setTransactionTime(Calendar transactionTime) {
        this.transactionTime = transactionTime;
    }

    /**
     * Returns transaction's time.
     * 
     * @return time of transaction
     */
    public Calendar getTransactionTime() {
        return transactionTime;
    }

    @Override
    public String toString() {
        return new StringBuilder("Transaction record: ").append(name)
                .append(" [id: ").append(id)
                .append(", belongs to account: ").append(accountID)
                .append("] {description: ").append(description)
                .append("}, amount: ").append(amount)
                .append(", associated transaction: ").append(associatedTransactionID)
                .append(", transaction time: [day: ")
                    .append(transactionTime.getDisplayName(Calendar.DAY_OF_MONTH,
                            Calendar.LONG, Locale.getDefault()))
                    .append(", month: ")
                    .append(transactionTime.getDisplayName(Calendar.MONTH,
                            Calendar.LONG, Locale.getDefault()))
                    .append(", year: ")
                    .append(transactionTime.getDisplayName(Calendar.YEAR,
                            Calendar.LONG, Locale.getDefault()))
                    .append("]").toString();
    }

    @Override
    public int hashCode() {
        return id == null ? TransactionRecord.class.getName().hashCode() : id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof TransactionRecord){
            Long objId = ((TransactionRecord)obj).getId();
            return id == null ? objId == null : id.equals(objId);
        }
        return false;
    }
}
