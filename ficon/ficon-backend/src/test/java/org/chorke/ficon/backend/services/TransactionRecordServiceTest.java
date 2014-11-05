package org.chorke.ficon.backend.services;

import java.util.Collection;
import org.chorke.ficon.api.objects.TransactionRecord;
import org.chorke.ficon.api.services.TransactionRecordService;
import org.chorke.ficon.api.test.services.TransactionRecordServiceAbstractTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 *
 * @author Chorke
 */
public class TransactionRecordServiceTest extends TransactionRecordServiceAbstractTest{

    @Override
    protected void beforeCreateNewTransactionRecord(TransactionRecord record) {
        //nothing yet
    }

    @Override
    protected void afterCreateNewTransactionRecord(Exception thrown, TransactionRecord record) {
        //nothing yet
    }

    @Override
    protected void beforeUpdateTransactionRecord(TransactionRecord record) {
        //nothing yet
    }

    @Override
    protected void afterUpdateTransactionRecord(Exception thrown, TransactionRecord record) {
        //nothing yet
    }

    @Override
    protected void beforeGetTransactionRecord(Long id) {
        //nothing yet
    }

    @Override
    protected void afterGetTransactionRecord(Exception thrown, Long id) {
        //nothing yet
    }

    @Override
    protected void beforeDeleteTransactionRecord(TransactionRecord record) {
        //nothing yet
    }

    @Override
    protected void afterDeleteTransactionRecord(Exception thrown, TransactionRecord record) {
        //nothing yet
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
    protected TransactionRecordService getInstance() {
        return new TransactionRecordServiceImpl(TestUtils.getDataSource());
    }

    @Override
    protected TransactionRecord getObject(Long id) {
        return TestUtils.getRecord(id);
    }

    @Override
    protected Collection<TransactionRecord> getAllObjects() {
        return TestUtils.getAllRecords();
    }

    @Override
    protected void saveObject(TransactionRecord obj) {
        TestUtils.save(obj);
    }

    @Override
    protected void deleteObject(TransactionRecord obj) {
        TestUtils.delete(obj);
    }

    @Override
    protected void updateObject(TransactionRecord obj) {
        TestUtils.update(obj);
    }
}
