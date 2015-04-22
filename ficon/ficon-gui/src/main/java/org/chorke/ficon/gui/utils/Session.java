
package org.chorke.ficon.gui.utils;

import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import org.chorke.ficon.api.objects.Account;
import org.chorke.ficon.api.objects.TransactionRecord;
import org.chorke.ficon.api.objects.User;
import org.chorke.ficon.gui.utils.exceptions.IllegalAccountOperationException;
import org.chorke.ficon.gui.utils.exceptions.ObjectManipulationException;

/**
 *
 * @author Chorke
 */
public class Session {

    public static interface Locales{
        public static final Locale sk_SK = new Locale("sk", "SK");
        public static final Locale en_US = new Locale("en", "US");
    }
    
    private final Locale defaultLocale;
    
    private User actualUser;
    private Account actualAccount;
    private TransactionRecord actualRecord;
    
    public Session(Locale defaultLocale) {
        this.defaultLocale = defaultLocale;
    }
    
    public Locale getLocale(){
        return defaultLocale;
    }
    
    public void setActualRecord(TransactionRecord actualRecord) {
        this.actualRecord = actualRecord;
        GuiUtils.fireRecordChangeEvent(this);
    }

    public TransactionRecord getActualRecord() {
        return actualRecord;
    }

    public Account getActualAccount() {
        return actualAccount;
    }

    public void setActualAccount(Account actualAccount) {
        this.actualAccount = actualAccount;
        GuiUtils.fireAccountChangeEvent(this);
        setActualRecord(null);
    }

    public void userCreated(){
        GuiUtils.fireUserListChangedEvent(this);
    }
    
    public void userDeleted(){
        GuiUtils.fireUserListChangedEvent(this);
    }
    
    public User getLoggedUser() {
        return actualUser;
    }

    public boolean isUserLogged(){
        return actualUser != null;
    }
    
    public void logInUser(User user) {
        if(user != null){
            actualUser = user;
            GuiUtils.fireLogInEvent(user);
            setActualAccount(null);
        }
    }
    
    public void createUser(User user) throws ObjectManipulationException{
        try{
            Utils.getUserService().createNewUser(user);
        } catch (Throwable t){
            throw new ObjectManipulationException("Create user [" + user + "]", t);
        }
    }
    
    public void deleteUser(Long id) throws ObjectManipulationException{
        try{
            Utils.getUserService().deleteUser(
                    Utils.getUserService().getUser(id));
        } catch (Throwable t){
            throw new ObjectManipulationException("Delete user [" + id + "]", t);
        }
    }
    
    public Map<Long, String> getApplicationUsersFromDB() throws ObjectManipulationException{
        try{
            return Utils.getUserService().getUsersNames();
        } catch (Throwable t){
            throw new ObjectManipulationException("Get application users from DB", t);
        }
    }
    
    public Map<Long, String> getAccountsOfActualUserFromDB() throws ObjectManipulationException{
        try{
            return Utils.getAccountService().getAccountsNames(actualUser.getId());
        } catch (Throwable t){
            throw new ObjectManipulationException("Get user's accounts from DB", t);
        }
    }
    
    public User getUserFromDB(Long id) throws ObjectManipulationException{
        try{
            return Utils.getUserService().getUser(id);
        } catch (Throwable t){
            throw new ObjectManipulationException("Get user [" + id + "]", t);
        }
    }
    
    public TransactionRecord getTransactionRecordFromDB(Long id) throws ObjectManipulationException{
        try{
            return Utils.getTransactionRecordService().getTransactionRecord(id);
        } catch (Throwable t){
            throw new ObjectManipulationException("Get record [" + id + "]", t);
        }
    }
    
    public void loadHistoryOfAccount(Properties prop) throws ObjectManipulationException{
        Account safeCopy = actualAccount == null ? null : actualAccount.clone();
        try{
            actualAccount = Utils.getAccountService().loadTransactionHistory(actualAccount, prop);
        } catch (Throwable t){
            actualAccount = safeCopy;
            throw new ObjectManipulationException("Load history [" + prop + "]", t);
        }
        GuiUtils.fireHistoryLoadedEvent(this);
    }
    
    public void addRecordToActualAccount(TransactionRecord record) throws IllegalAccountOperationException{
        try{
            if(actualAccount == null){
                throw new IllegalStateException(BundleUtils.getLocalizedMessage("account.not.set"));
            }
            actualAccount.addTransaction(record);
            GuiUtils.fireHistoryLoadedEvent(this);
            setActualRecord(record);
        } catch (Throwable t){
            throw new IllegalAccountOperationException(
                    "Add record [" + record + ", " + actualAccount + "]", t);
        }
    }
    
    public Account createAccount(Account account) throws ObjectManipulationException{
        try{
            Utils.getAccountService().createNewAccount(account);
            return account;
        } catch (Throwable t){
            throw new ObjectManipulationException("Create account [" + account + "]", t);
        }
    }
    
    public Account getAccount(Long id) throws ObjectManipulationException{
        try{
            Account ac = Utils.getAccountService().getBasicAccount(id);
            return ac;
        } catch (Throwable t){
            throw new ObjectManipulationException("Get basic account [" + id + "]", t);
        }
    }
    
    public Account updateAccount(Account account) throws ObjectManipulationException{
        try{
            Utils.getAccountService().updateAccount(account);
            return account;
        } catch (Throwable t){
            throw new ObjectManipulationException("Update account [" + account + "]", t);
        }
    }
    
    public TransactionRecord createRecord(TransactionRecord record) throws ObjectManipulationException{
        try{
            Utils.getTransactionRecordService().createNewTransactionRecord(record);
            return record;
        } catch (Throwable t){
            throw new ObjectManipulationException("Create record [" + record + "]", t);
        }
    }
    
    public TransactionRecord updateRecord(TransactionRecord record) throws ObjectManipulationException{
        try{
            Utils.getTransactionRecordService().updateTransactionRecord(record);
            return record;
        } catch (Throwable t){
            throw new ObjectManipulationException("Update record [" + record + "]", t);
        }
    }
    
    public void deleteActualAccount() throws ObjectManipulationException{
        try{
            Utils.getAccountService().deleteAccount(actualAccount);
            setActualAccount(null);
        } catch (Throwable t){
            throw new ObjectManipulationException("Delete actual account [" + actualAccount + "]", t);
        }
    }
    
    public void deleteActualRecord() throws ObjectManipulationException{
        try{
            Utils.getTransactionRecordService().deleteTransactionRecord(actualRecord);
            setActualRecord(null);
        } catch (Throwable t){
            throw new ObjectManipulationException("Delete actual record [" + actualRecord + "]", t);
        }
    }
    
    public void getAndLogInUserFromDB(Long id) throws ObjectManipulationException{
        logInUser(getUserFromDB(id));
    }
    
    public void logOutUser(){
        if(isUserLogged()){
            User old = actualUser;
            actualUser = null;
            GuiUtils.fireLogOutEvent(old);
            setActualAccount(null);
        }
    }
    
    public void cancelAllDBOperations(){
        //TODO
    }
}
