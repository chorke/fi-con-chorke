
package org.chorke.ficon.api.test.services;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import org.chorke.ficon.api.exceptions.TransactionRecordServiceException;
import org.chorke.ficon.api.objects.TransactionRecord;
import org.chorke.ficon.api.services.TransactionRecordService;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Abstract test for TransactionRecordService. When implementing 
 * TransactionRecordService interface 
 * all what you need to do to test it, is to extend this class and implement
 * abstract methods. 
 * 
 * @author Chorke
 */
public abstract class TransactionRecordServiceAbstractTest 
    extends AbstractServiceTest<TransactionRecordService, TransactionRecord>{

    /**
     * Creates new transaction record. Method calls associated {@code befor}
     * method, create method of service and associated {@code after} method.
     * Depends on standard create method of service.
     * 
     * @param record record to be created
     * @throws TransactionRecordServiceException
     * @see #beforeCreateNewTransactionRecord(org.chorke.ficon.api.objects.TransactionRecord) 
     * @see #afterCreateNewTransactionRecord(java.lang.Exception, org.chorke.ficon.api.objects.TransactionRecord) 
     */
    protected final void doCreateNewTransactionRecord(TransactionRecord record)
            throws TransactionRecordServiceException{
        beforeCreateNewTransactionRecord(record);
        try{
            service.createNewTransactionRecord(record);
            afterCreateNewTransactionRecord(null, record);
        } catch (TransactionRecordServiceException | IllegalArgumentException ex){
            afterCreateNewTransactionRecord(ex, record);
            throw ex;
        }
    }
    
    /**
     * Updates transaction record. Method calls associated {@code befor}
     * method, update method of service and associated {@code after} method.
     * Depends on standard update method of service.
     * 
     * @param record record to be updated
     * @throws TransactionRecordServiceException
     * @see #beforeUpdateTransactionRecord(org.chorke.ficon.api.objects.TransactionRecord) 
     * @see #afterUpdateTransactionRecord(java.lang.Exception, org.chorke.ficon.api.objects.TransactionRecord)  
     */
    protected final void doUpdateTransactionRecord(TransactionRecord record)
            throws TransactionRecordServiceException{
        beforeUpdateTransactionRecord(record);
        try{
            service.updateTransactionRecord(record);
            afterUpdateTransactionRecord(null, record);
        } catch (TransactionRecordServiceException | IllegalArgumentException ex){
            afterUpdateTransactionRecord(ex, record);
            throw ex;
        }
    }
    
    /**
     * Returns transaction record. Method calls associated {@code befor}
     * method, get method of service and associated {@code after} method.
     * Depends on standard get method of service.
     * 
     * @param id ID of record
     * @throws TransactionRecordServiceException
     * @see #beforeGetTransactionRecord(java.lang.Long) 
     * @see #afterGetTransactionRecord(java.lang.Exception, java.lang.Long)
     */
    protected final TransactionRecord doGetTransactionRecord(Long id)
            throws TransactionRecordServiceException{
        beforeGetTransactionRecord(id);
        try{
            TransactionRecord rec = service.getTransactionRecord(id);
            afterGetTransactionRecord(null, id);
            return rec;
        } catch (TransactionRecordServiceException | IllegalArgumentException ex){
            afterGetTransactionRecord(ex, id);
            throw ex;
        }
    }
    
    /**
     * Deletes transaction record. Method calls associated {@code befor}
     * method, delete method of service and associated {@code after} method.
     * Depends on standard delete method of service.
     * 
     * @param record record to be deleted
     * @throws TransactionRecordServiceException
     * @see #beforeDeleteTransactionRecord(org.chorke.ficon.api.objects.TransactionRecord) 
     * @see #afterDeleteTransactionRecord(java.lang.Exception, org.chorke.ficon.api.objects.TransactionRecord)  
     */
    protected final void doDeleteTransactionRecord(TransactionRecord record)
            throws TransactionRecordServiceException{
        beforeDeleteTransactionRecord(record);
        try{
            service.deleteTransactionRecord(record);
            afterDeleteTransactionRecord(null, record);
        } catch (TransactionRecordServiceException | IllegalArgumentException ex){
            afterDeleteTransactionRecord(ex, record);
            throw ex;
        }
    }
    
    /**
     * This method is called closely before calling create method of service with 
     * parameter {@code record}.
     * 
     * @param record 
     */
    protected abstract void beforeCreateNewTransactionRecord(TransactionRecord record);
    /**
     * This method is called immediately after calling create method of service with 
     * parameter {@code record}.
     * 
     * @param thrown exception that has been thrown during operation
     * @param record 
     */
    protected abstract void afterCreateNewTransactionRecord(Exception thrown, TransactionRecord record);
    
    /**
     * This method is called closely before calling update method of service with 
     * parameter {@code record}.
     * 
     * @param record 
     */
    protected abstract void beforeUpdateTransactionRecord(TransactionRecord record);
    /**
     * This method is called immediately after calling update method of service with 
     * parameter {@code record}.
     * 
     * @param thrown exception that has been thrown during operation
     * @param record 
     */
    protected abstract void afterUpdateTransactionRecord(Exception thrown, TransactionRecord record);
    
    /**
     * This method is called closely before calling get method of service with 
     * parameter {@code id}.
     * 
     * @param id 
     */
    protected abstract void beforeGetTransactionRecord(Long id);
    /**
     * This method is called immediately after calling get method of service with 
     * parameter {@code id}.
     * 
     * @param thrown exception that has been thrown during operation
     * @param id
     */
    protected abstract void afterGetTransactionRecord(Exception thrown, Long id);
    
    /**
     * This method is called closely before calling delete method of service with 
     * parameter {@code record}.
     * 
     * @param record 
     */
    protected abstract void beforeDeleteTransactionRecord(TransactionRecord record);
    /**
     * This method is called immediately after calling delete method of service with 
     * parameter {@code record}.
     * 
     * @param thrown exception that has been thrown during operation
     * @param record 
     */
    protected abstract void afterDeleteTransactionRecord(Exception thrown, TransactionRecord record);
    
      /////////////////////////////
     /////////// Tests ///////////
    /////////////////////////////
    
    ////////// create //////////
    
    @Test(expected = IllegalArgumentException.class)
    public void createNullArgument() throws TransactionRecordServiceException{
        doCreateNewTransactionRecord(null);
        fail("null argument");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void createIDAlreadySet() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(1L, 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        doCreateNewTransactionRecord(tr);
        fail("id already set");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void createNullUserID() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, null,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        doCreateNewTransactionRecord(tr);
        fail("account's ID is null");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void createNullName() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                null, "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        doCreateNewTransactionRecord(tr);
        fail("transaction's name is null");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void createEmptyName() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                "", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        doCreateNewTransactionRecord(tr);
        fail("transaction's name is empty");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void createNullAmount() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                "name", "description", null, null,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        doCreateNewTransactionRecord(tr);
        fail("amount is null");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void createZeroAmount() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                "name", "description", null, BigDecimal.ZERO,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        doCreateNewTransactionRecord(tr);
        fail("amount is zero");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void createNullDate() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                "name", "description", null, BigDecimal.ONE,
                null);
        doCreateNewTransactionRecord(tr);
        fail("transaction's date is null");
    }
    
    @Test
    public void createOkArgumentDescriptionSet() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        doCreateNewTransactionRecord(tr);
        TransactionRecord trClone = getTransactionRecord(tr.getId(), 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        TransactionRecord fromDB = getObject(tr.getId());
        deepEquals(trClone, fromDB);
    }
    
    @Test
    public void createOkArgumentDescriptionEmpty() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                "name", "", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        doCreateNewTransactionRecord(tr);
        TransactionRecord trClone = getTransactionRecord(tr.getId(), 1L,
                "name", "", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        TransactionRecord fromDB = getObject(tr.getId());
        deepEquals(trClone, fromDB);
    }
    
    @Test
    public void createOkArgumentDescriptionNull() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                "name", null, null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        doCreateNewTransactionRecord(tr);
        TransactionRecord trClone = getTransactionRecord(tr.getId(), 1L,
                "name", null, null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        TransactionRecord fromDB = getObject(tr.getId());
        deepEquals(trClone, fromDB);
    }
    
    @Test
    public void createOkArgumentAssociatedTranactionsIDSet() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                "name", null, 10L, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        doCreateNewTransactionRecord(tr);
        TransactionRecord trClone = getTransactionRecord(tr.getId(), 1L,
                "name", null, 10L, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        TransactionRecord fromDB = getObject(tr.getId());
        deepEquals(trClone, fromDB);
    }
    
    ////////// delete //////////
    
    @Test(expected = IllegalArgumentException.class)
    public void deleteNullArgument() throws TransactionRecordServiceException{
        doDeleteTransactionRecord(null);
        fail("null argument");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void deleteNullID() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        doDeleteTransactionRecord(tr);
        fail("null ID");
    }
    
    @Test()
    public void deleteOkArgumentRecordNotInDB() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        saveObject(tr);
        TransactionRecord notInDB = getTransactionRecord(tr.getId() + 1, 1L,
                "name2", "not in DB", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        doDeleteTransactionRecord(notInDB);
        Collection<TransactionRecord> fromDB = getAllObjects();
        deepListTransactionsEquals(Arrays.asList(tr), fromDB);
    }
    
    @Test
    public void deleteOkArgument() throws TransactionRecordServiceException{
        TransactionRecord tr1 = getTransactionRecord(null, 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        TransactionRecord tr2 = getTransactionRecord(null, 2L,
                "name2", "description1", null, BigDecimal.TEN,
                new GregorianCalendar(2014, Calendar.JANUARY, 14));
        TransactionRecord tr1ForDelete = getTransactionRecord(tr1.getId(), 1L,
                null, null, null, null, null);
        saveObject(tr1);
        saveObject(tr2);
        doDeleteTransactionRecord(tr1ForDelete);
        deepListTransactionsEquals(getAllObjects(), Arrays.asList(tr2));
    }
    
    ////////// update //////////
    
    @Test(expected = IllegalArgumentException.class)
    public void updateNullArgument() throws TransactionRecordServiceException{
        doUpdateTransactionRecord(null);
        fail("null argument");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void updateNullID() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        doUpdateTransactionRecord(tr);
        fail("null ID");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void updateNullName() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        saveObject(tr);
        TransactionRecord trToUpdate = getTransactionRecord(tr.getId(), 1L,
                null, "description2", null, BigDecimal.TEN,
                new GregorianCalendar(2014, Calendar.JUNE, 13));
        try{
            doUpdateTransactionRecord(trToUpdate);
            fail("null name");
        } catch (IllegalArgumentException ex){
            TransactionRecord trClone = getTransactionRecord(tr.getId(), 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
            deepListTransactionsEquals(Arrays.asList(trClone), getAllObjects());
            throw ex;
        }
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void updateEmptyName() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                "", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        saveObject(tr);
        TransactionRecord trToUpdate = getTransactionRecord(tr.getId(), 1L,
                "", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        try{
            doUpdateTransactionRecord(trToUpdate);
            fail("empty name");
        } catch (IllegalArgumentException ex){
            TransactionRecord trClone = getTransactionRecord(tr.getId(), 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
            deepListTransactionsEquals(Arrays.asList(trClone), getAllObjects());
            throw ex;
        }
    }
    
    @Test(expected = TransactionRecordServiceException.class)
    public void updateRecordNotInDB() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        saveObject(tr);
        TransactionRecord trToUpdate = getTransactionRecord(tr.getId() + 1, 1L,
                "name2", "description2", null, BigDecimal.TEN,
                new GregorianCalendar(2015, Calendar.JULY, 16));
        try{
            doUpdateTransactionRecord(trToUpdate);
            fail("record not in DB");
        } catch (TransactionRecordServiceException ex){
            TransactionRecord trClone = getTransactionRecord(tr.getId(), 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
            deepListTransactionsEquals(getAllObjects(), Arrays.asList(trClone));
            throw ex;
        }
    }
    
    @Test(expected = TransactionRecordServiceException.class)
    public void updateAccountsIDChanged() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        saveObject(tr);
        TransactionRecord trToUpdate = getTransactionRecord(tr.getId(), tr.getAccountID() + 1,
                "name2", "description after", null, BigDecimal.TEN,
                new GregorianCalendar(2015, Calendar.JULY, 16));
        try{
            doUpdateTransactionRecord(trToUpdate);
            fail("account's ID has been changed");
        } catch (TransactionRecordServiceException ex){
            TransactionRecord trClone = getTransactionRecord(tr.getId(), 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
            deepListTransactionsEquals(getAllObjects(), Arrays.asList(trClone));
            throw ex;
        }
    }
    
    @Test
    public void updateOkArgumentNameChanged() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        saveObject(tr);
        TransactionRecord trToUpdate = getTransactionRecord(tr.getId(), 1L,
                "nameafter", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        
        doUpdateTransactionRecord(trToUpdate);
        
        TransactionRecord trToUpdateClone = getTransactionRecord(tr.getId(), 1L,
                "nameafter", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        deepListTransactionsEquals(Arrays.asList(trToUpdateClone), getAllObjects());
    }
    
    @Test
    public void updateOkArgumentDescriptionChanged() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        saveObject(tr);
        TransactionRecord trToUpdate = getTransactionRecord(tr.getId(), 1L,
                "name", "description after update", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        
        doUpdateTransactionRecord(trToUpdate);
        
        TransactionRecord trToUpdateClone = getTransactionRecord(tr.getId(), 1L,
                "name", "description after update", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        deepListTransactionsEquals(Arrays.asList(trToUpdateClone), getAllObjects());
    }
    
    @Test
    public void updateOkArgumentDescriptionToEmpty() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        saveObject(tr);
        TransactionRecord trToUpdate = getTransactionRecord(tr.getId(), 1L,
                "name", "", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        
        doUpdateTransactionRecord(trToUpdate);
        
        TransactionRecord trToUpdateClone = getTransactionRecord(tr.getId(), 1L,
                "name", "", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        deepListTransactionsEquals(Arrays.asList(trToUpdateClone), getAllObjects());
    }
    
    @Test
    public void updateOkArgumentDescriptionToNull() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        saveObject(tr);
        TransactionRecord trToUpdate = getTransactionRecord(tr.getId(), 1L,
                "name", null, null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        
        doUpdateTransactionRecord(trToUpdate);
        
        TransactionRecord trToUpdateClone = getTransactionRecord(tr.getId(), 1L,
                "name", null, null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        deepListTransactionsEquals(Arrays.asList(trToUpdateClone), getAllObjects());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void updateOkArgumentAmountToZero() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        saveObject(tr);
        TransactionRecord trToUpdate = getTransactionRecord(tr.getId(), 1L,
                "name2", "description2", null, BigDecimal.ZERO,
                new GregorianCalendar(2014, Calendar.JANUARY, 23));
        try{
            doUpdateTransactionRecord(trToUpdate);
            fail("zero amount");
        } catch (IllegalArgumentException ex){
            TransactionRecord trClone = getTransactionRecord(tr.getId(), 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
            deepListTransactionsEquals(Arrays.asList(trClone), getAllObjects());
            throw ex;
        }
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void updateOkArgumentAmountToNull() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        saveObject(tr);
        TransactionRecord trToUpdate = getTransactionRecord(tr.getId(), 1L,
                "name2", "description2", null, null,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        try{
            doUpdateTransactionRecord(trToUpdate);
            fail("null amount");
        } catch (IllegalArgumentException ex){
            TransactionRecord trClone = getTransactionRecord(tr.getId(), 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
            deepListTransactionsEquals(Arrays.asList(trClone), getAllObjects());
            throw ex;
        }
    }
    
    @Test
    public void updateOkArgumentAmountChanged() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        saveObject(tr);
        TransactionRecord trToUpdate = getTransactionRecord(tr.getId(), 1L,
                "name", "description", null, BigDecimal.TEN.negate(),
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        
        doUpdateTransactionRecord(trToUpdate);
        
        TransactionRecord trToUpdateClone = getTransactionRecord(tr.getId(), 1L,
                "name", "description", null, BigDecimal.TEN.negate(),
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        deepListTransactionsEquals(Arrays.asList(trToUpdateClone), getAllObjects());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void updateOkArgumentDateToNull() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        saveObject(tr);
        TransactionRecord trToUpdate = getTransactionRecord(tr.getId(), 1L,
                "name2", "description2", null, BigDecimal.ONE, null);
        try{
            doUpdateTransactionRecord(trToUpdate);
            fail("null name");
        } catch (IllegalArgumentException ex){
            TransactionRecord trClone = getTransactionRecord(tr.getId(), 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
            deepListTransactionsEquals(Arrays.asList(trClone), getAllObjects());
            throw ex;
        }
    }
    
    @Test
    public void updateOkArgumentDateChanged() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        saveObject(tr);
        TransactionRecord trToUpdate = getTransactionRecord(tr.getId(), 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2015, Calendar.JULY, 14));
        
        doUpdateTransactionRecord(trToUpdate);
        
        TransactionRecord trToUpdateClone = getTransactionRecord(tr.getId(), 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2015, Calendar.JULY, 14));
        deepListTransactionsEquals(Arrays.asList(trToUpdateClone), getAllObjects());
    }
    
    @Test(expected = TransactionRecordServiceException.class)
    public void updateAssociatedTransactionsIDChangedToNumber() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        saveObject(tr);
        TransactionRecord trToUpdate = getTransactionRecord(tr.getId(), 1L,
                "name2", "description2", 1L, BigDecimal.TEN,
                new GregorianCalendar(2014, Calendar.JANUARY, 1));
        try{
            doUpdateTransactionRecord(trToUpdate);
            fail("associated transaction's ID has been changed");
        } catch (TransactionRecordServiceException ex){
            TransactionRecord trClone = getTransactionRecord(tr.getId(), 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
            deepListTransactionsEquals(getAllObjects(), Arrays.asList(trClone));
            throw ex;
        }
    }
    
    @Test(expected = TransactionRecordServiceException.class)
    public void updateAssociatedTransactionsIDChangedToNull() throws TransactionRecordServiceException{
        TransactionRecord tr = getTransactionRecord(null, 1L,
                "name", "description", 1L, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        saveObject(tr);
        TransactionRecord trToUpdate = getTransactionRecord(tr.getId(), 1L,
                "name2", "description2", null, BigDecimal.TEN,
                new GregorianCalendar(2014, Calendar.JANUARY, 3));
        try{
            doUpdateTransactionRecord(trToUpdate);
            fail("associated transaction's ID has been changed");
        } catch (TransactionRecordServiceException ex){
            TransactionRecord trClone = getTransactionRecord(tr.getId(), 1L,
                "name", "description", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
            deepListTransactionsEquals(getAllObjects(), Arrays.asList(trClone));
            throw ex;
        }
    }
    
    /////////// get ////////////
    
    @Test(expected = IllegalArgumentException.class)
    public void getNullArgument() throws TransactionRecordServiceException{
        doGetTransactionRecord(null);
        fail("null argument");
    }
    
    @Test
    public void getNotInDB() throws TransactionRecordServiceException{
        TransactionRecord tr1 = getTransactionRecord(null, 1L,
                "name1", "description1", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        saveObject(tr1);
        assertNull("Record with declared ID is not in DB.", doGetTransactionRecord(tr1.getId() + 1));
    }
    
    @Test
    public void getOkArgument() throws TransactionRecordServiceException{
        TransactionRecord tr1 = getTransactionRecord(null, 1L,
                "name1", "description1", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        TransactionRecord tr2 = getTransactionRecord(null, 1L,
                "name2", "description2", null, BigDecimal.TEN,
                new GregorianCalendar(2014, Calendar.JULY, 14));
        saveObject(tr1);
        saveObject(tr2);
        TransactionRecord fromDB = doGetTransactionRecord(tr1.getId());
        TransactionRecord tr1Clone = getTransactionRecord(tr1.getId(), 1L,
                "name1", "description1", null, BigDecimal.ONE,
                new GregorianCalendar(2014, Calendar.JANUARY, 13));
        deepEquals(tr1Clone, fromDB);
    }
}
