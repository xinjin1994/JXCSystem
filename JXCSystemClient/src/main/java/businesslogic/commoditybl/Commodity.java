package businesslogic.commoditybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CommodityPO;
import po.PatchPO;
import po.SortPO;
import vo.StockVO;
import businesslogicservice.commodityblservice.CommodityblService;
import data.commoditydata.CommodityDataService_Stub;
import dataservice.commoditydataservice.CommodityDataService;


//-1 未知错误
//1  商品已存在
//2  商品不存在

public class Commodity implements businesslogic.financialbl.CommodityInfo,
			businesslogic.initializationlbl.CommodityInfo, businesslogic.invoicebl.CommodityInfo,
			businesslogic.salesbl.CommodityInfo{
	
	public InvoiceInfo invoice;
	public SystemlogInfo systemlog;
	public CommodityDataService sto=new CommodityDataService_Stub();

	public int addCommodity(String name, String type) {
		int i=0;
		CommodityPO com = new CommodityPO(true, "name", "type", 10, 10, "10", 10, 10, 10);
//		CommodityDataService sto = new CommodityDataService_Stub(true, "n", "t", 10, 10, 10,10, 10, 10);
//		sto = new CommodityDataService_Stub();
		
		try {
			
			ArrayList<CommodityPO> po=sto.getAll();
			
			for(i=0;i<po.size();i++){
				if(po.get(i).getName().equals(name)&&po.get(i).getType().equals(type)){
					return 1;
				}
			}
			
			com=new CommodityPO(false,name,type,0,0,"0",0,0,0);
			
			if (sto.addGood(com,new SortPO("type", 10))) {
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
		CommodityPO com = new CommodityPO(true, "name", "type", 10, 10, "10", 10, 10, 10);
		
		ArrayList<CommodityPO> po=sto.getAll();
		
		for(i=0;i<po.size();i++){
			if(po.get(i).getName().equals(name)&&po.get(i).getType().equals(type)){
				return 1;
			}
		}
		
		com=new CommodityPO(false,name,type,0,0,"0",0,0,0);
		
		if (sto.addGood(com,new SortPO("type", 10))) {
			return 0;
		}
		return -1;
	}

	public int addCommodity(CommodityPO po1,SortPO po2) {
		// TODO Auto-generated method stub
		CommodityPO com = new CommodityPO(true, "name", "type", 10, 10, "10", 10, 10, 10);
//		CommodityDataService sto = new CommodityDataService_Stub(true, "n", "t", 10, 10, 10,10, 10, 10);
//		sto = new CommodityDataService_Stub();
		
		try {
			if (sto.addGood(com,new SortPO("type", 10))) {
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}

	public int delCommodity(String name, String type) {
		CommodityPO com = new CommodityPO(true, "name", "type", 10, 10, "10", 10, 10, 10);
//		CommodityDataService sto = new CommodityDataService_Stub(true, "n", "t", 10, 10, 10,10, 10, 10);
//		sto = new CommodityDataService_Stub();
		
		try {
			if (sto.delGood(com)) {
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}

	public int updateCommodity(String name, String type, int in_price,
			int out_price) {
		CommodityPO com1 =new CommodityPO(true, "name", "type", 10, 10, "10", 10, 10, 10);
		CommodityPO com2 = new CommodityPO(true, "name", "type", 10, 10, "10", 10, 10, 10);
//		CommodityDataService sto = new CommodityDataService_Stub(true, "n", "t", 10, 10, 10,10, 10, 10);
//		sto = new CommodityDataService_Stub();
		
		try {
			if (sto.updateGood(com1, com2)) {
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}

	public ArrayList<CommodityPO> searchCommodity(String word) {
//		CommodityDataService sto = new CommodityDataService_Stub(true, "n", "t", 10, 10, 10,10, 10, 10);
//		sto = new CommodityDataService_Stub();
		
		try {
			if(sto.findName(word)!=null){
			    return null;	
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public int addSort(String name) {
		SortPO com = new SortPO(name, 10);
//		CommodityDataService sto = new CommodityDataService_Stub(true, "n", "t", 10, 10, 10,10, 10, 10);
//		sto = new CommodityDataService_Stub();
		SortPO po2=new SortPO(name,10);
		
		try {
			if (sto.addSort(com,po2)) {
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}

	public int delSort(String name) {
		SortPO com = new SortPO(name,10);
//		CommodityDataService sto = new CommodityDataService_Stub(true, "n", "t", 10, 10, 10,10, 10, 10);
//		sto = new CommodityDataService_Stub();
		
		try {
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
		SortPO com1 = new SortPO(name1,1);
		SortPO com2 = new SortPO(name2,1);
//		CommodityDataService sto = new CommodityDataService_Stub(true, "n", "t", 10, 10, 10,10, 10, 10);
//		sto = new CommodityDataService_Stub();
		
		try {
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
		CommodityPO com = new CommodityPO(true,"name","type",10,10,"10",20,20,100);
//		CommodityDataService sto = new CommodityDataService_Stub(true, "n", "t", 10, 10, 10,10, 10, 10);
//		sto = new CommodityDataService_Stub();
		
		try {
			if (sto.addGift(com)) {
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}

	public int delGift(String name, String type) {
		CommodityPO com = new CommodityPO(true,"name","type",10,10,"10",20,20,100);
//		sto = new CommodityDataService_Stub();
		
		try {
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
		CommodityPO com2 = new CommodityPO(true,"name","type",10,10,"10",20,20,200);
		String word="patch:"+com2.getName()+","+com2.getType()+","+number;
		systemlog.add(word);
		PatchPO po=new PatchPO(name, type, number, "patch-099");
		invoice.add(po);
		return 0;
	}

	public int warn(String name, String type, int number) {
		CommodityPO com1 = new CommodityPO(true,"name","type",10,10,"10",20,20,100);
		CommodityPO com2 = new CommodityPO(true,"name","type",10,10,"10",20,20,100);
//		sto = new CommodityDataService_Stub();
		
		try {
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
		return " ";
	}

	public String delPatch(PatchPO po) {
		// TODO Auto-generated method stub
		return " ";
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

}
