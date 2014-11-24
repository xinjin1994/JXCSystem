package businesslogic.promotionbl;

import data.promotiondata.PromotionDataService_Stub;
import po.DiscountPO;

public class MockDelDiscount extends PromotionDataService_Stub{
	public boolean delDiscount(DiscountPO po) {
		return true;
	}
}
