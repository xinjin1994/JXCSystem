package businesslogic.salesbl;

import po.CommodityPO;

public interface CommodityInfo {

	public CommodityPO findCommodity(String name, String type);
	
}
