package businesslogic.salesbl;

import data.salesdata.SaleDataService_Stub;
import po.CustomerPO;

public class MockDelCustomer extends SaleDataService_Stub{
	public boolean delCustomer(CustomerPO po) {
		return true;
	}
}
