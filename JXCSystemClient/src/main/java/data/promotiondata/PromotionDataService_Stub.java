package data.promotiondata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CommodityPO;
import po.DiscountPO;
import po.ProGiftPO;
import po.VoucherPO;
import dataservice.promotiondataservice.PromotionDataService;

public class PromotionDataService_Stub implements PromotionDataService{
//	public PromotionDataService_Stub(int dm, String t1, String t2, int sm,
//			int em, int d, CommodityPO gift, String time1, String time2) {
//		this.dm = dm;
//		this.t1 = t1;
//		this.t2 = t2;
//		this.sm = sm;
//		this.em = em;
//		this.d = d;
//		this.gift = gift;
//		this.time1 = time1;
//		this.time2 = time2;
//	}
//
//	int dm;
//	String t1;
//	String t2;
//	int sm;
//	int em;
//	int d;
//	
//	CommodityPO gift;
//	String time1;
//	String time2;
	


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
		return new DiscountPO(1,"t1","t2",1000,2000);
	}

	public ProGiftPO getGift() {
		CommodityPO gift=new CommodityPO(true, "n", "t", 10, 10, "10", 10, 10, 10);
		return new ProGiftPO(gift, "time1", "time2", 0, 0, 0);
	}

	public ArrayList<DiscountPO> showDiscount() {
		return new ArrayList<DiscountPO>();
	}

	public ArrayList<ProGiftPO> showProGift() {
		return new ArrayList<ProGiftPO>();
	}

	public boolean addVoucher(VoucherPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delVoucher(VoucherPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public VoucherPO getVoucher() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<VoucherPO> showVoudcher() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean clear() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
