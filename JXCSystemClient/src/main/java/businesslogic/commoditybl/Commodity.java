package businesslogic.commoditybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CommodityPO;
import po.PatchPO;
import po.SendGiftPO;
import po.SortPO;
import vo.StockVO;
import data.commoditydata.CommodityDataService_Stub;
import dataservice.commoditydataservice.CommodityDataService;


//-1 未知错误
//1  商品已存在
//2  商品不存在
//3  分类已存在
//4  分类不存在
//5  分类中存在商品，不能删除
//6  商品数量不足，不能添加为赠品
//7  赠品数量不足，不能删除
//8  商品数量不能为负

public class Commodity implements businesslogic.financialbl.CommodityInfo,
			businesslogic.initializationlbl.CommodityInfo, businesslogic.invoicebl.CommodityInfo,
			businesslogic.salesbl.CommodityInfo{
	
	public InvoiceInfo invoice;
	public SystemlogInfo systemlog;
	public CommodityDataService sto=new CommodityDataService_Stub();

	public int addCommodity(String name, String type) {
		int i=0;
		CommodityPO com;
//		CommodityDataService sto = new CommodityDataService_Stub(true, "n", "t", 10, 10, 10,10, 10, 10);
//		sto = new CommodityDataService_Stub();
		
		try {
			
//			com=sto.findGood(name,type);
//			
//			if(com!=null){
//				return 1;
//			}			
			
			ArrayList<CommodityPO> po=sto.getAll();
			
			for(i=0;i<po.size();i++){
				if(po.get(i).getName().equals(name)&&po.get(i).getType().equals(type)){
					return 1;
				}
			}
			
			com=new CommodityPO(false,name,type,0,0,"0",0,0,0);
			
			if (sto.addGood(com,null)) {
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public int addCommodity(String name, String type, int number) throws RemoteException {
		int i=0;
		CommodityPO com;
		
		ArrayList<CommodityPO> po=sto.getAll();
		
		for(i=0;i<po.size();i++){
			if(po.get(i).getName().equals(name)&&po.get(i).getType().equals(type)){
				sto.addGood(po.get(i), null);
				return 0;
			}
		}
		
		com=new CommodityPO(false,name,type,0,0,"0",0,0,number);
		
		if (sto.addGood(com,null)) {
			return 0;
		}
		return -1;
	}

	public int addCommodity(CommodityPO po1,SortPO po2) {
		// TODO Auto-generated method stub
		int i=0;
//		CommodityDataService sto = new CommodityDataService_Stub(true, "n", "t", 10, 10, 10,10, 10, 10);
//		sto = new CommodityDataService_Stub();
		
		try {
			
			ArrayList<CommodityPO> po=sto.getAll();
			
			for(i=0;i<po.size();i++){
				if(po.get(i).getName().equals(po1.getName())&&po.get(i).getType().equals(po1.getType())){
					return 1;
				}
			}
			
			if (sto.addGood(po1,po2)) {
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}

	public int delCommodity(String name, String type) {
		CommodityPO com;
		int i=0;
//		CommodityDataService sto = new CommodityDataService_Stub(true, "n", "t", 10, 10, 10,10, 10, 10);
//		sto = new CommodityDataService_Stub();
		
		try {
			
			ArrayList<CommodityPO> po=sto.getAll();
			
			for(i=0;i<po.size();i++){
				if(po.get(i).getName().equals(name)&&po.get(i).getType().equals(type)){
					
					if(sto.delGood(po.get(i))){
						return 0;
					}else{
						return -1;
					}
					
				}
			}
	
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 2;
	}

	public int updateCommodity(String name, String type, int in_price,
			int out_price) {
		CommodityPO com=null;
//		CommodityPO com2 = new CommodityPO(false, "name", "type", 10, 10, "10", 10, 10, 10);
		int i=0;
//		CommodityDataService sto = new CommodityDataService_Stub(true, "n", "t", 10, 10, 10,10, 10, 10);
//		sto = new CommodityDataService_Stub();
		
		try {
			
			ArrayList<CommodityPO> po=sto.getAll();
			
			for(i=0;i<po.size();i++){
				if(po.get(i).getName().equals(name)&&po.get(i).getType().equals(type)){
					com=new CommodityPO(false,name,type,in_price,out_price,po.get(i).getNote(),po.get(i).recent_in_price,po.get(i).recent_out_price,po.get(i).number);
					if(sto.updateGood(com, com)){
						return 0;
					}
					return -1;
				}
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 2;
	}

	public ArrayList<CommodityPO> searchCommodity(String word) {
//		CommodityDataService sto = new CommodityDataService_Stub(true, "n", "t", 10, 10, 10,10, 10, 10);
//		sto = new CommodityDataService_Stub();
		
		ArrayList<CommodityPO> array=new ArrayList<CommodityPO>();
		int i=0;
		
		try {
			
			ArrayList<CommodityPO> res=sto.getAll();
			
			for(i=0;i<res.size();i++){
				if(res.get(i).getName().equals(word)||res.get(i).getType().equals(word)||res.get(i).getNote().equals(word)){
					array.add(res.get(i));
				}
			}
			
			return array;
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public int addSort(String name1,String name2) {
		SortPO po1=null;
//		CommodityDataService sto = new CommodityDataService_Stub(true, "n", "t", 10, 10, 10,10, 10, 10);
//		sto = new CommodityDataService_Stub();
		SortPO po2=null;
		int i=0;
		
		try {
			
			ArrayList<SortPO> sort=sto.getAllSort();
			
			for(i=0;i<sort.size();i++){
				if(sort.get(i).getName().equals(name1)){
					po1=sort.get(i);
				}else if(sort.get(i).getName().equals(name2)){
					po2=sort.get(i);
				}
			}
			
			if(po1!=null){
				return 3;
			}
			if(po2==null){
				return 4;
			}
			
			if (sto.addSort(po1,po2)) {
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}

	public int delSort(String name) {
		SortPO com=null;
//		CommodityDataService sto = new CommodityDataService_Stub(true, "n", "t", 10, 10, 10,10, 10, 10);
//		sto = new CommodityDataService_Stub();
		int i=0;
		
		try {
			
			ArrayList<SortPO> sort=sto.getAllSort();
			
			for(i=0;i<sort.size();i++){
				if(sort.get(i).getName().equals(name)){
					com=sort.get(i);
				}
			}
			
			if(com==null){
				return 4;
			}
			
			if(com.hasCommodity()){
				return 5;
			}
			
			
			if (sto.delSort(com)) {
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}

	public int updateSort(String name1, String name2) {
		SortPO com1 =null;
		SortPO com2 =null;
		int i=0;
//		CommodityDataService sto = new CommodityDataService_Stub(true, "n", "t", 10, 10, 10,10, 10, 10);
//		sto = new CommodityDataService_Stub();
		
		try {
			
			ArrayList<SortPO> sort=sto.getAllSort();
			
			for(i=0;i<sort.size();i++){
				if(sort.get(i).getName().equals(name1)){
					com1=sort.get(i);
				}else if(sort.get(i).getName().equals(name2)){
					com2=sort.get(i);
				}
			}
			
			if(com1==null){
				return 4;
			}
			
			if(com2!=null){
				return 3;
			}
			
			if (sto.updateSort(com1,com2)) {
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}

	public ArrayList<CommodityPO> Examine(String time1, String time2) {
//		CommodityDataService sto =new CommodityDataService_Stub(true, "n", "t", 10, 10, 10,10, 10, 10);
//		sto = new CommodityDataService_Stub();
		
		try {
			if(sto.getAll()!=null){
				return null;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public ArrayList<StockVO> Iventory() {
//		CommodityDataService sto = new CommodityDataService_Stub(true, "n", "t", 10, 10, 10,10, 10, 10);
//		sto = new CommodityDataService_Stub();
		
		try {
			if(sto.getAll()!=null){
				
				return null;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public int addGift(String name, String type,int number) {
		CommodityPO com =null;
//		CommodityDataService sto = new CommodityDataService_Stub(true, "n", "t", 10, 10, 10,10, 10, 10);
//		sto = new CommodityDataService_Stub();
		
		try {
			
			com=sto.findGood(name, type);
			
			if(com==null){
				return 2;
			}
			
			if(com.number<number){
				return 6;
			}
			
			if (sto.addGift(com)) {
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}

	public int delGift(String name, String type,int number) {
		CommodityPO com = new CommodityPO(true,"name","type",10,10,"10",20,20,100);
//		sto = new CommodityDataService_Stub();
		
		try {
			
			com=sto.findGift(name, type);
			
			if(com==null){
				return 2;
			}
			
			if(com.number<number){
				return 7;
			}
			
			if (sto.delGift(com)) {
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}

	public int patch(String name, String type, int number) {
//		CommodityPO com1 = new CommodityPO(true,"name","type",10,10,10,20,20,100);
		CommodityPO com =null;
		
		try {
			com=sto.findGood(name,type);
			
			if(com==null){
				return 2;
			}
			
			if((com.number+number)<0){
				return 8;
			}
			
			String word="patch:"+com.getName()+","+com.getType()+","+number;
			systemlog.add_up(word);
			PatchPO po=new PatchPO(com, number,"");
			invoice.add(po);
			return 0;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public int warn(String name, String type, int number) {
		CommodityPO com1 = new CommodityPO(true,"name","type",10,10,"10",20,20,100);
		CommodityPO com2 = new CommodityPO(true,"name","type",10,10,"10",20,20,100);
//		sto = new CommodityDataService_Stub();
		
		try {
			
			com1=sto.findGood(name, type);
			
			if(com1==null){
				return 2;
			}
			
			com2=com1.copy();
			com2.warn=number;
			
			if (sto.updateGood(com1, com2)) {
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public ArrayList<CommodityPO> getAllCommodity(){
//		sto = new CommodityDataService_Stub();
		
		try {
			return sto.getAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public String addPatch(PatchPO po) {
		// TODO Auto-generated method stub
//		sto.updateGood(po1, po2);
		CommodityPO com1 =null;
		CommodityPO com2 =null;
		
		try {
			com1=sto.findGood(po.getCommodity().getName(),po.getCommodity().getType());
	
			if(com1==null){
				return "失败";
			}
			
			com2=com1.copy();
			com2.number=com2.number+po.getNumber();
			
			if (sto.updateGood(com1, com2)) {
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "成功";
	}

	public String delPatch(PatchPO po) {
		// TODO Auto-generated method stub
		CommodityPO com1 =null;
		CommodityPO com2 =null;
		
		try {
			com1=sto.findGood(po.getCommodity().getName(),po.getCommodity().getType());
	
			if(com1==null){
				return "失败";
			}
			
			com2=com1.copy();
			com2.number=com2.number-po.getNumber();
			
			if (sto.updateGood(com1, com2)) {
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "成功";
	}

	public CommodityPO findCommodity(String name, String type) {
		// TODO Auto-generated method stub
		
		try {
			return sto.findGood(name, type);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public String addCommodity(String name, String type, int in_price,
			int out_price) {
		// TODO Auto-generated method stub
		CommodityPO com=null;
//		CommodityPO com2 = new CommodityPO(false, "name", "type", 10, 10, "10", 10, 10, 10);
		int i=0;
//		CommodityDataService sto = new CommodityDataService_Stub(true, "n", "t", 10, 10, 10,10, 10, 10);
//		sto = new CommodityDataService_Stub();
		
		try {
			
			ArrayList<CommodityPO> po=sto.getAll();
			
			for(i=0;i<po.size();i++){
				if(po.get(i).getName().equals(name)&&po.get(i).getType().equals(type)){
					com=new CommodityPO(false,name,type,in_price,out_price,po.get(i).getNote(),po.get(i).recent_in_price,po.get(i).recent_out_price,po.get(i).number);
					if(sto.updateGood(com, com)){
						return "0";
					}
					return "-1";
				}
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "2";
	}

	
	
	
	
	
	//////////////////////////////////////////////////////////////
	public String addGood_Data(SendGiftPO po) {
		// TODO Auto-generated method stub
		try {
			sto.addGift(new CommodityPO(null, null, null, 0, 0, null, 0, 0, 0));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return " ";
	}

	public String addPatch_Data(PatchPO po) {
		// TODO Auto-generated method stub

		try {
			CommodityPO po1=sto.findGood(po.getCommodity().getName(),po.getCommodity().getType());
			
			if(po1==null){
				return null;
			}
			
			sto.addGood(po1, null);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
