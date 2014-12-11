package businesslogic.initializationlbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;
import po.CommodityPO;
import po.CustomerPO;
import po.InitializationPO;
import po.UserPO;
import data.initializationdata.InitializationDataService_Stub;
import dataservice.initializationdataservice.InitializationDataService;

public class Initialization {
	public AccountInfo accountInfo;
	public CommodityInfo commodityInfo;
	public SalesInfo salesInfo;
	public UserInfo userInfo;
	public InitializationDataService initialization=new InitializationDataService_Stub(new CommodityPO(true, "time", "operation", 10, 10, "10", 10, 10, 10), new CustomerPO("10", "time", 10, false, "operation", "style", "mail", 10, 10, "zip", "plugin"), new AccountPO("zip", 10),new UserPO("123","312",10,"note"));
	
	
	public int newSystem(ArrayList<CommodityPO> po1,ArrayList<CustomerPO> po2,
			ArrayList<AccountPO> po3,ArrayList<UserPO> po4) {
		// TODO Auto-generated method stub
		InitializationPO po=new InitializationPO(po1,po2,po3,po4);
		int i=0;
		for(i=0;i<po1.size();i++){
			addCommodity(po1.get(i).getName(),po1.get(i).getType(),po1.get(i).getIn_price(),po1.get(i).getOut_price());
		}
		for(i=0;i<po2.size();i++){
			addCustomer(po2.get(i).getName(),po2.get(i).getPhone(),po2.get(i).getLevel(),po2.get(i).getMoney());
		}
		for(i=0;i<po3.size();i++){
			addAccount(po3.get(i).getName(),po3.get(i).getMoney());
		}
		for(i=0;i<po4.size();i++){
			addUser(po4.get(i).getName(),po4.get(i).getPassword(),po4.get(i).getDuty());
		}
		
		try {
			initialization.doInitialization(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public String addCommodity(String name, String type, int in_price,
			int out_price) {
		// TODO Auto-generated method stub
		return commodityInfo.addCommodity(name, type, in_price, out_price);
	}

	public String addCustomer(String name, String phone, int level, int money) {
		// TODO Auto-generated method stub
		return salesInfo.addCustomer(name, level, phone, money);
	}

	public String addAccount(String name, int money) {
		
		return accountInfo.addAccount(name,money);
	}
	
	public String addUser(String name,String password,int duty){
		userInfo.addUser_Data(name, password, duty);
		return "成功";
	}

	public String showInformation() {
		// TODO Auto-generated method stub
		initialization=new InitializationDataService_Stub(new CommodityPO(true, "time", "operation", 10, 10, "10", 10, 10, 10), new CustomerPO("10", "time", 10,false, "operation",  "style", "mail", 10, 10, "zip", "plugin"), new AccountPO("zip", 10),new UserPO("132","12312",10,"note"));
		try {
			if(initialization.getInfomation()!=null){
				return "�ɹ�";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ʧ��";
	}



}
