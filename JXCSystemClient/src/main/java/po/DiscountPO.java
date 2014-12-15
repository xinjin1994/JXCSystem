package po;

import java.io.Serializable;

public class DiscountPO extends PromotionPO implements Serializable{
	double discountMoney;//���ý��
	
	public DiscountPO(double discountMoney,String start_time,String end_time,double start_money,double end_money,int level) {
		super(start_time,end_time,level,start_money,end_money);
		this.discountMoney = discountMoney;
	}
	
	
	public DiscountPO copy(){
		return new DiscountPO(discountMoney, start_time, end_time, start_money, end_money,level);
	}
	
	public double getDiscountMoney() {
		return discountMoney;
	}
}

