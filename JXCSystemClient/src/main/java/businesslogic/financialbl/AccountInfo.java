package businesslogic.financialbl;

import po.PaymentPO;
import po.ReceiptPO;

public interface AccountInfo {
	
	public ReceiptPO[] getAllReceipt();
	
	public PaymentPO[] getAllPayment();

}
