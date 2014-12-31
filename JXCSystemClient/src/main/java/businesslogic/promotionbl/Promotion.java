package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import main.ClientStart;
import po.CommodityPO;
import po.DiscountPO;
import po.ProGiftPO;
import po.VoucherPO;
import data.promotiondata.PromotionDataService_Stub;
import dataservice.promotiondataservice.PromotionDataService;

public class Promotion implements businesslogic.salesbl.PromotionInfo {
	
	public PromotionDataService promotion=new PromotionDataService_Stub(); 
	public SystemlogInfo systemlog;
	public CommodityInfo commodity;
	
	public void setInfo(SystemlogInfo systemlog,CommodityInfo commodity){
		this.systemlog=systemlog;
		this.commodity=commodity;
	}
	
	
	public PromotionDataService getPro() {
		return promotion;
	}
	public void setPro(PromotionDataService pro) {
		this.promotion = pro;
	}
	

	public int makeDiscount(double start_money, double discount, double end_money,
			String time1, String time2,int level) {
		// TODO Auto-generated method stub
		//pro=new PromotionDataService_Stub(); 
		DiscountPO dis=new DiscountPO(discount,time1,time2,start_money,end_money,level);
		
		if(time1.compareTo(time2)>0){
			return -1;
		}
		
		try {
			
			DiscountPO lin=getDiscount(level);
			
			if(lin!=null){
				return 13;
			}
			
			if(promotion.addDiscount(dis)){
				systemlog.add_up("AddDiscount: start_money="+start_money+" discount="+discount+" start_time="+time1+" end_time="+time2);
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return -1;
		
	}
	
	public int makeGift(String name,String type,int number,String start_time,String end_time,double start_money,int level) {
		// TODO Auto-generated method stub
		CommodityPO gift=commodity.findCommodity(name, type);
		ProGiftPO dis=new ProGiftPO(gift, start_time, end_time,number,start_money,999999,level);
		
		if(start_time.compareTo(end_time)>0){
			return -1;
		}
		
		try {
			
			ProGiftPO lin=getProGift(level);
			
			if(lin!=null){
				return 13;
			}
			
			if(promotion.addGift(dis)){
				commodity.addGift(name, type, number);
				systemlog.add_up("AddGift: start_money="+start_money+" name="+name+" type="+type+" start_time="+start_time+" end_time="+end_time);
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public int makeVoucher(double start_money, double voucher, double end_money,
			String time1, String time2,int level) {
		// TODO Auto-generated method stub
		VoucherPO dis=new VoucherPO(time1,time2,start_money,end_money,voucher,level);
		
		if(time1.compareTo(time2)>0){
			return -1;
		}
		
		try {
			
			VoucherPO lin=getVoucher(level);
			
			if(lin!=null){
				return 13;
			}
			
			if(promotion.addVoucher(dis)){
				systemlog.add_up("AddDiscount: start_money="+start_money+" voucher="+voucher+" start_time="+time1+" end_time="+time2);
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return -1;
	}
	
	public int delDiscount(int level) {
		// TODO Auto-generated method stub
		try {
			
			if(promotion.getDiscount(level)==null){
				return -1;
			}
			
			if(promotion.delDiscount(level)){
				systemlog.add_up("DelDiscount:");
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public int delProGift(int level) {
		// TODO Auto-generated method stub
		try {
			
			if(promotion.getGift(level)==null){
				return -1;
			}
			
			if(promotion.delGift(level)){
				systemlog.add_up("DelProGift:");
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public int delVoucher(int level) {
		// TODO Auto-generated method stub
		try {
			
			if(promotion.getVoucher(level)==null){
				return -1;
			}
			
			if(promotion.delVoucher(level)){
				systemlog.add_up("DelVoucher:");
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public DiscountPO getDiscount(int level){
//			return promotion.getDiscount(level);
	
		ArrayList<DiscountPO> po;
		po = ClientStart.promotion.getAllDiscount();

System.out.println("getAllDIscount:"+po.size());
			for(int i=0;i<po.size();i++){
//					if(!(sysDatetime.compareTo(po.get(i).getStartTime())<0&&sysDatetime.compareTo(po.get(i).getEndTime())>0)){
					if(po.get(i).getLevel()==level){
						System.out.println("getDiscountHuin:"+po.get(i).getDiscountMoney());
						return po.get(i);
//						}
				}

			}
			
		
		return null;
	}
	
	public ProGiftPO getProGift(int level){
		ArrayList<ProGiftPO> po;
		po = ClientStart.promotion.getAllProGift();
		
		for(int i=0;i<po.size();i++){
//				if(!(sysDatetime.compareTo(po.get(i).getStartTime())<0&&sysDatetime.compareTo(po.get(i).getEndTime())>0)){
			if(po.get(i).getLevel()==level){	
				return po.get(i);
//				}}
			}
		}
		return null;
	}
	
	public VoucherPO getVoucher(int level){
		try {
			return promotion.getVoucher(level);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<DiscountPO> getAllDiscount() {
		// TODO Auto-generated method stub
		ArrayList<DiscountPO> po=new ArrayList<DiscountPO>();
		ArrayList<DiscountPO> array=new ArrayList<DiscountPO>();
		try {
			po = promotion.showDiscount();
//			System.out.println("getAllDIscount:"+po.size());
			for(int i=0;i<po.size();i++){
//				if(!(sysDatetime.compareTo(po.get(i).getStartTime())<0&&sysDatetime.compareTo(po.get(i).getEndTime())>0)){
					array.add(po.get(i));
//				}
			}
			return array;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}
	
	public ArrayList<ProGiftPO> getAllProGift() {
		// TODO Auto-generated method stub
		ArrayList<ProGiftPO> po=new ArrayList<ProGiftPO>();
		ArrayList<ProGiftPO> array=new ArrayList<ProGiftPO>();
		
		try {
			po = promotion.showProGift();
			
			for(int i=0;i<po.size();i++){
//				if(!(sysDatetime.compareTo(po.get(i).getStartTime())<0&&sysDatetime.compareTo(po.get(i).getEndTime())>0)){
					array.add(po.get(i));
//				}
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}
	
	public ArrayList<VoucherPO> getAllVoucher() {
		// TODO Auto-generated method stub
		ArrayList<VoucherPO> po=new ArrayList<VoucherPO>();
		ArrayList<VoucherPO> array=new ArrayList<VoucherPO>();
		try {
			po = promotion.showVoucher();
			for(int i=0;i<po.size();i++){
//				if(!(sysDatetime.compareTo(po.get(i).getStartTime())<0&&sysDatetime.compareTo(po.get(i).getEndTime())>0)){
					array.add(po.get(i));
//				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}

}
