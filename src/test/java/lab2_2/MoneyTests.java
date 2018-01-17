package lab2_2;

import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.*;
import org.junit.Test;

import pl.com.bottega.ecommerce.sharedkernel.Money;

public class MoneyTests {

	@Test(expected = IllegalArgumentException.class)
	public void testDifferentCurrencyThrowsException() throws Exception {
		Money moneyPln = new Money(10, "PLN");
		Money moneyEur = new Money(10, "EUR");
		moneyPln.add(moneyEur);
	}
	
	@Test
	public void testGivenCurrencyAddition() {
		Money money1 = new Money(10, "PLN");
		Money money2 = new Money(10, "PLN");
		Money result = new Money(20, "PLN");
		assertThat(money1.add(money2), is(result));
	}

	@Test
	public void testGivenCurrencySubtraction() {
		Money money1 = new Money(10, "PLN");
		Money money2 = new Money(10, "PLN");
		Money result = new Money(0, "PLN");
		assertThat(money1.subtract(money2), is(result));
	}

	@Test
	public void testGivenCurrencyDoubleMultiplication() {
		Money money1 = new Money(10, "PLN");
		Money result = new Money(100, "PLN");
		assertThat(money1.multiplyBy(10d), is(result));
	}

	@Test
	public void testGivenCurrencyBigDecimalMultiplication() {
		Money money1 = new Money(10, "PLN");
		Money result = new Money(100, "PLN");
		assertThat(money1.multiplyBy(new BigDecimal(10)), is(result));
	}

}
