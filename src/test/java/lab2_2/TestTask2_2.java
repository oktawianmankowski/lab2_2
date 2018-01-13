package lab2_2;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;

import pl.com.bottega.ecommerce.sharedkernel.Money;

public class TestTask2_2 {

    @org.junit.Test
    public void moneyMultiplyingByTwo() {
        Money money = new Money(120, "PLN");
        assertThat(money.multiplyBy(2), Matchers.is(new Money(240, "PLN")));
    }

    @org.junit.Test
    public void moneyDivideByTwoSecondTwoParametersConstructor() {
        Money money = new Money(120);
        assertThat(money.multiplyBy(0.5), Matchers.is(new Money(60)));
    }

    @org.junit.Test
    public void moneyAddingTwoArguments() {
        Money money1arg = new Money(120, "PLN");
        Money money2arg = new Money(240, "PLN");
        assertThat(money1arg.add(money2arg), Matchers.is(new Money(360, "PLN")));
    }

    @org.junit.Test
    public void moneyAddingWithDefaultCurrency() {
        Money money1arg = new Money(60);
        Money money2arg = new Money(20);
        assertThat(money1arg.add(money2arg), Matchers.is(new Money(80, "EUR")));
    }

    @org.junit.Test
    public void moneySubstractionTwoArguments() {
        Money money1arg = new Money(60, "PLN");
        Money money2arg = new Money(20, "PLN");
        assertThat(money1arg.subtract(money2arg), Matchers.is(new Money(40, "PLN")));
    }

    @org.junit.Test
    public void moneySubstractionTwoArgumentsOneWithDefaultCurrency() {
        Money money1arg = new Money(60, "EUR");
        Money money2arg = new Money(20);
        assertThat(money1arg.subtract(money2arg), Matchers.is(new Money(40, "EUR")));
    }

    @org.junit.Test
    public void exceptionThrownByAddBecauseOfDifferentCurrencies() {
        Money money1arg = new Money(60, "EUR");
        Money money2arg = new Money(20, "PLN");
        boolean result = true;
        try {
            money1arg.add(money2arg);
        } catch (IllegalArgumentException e) {
            result = false;
        }
        assertThat(result, Matchers.is(false));
    }

    @org.junit.Test
    public void exceptionThrownBySubtractionBecauseOfDifferentCurrencies() {
        Money money1arg = new Money(60, "EUR");
        Money money2arg = new Money(20, "PLN");
        boolean result = true;
        try {
            money1arg.subtract(money2arg);
        } catch (IllegalArgumentException e) {
            result = false;
        }
        assertThat(result, Matchers.is(false));
    }

    @org.junit.Test
    public void moneyGreaterThanMethodTest() {
        Money money1arg = new Money(60, "EUR");
        Money money2arg = new Money(20);
        assertThat(money1arg.greaterThan(money2arg), Matchers.is(true));
    }

    @org.junit.Test
    public void moneyLessOrEqualThanMethodTest() {
        Money money1arg = new Money(60, "EUR");
        Money money2arg = new Money(20);
        assertThat(money1arg.lessThan(money2arg), Matchers.is(false));
    }
}
