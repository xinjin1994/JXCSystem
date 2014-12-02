package businesslogicservice.promotionblservice;

import java.util.ArrayList;

import vo.DiscountVO;

public interface PromotionblService {
	
	//设置折扣促销
	public int makeDiscount(int start_money, int discount, int end_money,
			String time1, String time2);
	
	//删除促销策略
	public int delPromotion(String note);

	//设置赠品促销策略
	public int makeGift(int start_money, String time1, String time2);

	//显示所有促销策略
	public ArrayList<DiscountVO> search();

	//手动输入测下哦策略，经理输入促销策略后，由由业务员主动执行操作
	public int makeOther(String word);
}
