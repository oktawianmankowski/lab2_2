package lab2_2;

import static org.junit.Assert.assertThat;
import org.hamcrest.Matchers;
import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class Testy_2_2 {

        @Test
        public void testShouldGiveAnswerMultiplyByTwo() {
            Money money = new Money(100, "PLN");
            assertThat(money.multiplyBy(2), Matchers.is(new Money(200, "PLN")));
        }

}
