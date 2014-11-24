package businesslogic.salesbl;

import po.Export_ReturnPO;
import data.salesdata.SaleDataService_Stub;

public class MockAddExport extends SaleDataService_Stub{
	public boolean addExport_Return(Export_ReturnPO po) {
		return true;
	}
}
