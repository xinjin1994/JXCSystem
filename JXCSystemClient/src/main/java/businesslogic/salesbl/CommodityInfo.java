package businesslogic.salesbl;

import java.util.ArrayList;

import po.CommodityPO;

public interface CommodityInfo {

	public CommodityPO findCommodity(String name, String type);
	
	public ArrayList<CommodityPO> getAllCommodity();
	
}
