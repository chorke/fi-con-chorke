
package org.chorke.ficon.api.objects;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
import org.junit.Test;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Chorke
 */
public class AccountTest {

    @Mock
    private TransactionRecord transaction1;
    @Mock
    private TransactionRecord transaction2;
    @Mock
    private TransactionRecord transaction3;
    
    private Long accountID1 = 1L;
    private Long accountID2 = 2L;
    
    private BigDecimal amount1 = new BigDecimal("100.543");
    private BigDecimal amount2 = new BigDecimal("-50.124");
    private BigDecimal amount3 = new BigDecimal("100");
    
    private Account account;
    
    private static final Currency DEFAULT_CURRENCY = Currency.getInstance(new Locale("sk", "SK"));
    
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        setUpTransactionBehavior(transaction1, 1L, accountID1, amount1);
        setUpTransactionBehavior(transaction2, 2L, accountID1, amount2);
        setUpTransactionBehavior(transaction3, 3L, accountID2, amount3);
        account = new Account(1L, DEFAULT_CURRENCY);
        account.setId(accountID1);
    }
    
    private void setUpTransactionBehavior(TransactionRecord tr, Long id,
            Long accountID, BigDecimal amount){
        when(tr.getAmount()).thenReturn(amount);
        when(tr.getId()).thenReturn(id);
        when(tr.getAccountID()).thenReturn(accountID);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void createNewInstanceTestNullID(){
        account = new Account(null, DEFAULT_CURRENCY);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void createNewInstanceTestNullCurrency(){
        account = new Account(1L, null);
    }
    
    @Test(expected = IllegalStateException.class)
    public void setIdTest(){
        account.setId(3L);
    }
    
    @Test
    public void addGetRemoveTransactionTest(){
        if(!account.getTransactions().isEmpty()){
            fail("New account with transactions");
        }
        //add first transaction
        account.addTransaction(transaction1);
        if(account.getTransactions().size() != 1){
            fail("More then one transaction has been added.");
        }
        if(account.getTransactions().get(0) != transaction1){
            fail("Unequal transactions.");
        }
        // add second transaction
        account.addTransaction(transaction2);
        if(account.getTransactions().size() != 2){
            fail("Wrong number of transactions.");
        }
        if(account.getTransactions().get(0) != transaction1){
            fail("Unequal transactions.");
        }
        if(account.getTransactions().get(1) != transaction2){
            fail("Unequal transactions.");
        }
        //remove transaction
        account.removeTransaction(transaction1);
        if(account.getTransactions().size() != 1){
            fail("Wrong number of transactions.");
        }
        if(account.getTransactions().get(0) != transaction2){
            fail("Unequal transactions.");
        }
        //remove missing transaction
        account.removeTransaction(transaction1);
        if(account.getTransactions().size() != 1){
            fail("Wrong number of transactions.");
        }
        if(account.getTransactions().get(0) != transaction2){
            fail("Unequal transactions.");
        }
        //remove transaction with wrong accountID
        account.removeTransaction(transaction3);
        if(account.getTransactions().size() != 1){
            fail("Wrong number of transactions.");
        }
        if(account.getTransactions().get(0) != transaction2){
            fail("Unequal transactions.");
        }
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void addWrongTransactionTest(){
        account.addTransaction(transaction3);
    }
    
    @Test
    public void getBalanceTest(){
        if(account.getBalance().compareTo(BigDecimal.ZERO) != 0){
            fail("New account has nonzero balance.");
        }
        account.addTransaction(transaction1);
        account.addTransaction(transaction2);
        if(account.getBalance().compareTo(amount1.add(amount2)) != 0){
            fail("Wrong balance.");
        }
        account.removeTransaction(transaction1);
        if(account.getBalance().compareTo(amount2) != 0){
            fail("Wrong balance.");
        }
    }
}
