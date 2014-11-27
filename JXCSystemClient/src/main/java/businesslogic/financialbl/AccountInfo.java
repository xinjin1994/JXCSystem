package businesslogic.financialbl;

import java.util.ArrayList;

import po.PaymentPO;
import po.ReceiptPO;

public interface AccountInfo {
	
	public ArrayList<ReceiptPO> getAllReceipt();
	
	public ArrayList<PaymentPO> getAllPayment();

}
