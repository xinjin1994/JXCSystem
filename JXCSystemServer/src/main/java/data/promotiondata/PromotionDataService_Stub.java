package data.promotiondata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.CommodityPO;
import po.DiscountPO;
import po.ProGiftPO;
import dataservice.promotiondataservice.PromotionDataService;

public class PromotionDataService_Stub extends UnicastRemoteObject implements PromotionDataService{

	ProGiftPO nowProGift;
	ProGiftPO nowDiscount;
	
	ArrayList<ProGiftPO> proGiftList=new ArrayList<ProGiftPO>();
	ArrayList<DiscountPO> discountPO=new ArrayList<DiscountPO>();

	public PromotionDataService_Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean addDiscount(DiscountPO po) {
		return true;
	}

	public boolean addGift(ProGiftPO po) {
		return true;
	}

	public boolean delDiscount(DiscountPO po) {
		return true;
	}

	public boolean delGift(ProGiftPO po) {
		return true;
	}

	public DiscountPO getDiscount() {
		return new DiscountPO(1,"t1","t2",1000,2000,50);
	}

	public ProGiftPO getGift() {
		CommodityPO gift=new CommodityPO(true, "n", "t", 10, 10, 10, 10, 10, 10);
		return new ProGiftPO(gift, "time1", "time2");
	}

	public DiscountPO[] showDiscount() {
		return new DiscountPO[1];
	}

	public ProGiftPO[] showProGift() {
		return new ProGiftPO[1];
	}

}
