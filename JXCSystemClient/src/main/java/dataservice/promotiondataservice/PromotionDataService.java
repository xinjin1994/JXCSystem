package dataservice.promotiondataservice;

import po.DiscountPO;
import po.ProGiftPO;

public interface PromotionDataService {
	public boolean addDiscount(DiscountPO po);
	public boolean addGift(ProGiftPO po);
	public boolean delDiscount(DiscountPO po);
	public boolean delGift(ProGiftPO po);
	public DiscountPO getDiscount();
	public ProGiftPO getGift();
	public DiscountPO[] showDiscount();
	public ProGiftPO[] showProGift();
}
	
