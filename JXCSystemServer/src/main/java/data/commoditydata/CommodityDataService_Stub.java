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

	
	
	
	
	public CommodityPO findGood(String name, String type) {
		
		return new CommodityPO(true,"name","type",10,10,10,20,20,100);
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
		return true;
	}

	public boolean updateGood(CommodityPO po1, CommodityPO po2) {
		return true;
	}

	public boolean addSort(SortPO po) {
		return true;
	}

	public boolean delSort(SortPO po) {
		return true;
	}

	public boolean updateSort(SortPO po1, SortPO po2) {
		return true;
	}

	public boolean addGift(CommodityPO po) {
		return true;
	}

	public CommodityPO findGift(String name, String type) {
		return new CommodityPO(true,"name","type",10,10,10,20,20,100);
	}

	public boolean delGift(CommodityPO po){
		return true;
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
		}
		return null;
	}

	public boolean clear() {
		return true;
	}

}
