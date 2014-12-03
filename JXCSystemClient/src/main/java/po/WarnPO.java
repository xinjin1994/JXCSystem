package po;

public class WarnPO {
	
	public CommodityPO commodity;
	public int warn_number;
	
	public String getName(){
		return commodity.getName();
	}
	
	public String getType(){
		return commodity.getType();
	}
	
	public int getWarnNumber(){
		return warn_number;
	}

}
