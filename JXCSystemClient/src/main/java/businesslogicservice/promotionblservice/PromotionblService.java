package businesslogicservice.promotionblservice;

public interface PromotionblService {
	
	//设置折扣促销
	public String makeDiscount(int start_money, int discount, int end_money,
			String time1, String time2);
	
	//删除促销策略
	public String delPromotion(String note);

	//设置赠品促销策略
	public String makeGift(int start_money, String time1, String time2);

	//显示所有促销策略
	public String search();

	//手动输入测下哦策略，经理输入促销策略后，由由业务员主动执行操作
	public String makeOther(String word);
}
