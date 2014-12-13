package businesslogic.promotionbl;

import java.util.ArrayList;

import vo.promotion.DiscountVO;
import vo.promotion.ProGiftVO;
import vo.promotion.VoucherVO;
import businesslogicservice.promotionblservice.PromotionblService;

public class PromotionController implements PromotionblService{
	
	public Promotion promotion=new Promotion();

	public int makeDiscount(int start_money, int discount, int end_money,
			String time1, String time2) {
		// TODO Auto-generated method stub
		int message=promotion.makeDiscount(start_money, discount, end_money, time1, time2);
		return message;
	}

	public int delPromotion(String note) {
		// TODO Auto-generated method stub
		int message=promotion.delPromotion(note);
		return message;
	}

	public int makeGift(int start_money, String time1, String time2) {
		// TODO Auto-generated method stub
		int message=promotion.makeGift(start_money, time1, time2);
		return message;
	}

	public ArrayList<DiscountVO> search_up() {
		// TODO Auto-generated method stub
		ArrayList<DiscountVO> result=promotion.search();
		return result;
	}

	public int makeOther_up(String word) {
		// TODO Auto-generated method stub
		int message=promotion.makeOther(word);
		return message;
	}

	public int makeDiscount_up(DiscountVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int makeGift_up(ProGiftVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int makeVoucher_up(VoucherVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delPromotion_up(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<DiscountVO> getDiscount_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ProGiftVO> getProGift_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<VoucherVO> getVoucher_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOtherPromotion_up() {
		// TODO Auto-generated method stub
		return null;
	}

}
