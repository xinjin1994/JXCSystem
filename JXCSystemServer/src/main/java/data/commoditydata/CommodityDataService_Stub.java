package data.commoditydata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.CommodityPO;
import po.SortPO;
import dataservice.commoditydataservice.CommodityDataService;

public class CommodityDataService_Stub extends UnicastRemoteObject implements CommodityDataService{
//	Boolean g;
//	String n;
//	String t;
//	int i;
//	int o;
//	int no;
//	int rei;
//	int reo;
//	int num;
//	public CommodityDataService_Stub(Boolean g, String n, String t, int i,
//			int o, int no, int rei, int reo, int num) {
//		super();
//		this.g = g;
//		this.n = n;
//		this.t = t;
//		this.i = i;
//		this.o = o;
//		this.no = no;
//		this.rei = rei;
//		this.reo = reo;
//		this.num = num;
//	}

	public CommodityDataService_Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	ArrayList<CommodityPO> sto=new ArrayList<CommodityPO>();
	
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
		sto.add(po1);
		System.out.println("Add Success!");
		return true;
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

	public CommodityPO[] getAll() {
		CommodityPO com=new CommodityPO(true,"name","type",10,10,10,20,20,100);
		CommodityPO[] coms=new CommodityPO[1];
		coms[0]=com;
		return coms;
	}

	public boolean clear() {
		return true;
	}

}
