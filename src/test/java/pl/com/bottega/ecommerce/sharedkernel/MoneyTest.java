package pl.com.bottega.ecommerce.sharedkernel;

import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.Currency;

import org.hamcrest.Matchers;
import org.junit.Test;

public class MoneyTest {

    @Test
    public void multiplyTest() {
        BigDecimal actualValue = new BigDecimal(100);
        BigDecimal expectedValue = new BigDecimal(500);
        BigDecimal multiplyier = new BigDecimal(5);
        Currency currency = Currency.getInstance("USD");
        Money actualMoney = new Money(actualValue, currency);
        Money expectedMoney = new Money(expectedValue, currency);

        assertThat(actualMoney.multiplyBy(multiplyier), Matchers.is(expectedMoney));
    }

}
