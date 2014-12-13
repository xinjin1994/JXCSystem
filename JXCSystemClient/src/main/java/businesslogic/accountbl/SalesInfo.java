package businesslogic.accountbl;

import java.util.ArrayList;

import po.CustomerPO;

public interface SalesInfo {
	
	public CustomerPO findCustomer(String name);
	
	public ArrayList<CustomerPO> getAllCustomer();

}
