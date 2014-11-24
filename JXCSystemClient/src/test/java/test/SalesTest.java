package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import businesslogic.salesbl.MockAddCustomer;
import businesslogic.salesbl.MockAddExport;
import businesslogic.salesbl.MockAddExport_Return;
import businesslogic.salesbl.MockAddImport;
import businesslogic.salesbl.MockAddImport_Return;
import businesslogic.salesbl.MockDelCustomer;
import businesslogic.salesbl.MockFindCustomer;
import businesslogic.salesbl.MockInvoice;
import businesslogic.salesbl.MockUpdateCustomer;
import businesslogic.salesbl.Sales;

public class SalesTest {

	@Test
	public void testAddCustomer() {
		MockAddCustomer mockAdd = new MockAddCustomer();
		Sales sale = new Sales();
		sale.setSale(mockAdd);
		assertEquals("�ɹ�", sale.addCustomer("string", 10, "phone", "zip",
				"mail", 10, "clerk"));
	}

	@Test
	public void testDelCustomer() {
		MockDelCustomer mockDel = new MockDelCustomer();
		Sales sale = new Sales();
		sale.setSale(mockDel);
		assertEquals("�ɹ�", sale.delCustomer("name"));
	}

	@Test
	public void testUpdateCustomer() {
		MockUpdateCustomer mockUpdate = new MockUpdateCustomer();
		Sales sale = new Sales();
		sale.setSale(mockUpdate);
		assertEquals("�ɹ�", sale.updateCustomer("name", 10, "phone",
				"zip", "mail", 10, "clerk"));
	}

	@Test
	public void testSearchCustomer() {
		MockFindCustomer mockFind = new MockFindCustomer();
		Sales sale = new Sales();
		sale.setSale(mockFind);
		assertEquals("�ɹ�", sale.searchCustomer("name"));
	}

	@Test
	public void testAddImport() {
		MockAddImport mockAddIm = new MockAddImport();
		MockInvoice mock=new MockInvoice();
		Sales sale = new Sales();
		sale.setSale(mockAddIm);
		sale.invoice=mock;
		assertEquals("�ɹ�", sale.addImport("name", 10, "good_name",
				"good_type", "ps", 10));
	}

	@Test
	public void testAddExport() {
		MockAddExport mockAddEx = new MockAddExport();
		Sales sale = new Sales();
		sale.setSale(mockAddEx);
		MockInvoice mock=new MockInvoice();
		sale.invoice=mock;
		assertEquals("�ɹ�", sale.addExport("name", 10,"good_name",
				"good_type", "ps", 10, 10, 10));
	}

	@Test
	public void testAddExport_Return() {
		MockAddExport_Return mockAddExRe = new MockAddExport_Return();
		Sales sale = new Sales();
		sale.setSale(mockAddExRe);
		MockInvoice mock=new MockInvoice();
		sale.invoice=mock;
		assertEquals("�ɹ�", sale.addExport_Return("name", 10,"good_name",
				"good_type", "ps", 10, 10, 10));
	}

	@Test
	public void testAddImport_Return() {
		MockAddImport_Return mockAddImRe = new MockAddImport_Return();
		Sales sale = new Sales();
		sale.setSale(mockAddImRe);
		MockInvoice mock=new MockInvoice();
		sale.invoice=mock;
		assertEquals("�ɹ�", sale.addImport_Return("name", 10, "good_name",
				"good_type", "ps", 10));
	}

}
