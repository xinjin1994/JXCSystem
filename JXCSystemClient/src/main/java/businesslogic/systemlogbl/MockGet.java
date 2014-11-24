package businesslogic.systemlogbl;

import data.systemlogdata.SystemlogDataService_Stub;
import po.SystemlogPO;

public class MockGet extends SystemlogDataService_Stub{
	public SystemlogPO[] get() {
		SystemlogPO[] systemlog=new SystemlogPO[1];
		systemlog[0]=new SystemlogPO("test","2222/2/2");
		return systemlog;
	}
}
