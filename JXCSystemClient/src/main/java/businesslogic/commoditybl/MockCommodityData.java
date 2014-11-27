package businesslogic.commoditybl;

import java.util.ArrayList;

import po.CommodityPO;
import po.SortPO;
import dataservice.commoditydataservice.CommodityDataService;

public class MockCommodityData implements CommodityDataService{
	
	public ArrayList<CommodityPO> array=new ArrayList<CommodityPO>();
	public ArrayList<SortPO> arr=new ArrayList<SortPO>();

	public CommodityPO findGood(String name, String type) {
		// TODO Auto-generated method stub
		CommodityPO com=new CommodityPO(false, name, type, 50, 60, 99, 0, 0, 0);
		return com;
	}

	public CommodityPO findName(String name) {
		// TODO Auto-generated method stub
		CommodityPO com=new CommodityPO(false, name, "type", 50, 60, 99, 0, 0, 0);
		return com;
	}

	public CommodityPO findType(String type) {
		// TODO Auto-generated method stub
		CommodityPO com=new CommodityPO(false, "name", type, 50, 60, 99, 0, 0, 0);
		return com;
	}

	public boolean addGood(CommodityPO po1, SortPO po2) {
		// TODO Auto-generated method stub
		array.add(po1);
		return true;
	}

	public boolean delGood(CommodityPO po) {
		// TODO Auto-generated method stub
//		array.remove(po);
		return true;
	}

	public boolean updateGood(CommodityPO po1, CommodityPO po2) {
		// TODO Auto-generated method stub
		array.remove(po1);
		array.add(po2);
		return true;
	}

	public boolean addSort(SortPO po) {
		// TODO Auto-generated method stub
		arr.add(po);
		return true;
	}

	public boolean delSort(SortPO po) {
		// TODO Auto-generated method stub
//		arr.remove(po);
		return true;
	}

	public boolean updateSort(SortPO po1, SortPO po2) {
		// TODO Auto-generated method stub
		arr.remove(po1);
		arr.add(po2);
		return true;
	}

	public boolean addGift(CommodityPO po) {
		// TODO Auto-generated method stub
		CommodityPO com=new CommodityPO(true, "name", "type", 50, 60, 99, 0, 0, 0);
		array.add(com);
		return true;
	}

	public CommodityPO findGift(String name, String type) {
		// TODO Auto-generated method stub
		CommodityPO com=new CommodityPO(true, name, "type", 50, 60, 99, 0, 0, 0);
		return com;
	}

	public boolean delGift(CommodityPO po) {
		// TODO Auto-generated method stub
//		CommodityPO com=new CommodityPO(true, "name", "type", 50, 60, 99, 0, 0, 0);
//		array.remove(com);
		return true;
	}

	public ArrayList<CommodityPO> getAll() {
		// TODO Auto-generated method stub
		CommodityPO[] com=new CommodityPO[1];
		com[0]=array.get(0);
		return new ArrayList<CommodityPO>();
	}

	public boolean clear() {
		// TODO Auto-generated method stub
		array.clear();
		return true;
	}

}
