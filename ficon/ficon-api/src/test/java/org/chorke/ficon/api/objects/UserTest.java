
package org.chorke.ficon.api.objects;

import java.util.Iterator;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Chorke
 */
public class UserTest {
    
    @Mock
    private Account account1;
    @Mock
    private Account account2;
    @Mock
    private Account account3;
    
    private Long userID1 = 10L;
    private Long userID2 = 20L;
    
    private User user;
    
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        setUpAccountBehavior(account1, 1L, userID1);
        setUpAccountBehavior(account2, 2L, userID1);
        setUpAccountBehavior(account3, 3L, userID2);
        user = new User();
        user.setId(userID1);
    }
    
    private void setUpAccountBehavior(Account acc, Long id, Long userID){
        when(acc.getId()).thenReturn(id);
        when(acc.getUsersID()).thenReturn(userID);
    }
    
    @Test(expected = IllegalStateException.class)
    public void setIdTest(){
        user.setId(3L);
    }
    
    @Test
    public void addGetRemoveAccountTest(){
        if(!user.getAccounts().isEmpty()){
            fail("New user with accounts");
        }
        //add first transaction
        user.addAccount(account1);
        if(user.getAccounts().size() != 1){
            fail("More then one account has been added.");
        }
        if(user.getAccounts().iterator().next() != account1){
            fail("Unequal accounts.");
        }
        // add second transaction
        user.addAccount(account2);
        if(user.getAccounts().size() != 2){
            fail("Wrong number of accounts.");
        }
        Iterator<Account> iter = user.getAccounts().iterator();
        Account ac1 = iter.next();
        Account ac2 = iter.next();
        if(!((ac1 == account1 && ac2 == account2)
               || (ac1 == account2 && ac2 == account1))){
            fail("Unequal accounts.");
        }
        //remove transaction
        user.removeAccount(account1);
        if(user.getAccounts().size() != 1){
            fail("Wrong number of accounts.");
        }
        if(user.getAccounts().iterator().next() != account2){
            fail("Unequal accounts.");
        }
        //remove missing transaction
        user.removeAccount(account1);
        if(user.getAccounts().size() != 1){
            fail("Wrong number of accounts.");
        }
        if(user.getAccounts().iterator().next() != account2){
            fail("Unequal accounts.");
        }
        //remove transaction with wrong accountID
        user.removeAccount(account3);
        if(user.getAccounts().size() != 1){
            fail("Wrong number of accounts.");
        }
        if(user.getAccounts().iterator().next() != account2){
            fail("Unequal accounts.");
        }
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void addWrongTransactionTest(){
        user.addAccount(account3);
    }
}
