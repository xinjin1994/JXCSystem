package businesslogic.salesbl;

import po.CustomerPO;
import data.salesdata.SaleDataService_Stub;

public class MockUpdateCustomer extends SaleDataService_Stub{
	public boolean updateCustomer(CustomerPO po1, CustomerPO po2) {
		return true;
	}
}
