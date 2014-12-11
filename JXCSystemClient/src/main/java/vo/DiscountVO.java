package vo;

import po.DiscountPO;

public class DiscountVO {
	
	String time1;
	String time2;
	double start_money;
	double end_money;
//	int discount;
	double discount_money;
	int level;
	
	public DiscountVO(DiscountPO po){
		this.time1=po.getStartTime();
		this.time2=po.getEndTime();
		this.start_money=po.getStartMoney();
		this.end_money=po.getEndMoney();
//		this.discount=po.getDiscount();
		this.discount_money=po.getDiscountMoney();
	}
	
	public DiscountVO(String time1,String time2,int start_money,int end_money,int discount_money,int level){
		this.time1=time1;
		this.time2=time2;
		this.start_money=start_money;
		this.end_money=end_money;
//		this.discount=discount;
		this.discount_money=discount_money;
		this.level=level;
	}
	
	public String getStartTime(){
		return time1;
	}
	public String getEndTime(){
		return time2;
	}
	public int getStartMoney(){
		return start_money;
	}
	public int getEndMoney(){
		return end_money;
	}
	public int getDiscontMoney(){
		return discount_money;
	}
	public int getLevel(){
		return level;
	}
	
	
	
}
