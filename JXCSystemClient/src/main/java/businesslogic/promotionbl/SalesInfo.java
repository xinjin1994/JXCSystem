package businesslogic.promotionbl;

import po.DiscountPO;
import po.ProGiftPO;
import po.VoucherPO;

public interface SalesInfo {
	public DiscountPO getDiscount(int level);

	public ProGiftPO getProGift(int level);

	public VoucherPO getVoucher(int level);
}
