package lab2_2;

import org.hamcrest.Matchers;
import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.junit.Assert.assertThat;

public class Testy_2_2 {

    @Test public void testShouldGiveAnswerMultiplyByTwo() {
        Money money = new Money(100, "PLN");
        assertThat(money.multiplyBy(2), Matchers.is(new Money(200, "PLN")));
    }

    @Test public void testShouldGiveMoneyDivideByTwoSecondTwoParametersConstructor() {
        Money money = new Money(120);
        assertThat(money.multiplyBy(0.5), Matchers.is(new Money(60)));
    }
    @Test
    public void testShouldGiveSumMoneyTwoArguments() {
        Money money1arg = new Money(60, "PLN");
        Money money2arg = new Money(200, "PLN");
        assertThat(money1arg.add(money2arg), Matchers.is(new Money(260, "PLN")));
    }

    @Test
    public void testShouldGiveSubtractMoneyTwoArgumentsAndOneCurrency() {
        Money money1arg = new Money(60, "EUR");
        Money money2arg = new Money(20);
        assertThat(money1arg.subtract(money2arg), Matchers.is(new Money(40, "EUR")));
    }

    @Test
    public void testShouldGiveSubtractMoneyTwoArgumentsAndTwoCurrency() {
        Money money1arg = new Money(60, "PLN");
        Money money2arg = new Money(20, "PLN");
        assertThat(money1arg.subtract(money2arg), Matchers.is(new Money(40, "PLN")));
    }

    @Test
    public void testShouldGiveSumMoneyWithCurrencyCodeEur() {
        Money money1arg = new Money(60);
        Money money2arg = new Money(20);
        assertThat(money1arg.add(money2arg), Matchers.is(new Money(80, "EUR")));
    }

}
