package vo;

public class VoucherVO {
	
	public String start_time;
	public String end_time;
	public int start_money;
	public int end_money;
	public int money;
	public int level;
	
	public VoucherVO(String start_time,String end_time,int start_money,int end_money,int money,int level){
		this.start_time=start_time;
		this.end_time=end_time;
		this.start_money=start_money;
		this.end_money=end_money;
		this.money=money;
		this.level=level;
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
	public int getMoney(){
		return money;
	}
	public int getLevel(){
		return level;
	}

}
