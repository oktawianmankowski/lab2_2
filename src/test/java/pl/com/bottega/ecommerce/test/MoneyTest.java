package pl.com.bottega.ecommerce.test;

import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MoneyTest {

    private Money money;
    private int denomination;

    @Before
    public void setUp() {
        denomination = 100;
    }

    @Test
    public void returnDefaultCurrencyCode() {
        money = new Money(denomination);
        assertThat(money.getCurrencyCode(), is("EUR"));
    }

    @Test
    public void returnMoneyMultipliedByDouble() {
        money = new Money(denomination);
        double value = 2.13;
        assertThat(money.multiplyBy(value), is(new Money(denomination * value)));
    }

    @Test
    public void returnMoneyMultipliedByBigDecimal() {
        money = new Money(denomination);
        BigDecimal value = new BigDecimal(2.13);
        assertThat(money.multiplyBy(value), is(new Money(denomination * value.doubleValue())));
    }

    @Test
    public void returnMoneyAddedByMoney() {
        money = new Money(denomination);
        int value = 123;
        Money valueMoney = new Money(value);
        assertThat(money.add(valueMoney), is(new Money(denomination + value)));
    }

    @Test
    public void returnMoneySubtractedByMoney() {
        money = new Money(denomination);
        double value = 23.89;
        Money valueMoney = new Money(value);
        assertThat(money.subtract(valueMoney), is(new Money(denomination - value)));
    }

    @Test
    public void returnCurrencyCode() {
        String PLN = "PLN";
        money = new Money(denomination, PLN);
        assertThat(money.getCurrencyCode(), is(PLN));
    }

}
