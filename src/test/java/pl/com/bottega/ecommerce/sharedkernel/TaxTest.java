package pl.com.bottega.ecommerce.sharedkernel;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

import pl.com.bottega.ecommerce.sales.domain.invoicing.Tax;
import pl.com.bottega.ecommerce.sales.domain.invoicing.TaxCalculator;
import pl.com.bottega.ecommerce.sales.domain.invoicing.TaxPolicy;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;

public class TaxTest {

	@Test
	public void calculatingTaxForFoodIsCorrect() {
		Money money = new Money(10, "PLN");
		TaxPolicy taxPolicy = new TaxCalculator();
		Tax tax = taxPolicy.calculateTax(ProductType.FOOD, money);
		assertThat(tax.getAmount(), Matchers.is(new Money(0.7, "PLN")));
	}

}
