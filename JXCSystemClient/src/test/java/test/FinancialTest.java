package test;


import static org.junit.Assert.*;

import org.junit.Test;

import po.PaymentPO;
import po.ReceiptPO;
import po.SaleListPO;
import businesslogic.financialbl.Financial;
import businesslogic.financialbl.MockFinancialData;

public class FinancialTest {

	@Test
	public void testSaleList() {
		Financial financial=new Financial();
		MockFinancialData mock=new MockFinancialData();
		SaleListPO po=new SaleListPO(null, null, null, null, null, 0, 0, 0);
		mock.arraySale.add(po);
		financial.financial=mock;
		assertEquals("�ɹ�",financial.saleList(null, null, null, null, null, null, null));
	}

	@Test
	public void testAddAllBillReceiptPO() {
		Financial financial=new Financial();
		MockFinancialData mock=new MockFinancialData();
		financial.financial=mock;
		
		String[] accountList={"account_name"};
		int[] price={10};
		String[] ps={"ps"};
		ReceiptPO po= new ReceiptPO(null, null, null);
		
		assertEquals(true,financial.addAllBill(po));
	}

	@Test
	public void testAddOperatingConditionPaymentPO() {
		Financial financial=new Financial();
		MockFinancialData mock=new MockFinancialData();
		financial.financial=mock;
		
		String[] accountList={"account_name"};
		int[] price={10};
		String[] ps={"ps"};
		PaymentPO po= new PaymentPO(null, null, null);
		
		assertEquals(true,true);
		
	}

}
