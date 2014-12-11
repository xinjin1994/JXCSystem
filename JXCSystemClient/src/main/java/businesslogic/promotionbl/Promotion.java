package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CommodityPO;
import po.DiscountPO;
import po.ProGiftPO;
import vo.promotion.DiscountVO;
import businesslogic.systemlogbl.Systemlog;
import businesslogicservice.promotionblservice.PromotionblService;
import data.promotiondata.PromotionDataService_Stub;
import dataservice.promotiondataservice.PromotionDataService;

public class Promotion {
	
	public PromotionDataService promotion=new PromotionDataService_Stub(); 
	public SystemlogInfo systemlog=new Systemlog();
	
	
	public PromotionDataService getPro() {
		return promotion;
	}
	public void setPro(PromotionDataService pro) {
		this.promotion = pro;
	}

	public int makeDiscount(int start_money, int discount, int end_money,
			String time1, String time2) {
		// TODO Auto-generated method stub
		//pro=new PromotionDataService_Stub(); 
		DiscountPO dis=new DiscountPO(1,"t1","t2",1000,2000);
		try {
			if(promotion.addDiscount(dis)){
				systemlog.add_up("AddDiscount:");
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return -1;
		
	}

	public int delPromotion(String note) {
		// TODO Auto-generated method stub
		//PromotionDataService pro=new PromotionDataService_Stub(); 
		DiscountPO dis= new DiscountPO(1,"t1","t2",1000,2000);
		try {
			if(promotion.delDiscount(dis)){
				systemlog.add_up("DelDiscount:");
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public int makeGift(int start_money, String time1, String time2) {
		// TODO Auto-generated method stub
//		PromotionDataService pro=new PromotionDataService_Stub(); 
		CommodityPO gift=new CommodityPO(true, "n", "t", 10, 10, "10", 10, 10, 10);
		ProGiftPO dis=new ProGiftPO(gift, time1, time2, start_money, start_money, start_money);
		try {
			if(promotion.addGift(dis)){
				systemlog.add_up("AddGift:");
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public ArrayList<DiscountVO> search() {
		// TODO Auto-generated method stub
//		PromotionDataService pro=new PromotionDataService_Stub(); 
		ArrayList<DiscountVO> vo=new ArrayList<DiscountVO>();
		try {
			if(promotion.getDiscount()!=null){
				systemlog.add_up("Search:");
				return vo;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	public int makeOther(String word) {
		// TODO Auto-generated method stub
		return 0;
	}

}
