package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import vo.CustomerVO;
import vo.bill.ExportMenuVO;
import vo.bill.ImportMenuVO;
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
		assertEquals("�ɹ�", sale.addCustomer(null));
	}

	@Test
	public void testDelCustomer() {
		MockDelCustomer mockDel = new MockDelCustomer();
		Sales sale = new Sales();
		sale.setSale(mockDel);
		assertEquals("�ɹ�", sale.delCustomer(null));
	}

	@Test
	public void testUpdateCustomer() {
		MockUpdateCustomer mockUpdate = new MockUpdateCustomer();
		Sales sale = new Sales();
		sale.setSale(mockUpdate);
		assertEquals("�ɹ�", sale.updateCustomer(new CustomerVO("string", false, 10, "phone", "zip",
				"mail", null, null, 10, 0, "clerk"), null));
	}

	@Test
	public void testSearchCustomer() {
		MockFindCustomer mockFind = new MockFindCustomer();
		Sales sale = new Sales();
		sale.setSale(mockFind);
		assertEquals("�ɹ�", sale.searchFuzzyCustomer(null));
	}

	@Test
	public void testAddImport() {
		MockAddImport mockAddIm = new MockAddImport();
		MockInvoice mock=new MockInvoice();
		Sales sale = new Sales();
		sale.setSale(mockAddIm);
		sale.invoice=mock;
		assertEquals("�ɹ�", sale.addImport(null));
	}

	@Test
	public void testAddExport() {
		MockAddExport mockAddEx = new MockAddExport();
		Sales sale = new Sales();
		sale.setSale(mockAddEx);
		MockInvoice mock=new MockInvoice();
		sale.invoice=mock;
		assertEquals("�ɹ�", sale.addExport(null));
	}

	@Test
	public void testAddExport_Return() {
		MockAddExport_Return mockAddExRe = new MockAddExport_Return();
		Sales sale = new Sales();
		sale.setSale(mockAddExRe);
		MockInvoice mock=new MockInvoice();
		sale.invoice=mock;
		assertEquals("�ɹ�", sale.addExport_Return(null));
	}

	@Test
	public void testAddImport_Return() {
		MockAddImport_Return mockAddImRe = new MockAddImport_Return();
		Sales sale = new Sales();
		sale.setSale(mockAddImRe);
		MockInvoice mock=new MockInvoice();
		sale.invoice=mock;
		assertEquals("�ɹ�", sale.addImport_Return(null));
	}

}
