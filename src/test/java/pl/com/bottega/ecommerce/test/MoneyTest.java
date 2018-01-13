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
        money = new Money(denomination);
    }

    @Test
    public void returnDefaultCurrencyCode() {
        assertThat(money.getCurrencyCode(), is("EUR"));
    }

    @Test
    public void returnMoneyMultipliedByDouble() {
        double value = 2.13;
        assertThat(money.multiplyBy(value), is(new Money(denomination * value)));
    }

    @Test
    public void returnMoneyMultipliedByBigDecimal() {
        BigDecimal value = new BigDecimal(2.13);
        assertThat(money.multiplyBy(value), is(new Money(denomination * value.doubleValue())));
    }

    @Test
    public void returnMoneyAddedByMoney() {
        int value = 123;
        assertThat(money.add(new Money(value)), is(new Money(denomination + value)));
    }

    @Test
    public void returnMoneySubtractedByMoney() {
        double value = 23.89;
        assertThat(money.subtract(new Money(value)), is(new Money(denomination - value)));
    }

    @Test
    public void returnCurrencyCode() {
        final String PLN = "PLN";
        Money moneyPLN = new Money(denomination, PLN);
        assertThat(moneyPLN.getCurrencyCode(), is(PLN));
    }

    @Test
    public void returnIsGreaterThanMoney() {
        int value = denomination / 2;
        assertThat(money.greaterThan(new Money(value)), is(true));
        assertThat(money.greaterThan(new Money(value + denomination)), is(false));
    }

    @Test
    public void returnIsLessThanMoney() {
        int value = denomination * 2;
        assertThat(money.lessThan(new Money(value)), is(true));
        assertThat(money.lessThan(new Money(value - denomination)), is(false));

    }

    @Test
    public void returnIsLessOrEqualsMoney() {
        int value = denomination;
        assertThat(money.lessOrEquals(new Money(value)), is(true));
        assertThat(money.lessOrEquals(new Money(value + denomination)), is(true));
        assertThat(money.lessOrEquals(new Money(value - denomination)), is(false));

    }

    @Test
    public void returnIsEqualsMoney() {
        assertThat(money.equals(new Money(denomination)), is(true));
        assertThat(money.equals(new Money(denomination * 2)), is(false));
    }

}
