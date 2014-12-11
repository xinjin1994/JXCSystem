package po;

import java.io.Serializable;

public class WarnPO extends AllBillPO implements Serializable{
	
	public CommodityPO commodity;
	public int warn_number;
	
	public WarnPO(CommodityPO commodity,int warn_number){
		this.commodity=commodity;
		this.warn_number=warn_number;
	}
	
	
	public String getName(){
		return commodity.getName();
	}
	
	public String getType(){
		return commodity.getType();
	}
	
	public CommodityPO getCommodity(){
		return commodity;
	}
	
	public int getWarnNumber(){
		return warn_number;
	}
	
	public WarnPO copy(){
		WarnPO po=new WarnPO(commodity.copy(),warn_number);
		po.setNote(this.getNote());
		po.setTime(this.getTime());
		return po;
	}

}
