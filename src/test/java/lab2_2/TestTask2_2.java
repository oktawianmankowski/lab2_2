package lab2_2;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;

import pl.com.bottega.ecommerce.sharedkernel.Money;

public class TestTask2_2 {

    @org.junit.Test
    public void testExample() {
        boolean testResult = true;
        assertThat(testResult, Matchers.is(true));
    }

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
}
