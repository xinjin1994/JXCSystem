package businesslogic.systemlogbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.AccountPO;
import po.SystemlogPO;
import vo.AccountVO;
import vo.SystemlogVO;
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

	public ArrayList<SystemlogVO> show_up() {
		// TODO Auto-generated method stub
		// SystemlogDataService sys = new SystemlogDataService_Stub();
		ArrayList<SystemlogVO> vo=new ArrayList<SystemlogVO>();
		
		try {
			
			
			ArrayList<SystemlogPO> po=sys.get();
			
			
			if (sys.get() != null) {
				
				
				for(int i=0;i<po.size();i++){
					vo.get(i).time=po.get(i).getTime();
					vo.get(i).operation=po.get(i).getOperation();
				}
				
				
			
				
				
				return vo ;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	public int add_up(String word) {
		// TODO Auto-generated method stub
		
		Date date = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String time = dateFormat.format( date ); //这一段要不要写在这里啊啊啊啊啊啊啊啊
		
		SystemlogPO system = new SystemlogPO(word,time);
		// SystemlogDataService sys = new SystemlogDataService_Stub();
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
