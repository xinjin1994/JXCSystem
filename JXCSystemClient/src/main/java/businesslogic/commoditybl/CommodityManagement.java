package businesslogic.commoditybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CommodityPO;
import po.SortPO;
import dataservice.commoditydataservice.CommodityDataService;

public class CommodityManagement {
	
	public InvoiceInfo invoice;
	public SystemlogInfo systemlog;
	public SalesInfo sales;
	public CommodityDataService sto;
	
	
	public void setInfo(InvoiceInfo invoice,SystemlogInfo systemlog,SalesInfo sales){
		this.invoice=invoice;
		this.systemlog=systemlog;
		this.sales=sales;
	}
	

	public int addCommodity(CommodityPO po1,SortPO po2) {
		// TODO Auto-generated method stub
		int i=0;
		
		try {
			
			ArrayList<CommodityPO> po=sto.getAll();
			
			for(i=0;i<po.size();i++){
				if(po.get(i).getName().equals(po1.getName())&&po.get(i).getType().equals(po1.getType())){
					return 1;
				}
			}
			
			SortPO sort=findSort(po2.name);
			
			if(sort==null){
				return 4;
			}
			
			if(sort.hasSort()){
				return 9;
			}
			
			po1.father=po2.getName();
			
			if (sto.addGood(po1,po2)) {
				systemlog.add_up("addCommodity:"+po1.getName()+" "+po1.getType());
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}

	public int delCommodity(String name, String type) {
		int i=0;
		
		try {
			
			ArrayList<CommodityPO> po=sto.getAll();
			
			for(i=0;i<po.size();i++){
				if(po.get(i).getName().equals(name)&&po.get(i).getType().equals(type)){
					
					if(po.get(i).getNumber()!=0){
						return 7;
					}
					
					
					if(sto.delGood(po.get(i))){
						systemlog.add_up("delCommodity:"+name+" "+type);
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
	
	public int updateCommodity(CommodityPO po1,CommodityPO po2){
		try {
			CommodityPO com1=sto.findGood(po1.getName(), po1.getType());
			if(com1==null){
				return 2;
			}
			sto.updateGood(com1, po2);
			systemlog.add_up("updateCommodity:"+po1.getName()+" "+po1.getType());
			return 0;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public int updateCommodity(CommodityPO po1,SortPO po2){
		try {
			CommodityPO com1=sto.findGood(po1.getName(), po1.getType());
			if(com1==null){
				return 2;
			}
			SortPO sort2=findSort(po2.getName());
			if(sort2==null){
				return 4;
			}
			if(sort2.hasSort()){
				return 9;
			}
			
			sto.updateGood(com1, sort2);
			systemlog.add_up("updateCommodity:"+po1.getName()+" "+po1.getType());
			return 0;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public ArrayList<CommodityPO> searchCommodity(String word) {
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
		
		return new ArrayList<CommodityPO>();
	}
	
	public String getCommodityNote(SortPO po){
		try {
			return sto.getGoodNote(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "COM";
	}

	public int addSort(SortPO sort1,SortPO sort2) {
		SortPO po1=null;
		SortPO po2=null;
		int i=0;
		
		try {
			
			ArrayList<SortPO> sort=getAllSort();
			
			for(i=0;i<sort.size();i++){
				if(sort.get(i).getName().equals(sort1.getName())){
					po1=sort.get(i);
				}
				if(sort2!=null){
					if(sort.get(i).getName().equals(sort2.getName())){
						po2=sort.get(i);
					}
				}
			}
			
			if(po1!=null){
				return 3;
			}
			
			if(po2!=null){
				if(po2.hasCommodity()){
					return 10;
				}
			}
			
			sort1.father=sort2.getName();
			
			if (sto.addSort(sort1,po2)) {
				systemlog.add_up("addSort:"+sort1.getName());
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
		int i=0;
		
		try {
			
			ArrayList<SortPO> sort=getAllSort();
			
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
			
			if(com.hasSort()){
				return 11;
			}
			
			if (sto.delSort(com)) {
				systemlog.add_up("delSort:"+name);
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
		
		try {
			
			ArrayList<SortPO> sort=getAllSort();
			
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
			
			com2=com1.copy();
			com2.name=name2;
			
			if (sto.updateSort(com1,com2)) {
				systemlog.add_up("updateSort:"+name1+"to"+name2);
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public int updateSort_Mov(SortPO po1,SortPO po2){
		try {	
			SortPO sort1=findSort(po1.getName());
			SortPO sort2;
			
			if(sort1==null){
				return 4;
			}
			
			if(po2!=null){
				sort2=findSort(po2.getName());
				if(sort2==null){
					return 4;
				}
			}else{
				sort2=null;
			}
			
			if(sto.updateSort_Mov(sort1, sort2)){
				systemlog.add_up("moveSort:"+sort1.getName()+"to"+sort2.getName());
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public ArrayList<SortPO> getAllSort(){
		try {
			ArrayList<SortPO> sort=new ArrayList<SortPO>();
			ArrayList<SortPO> po=sto.getAllSort();
			ArrayList<SortPO> lin=new ArrayList<SortPO>();
			
			for(int i=0;i<po.size();i++){
				lin=getAllSortSon(po.get(i));
				for(int j=0;j<lin.size();j++){
					SortPO so=new SortPO(lin.get(j).getName());
					so.note=lin.get(j).getNote();
					so.father=lin.get(j).father;
					so.sortList=lin.get(j).sortList;
					so.commodityList=lin.get(j).commodityList;
//					System.out.println("getAllSort:Name+Size:"+so.name+so.sortList.size());
					sort.add(so);
				}
			}
			
			return sort;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<SortPO>();
	}
	
	public ArrayList<SortPO> getAllSortSon(SortPO po){
		ArrayList<SortPO> sort=new ArrayList<SortPO>();
		ArrayList<SortPO> lin=new ArrayList<SortPO>();
		SortPO so=new SortPO(po.getName());
		so.note=po.getNote();
		so.commodityList=po.commodityList;
		so.sortList=po.sortList;
		so.father=po.father;
		sort.add(so);
		
		if(po.hasSort()){
			for(int i=0;i<po.sortList.size();i++){
				lin=getAllSortSon(po.sortList.get(i));
				for(int j=0;j<lin.size();j++){
					so=new SortPO(lin.get(j).getName());
					so.note=lin.get(j).getNote();
					so.father=lin.get(j).father;
					so.sortList=lin.get(j).sortList;
					so.commodityList=lin.get(j).commodityList;
					sort.add(so);
				}
			}
		}
		return sort;
	}
	
	public String getSortNote(SortPO po){
		try {
			return sto.getSortNote(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "SORT";
	}
	
	public CommodityPO findCommodity(String name, String type) {
		// TODO Auto-generated method stub
		
		try {
			int i=0;
			ArrayList<CommodityPO> res=sto.getAll();
			
			for(i=0;i<res.size();i++){
				if(res.get(i).getName().equals(name)&&res.get(i).getType().equals(type)){
					return res.get(i);
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public SortPO findSort(String name){
		ArrayList<SortPO> sort;
			sort = getAllSort();
		
			int i=0;
			for(i=0;i<sort.size();i++){
				if(sort.get(i).getName().equals(name)){
					System.out.println("findSort:"+name);
					System.out.println("findSortSize:"+sort.get(i).sortList.size());
					return sort.get(i);
				}
			}
	
		return null;
	}
	
}
