package vo;

public class ProGiftVO {

	public CommodityVO commodity;
	public String start_time;
	public String end_time;
	public int start_money;
	public int end_money;
	public int number;
	public int level;
	
	public ProGiftVO(CommodityVO commodity,int number,String start_time,String end_time,int start_money,int end_money,int level){
		this.commodity=commodity;
		this.number=number;
		this.start_time=start_time;
		this.end_time=end_time;
		this.start_money=start_money;
		this.end_money=end_money;
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
	public int getStartMoney(){
		return start_money;
	}
	public int getEndMoney(){
		return end_money;
	}
	public int getLevel(){
		return level;
	}
	
	
}
