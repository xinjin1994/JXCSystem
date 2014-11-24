package businesslogic.salesbl;

import po.Import_ReturnPO;
import data.salesdata.SaleDataService_Stub;

public class MockAddImport_Return extends SaleDataService_Stub{
	public boolean addImport_Return(Import_ReturnPO po) {
		return true;
	}
}