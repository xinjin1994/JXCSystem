package vo;

import po.DiscountPO;

public class DiscountVO {
	
	String time1;
	String time2;
	int start_money;
	int end_money;
//	int discount;
	int discountMoney;
	
	public DiscountVO(DiscountPO po){
		this.time1=po.getStartTime();
		this.time2=po.getEndTime();
		this.start_money=po.getStartMoney();
		this.end_money=po.getEndMoney();
//		this.discount=po.getDiscount();
		this.discountMoney=po.getDiscountMoney();
	}
	
	public DiscountVO(String time1,String time2,int start_money,int end_money,int discount,int discountMoney){
		this.time1=time1;
		this.time2=time2;
		this.start_money=start_money;
		this.end_money=end_money;
//		this.discount=discount;
		this.discountMoney=discountMoney;
	}
	
	
	
}
