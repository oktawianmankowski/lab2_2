package pl.com.bottega.ecommerce.sales.domain.invoicing;

import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.Currency;

import org.hamcrest.Matchers;
import org.junit.Test;

import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class TaxPolicyTest {

    @Test
    public void drugTaxPolicyTestPositive() {
        String drugDescription = "5% (D)";
        TaxPolicy tax = new StandardTaxPolicy();
        BigDecimal actualValue = new BigDecimal(100);
        BigDecimal expectedValue = new BigDecimal(7);
        Currency currency = Currency.getInstance("USD");
        Money actualMoney = new Money(actualValue, currency);
        Money expectedMoney = new Money(expectedValue, currency);
        Tax actualTax = tax.calculateTax(ProductType.FOOD, actualMoney);
        Tax expectedTax = new Tax(expectedMoney, drugDescription);

        assertThat(actualTax.getAmount(), Matchers.is(expectedTax.getAmount()));
    }

}
