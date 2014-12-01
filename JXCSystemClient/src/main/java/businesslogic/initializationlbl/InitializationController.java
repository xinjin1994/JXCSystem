package businesslogic.initializationlbl;

import java.util.ArrayList;

import po.AccountPO;
import po.CommodityPO;
import po.CustomerPO;
import po.UserPO;
import vo.AccountVO;
import vo.CommodityVO;
import vo.CustomerVO;
import vo.UserVO;
import businesslogicservice.initializationblservice.InitializationblService;

public class InitializationController implements InitializationblService{
	
	public Initialization initialization=new Initialization();

	public int newSystem(ArrayList<CommodityVO> vo1,ArrayList<CustomerVO> vo2,
			ArrayList<AccountVO> vo3,ArrayList<UserVO> vo4) {
		// TODO Auto-generated method stub
		int i=0;
		ArrayList<CommodityPO> po1=new ArrayList<CommodityPO>();
		ArrayList<CustomerPO> po2=new ArrayList<CustomerPO>();
		ArrayList<AccountPO> po3=new ArrayList<AccountPO>();
		ArrayList<UserPO> po4=new ArrayList<UserPO>();
		for(i=0;i<vo1.size();i++){
			CommodityPO po11=new CommodityPO(false,vo1.get(i).name,vo1.get(i).type,(int)vo1.get(i).inValue,(int)vo1.get(i).outValue,
					vo1.get(i).id,(int)vo1.get(i).latestInValue,(int)vo1.get(i).latestOutValue,vo1.get(i).num);
			po1.add(po11);
		}
		for(i=0;i<vo2.size();i++){
			CustomerPO po22=new CustomerPO(vo2.get(i).id, vo2.get(i).cusName,vo2.get(i).level,false,
					vo2.get(i).tel, vo2.get(i).zipCode, "mail", 0, vo2.get(i).mostOwe,
					vo2.get(i).person, vo2.get(i).address);
			po2.add(po22);
		}
		for(i=0;i<vo3.size();i++){
			AccountPO po33=new AccountPO(vo3.get(i).name,(int)vo3.get(i).balance);
			po3.add(po33);
		}
		for(i=0;i<vo4.size();i++){
			UserPO po44=new UserPO(vo4.get(i).name,vo4.get(i).password,vo4.get(i).duty);
			po4.add(po44);
		}
		
		return initialization.newSystem(po1,po2,po3,po4);
	}

//	public String addCommodity(String name, String type, int in_price,
//			int out_price) {
//		// TODO Auto-generated method stub
//		return initialization.addCommodity(name, type, in_price, out_price);
//	}
//
//	public String addCustomer(String name, String phone, int level, int money) {
//		// TODO Auto-generated method stub
//		return initialization.addCustomer(name, phone, level, money);
//	}
//
//	public String addAccount(String name, int money) {
//		// TODO Auto-generated method stub
//		return initialization.addAccount(name, money);
//	}

	public String showInformation() {
		// TODO Auto-generated method stub
		return initialization.showInformation();
	}

}
