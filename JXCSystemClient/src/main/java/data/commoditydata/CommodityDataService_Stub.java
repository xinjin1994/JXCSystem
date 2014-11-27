package data.commoditydata;

import java.util.ArrayList;

import po.CommodityPO;
import po.SortPO;
import dataservice.commoditydataservice.CommodityDataService;

public class CommodityDataService_Stub implements CommodityDataService{
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

	public ArrayList<CommodityPO> getAll() {
		CommodityPO com=new CommodityPO(true,"name","type",10,10,10,20,20,100);
		ArrayList<CommodityPO> coms=new ArrayList<CommodityPO>();
		coms.add(com);
		return coms;
	}

	public boolean clear() {
		return true;
	}

}
