package vo.promotion;

public class VoucherVO {
	
	public String start_time;
	public String end_time;
	public double start_money;
	public double end_money;
	public double money;
	public int level;
	
	public VoucherVO(String start_time,String end_time,double start_money,double end_money,double money,int level){
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
	
	public double getStartMoney(){
		return start_money;
	}
	public double getEndMoney(){
		return end_money;
	}
	public double getMoney(){
		return money;
	}
	public int getLevel(){
		return level;
	}

}
