package pl.com.bottega.ecommerce.sharedkernel;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class MoneyTest {

	@Test
	public void multiplyingByTwoIsCorrect() {
		Money money = new Money(10, "PLN");
		assertThat(money.multiplyBy(2), Matchers.is(new Money(20, "PLN")));
	}

}
