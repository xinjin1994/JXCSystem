package businesslogicservice.commodityblservice;

public interface CommodityblService {

	public String addCommodity(String name, String type);

	public String addCommodity(String name, String type, int in_price,
			int out_price);

	public String delCommodity(String name, String type);

	public String updateCommodity(String name, String type, int in_price,
			int out_price);

	public String searchCommodity(String word);

	public String addSort(String name);

	public String delSort(String name);

	public String updateSort(String name1, String name2);

	public String Examine(String time1, String time2);

	public String Iventory();

	public String addGift(String name, String type);

	public String delGift(String name, String type);

	public String patch(String name, String type, int number);

	public String warn(String name, String type, int number);

}
