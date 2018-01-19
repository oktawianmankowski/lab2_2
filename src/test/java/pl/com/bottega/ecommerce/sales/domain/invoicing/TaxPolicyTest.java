package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.hamcrest.Matchers;
import org.junit.Test;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.Assert.assertThat;

public class TaxPolicyTest {

    @Test
    public void foodTaxtPolicy() {

        TaxPolicy taxPolicy = new StandardTaxPolicy();
        Tax tax = taxPolicy.calculateTax(ProductType.FOOD, new Money(new BigDecimal(100), Currency.getInstance("USD")));
        Tax expectedTax = new Tax(new Money(new BigDecimal(7), Currency.getInstance("USD")), "7% (F)");
        assertThat(tax.getAmount(), Matchers.is(expectedTax.getAmount()));
    }

}
