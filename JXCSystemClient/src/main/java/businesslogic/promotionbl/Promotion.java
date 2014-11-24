package businesslogic.promotionbl;

import po.CommodityPO;
import po.DiscountPO;
import po.ProGiftPO;
import businesslogic.systemlogbl.Systemlog;
import businesslogicservice.promotionblservice.PromotionblService;
import data.promotiondata.PromotionDataService_Stub;
import dataservice.promotiondataservice.PromotionDataService;

public class Promotion implements PromotionblService{
	
	PromotionDataService pro=new PromotionDataService_Stub(); 
	SystemlogInfo systemlog=new Systemlog();
	
	
	public PromotionDataService getPro() {
		return pro;
	}
	public void setPro(PromotionDataService pro) {
		this.pro = pro;
	}

	public String makeDiscount(int start_money, int discount, int end_money,
			String time1, String time2) {
		// TODO Auto-generated method stub
		//pro=new PromotionDataService_Stub(); 
		DiscountPO dis=new DiscountPO(1,"t1","t2",1000,2000,50);
		if(pro.addDiscount(dis)){
			systemlog.add("AddDiscount:");
			return "成功";
		}
	
		return "失败";
		
	}

	public String delPromotion(String note) {
		// TODO Auto-generated method stub
		//PromotionDataService pro=new PromotionDataService_Stub(); 
		DiscountPO dis= new DiscountPO(1,"t1","t2",1000,2000,50);
		if(pro.delDiscount(dis)){
			systemlog.add("DelDiscount:");
			return "成功";
		}
		return "失败";
	}

	public String makeGift(int start_money, String time1, String time2) {
		// TODO Auto-generated method stub
//		PromotionDataService pro=new PromotionDataService_Stub(); 
		CommodityPO gift=new CommodityPO(true, "n", "t", 10, 10, 10, 10, 10, 10);
		ProGiftPO dis=new ProGiftPO(gift, time1, time2);
		if(pro.addGift(dis)){
			systemlog.add("AddGift:");
			return "成功";
		}
		return "失败";
	}

	public String search() {
		// TODO Auto-generated method stub
//		PromotionDataService pro=new PromotionDataService_Stub(); 
		if(pro.getDiscount()!=null){
			systemlog.add("Search:");
			return "成功";
		}
		return "失败";
	}

	public String makeOther(String word) {
		// TODO Auto-generated method stub
		return null;
	}

}
