package businesslogic.promotionbl;

import po.CommodityPO;

public interface CommodityInfo {
	
	public CommodityPO findCommodity(String name,String type);
	
	public int addGift(String name,String type,int number);

}
