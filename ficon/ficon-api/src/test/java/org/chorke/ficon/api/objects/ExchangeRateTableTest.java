
package org.chorke.ficon.api.objects;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Currency;
import org.chorke.ficon.api.utils.ExchangeRateTable;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Chorke
 */
public class ExchangeRateTableTest {

    private ExchangeRateTable table;
    
    @Before
    public void setUp(){
        table = new ExchangeRateTable();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void addNullSource(){
        table.addExchangeRate(null, Currency.getInstance("EUR"), BigDecimal.ONE);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void addNullDestination(){
        table.addExchangeRate(Currency.getInstance("EUR"), null, BigDecimal.ONE);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void addNullRate(){
        table.addExchangeRate(Currency.getInstance("EUR"), Currency.getInstance("EUR"), null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void addNegativeRate(){
        table.addExchangeRate(Currency.getInstance("EUR"), Currency.getInstance("EUR"), BigDecimal.ZERO);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void addZeroRate(){
        table.addExchangeRate(Currency.getInstance("EUR"), Currency.getInstance("EUR"), BigDecimal.ONE.negate());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void exchangeNullSource(){
        table.exchange(null, Currency.getInstance("EUR"), BigDecimal.ONE);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void exchangeNullDestination(){
        table.exchange(Currency.getInstance("EUR"), null, BigDecimal.ONE);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void exchangeNullRate(){
        table.exchange(Currency.getInstance("EUR"), Currency.getInstance("EUR"), null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void exchangeNotInTable(){
        table.addExchangeRate(Currency.getInstance("EUR"), Currency.getInstance("USD"), BigDecimal.TEN);
        table.exchange(Currency.getInstance("EUR"), Currency.getInstance("EUR"), BigDecimal.ONE);
    }
    
    @Test
    public void exchange(){
        Currency usd = Currency.getInstance("USD");
        Currency eur = Currency.getInstance("EUR");
        table.addExchangeRate(eur, usd, new BigDecimal("1.4567"));
        BigDecimal res = table.exchange(eur, usd, new BigDecimal("1.54"));
        BigDecimal expected = new BigDecimal("1.4567").multiply(new BigDecimal("1.54"),
                new MathContext(usd.getDefaultFractionDigits()));
        assertTrue(expected.compareTo(res) == 0);
        
        res = table.exchange(usd, eur, new BigDecimal("1.54"));
        
        expected = BigDecimal.ONE.divide(new BigDecimal("1.4567"), new MathContext(5))
                .multiply(new BigDecimal("1.54"),
                new MathContext(usd.getDefaultFractionDigits()));
        assertTrue(expected.compareTo(res) == 0);
    }
}
