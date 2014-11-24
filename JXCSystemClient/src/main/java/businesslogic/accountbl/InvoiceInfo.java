package businesslogic.accountbl;

import po.PaymentPO;
import po.ReceiptPO;

public interface InvoiceInfo {
	
	public String add(ReceiptPO po);

	public String add(PaymentPO po);

}
