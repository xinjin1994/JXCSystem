package businesslogicservice.promotionblservice;

import java.util.ArrayList;

import vo.promotion.DiscountVO;
import vo.promotion.ProGiftVO;
import vo.promotion.VoucherVO;

//-1 未知错误
//1  商品不存在
//2  库存中商品数量不足，不能完成赠品促销
//3  客户等级不存在

public interface PromotionblService {
	
	//设置折扣促销
	public int makeDiscount_up(DiscountVO vo);
	
	//设置赠品促销策略
	public int makeGift_up(ProGiftVO vo);
	
	//设置代金券促销
	public int makeVoucher_up(VoucherVO vo);
	
	//删除折扣促销策略
	public int delGift_up(int level);
	//删除赠品促销策略	
	public int delDiscount_up(int level);
	//删除代金券促销策略
	public int delVoucher_up(int level);
	
	//显示当前折扣促销策略
	public ArrayList<DiscountVO> getDiscount_up();
	//显示当前赠品促销策略
	public ArrayList<ProGiftVO> getProGift_up();
	//显示当前代金券促销策略
	public ArrayList<VoucherVO> getVoucher_up();
	//显示当前其他促销策略
//	public String getOtherPromotion_up();

	//手动输入测下哦策略，经理输入促销策略后，由由业务员主动执行操作
//	public int makeOther_up(String word);
	
}
