package businesslogic.systemlogbl;


import java.rmi.RemoteException;

import po.SystemlogPO;
import businesslogicservice.systemlogblservice.SystemlogblService;
import data.systemlogdata.SystemlogDataService_Stub;
import dataservice.systemlogdataservice.SystemlogDataService;

public class Systemlog implements SystemlogblService, businesslogic.commoditybl.SystemlogInfo,
			businesslogic.accountbl.SystemlogInfo, businesslogic.financialbl.SystemlogInfo,
			businesslogic.initializationlbl.SystemlogInfo, businesslogic.invoicebl.SystemlogInfo,
			businesslogic.promotionbl.SystemlogInfo, businesslogic.salesbl.SystemlogInfo,
			businesslogic.userbl.SystemlogInfo{
	
	public SystemlogDataService sys = new SystemlogDataService_Stub();

	public SystemlogDataService getSys() {
		return sys;
	}

	public void setSys(SystemlogDataService sys) {
		this.sys = sys;
	}

	public String show() {
		// TODO Auto-generated method stub
		//SystemlogDataService sys = new SystemlogDataService_Stub();
		try {
			if(sys.get()!=null){
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "失败";
	}

	public String add(String word) {
		// TODO Auto-generated method stub
		SystemlogPO system = new SystemlogPO("operation","time");
		//SystemlogDataService sys = new SystemlogDataService_Stub();
		try {
			if(sys.add(system)){
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "失败";
	}

}
