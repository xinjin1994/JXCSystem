package businesslogic.promotionbl;

import businesslogicservice.promotionblservice.PromotionblService;

public class PromotionController implements PromotionblService{
	
	Promotion promotion=new Promotion();

	public String makeDiscount(int start_money, int discount, int end_money,
			String time1, String time2) {
		// TODO Auto-generated method stub
		return promotion.makeDiscount(start_money, discount, end_money, time1, time2);
	}

	public String delPromotion(String note) {
		// TODO Auto-generated method stub
		return promotion.delPromotion(note);
	}

	public String makeGift(int start_money, String time1, String time2) {
		// TODO Auto-generated method stub
		return promotion.makeGift(start_money, time1, time2);
	}

	public String search() {
		// TODO Auto-generated method stub
		return promotion.search();
	}

	public String makeOther(String word) {
		// TODO Auto-generated method stub
		return promotion.makeOther(word);
	}

}
