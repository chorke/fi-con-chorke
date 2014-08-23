
package org.chorke.ficon.api.objects;

import org.junit.Test;
import static org.junit.Assert.fail;

/**
 *
 * @author Chorke
 */
public class TransactionRecordTest {

    @Test(expected = IllegalArgumentException.class)
    public void createNewInstanceTestNullAccountsID(){
        TransactionRecord tr = new TransactionRecord(null);
    }
    
    @SuppressWarnings("null")
    @Test(expected = IllegalStateException.class)
    public void setIdTest(){
        TransactionRecord tr = null;
        try{
            tr = new TransactionRecord(1L);
            tr.setId(2L);
        } catch (Exception ex){
            fail(ex.toString());
        }
        tr.setId(3L);
    }
}
