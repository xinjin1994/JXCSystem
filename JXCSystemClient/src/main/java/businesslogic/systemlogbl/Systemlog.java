package businesslogic.systemlogbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.SystemlogPO;
import vo.AccountVO;
import vo.SystemlogVO;
import businesslogicservice.systemlogblservice.SystemlogblService;
import data.systemlogdata.SystemlogDataService_Stub;
import dataservice.systemlogdataservice.SystemlogDataService;

public class Systemlog implements SystemlogblService,
		businesslogic.commoditybl.SystemlogInfo,
		businesslogic.accountbl.SystemlogInfo,
		businesslogic.financialbl.SystemlogInfo,
		businesslogic.initializationlbl.SystemlogInfo,
		businesslogic.invoicebl.SystemlogInfo,
		businesslogic.promotionbl.SystemlogInfo,
		businesslogic.salesbl.SystemlogInfo, businesslogic.userbl.SystemlogInfo {

	public SystemlogDataService sys = new SystemlogDataService_Stub();

	public SystemlogDataService getSys() {
		return sys;
	}

	public void setSys(SystemlogDataService sys) {
		this.sys = sys;
	}

	public ArrayList<SystemlogVO> show() {
		// TODO Auto-generated method stub
		// SystemlogDataService sys = new SystemlogDataService_Stub();
		ArrayList<SystemlogVO> vo=new ArrayList<SystemlogVO>();
		try {
			if (sys.get() != null) {
				return vo;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	public int add(String word) {
		// TODO Auto-generated method stub
		SystemlogPO system = new SystemlogPO("operation", "time");
		// SystemlogDataService sys = new SystemlogDataService_Stub();
		try {
			if (sys.add(system)) {
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;// 此数字应该对应某种失败结果
	}

}
