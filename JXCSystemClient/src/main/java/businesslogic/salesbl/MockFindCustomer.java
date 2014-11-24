package businesslogic.salesbl;

import po.CustomerPO;
import data.salesdata.SaleDataService_Stub;

public class MockFindCustomer extends SaleDataService_Stub{
	public CustomerPO findCustomer(String name) {
		return new CustomerPO(1, name,1, "type", "phone", "zip", "mail", 1000, 2000, "clerk", "address");
	}
}
