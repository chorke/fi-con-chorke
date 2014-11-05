
package org.chorke.ficon.api.objects;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Account of user.
 * 
 * @author Chorke
 */
public class Account {
    /**
     * ID of this account.
     */
    private Long id;
    /**
     * ID of user that this account belong to.
     */
    private final Long usersID;
    /**
     * Name of this account.
     */
    private String name;
    /**
     * Description of this account.
     */
    private String description;
    /**
     * List of transactions associated with whit account.
     */
    private List<TransactionRecord> transactions;
    /**
     * List of ID's of transactions.
     */
    private List<Long> transactionsIDs;
    /**
     * Balance for this account.
     */
    private transient BigDecimal balance;

    /**
     * Returns new instance of {@link Account} and associates it with user
     * with ID {@code usersID}.
     * 
     * @param usersID user that this account belong to
     * @throws IllegalArgumentException if {@code usersID} is {@code null}
     */
    public Account(Long usersID) {
        if(usersID == null){
            throw new IllegalArgumentException("User's ID cannot be null. "
                    + "Account has to be associated with some user.");
        }
        this.usersID = usersID;
        transactions = new LinkedList<>();
        transactionsIDs = new LinkedList<>();
    }

    /**
     * Returns ID of user that this transaction belong to.
     * 
     * @return user's ID
     */
    public Long getUsersID() {
        return usersID;
    }

    /**
     * Returns account's ID.
     * 
     * @return ID of account
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets ID of this account. ID can be set only once.
     * 
     * @param id id to be set
     * @throws IllegalStateException if ID has been already set
     */
    public void setId(Long id) {
        if(this.id != null){
            throw new IllegalStateException("ID already set.");
        }
        this.id = id;
    }

    /**
     * Returns name of this account.
     * 
     * @return account's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name for this account.
     * 
     * @param name name to be set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns description for this account.
     * 
     * @return account's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description for this account.
     * 
     * @param description description to be set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns list of all transactions associated with this account.
     * 
     * @return all transactions for this account
     */
    public List<TransactionRecord> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    /**
     * Adds new transaction's record for this acount. If transaction with same
     * ID is already present, then transaction will be replaced.
     * 
     * @param transaction transaction to be added
     * @throws IllegalArgumentException if transaction does not belong to
     *          this account
     */
    public void addTransaction(TransactionRecord transaction) {
        if(transaction.getAccountID() == null || id == null
                || transaction.getAccountID().longValue() != id.longValue()){
            throw new IllegalArgumentException("Transaction " + transaction 
                    + " does not belong to this account (account's ID: " + id + 
                    ", account's ID in transaction: " + transaction.getAccountID()+ ").");
        }
        //readding
        removeTransaction(transaction);
        transactions.add(transaction);
        transactionsIDs.add(transaction.getId());
        correctBalance(transaction.getAmount());
    }
    
    /**
     * Removes transaction from this account.
     * 
     * @param transaction transaction to be removed
     */
    public void removeTransaction(TransactionRecord transaction){
        if(transactionsIDs.contains(transaction.getId())){
            transactions.remove(transaction);
            transactionsIDs.remove(transaction.getId());
            correctBalance(transaction.getAmount().negate());
        }
    }
    
    /**
     * Returns balance of this account.
     * 
     * @return account's balance
     */
    public BigDecimal getBalance() {
        if(balance == null){
            balance = BigDecimal.ZERO;
            for(TransactionRecord tr : transactions){
                correctBalance(tr.getAmount());
            }
        }
        return balance;
    }
    
    /**
     * Adds amount of money to the balance of this account.
     * 
     * @param transaction 
     */
    private void correctBalance(BigDecimal amount){
        balance = balance == null ? null : balance.add(amount);
    }
    
    /**
     * Clears transaction history for this account (e.g. user signs out, 
     * user switches account).
     */
    public void transactionHistoryNoMoreNeeded(){
        transactions.clear();
        transactionsIDs.clear();
    }

    @Override
    public String toString() {
        return "Account: " + name + "[id: " +  id + ", belongs to user: "
                + usersID + "] {description: " + description 
                + "}, number of transactions: " + transactions.size();
    }
    
    @Override
    public int hashCode() {
        return id == null ? Account.class.getName().hashCode() : id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Account){
            Long objId = ((Account)obj).getId();
            return id == null ? objId == null : id.equals(objId);
        }
        return false;
    }
}
