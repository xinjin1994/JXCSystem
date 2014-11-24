package businesslogicservice.promotionblservice;

public interface PromotionblService {
	public String makeDiscount(int start_money, int discount, int end_money,
			String time1, String time2);

	public String delPromotion(String note);

	public String makeGift(int start_money, String time1, String time2);

	public String search();

	public String makeOther(String word);
}
