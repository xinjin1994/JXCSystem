package dataservice.systemlogdataservice;

import po.SystemlogPO;

public interface SystemlogDataService {
	public SystemlogPO[] get();
	public boolean add(SystemlogPO po);
	public boolean clear();
}
