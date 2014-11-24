package businesslogic.promotionbl;

import po.DiscountPO;
import data.promotiondata.PromotionDataService_Stub;

public class MockGetDiscount extends PromotionDataService_Stub{
    public DiscountPO getDiscount(){
    	return new DiscountPO(1,"t1","t2",1000,2000,50);
    }
}
