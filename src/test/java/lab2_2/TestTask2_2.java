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
    public void monyeMultiplyingByTwo() {
        Money money = new Money(120, "PLN");

        assertThat(money.multiplyBy(2), Matchers.is(new Money(240, "PLN")));
    }

    public void monyeDivideByTwoSecondTwoParametersConstructor() {
        Money money = new Money(120);
        assertThat(money.multiplyBy(1 / 2), Matchers.is(new Money(60, "PLN")));
    }
}
