package po;

import java.io.Serializable;

public class DiscountPO extends PromotionPO implements Serializable{
	int discountMoney;//���ý��
	
	public DiscountPO(int discountMoney,String start_time,String end_time,int start_money,int end_money) {
		super(start_time,end_time,start_money,end_money);
		this.discountMoney = discountMoney;
	}
	
	
	public DiscountPO copy(){
		return new DiscountPO(discountMoney, start_time, end_time, start_money, end_money);
	}
	
	public int getDiscountMoney() {
		return discountMoney;
	}
}

