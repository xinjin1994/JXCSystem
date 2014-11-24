package businesslogic.salesbl;

import po.ImportPO;
import data.salesdata.SaleDataService_Stub;

public class MockAddImport extends SaleDataService_Stub{
	public boolean addImport(ImportPO po) {
		return true;
	}
}
