package businesslogic.systemlogbl;


import po.SystemlogPO;
import businesslogicservice.systemlogblservice.SystemlogblService;
import data.systemlogdata.SystemlogDataService_Stub;
import dataservice.systemlogdataservice.SystemlogDataService;

public class Systemlog implements SystemlogblService, businesslogic.commoditybl.SystemlogInfo,
			businesslogic.accountbl.SystemlogInfo, businesslogic.financialbl.SystemlogInfo,
			businesslogic.initializationlbl.SystemlogInfo, businesslogic.invoicebl.SystemlogInfo,
			businesslogic.promotionbl.SystemlogInfo, businesslogic.salesbl.SystemlogInfo,
			businesslogic.userbl.SystemlogInfo{
	
	SystemlogDataService sys = new SystemlogDataService_Stub();

	public SystemlogDataService getSys() {
		return sys;
	}

	public void setSys(SystemlogDataService sys) {
		this.sys = sys;
	}

	public String show() {
		// TODO Auto-generated method stub
		//SystemlogDataService sys = new SystemlogDataService_Stub();
		if(sys.get()!=null){
			return "成功";
		}
		return "失败";
	}

	public String add(String word) {
		// TODO Auto-generated method stub
		SystemlogPO system = new SystemlogPO("operation","time");
		//SystemlogDataService sys = new SystemlogDataService_Stub();
		if(sys.add(system)){
			return "成功";
		}
		return "失败";
	}

}
