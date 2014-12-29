package businesslogic.salesbl;

import java.util.ArrayList;

import po.CommodityPO;
import po.CustomerPO;

public interface CommodityInfo {

	public CommodityPO findCommodity(String name, String type);
	
	public ArrayList<CommodityPO> getAllCommodity();
	
	public boolean hasGift(CommodityPO gift,int number);
	
	public boolean addSendGift(CommodityPO gift,int number,CustomerPO customer);
	
}
