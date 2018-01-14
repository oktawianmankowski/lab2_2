package pl.com.bottega.ecommerce.sharedkernel;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Lukasz on 2018-01-14.
 */
public class MoneyTest {

    @Test
    public void multiplyByTen(){
        Money money = new Money(100, "GBH");
        assertThat(money.multiplyBy(10), Matchers.is(new Money(1000, "GBH")));
    }


    @Test(expected = IllegalArgumentException.class)
    public void addMoneyWithNotSameCurrencyCode(){
        Money money = new Money(100, "PLN");
        Money result = money.add(new Money(100,"GBH"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void substractMoneyWithNotSameCurrencyCode(){
        Money money = new Money(100, "PLN");
        Money result = money.subtract(new Money(100,"GBH"));
    }

    @Test
    public void addMoneyProperly(){
        Money money = new Money(100, "PLN");
        Money result = new Money(100,"PLN");
        assertThat(money.add(result), Matchers.is(new Money(200,"PLN")));
    }


}