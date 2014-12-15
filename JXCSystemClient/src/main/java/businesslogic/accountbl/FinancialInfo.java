package businesslogic.accountbl;


import po.PaymentPO;
import po.ReceiptPO;

public interface FinancialInfo {
	
	public boolean addAllBill(ReceiptPO po);
	
//	public boolean addOperatingCondition(ReceiptPO po);
	
	public boolean addAllBill(PaymentPO po);
	
//	public boolean addOperatingCondition(PaymentPO po);

}
