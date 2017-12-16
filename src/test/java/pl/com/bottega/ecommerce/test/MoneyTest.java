package pl.com.bottega.ecommerce.test;

import org.hamcrest.Matchers;
import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.junit.Assert.assertThat;

public class MoneyTest {

    private Money money;

    @Test
    public void returnDefaultCurrencyCode() {
        money = new Money(100);
        assertThat(money.getCurrencyCode(), Matchers.is("EUR"));
    }
    
}
