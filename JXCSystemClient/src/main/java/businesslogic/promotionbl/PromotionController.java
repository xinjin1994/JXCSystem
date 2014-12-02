package businesslogic.promotionbl;

import java.util.ArrayList;

import vo.DiscountVO;
import businesslogicservice.promotionblservice.PromotionblService;

public class PromotionController implements PromotionblService{
	
	public Promotion promotion=new Promotion();

	public int makeDiscount(int start_money, int discount, int end_money,
			String time1, String time2) {
		// TODO Auto-generated method stub
		return promotion.makeDiscount(start_money, discount, end_money, time1, time2);
	}

	public int delPromotion(String note) {
		// TODO Auto-generated method stub
		return promotion.delPromotion(note);
	}

	public int makeGift(int start_money, String time1, String time2) {
		// TODO Auto-generated method stub
		return promotion.makeGift(start_money, time1, time2);
	}

	public ArrayList<DiscountVO> search() {
		// TODO Auto-generated method stub
		return promotion.search();
	}

	public int makeOther(String word) {
		// TODO Auto-generated method stub
		return promotion.makeOther(word);
	}

}
