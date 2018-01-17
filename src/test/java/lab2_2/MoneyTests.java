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
}
