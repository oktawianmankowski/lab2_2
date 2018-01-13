package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.payment.Payment;
import pl.com.bottega.ecommerce.sales.domain.payment.PaymentFactory;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.awt.print.Book;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Justyna on 11.01.2018.
 */
public class BookKeeperTest {

    private TaxPolicy taxPolicy;
    private BookKeeper bookKeeper;

    @Before
    public void setUp(){
        bookKeeper = new BookKeeper();
        taxPolicy = new TaxPolicy() {
            public Tax calculateTax(ProductType productType, Money net) {
                Money value = productType == ProductType.STANDARD
                        ? net.multiplyBy(0.23)
                        : net.multiplyBy(0.07);
                Tax tax = new Tax(value, "VAT");

                return tax;
            }
        };
    }

    @Test
    public void hasProperNumberOfInvoiceLines() throws Exception {
        RequestItem requestItem = createRequestItem1();
        RequestItem requestItem2 = createRequestItem2();

        ClientData clientData = new ClientData(Id.generate(), "Jan Kowalski");
        InvoiceRequest invoiceRequest = new InvoiceRequest(clientData);
        invoiceRequest.add(requestItem);
        invoiceRequest.add(requestItem2);

        Invoice invoice = bookKeeper.issuance(invoiceRequest, taxPolicy);

        List<InvoiceLine> lines = invoice.getItems();
        assertEquals(lines.size(), 2);
    }

    @Test
    public void isTaxCalculatedProperly() throws Exception {
        RequestItem requestItem = createRequestItem1();
        RequestItem requestItem2 = createRequestItem2();

        ClientData clientData = new ClientData(Id.generate(), "Jan Kowalski");
        InvoiceRequest invoiceRequest = new InvoiceRequest(clientData);
        invoiceRequest.add(requestItem);
        invoiceRequest.add(requestItem2);

        Invoice invoice = bookKeeper.issuance(invoiceRequest, taxPolicy);

        List<InvoiceLine> lines = invoice.getItems();
        InvoiceLine invoiceLine1 = lines.get(0);
        InvoiceLine invoiceLine2 = lines.get(1);

        BigDecimal expectedTax1 = BigDecimal.valueOf(98.29);
        BigDecimal expectedTax2 = BigDecimal.valueOf(0.67);

        BigDecimal expectedGros1 = BigDecimal.valueOf(525.63);
        BigDecimal expectedGros2 = BigDecimal.valueOf(10.27);

        BigDecimal expectedTotalGros = BigDecimal.valueOf(535.90);

        assertTrue(invoice.getGros().getDenomination().compareTo(expectedTotalGros) == 0);

        assertTrue(invoiceLine1.getTax().getAmount().getDenomination().compareTo(expectedTax1) == 0);
        assertTrue(invoiceLine2.getTax().getAmount().getDenomination().compareTo(expectedTax2) == 0);

        assertTrue(invoiceLine1.getGros().getDenomination().compareTo(expectedGros1) == 0);
        assertTrue(invoiceLine2.getGros().getDenomination().compareTo(expectedGros2) == 0);
    }

    @Test
    public void hasOneInvoiceLine() throws Exception {
        RequestItem requestItem = createRequestItem1();

        ClientData clientData = new ClientData(Id.generate(), "Jan Kowalski");
        InvoiceRequest invoiceRequest = new InvoiceRequest(clientData);
        invoiceRequest.add(requestItem);

        Invoice invoice = bookKeeper.issuance(invoiceRequest, taxPolicy);

        List<InvoiceLine> lines = invoice.getItems();
        assertEquals(lines.size(), 1);
    }

    @Test
    public void hasNoInvoiceLines() throws Exception {
        ClientData clientData = new ClientData(Id.generate(), "Jan Kowalski");
        InvoiceRequest invoiceRequest = new InvoiceRequest(clientData);

        Invoice invoice = bookKeeper.issuance(invoiceRequest, taxPolicy);

        List<InvoiceLine> lines = invoice.getItems();
        assertEquals(lines.size(), 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void addingTwoDifferentCurriencesThrowsAnException() throws Exception{
        Money firstCurrency = new Money(42.30, Money.DEFAULT_CURRENCY);
        Money secondCurrency = new Money(120.12, "PLN");

        firstCurrency.add(secondCurrency);
    }


    private RequestItem createRequestItem1() {
        Money price = new Money(213.67, Money.DEFAULT_CURRENCY);
        ProductData productData = new ProductData(Id.generate(), price, "ticket", ProductType.STANDARD, new Date());
        return new RequestItem(productData, 2, price.multiplyBy(2));
    }

    private RequestItem createRequestItem2() {
        Money price = new Money(3.20, Money.DEFAULT_CURRENCY);
        ProductData productData = new ProductData(Id.generate(), price, "butter", ProductType.FOOD, new Date());
        return new RequestItem(productData, 3, price.multiplyBy(3));
    }


}