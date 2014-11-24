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
		SaleListPO po=new SaleListPO("2222/2/2", "name", "clerk", "wareHouse","type",
				"commodity", 50, 10, 500);
		mock.arraySale.add(po);
		financial.financial=mock;
		assertEquals("�ɹ�",financial.saleList("1111/1/1", "2222/2/2", "good_name", "good_type",
				"customer_name","clerk", 1));
	}

	@Test
	public void testAddAllBillReceiptPO() {
		Financial financial=new Financial();
		MockFinancialData mock=new MockFinancialData();
		financial.financial=mock;
		
		String[] accountList={"account_name"};
		int[] price={10};
		ReceiptPO po= new ReceiptPO("serialnum", "operator", "name", accountList, "ps", price);
		
		assertEquals(true,financial.addAllBill(po));
	}

	@Test
	public void testAddOperatingConditionPaymentPO() {
		Financial financial=new Financial();
		MockFinancialData mock=new MockFinancialData();
		financial.financial=mock;
		
		String[] accountList={"account_name"};
		int[] price={10};
		PaymentPO po= new PaymentPO("serialnum","operator", "Customer_name", accountList, "item",
				"ps", price);
		
		assertEquals(true,financial.addOperatingCondition(po));
		
	}

}
