package data.initializationdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;
import po.CommodityPO;
import po.CustomerPO;
import po.InitializationPO;
import po.UserPO;
import dataservice.initializationdataservice.InitializationDataService;

public class InitializationDataService_Stub implements InitializationDataService{
	
	CustomerPO customer;
	CommodityPO commodity;
	AccountPO account;
	UserPO user;
	public InitializationDataService_Stub(CommodityPO commodity,CustomerPO customer,AccountPO account,UserPO user) {
		this.commodity = commodity;
		this.customer = customer;
		this.account = account;
		this.user=user;
	}
	public InitializationPO getInfomation() {
		return new InitializationPO(new ArrayList<CommodityPO>(), new ArrayList<CustomerPO>(), new ArrayList<AccountPO>(),new ArrayList<UserPO>());
	}
	public boolean clear() throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}
	public boolean doInitialization(InitializationPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
