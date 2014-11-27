package businesslogic.systemlogbl;

import java.util.ArrayList;

import data.systemlogdata.SystemlogDataService_Stub;
import po.SystemlogPO;

public class MockGet extends SystemlogDataService_Stub{
	public ArrayList<SystemlogPO> get() {
		ArrayList<SystemlogPO> systemlog=new ArrayList<SystemlogPO>();
		systemlog.add(new SystemlogPO("test","2222/2/2"));
		return systemlog;
	}
}
