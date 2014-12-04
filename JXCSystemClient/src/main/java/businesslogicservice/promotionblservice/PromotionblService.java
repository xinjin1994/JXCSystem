package businesslogicservice.promotionblservice;

import java.util.ArrayList;

import vo.DiscountVO;
import vo.ProGiftVO;
import vo.VoucherVO;

public interface PromotionblService {
	
	//设置折扣促销
	public int makeDiscount_up(DiscountVO vo);
	
	//设置赠品促销策略
	public int makeGift_up(ProGiftVO vo);
	
	//设置代金券促销
	public int makeVoucher_up(VoucherVO vo);
	
	//删除促销策略,i=1删除赠品促销，i=2删除价格折让促销，i=3删除代金券促销
	public int delPromotion_up(int i);
	
	//显示当前折扣促销策略
	public DiscountVO getDiscount_up();
	//显示当前赠品促销策略
	public ProGiftVO getProGift_up();
	//显示当前代金券促销策略
	public VoucherVO getVoucher_up();
	//显示当前其他促销策略
	public String getOtherPromotion_up();

	//手动输入测下哦策略，经理输入促销策略后，由由业务员主动执行操作
	public int makeOther_up(String word);
	
}
