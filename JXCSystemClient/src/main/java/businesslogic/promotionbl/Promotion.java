package businesslogic.promotionbl;

import java.rmi.RemoteException;

import po.CommodityPO;
import po.DiscountPO;
import po.ProGiftPO;
import businesslogic.systemlogbl.Systemlog;
import businesslogicservice.promotionblservice.PromotionblService;
import data.promotiondata.PromotionDataService_Stub;
import dataservice.promotiondataservice.PromotionDataService;

public class Promotion implements PromotionblService{
	
	public PromotionDataService promotion=new PromotionDataService_Stub(); 
	public SystemlogInfo systemlog=new Systemlog();
	
	
	public PromotionDataService getPro() {
		return promotion;
	}
	public void setPro(PromotionDataService pro) {
		this.promotion = pro;
	}

	public String makeDiscount(int start_money, int discount, int end_money,
			String time1, String time2) {
		// TODO Auto-generated method stub
		//pro=new PromotionDataService_Stub(); 
		DiscountPO dis=new DiscountPO(1,"t1","t2",1000,2000,50);
		try {
			if(promotion.addDiscount(dis)){
				systemlog.add("AddDiscount:");
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "失败";
		
	}

	public String delPromotion(String note) {
		// TODO Auto-generated method stub
		//PromotionDataService pro=new PromotionDataService_Stub(); 
		DiscountPO dis= new DiscountPO(1,"t1","t2",1000,2000,50);
		try {
			if(promotion.delDiscount(dis)){
				systemlog.add("DelDiscount:");
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "失败";
	}

	public String makeGift(int start_money, String time1, String time2) {
		// TODO Auto-generated method stub
//		PromotionDataService pro=new PromotionDataService_Stub(); 
		CommodityPO gift=new CommodityPO(true, "n", "t", 10, 10, "10", 10, 10, 10);
		ProGiftPO dis=new ProGiftPO(gift, time1, time2);
		try {
			if(promotion.addGift(dis)){
				systemlog.add("AddGift:");
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "失败";
	}

	public String search() {
		// TODO Auto-generated method stub
//		PromotionDataService pro=new PromotionDataService_Stub(); 
		try {
			if(promotion.getDiscount()!=null){
				systemlog.add("Search:");
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "失败";
	}

	public String makeOther(String word) {
		// TODO Auto-generated method stub
		return null;
	}

}
