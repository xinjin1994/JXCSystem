package data.systemlogdata;

import po.SystemlogPO;
import dataservice.systemlogdataservice.SystemlogDataService;

public class SystemlogDataService_Stub implements SystemlogDataService{

	public SystemlogPO[] get() {
		return new SystemlogPO[1];
	}

	public boolean add(SystemlogPO po) {
		return true;
	}

	public boolean clear() {
		return true;
	}

}
