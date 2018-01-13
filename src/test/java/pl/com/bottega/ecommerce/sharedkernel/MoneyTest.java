package pl.com.bottega.ecommerce.sharedkernel;

import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.Currency;

import org.hamcrest.Matchers;
import org.junit.Test;

public class MoneyTest {

    @Test
    public void multiplyTestPositive() {
        BigDecimal actualValue = new BigDecimal(100);
        BigDecimal expectedValue = new BigDecimal(500);
        BigDecimal multiplyier = new BigDecimal(5);
        Currency currency = Currency.getInstance("USD");
        Money actualMoney = new Money(actualValue, currency);
        Money expectedMoney = new Money(expectedValue, currency);

        assertThat(actualMoney.multiplyBy(multiplyier), Matchers.is(expectedMoney));
    }

    @Test
    public void addTestPositive() {
        BigDecimal actualValue = new BigDecimal(100);
        BigDecimal expectedValue = new BigDecimal(200);
        Currency currency = Currency.getInstance("USD");
        Money actualMoneyFirst = new Money(actualValue, currency);
        Money actualMoneySecond = new Money(actualValue, currency);
        Money expectedMoney = new Money(expectedValue, currency);

        assertThat(actualMoneyFirst.add(actualMoneySecond), Matchers.is(expectedMoney));
    }

    @Test(expected = IllegalArgumentException.class)
    public void substractTestException() throws IllegalArgumentException {
        BigDecimal firstValue = new BigDecimal(100);
        BigDecimal secondValue = new BigDecimal(100);
        BigDecimal expectedValue = new BigDecimal(200);
        Currency firstCurrency = Currency.getInstance("USD");
        Currency secondCurrency = Currency.getInstance("PLN");
        Money firstMoney = new Money(firstValue, firstCurrency);
        Money secondMoney = new Money(secondValue, secondCurrency);
        Money expectedMoney = new Money(expectedValue, secondCurrency);

        assertThat(firstMoney.add(secondMoney), Matchers.is(expectedMoney));
    }

    @Test
    public void substractTestPositive() {
        BigDecimal firstValue = new BigDecimal(100);
        BigDecimal secondValue = new BigDecimal(100);
        BigDecimal expectedValue = new BigDecimal(200);
        Currency firstCurrency = Currency.getInstance("USD");
        Money firstMoney = new Money(firstValue, firstCurrency);
        Money secondMoney = new Money(secondValue, firstCurrency);
        Money expectedMoney = new Money(expectedValue, firstCurrency);

        assertThat(firstMoney.add(secondMoney), Matchers.is(expectedMoney));
    }

}
