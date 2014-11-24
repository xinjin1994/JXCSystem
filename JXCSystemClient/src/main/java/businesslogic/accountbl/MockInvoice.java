package businesslogic.accountbl;

import po.PaymentPO;
import po.ReceiptPO;

public class MockInvoice implements InvoiceInfo{

	public String add(ReceiptPO po) {
		// TODO Auto-generated method stub
		return "成功";
	}

	public String add(PaymentPO po) {
		// TODO Auto-generated method stub
		return "成功";
	}

}
