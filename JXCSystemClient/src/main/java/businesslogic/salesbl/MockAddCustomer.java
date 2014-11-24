package businesslogic.salesbl;

import po.CustomerPO;
import data.salesdata.SaleDataService_Stub;

public class MockAddCustomer extends SaleDataService_Stub {
	public boolean addCustomer(CustomerPO po) {
		return true;
	}
}
