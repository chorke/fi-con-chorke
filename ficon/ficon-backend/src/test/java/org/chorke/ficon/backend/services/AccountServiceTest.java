
package org.chorke.ficon.backend.services;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import org.chorke.ficon.api.objects.Account;
import org.chorke.ficon.api.objects.TransactionRecord;
import org.chorke.ficon.api.services.AccountService;
import org.chorke.ficon.api.test.services.AccountServiceAbstractTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;


/**
 *
 * @author Chorke
 */
public class AccountServiceTest extends AccountServiceAbstractTest{

    @Override
    protected void beforeCreateNewAccount(Account account) {
        //nothing yet
    }

    @Override
    protected void afterCreateNewAccount(Exception thrown, Account account) {
        //nothing yet
    }

    @Override
    protected void beforeDeleteAccount(Account account) {
        //nothing yet
    }

    @Override
    protected void afterDeleteAccount(Exception thrown, Account account) {
        //nothing yet
    }

    @Override
    protected void beforeGetAccountsName(Long usersID) {
        //nothing yet
    }

    @Override
    protected void afterGetAccountsName(Exception thrown, Long usersID) {
        //nothing yet
    }

    @Override
    protected void beforeGetBasicAccount(Long id) {
        //nothing yet
    }

    @Override
    protected void afterGetBasicAccount(Exception thrown, Long id) {
        //nothing yet
    }

    @Override
    protected void beforeGetFullAccount(Long id) {
        //nothing yet
    }

    @Override
    protected void afterGetFullAccount(Exception thrown, Long id) {
        //nothing yet
    }

    @Override
    protected void beforeLoadTransactionHistory(Account account, Properties properties) {
        //nothing yet
    }

    @Override
    protected void afterLoadTransactionHistory(Exception thrown, Account account, Properties properties) {
        //nothing yet
    }

    @Override
    protected void beforeLoadTransactionHistory(Account account) {
        //nothing yet
    }

    @Override
    protected void afterLoadTransactionHistory(Exception thrown, Account account) {
        //nothing yet
    }

    @Override
    protected void beforeTransferMoney(Account fromAccount, Account toAccount, TransactionRecord template) {
        //nothing yet
    }

    @Override
    protected void afterTransferMoney(Exception thrown, Account fromAccount,
            Account toAccount, TransactionRecord template) {
        //nothing yet
    }

    @Override
    protected void beforeUpdateAccount(Account account) {
        //nothing yet
    }

    @Override
    protected void afterUpdateAccount(Exception thrown, Account account) {
        //nothing yet
    }

    @Override
    protected List<TransactionRecord> getTransactionHistoryOfAccount(Long id) {
        LinkedList<TransactionRecord> output = new LinkedList<>();
        if(id == null){
            return output;
        }
        for(TransactionRecord tr : TestUtils.getAllRecords()){
            if(id.equals(tr.getAccountID())){
                output.add(tr);
            }
        }
        return output;
    }

    @Override
    protected List<TransactionRecord> getAllStoredTransactions() {
        return new LinkedList<>(TestUtils.getAllRecords());
    }

    @Override
    protected void saveTransactionHistory(List<TransactionRecord> records) {
        if(records != null){
            for(TransactionRecord tr : records){
                TestUtils.save(tr);
            }
        }
    }

    @Override
    protected void tearDownTest() {
        TestUtils.clearTables();
    }

    @Override
    protected void setUpTest() {
        //nothing yet
    }

    @Override
    protected AccountService getInstance() {
        return new AccountServiceImpl(TestUtils.getDataSource());
    }

    /**
     * Set up testing class.
     */
    @BeforeClass
    public static void setUpClass(){
        if(!TestUtils.initDatabase()){
            throw new Error("Unable to start test. Database has not been initialized.");
        }
    }
    
    /**
     * Tear down testing class.
     */
    @AfterClass
    public static void tearDownClass(){
        if(!TestUtils.dropDatabase()){
            System.err.println("Database has not been deleted properly.");
        }
    }
    
    @Override
    protected Account getObject(Long id) {
        return TestUtils.getAccount(id);
    }

    @Override
    protected Collection<Account> getAllObjects() {
        return TestUtils.getAllAccounts();
    }

    @Override
    protected void saveObject(Account obj) {
        TestUtils.save(obj);
    }

    @Override
    protected void deleteObject(Account obj) {
        TestUtils.delete(obj);
    }

    @Override
    protected void updateObject(Account obj) {
        TestUtils.update(obj);
    }

    @Override
    protected void updateTransaction(TransactionRecord tr) {
        TestUtils.update(tr);
    }
}
