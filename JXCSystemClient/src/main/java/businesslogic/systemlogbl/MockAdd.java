package businesslogic.systemlogbl;

import po.SystemlogPO;
import data.systemlogdata.SystemlogDataService_Stub;

public class MockAdd extends SystemlogDataService_Stub{
	public boolean add(SystemlogPO po) {
		return true;
	}
}
