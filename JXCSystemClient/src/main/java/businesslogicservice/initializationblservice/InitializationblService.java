package businesslogicservice.initializationblservice;

public interface InitializationblService {
	public String newSystem();

	public String addCommodity(String name, String type, int in_price,
			int out_price);

	public String addCustomer(String name, String phone,int level,int money );

	public String addAccount(String name, int money);

	public String showInformation();
}
