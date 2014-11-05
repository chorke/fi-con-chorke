
package org.chorke.ficon.backend.services;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.chorke.ficon.api.objects.Account;
import org.chorke.ficon.api.objects.TransactionRecord;
import org.chorke.ficon.api.objects.User;
import org.chorke.ficon.api.services.UserService;
import org.chorke.ficon.api.test.services.UserServiceAbstractTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 *
 * @author Chorke
 */
public class UserServiceTest extends UserServiceAbstractTest{

    @Override
    protected void beforeCreateNewUser(User user) {
        //nothing yet
    }

    @Override
    protected void afterCreateNewUser(Exception thrown, User user) {
        //nothing yet
    }

    @Override
    protected void beforeDeleteUser(User user) {
        //nothing yet
    }

    @Override
    protected void afterDeleteUser(Exception thrown, User user) {
        //nothing yet
    }

    @Override
    protected void beforeGetUser(Long id) {
        //nothing yet
    }

    @Override
    protected void afterGetUser(Exception thrown, Long id) {
        //nothing yet
    }

    @Override
    protected void beforeGetUsersNames() {
        //nothing yet
    }

    @Override
    protected void afterGetUsersNames(Exception thrown) {
        //nothing yet
    }

    @Override
    protected void beforeLoadUsersAccounts(User user) {
        //nothing yet
    }

    @Override
    protected void afterLoadUsersAccounts(Exception thrown, User user) {
        //nothing yet
    }

    @Override
    protected void beforeUpdateUser(User user) {
        //nothing yet
    }

    @Override
    protected void afterUpdateUser(Exception thrown, User user) {
        //nothing yet
    }

    @Override
    protected void saveAccounts(List<Account> accounts) {
        if(accounts != null){
            for(Account ac : accounts){
                TestUtils.save(ac);
            }
        }
    }

    @Override
    protected void saveTransactions(List<TransactionRecord> transactions) {
        if(transactions != null){
            for(TransactionRecord tr : transactions){
                TestUtils.save(tr);
            }
        }
    }

    @Override
    protected List<Account> getAccountsOfUser(Long id) {
        List<Account> output = new LinkedList<>();
        if(id == null){
            return output;
        }
        for(Account ac : TestUtils.getAllAccounts()){
            if(id.equals(ac.getUsersID())){
                output.add(ac);
            }
        }
        return output;
    }

    @Override
    protected List<Account> getAllStoredAccounts() {
        return new LinkedList<>(TestUtils.getAllAccounts());
    }

    @Override
    protected List<TransactionRecord> getTransactionsOfAccount(Long id) {
        List<TransactionRecord> output = new LinkedList<>();
        if(id == null){
            return output;
        }
        for(TransactionRecord tr: TestUtils.getAllRecords()){
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
    protected void deleteTransaction(TransactionRecord tr) {
        TestUtils.delete(tr);
    }

    @Override
    protected void deleteAccount(Account ac) {
        TestUtils.delete(ac);
    }

    @Override
    protected void tearDownTest() {
        TestUtils.clearTables();
    }

    @Override
    protected void setUpTest() {
        //nothing yet
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
    protected UserService getInstance() {
        return new UserServiceImpl(TestUtils.getDataSource());
    }

    @Override
    protected User getObject(Long id) {
        return TestUtils.getUser(id);
    }

    @Override
    protected Collection<User> getAllObjects() {
        return TestUtils.getAllUsers();
    }

    @Override
    protected void saveObject(User obj) {
        TestUtils.save(obj);
    }

    @Override
    protected void deleteObject(User obj) {
        TestUtils.delete(obj);
    }

    @Override
    protected void updateObject(User obj) {
        TestUtils.update(obj);
    }

    @Override
    protected void updateTransaction(TransactionRecord tr) {
        TestUtils.update(tr);
    }
}
