package businesslogic.promotionbl;

import po.DiscountPO;
import data.promotiondata.PromotionDataService_Stub;

public class MockAddDiscount extends PromotionDataService_Stub{

	public boolean addDiscount(DiscountPO po){
		return true;
	}
}
