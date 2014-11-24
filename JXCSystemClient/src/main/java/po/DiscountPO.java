package po;

import java.io.Serializable;

public class DiscountPO implements Serializable{
	String time1;//开始时间
	String time2;//结束时间
	int start_money;//折让前价格
	int end_money;//折让后价格
	int discount;//折让的代金券价格
	int discountMoney;//折让金额
	
	public DiscountPO(int dm,String t1,String t2,int sm,int em,int d) {
		time1 = t1;
		time2 = t2;
		start_money = sm;
		end_money = em;
		discount = d;
		discountMoney = dm;
	}
	public String getTime1() {
		return time1;
	}

	public String getTime2() {
		return time2;
	}

	public int getStart_money() {
		return start_money;
	}

	public int getEnd_money() {
		return end_money;
	}

	public int getDiscount() {
		return discount;
	}
	
	public int getDiscountMoney() {
		return discountMoney;
	}
}

