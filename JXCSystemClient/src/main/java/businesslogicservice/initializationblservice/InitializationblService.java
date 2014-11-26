package businesslogicservice.initializationblservice;

public interface InitializationblService {
	
	//新建库存
	public String newSystem();

	//添加商品
	public String addCommodity(String name, String type, int in_price,
			int out_price);

	//添加客户
	public String addCustomer(String name, String phone,int level,int money );

	//添加账户
	public String addAccount(String name, int money);

	//显示期初信息
	public String showInformation();
}
