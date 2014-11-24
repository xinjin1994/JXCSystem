package businesslogic.financialbl;

import po.PaymentPO;
import po.ReceiptPO;

public class MockAccount implements AccountInfo{

	public ReceiptPO[] getAllReceipt() {
		// TODO Auto-generated method stub
		String[] accountList={"account_name"};
		int[] price={10};
		ReceiptPO po= new ReceiptPO("serialnum", "operator", "name", accountList, "ps", price);
		
		ReceiptPO[] rec=new ReceiptPO[1];
		rec[0]=po;
		return rec;
	}

	public PaymentPO[] getAllPayment() {
		// TODO Auto-generated method stub
		String[] accountList={"account_name"};
		int[] price={10};
		PaymentPO po= new PaymentPO("serialnum","operator", "Customer_name", accountList, "item", "ps", price);
		
		PaymentPO[] pay=new PaymentPO[1];
		pay[0]=po;
		return pay;
	}

}
