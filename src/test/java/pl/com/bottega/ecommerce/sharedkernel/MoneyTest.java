package pl.com.bottega.ecommerce.sharedkernel;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.Assert.assertThat;

public class MoneyTest {

    @Test
    public void multiplyByFiveIsCorrect() {
        Money money = new Money(new BigDecimal(2), Currency.getInstance("PLN"));
        assertThat(money.multiplyBy(5), Matchers.is(new Money(new BigDecimal(10), Currency.getInstance("PLN"))));
    }

    @Test
    public void addSixEuroToFiveEuro() {
        Money money = new Money(new BigDecimal(5), Currency.getInstance("EUR"));
        Money addMoney = new Money(new BigDecimal(6), Currency.getInstance("EUR"));
        Money expectedMoney = new Money(new BigDecimal(11), Currency.getInstance("EUR"));
        assertThat(money.add(addMoney), Matchers.is(expectedMoney));
    }

    @Test
    public void subtractSevenEuroFromTenEuro() {
        Money money = new Money(new BigDecimal(10), Currency.getInstance("EUR"));
        Money subtractMoney = new Money(new BigDecimal(7), Currency.getInstance("EUR"));
        Money expectedMoney = new Money(new BigDecimal(3), Currency.getInstance("EUR"));
        assertThat(money.subtract(subtractMoney), Matchers.is(expectedMoney));
    }
}