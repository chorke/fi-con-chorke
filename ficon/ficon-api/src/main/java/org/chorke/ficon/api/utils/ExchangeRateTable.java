
package org.chorke.ficon.api.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Chorke
 */
public class ExchangeRateTable {

    private Set<ExchangeRate> table = new HashSet<>();
    
    public void addExchangeRate(Currency source, Currency destination, BigDecimal rate){
        if(rate == null){
            throw new IllegalArgumentException("Rate cannot be null.");
        }
        rate = rate.round(new MathContext(5));
        ExchangeRate r1 = new ExchangeRate(source, destination, rate);
        ExchangeRate r2 = new ExchangeRate(destination, source,
                BigDecimal.ONE.divide(rate, 5, RoundingMode.HALF_UP));
        if(table.contains(r1)){
            table.remove(r1);
            table.remove(r2);
        }
        table.add(r1);
        table.add(r2);
    }
    
    public BigDecimal exchange(Currency source, Currency destination, BigDecimal amount){
        if(amount == null){
            throw new IllegalArgumentException("Amount cannot be null.");
        }
        ExchangeRate r = new ExchangeRate(source, destination, BigDecimal.ONE);
        for(ExchangeRate er : table){
            if(r.equals(er)){
                return er.exchangeMoney(amount);
            }
        }
        throw new IllegalArgumentException("The exchange rate is not in the table ["
                + source + " -> " + destination + "].");
    }
    
    private class ExchangeRate{
        private final Currency src;
        private final Currency des;
        private final BigDecimal rate;

        public ExchangeRate(Currency src, Currency des, BigDecimal rate) {
            if(src == null || des == null || rate == null){
                throw new IllegalArgumentException("No argument can be null.");
            }
            if(rate.signum() != 1){
                throw new IllegalArgumentException("Rate must be positive.");
            }
            this.src = src;
            this.des = des;
            this.rate = rate;
        }

        private BigDecimal exchangeMoney(BigDecimal amount){
            return amount.multiply(rate, new MathContext(des.getDefaultFractionDigits()));
        }
        
        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof ExchangeRate)){
                return false;
            }
            ExchangeRate er = (ExchangeRate)obj;
            return er.src == this.src && er.des == this.des;
        }

        @Override
        public int hashCode() {
            return src.hashCode() * des.hashCode();
        }
    }
}
