package businesslogic.commoditybl;

import businesslogicservice.commodityblservice.CommodityblService;

public class CommodityController implements CommodityblService{

	Commodity commodity;
	
	public String addCommodity(String name, String type) {
		// TODO Auto-generated method stub
		commodity=new Commodity();
		return commodity.addCommodity(name,type);
	}

	public String addCommodity(String name, String type, int in_price,
			int out_price) {
		// TODO Auto-generated method stub
		return commodity.addCommodity(name, type, in_price, out_price);
	}

	public String delCommodity(String name, String type) {
		// TODO Auto-generated method stub
		return commodity.delCommodity(name, type);
	}

	public String updateCommodity(String name, String type, int in_price,
			int out_price) {
		// TODO Auto-generated method stub
		return commodity.updateCommodity(name, type, in_price, out_price);
	}

	public String searchCommodity(String word) {
		// TODO Auto-generated method stub
		return commodity.searchCommodity(word);
	}

	public String addSort(String name) {
		// TODO Auto-generated method stub
		return commodity.addSort(name);
	}

	public String delSort(String name) {
		// TODO Auto-generated method stub
		return commodity.delSort(name);
	}

	public String updateSort(String name1, String name2) {
		// TODO Auto-generated method stub
		return commodity.updateSort(name1, name2);
	}

	public String Examine(String time1, String time2) {
		// TODO Auto-generated method stub
		return commodity.Examine(time1, time2);
	}

	public String Iventory() {
		// TODO Auto-generated method stub
		return commodity.Iventory();
	}

	public String addGift(String name, String type) {
		// TODO Auto-generated method stub
		return commodity.addGift(name, type);
	}

	public String delGift(String name, String type) {
		// TODO Auto-generated method stub
		return commodity.delGift(name, type);
	}

	public String patch(String name, String type, int number) {
		// TODO Auto-generated method stub
		return commodity.patch(name, type, number);
	}

	public String warn(String name, String type, int number) {
		// TODO Auto-generated method stub
		return commodity.warn(name, type, number);
	}

}
