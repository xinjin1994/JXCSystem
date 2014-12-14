package test;

import static org.junit.Assert.*;

import org.junit.Test;

import po.InvoicePO;
import businesslogic.invoicebl.MockSales;
import businesslogic.invoicebl.Invoice;
import businesslogic.invoicebl.MockInvoiceData;

public class InvoiceSalesTesterTest {

	@Test
	public void test() {
		InvoicePO invoicePO = null;
		
		MockInvoiceData mockInvoice = new MockInvoiceData(invoicePO);
		MockSales mockSales = new MockSales();
		Invoice invoice = new Invoice();
		
		invoice.salesInfo = mockSales;
		invoice.invoice = mockInvoice;
		
		assertEquals("�ɹ�", invoice.pass(null));
		assertEquals("�ɹ�", invoice.refuse("note"));
	}

}
