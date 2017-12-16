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
    public void returnMultipliedByDouble() {
        money = new Money(denomination);
        double value = 2.13;
        assertThat(money.multiplyBy(value), is(new Money(denomination * value)));
    }

    @Test
    public void returnMultipliedByBigDecimal() {
        money = new Money(denomination);
        BigDecimal value = new BigDecimal(2.13);
        assertThat(money.multiplyBy(value), is(new Money(denomination * value.doubleValue())));
    }
}
