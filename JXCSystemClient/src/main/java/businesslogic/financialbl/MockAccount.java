package businesslogic.financialbl;

import java.util.ArrayList;

import po.PaymentPO;
import po.ReceiptPO;

public class MockAccount implements AccountInfo{

	public ArrayList<ReceiptPO> getAllReceipt() {
		// TODO Auto-generated method stub
		String[] accountList={"account_name"};
		int[] price={10};
		String[] ps={"ps"};
		ReceiptPO po= new ReceiptPO(null, null, null);
		
		ArrayList<ReceiptPO> rec=new ArrayList<ReceiptPO>();
		rec.add(po);
		return rec;
	}

	public ArrayList<PaymentPO> getAllPayment() {
		// TODO Auto-generated method stub
		String[] accountList={"account_name"};
		int[] price={10};
		String[] ps={"ps"};
		PaymentPO po= new PaymentPO(null, null, null);	
	
		ArrayList<PaymentPO> pay=new ArrayList<PaymentPO>();
		pay.add(po);
		return pay;
	}

}
