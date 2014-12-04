package po;

import java.io.Serializable;

public class WarnPO extends DocumentPO implements Serializable{
	
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
