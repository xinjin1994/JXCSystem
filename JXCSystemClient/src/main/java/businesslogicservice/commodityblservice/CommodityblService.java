package businesslogicservice.commodityblservice;

public interface CommodityblService {

	//添加商品
	public String addCommodity(String name, String type);

	//添加商品
	public String addCommodity(String name, String type, int in_price,
			int out_price);
	//删除商品
	public String delCommodity(String name, String type);
	
	//删除商品
	public String updateCommodity(String name, String type, int in_price,
			int out_price);

	//模糊查找商品
	public String searchCommodity(String word);

	//添加分类
	public String addSort(String name);
	
	//删除分类
	public String delSort(String name);

	//修改分类
	public String updateSort(String name1, String name2);

	//查看库存
	public String Examine(String time1, String time2);

	//库存盘点
	public String Iventory();

	//库存赠送单
	public String addGift(String name, String type);

	//删除库存赠送
	public String delGift(String name, String type);

	//库存报溢报损单
	public String patch(String name, String type, int number);

	//设置库存警戒数量
	public String warn(String name, String type, int number);

}
