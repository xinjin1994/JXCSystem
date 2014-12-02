package vo;

import po.DiscountPO;

public class DiscountVO {
	
	String time1;
	String time2;
	int start_money;
	int end_money;
	int discount;
	int discountMoney;
	
	public DiscountVO(DiscountPO po){
		this.time1=po.getTime1();
		this.time2=po.getTime2();
		this.start_money=po.getStart_money();
		this.end_money=po.getEnd_money();
		this.discount=po.getDiscount();
		this.discountMoney=po.getDiscountMoney();
	}
	
	public DiscountVO(String time1,String time2,int start_money,int end_money,int discount,int discountMoney){
		this.time1=time1;
		this.time2=time2;
		this.start_money=start_money;
		this.end_money=end_money;
		this.discount=discount;
		this.discountMoney=discountMoney;
	}
	
	
	
}
