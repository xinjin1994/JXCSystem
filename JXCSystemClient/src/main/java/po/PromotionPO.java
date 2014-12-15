package po;

import java.io.Serializable;


//这个是所有促销策略PO的父类
public class PromotionPO implements Serializable{

	double start_money;
	double end_money;
	int level;
	String start_time;
	String end_time;
	
	public PromotionPO(String start_time,String end_time,int level,double start_money,double end_money){
		this.start_money=start_money;
		this.end_money=end_money;
		this.level=level;
		this.start_time=start_time;
		this.end_time=end_time;
	}
	
	
	public double getStartMoney(){
		return start_money;
	}
	public double getEndMoney(){
		return end_money;
	}
	public String getStartTime(){
		return start_time;
	}
	public String getEndTime(){
		return end_time;
	}
	public int getLevel(){
		return level;
	}
	
}
