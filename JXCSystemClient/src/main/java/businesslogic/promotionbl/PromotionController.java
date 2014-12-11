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

	public ArrayList<DiscountVO> search_up() {
		// TODO Auto-generated method stub
		return promotion.search();
	}

	public int makeOther_up(String word) {
		// TODO Auto-generated method stub
		return promotion.makeOther(word);
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
