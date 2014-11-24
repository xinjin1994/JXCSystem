package businesslogic.promotionbl;

import po.ProGiftPO;
import data.promotiondata.PromotionDataService_Stub;

public class MockAddGift extends PromotionDataService_Stub{
  public boolean addGift(ProGiftPO po){
	  return true;
  }
}
