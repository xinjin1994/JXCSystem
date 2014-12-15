package businesslogic.systemlogbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.AccountPO;
import po.SystemlogPO;
import vo.AccountVO;
import vo.SystemlogVO;
import businesslogic.userbl.User;
import businesslogicservice.systemlogblservice.SystemlogblService;
import data.systemlogdata.SystemlogDataService_Stub;
import dataservice.systemlogdataservice.SystemlogDataService;

public class Systemlog implements businesslogic.commoditybl.SystemlogInfo,
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

	public ArrayList<SystemlogPO> show_up() {
		// TODO Auto-generated method stub
		// SystemlogDataService sys = new SystemlogDataService_Stub();
		ArrayList<SystemlogPO> po=new ArrayList<SystemlogPO>();
		try {
			po=sys.get();
			if (sys.get() != null) {	
				return po ;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public int add_up(String word) {
		// TODO Auto-generated method stub
		
		SystemlogPO system = new SystemlogPO(User.operator,word);
		try {
			if (sys.add(system)) {
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;// 此数字应该对应某种失败结果
	}

}
