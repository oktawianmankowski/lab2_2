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


}
