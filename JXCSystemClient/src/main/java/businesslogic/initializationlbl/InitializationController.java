package businesslogic.initializationlbl;

import businesslogicservice.initializationblservice.InitializationblService;

public class InitializationController implements InitializationblService{
	
	public Initialization initialization=new Initialization();

	public String newSystem() {
		// TODO Auto-generated method stub
		return initialization.newSystem();
	}

	public String addCommodity(String name, String type, int in_price,
			int out_price) {
		// TODO Auto-generated method stub
		return initialization.addCommodity(name, type, in_price, out_price);
	}

	public String addCustomer(String name, String phone, int level, int money) {
		// TODO Auto-generated method stub
		return initialization.addCustomer(name, phone, level, money);
	}

	public String addAccount(String name, int money) {
		// TODO Auto-generated method stub
		return initialization.addAccount(name, money);
	}

	public String showInformation() {
		// TODO Auto-generated method stub
		return initialization.showInformation();
	}

}
