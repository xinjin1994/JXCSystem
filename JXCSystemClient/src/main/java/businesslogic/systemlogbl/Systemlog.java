package businesslogic.systemlogbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import po.AccountPO;
import po.SystemlogPO;
import vo.AccountVO;
import vo.SystemlogVO;
import businesslogic.financialbl.Excel;
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
			
			System.out.println("show_up:"+po.size());
			
			
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
				System.out.println("addSystemlog:"+word);
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;// 此数字应该对应某种失败结果
	}
	
	public int outputSystemlogExcel(ArrayList<SystemlogVO> system){
		
		Vector<String[]> vec=new Vector<String[]>(1,1);
		String[] title={"时间","操作员","操作项目"};
		vec.add(title);
		
		for(int i=0;i<system.size();i++){
			String[] cell=new String[3];
			cell[0]=system.get(i).time;
			cell[1]=system.get(i).operation;
			cell[2]=system.get(i).word;
			vec.addElement(cell);
		}
		
		Excel excel=new Excel();
		return excel.output(vec, "D://系统日志");
		
	}

}
