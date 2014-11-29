package data.commoditydata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.CommodityPO;
import po.PatchPO;
import po.PaymentPO;
import po.SortPO;
import dataservice.commoditydataservice.CommodityDataService;

public class CommodityDataService_Stub extends UnicastRemoteObject implements CommodityDataService{

	ArrayList<SortPO> sortList=new ArrayList<SortPO>();
	ArrayList<PatchPO> patchList=new ArrayList<PatchPO>();
	ArrayList<CommodityPO> giftList=new ArrayList<CommodityPO>();
//	ArrayList<CommodityPO> sto=new ArrayList<CommodityPO>();
	
	public CommodityDataService_Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void writeSortList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("sortList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(sortList);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	@SuppressWarnings("unchecked")
	public void readSortList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("sortList.out");
			ois=new ObjectInputStream(fis);
			sortList=(ArrayList<SortPO>) ois.readObject();
			ois.close();
			
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	
	public void writePatchList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("patchList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(patchList);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	@SuppressWarnings("unchecked")
	public void readPatchList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("patchList.out");
			ois=new ObjectInputStream(fis);
			patchList=(ArrayList<PatchPO>) ois.readObject();
			ois.close();
			
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	
	public void writeGiftList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("giftList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(giftList);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	@SuppressWarnings("unchecked")
	public void readGiftList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("giftList.out");
			ois=new ObjectInputStream(fis);
			giftList=(ArrayList<CommodityPO>) ois.readObject();
			ois.close();
			
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	
	
	
	public CommodityPO findGood(String name, String type) {
		int i=0;
		for(i=0;i<sortList.size();i++){
			CommodityPO po=sortList.get(i).findCommodity_true(name, type);
			if(po!=null){
				return po.copy();
			}
		}
		return null;
	}

	public CommodityPO findName(String name) {

		return new CommodityPO(true,"name","type",10,10,10,20,20,100);
	}

	public CommodityPO findType(String type) {
		return new CommodityPO(true,"name","type",10,10,10,20,20,100);
	}

	public boolean addGood(CommodityPO po1, SortPO po2) {
		SortPO sort=findSort_true(po2.getName());
		if(sort!=null&&sort.hasCommodity()){
			sort.addCommodity(po1);
			System.out.println("Add Success!");
			return true;
		}
		return false;
	}

	public boolean delGood(CommodityPO po) {
		CommodityPO po1=findGood_true(po.getName(),po.getType());
		int i=0;
		if(po1.number==0){
			for(i=0;i<sortList.size();i++){
				if(sortList.get(i).delCommodity(po1)){
					return true;
				}
			}
		}
		return false;
	}

	public boolean updateGood(CommodityPO po1, CommodityPO po2) {
		CommodityPO po=findGood_true(po1.getName(),po1.getType());
		if(po!=null){
			po.number=po2.number+po.number;
			return true;
		}
		return false;
	}

	public boolean addSort(SortPO po1,SortPO po2) {
		SortPO po=findSort_true(po1.getName());
		if(po!=null){
			return false;
		}else if(po2!=null){
			if(po2.hasCommodity()){
				return false;
			}
			
			if(po2.sortList==null){
				po2.sortList=new ArrayList<SortPO>();
			}
			po2.sortList.add(po1.copy());
			return true;
			
		}else{
			sortList.add(po1);
		}
		return true;
	}

	public boolean delSort(SortPO po) {
		SortPO po1=findSort_true(po.getName());
		
		int i=0;
		for(i=0;i<sortList.size();i++){
			if(po1.getName().equals(sortList.get(i).getName())){
				sortList.remove(po1);
				return true;
			}else{
				if(sortList.get(i).delSort(po1)){
					return true;
				}
			}
		}
		return false;
	}

	public boolean updateSort(SortPO po1, SortPO po2) {
		SortPO po=findSort_true(po1.getName());
		if(po!=null){
			po1.sort=po2.sort;
			po1.level=po2.getLevel();
			return true;
		}
		return false;
	}

	public boolean addGift(CommodityPO po) {
		
		CommodityPO po1=findGood_true(po.getName(),po.getType());
		
		if(po1!=null){
			if(!po1.isGift){
				if(po1.number>=po.number){
					po1.number=po1.number-po.number;
					po.isGift=true;
					giftList.add(po.copy());
					return true;
				}
			}
		}
		return false;
	}

	public CommodityPO findGift(String name, String type) {
		int i=0;
		for(i=0;i<giftList.size();i++){
			if(giftList.get(i).getName().equals(name)&&
					giftList.get(i).getType().equals(type)){
				return giftList.get(i).copy();
			}
		}
		return null;
	}

	public boolean delGift(CommodityPO po){
		int i=0;
		for(i=0;i<giftList.size();i++){
			if(giftList.get(i).getName().equals(po.getName())&&
					giftList.get(i).getType().equals(po.getType())){
				CommodityPO po1=findGood_true(giftList.get(i).getName(),giftList.get(i).getType());
				
				if(po1!=null){
					po1.number=giftList.get(i).number+po1.number;
					giftList.remove(i);
					return true;
				}else{
					giftList.get(i).isGift=false;
					return addGood(giftList.get(i),sortList.get(0));
				}
			}
		}
		return false;
	}

	public ArrayList<CommodityPO> getAll() {
		CommodityPO com=new CommodityPO(true,"name","type",10,10,10,20,20,100);
		ArrayList<CommodityPO> array=new ArrayList<CommodityPO>();
		array.add(com);
		return array;
	}
	
	public SortPO findSort_true(String name){
		int i=0;
		for(i=0;i<sortList.size();i++){
			if(sortList.get(i).getName().equals(name)){
				return sortList.get(i);
			}
			if(!sortList.get(i).hasCommodity()){
				SortPO po=sortList.get(i).findSort_true(name);
				if(po!=null){
					return po;
				}
				
			}
		}
		return null;
	}
	
	public CommodityPO findGood_true(String name, String type) {
		int i=0;
		for(i=0;i<sortList.size();i++){
			CommodityPO po=sortList.get(i).findCommodity_true(name, type);
			if(po!=null){
				return po.copy();
			}
		}
		return null;
	}

	public boolean clear() {
		sortList=new ArrayList<SortPO>();
		patchList=new ArrayList<PatchPO>();
		return true;
	}

}
