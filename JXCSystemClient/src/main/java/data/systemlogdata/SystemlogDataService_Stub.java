package data.systemlogdata;

import java.util.ArrayList;

import po.SystemlogPO;
import dataservice.systemlogdataservice.SystemlogDataService;

public class SystemlogDataService_Stub implements SystemlogDataService{

	public ArrayList<SystemlogPO> get() {
		ArrayList<SystemlogPO> array=new ArrayList<SystemlogPO>();
		array.add(new SystemlogPO("1111/1/1","123"));
		return array;
	}

	public boolean add(SystemlogPO po) {
		return true;
	}

	public boolean clear() {
		return true;
	}

}
