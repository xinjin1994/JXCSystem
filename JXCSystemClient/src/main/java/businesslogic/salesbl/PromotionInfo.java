package businesslogic.salesbl;

import java.rmi.RemoteException;

import po.DiscountPO;
import po.ProGiftPO;
import po.VoucherPO;

public interface PromotionInfo {
	public DiscountPO getDiscount(int level);
		
	
	public ProGiftPO getProGift(int level);
		
	
	public VoucherPO getVoucher(int level);
		
}
