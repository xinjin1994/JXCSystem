package businesslogic.promotionbl;

import java.util.ArrayList;

import main.ClientStart;
import po.DiscountPO;
import po.ProGiftPO;
import po.VoucherPO;
import vo.CommodityVO;
import vo.promotion.DiscountVO;
import vo.promotion.ProGiftVO;
import vo.promotion.VoucherVO;
import businesslogicservice.promotionblservice.PromotionblService;

public class PromotionController implements PromotionblService{
	
	public Promotion promotion=new Promotion();
	
	public PromotionController(){
		promotion=ClientStart.promotion;
	}

	public int makeDiscount_up(DiscountVO vo) {
		// TODO Auto-generated method stub
		return promotion.makeDiscount(vo.start_money, vo.discount_money, vo.end_money, vo.time1, vo.time2, vo.level);
	}

	public int makeGift_up(ProGiftVO vo) {
		// TODO Auto-generated method stub
		return promotion.makeGift(vo.commodity.name, vo.commodity.type, vo.number, vo.start_time, vo.end_time, vo.start_money, vo.level);
	}

	public int makeVoucher_up(VoucherVO vo) {
		// TODO Auto-generated method stub
		return promotion.makeVoucher(vo.start_money, vo.money, vo.end_money, vo.start_time, vo.end_time, vo.level);
	}

	public ArrayList<DiscountVO> getDiscount_up() {
		// TODO Auto-generated method stub
		ArrayList<DiscountPO> po= promotion.getAllDiscount();
		ArrayList<DiscountVO> array=new ArrayList<DiscountVO>();
		for(int i=0;i<po.size();i++){
			DiscountVO vo=new DiscountVO(po.get(i).getStartTime(),po.get(i).getEndTime(),po.get(i).getStartMoney(),po.get(i).getEndMoney(),po.get(i).getDiscountMoney(),po.get(i).getLevel());
			array.add(vo);
		}
		return array;
	}

	public ArrayList<ProGiftVO> getProGift_up() {
		// TODO Auto-generated method stub
		ArrayList<ProGiftPO> po=promotion.getAllProGift();
		ArrayList<ProGiftVO> array=new ArrayList<ProGiftVO>();
		for(int i=0;i<po.size();i++){
			CommodityVO com=new CommodityVO(po.get(i).getGift().getNote(), po.get(i).getGift().getName(), po.get(i).getGift().getType(), po.get(i).getGift().getNumber(), po.get(i).getGift().getIn_price(), po.get(i).getGift().getOut_price(),
					po.get(i).getGift().getRecent_in_price(), po.get(i).getGift().getRecent_out_price(),po.get(i).getGift().warn);
			ProGiftVO vo=new ProGiftVO(com, po.get(i).getNumber(),po.get(i).getStartTime(),po.get(i).getEndTime(),po.get(i).getStartMoney(),po.get(i).getLevel());
			array.add(vo);
		}
		return array;
	}

	public ArrayList<VoucherVO> getVoucher_up() {
		// TODO Auto-generated method stub
		ArrayList<VoucherPO> po=promotion.getAllVoucher();
		ArrayList<VoucherVO> array=new ArrayList<VoucherVO>();
		for(int i=0;i<po.size();i++){
			VoucherVO vo=new VoucherVO(po.get(i).getStartTime(),po.get(i).getEndTime(),po.get(i).getStartMoney(),po.get(i).getEndMoney(),po.get(i).getVoucherMoney(),po.get(i).getLevel());
			array.add(vo);
		}
		return array;
	}

	public int delGift_up(int level) {
		// TODO Auto-generated method stub
		return promotion.delProGift(level);
	}

	public int delDiscount_up(int level) {
		// TODO Auto-generated method stub
		return promotion.delDiscount(level);
	}

	public int delVoucher_up(int level) {
		// TODO Auto-generated method stub
		return promotion.delVoucher(level);
	}

}
