package pl.com.bottega.ecommerce.sharedkernel;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;
import static org.junit.Assert.assertThat;

public class MoneyTest {

    @Test
    public void MultiplyByFiveIsCorrect(){
        Money money = new Money(new BigDecimal(2), Currency.getInstance("PLN"));
        assertThat(money.multiplyBy(5), Matchers.is(new Money(new BigDecimal(10), Currency.getInstance("PLN"))));
    }
}
