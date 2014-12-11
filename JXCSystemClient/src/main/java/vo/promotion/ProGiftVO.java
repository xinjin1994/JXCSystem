package vo.promotion;

import vo.CommodityVO;

public class ProGiftVO {

	public CommodityVO commodity;
	public String start_time;
	public String end_time;
	public double start_money;
	public int number;
	public int level;
	
	public ProGiftVO(CommodityVO commodity,int number,String start_time,String end_time,double start_money,int level){
		this.commodity=commodity;
		this.number=number;
		this.start_time=start_time;
		this.end_time=end_time;
		this.start_money=start_money;
		this.level=level;
	}
	
	public CommodityVO getCommodity(){
		return commodity;
	}
	public int getNumber(){
		return number;
	}
	public String getStartTime(){
		return start_time;
	}
	public String getEndTime(){
		return end_time;
	}
	public double getStartMoney(){
		return start_money;
	}
	public int getLevel(){
		return level;
	}
	
	
}
