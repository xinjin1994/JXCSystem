package businesslogic.invoicebl;

import po.PaymentPO;
import po.ReceiptPO;

public interface AccountInfo {
	
	public String addReceipt_Data(ReceiptPO po);

	public String addPayment_Data(PaymentPO po);
	
	public String addAccount_Data(String name,int money);
	
//	public String delReceipt_Data(ReceiptPO po);
//
//	public String delPayment_Data(PaymentPO po);
	
}
