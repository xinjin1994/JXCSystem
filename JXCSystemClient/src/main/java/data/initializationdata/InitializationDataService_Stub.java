package data.initializationdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;
import po.CommodityPO;
import po.CustomerPO;
import po.InitializationPO;
import dataservice.initializationdataservice.InitializationDataService;

public class InitializationDataService_Stub implements InitializationDataService{
	
	CustomerPO customer;
	CommodityPO commodity;
	AccountPO account;
	public InitializationDataService_Stub(CommodityPO commodity,CustomerPO customer,AccountPO account) {
		this.commodity = commodity;
		this.customer = customer;
		this.account = account;
	}
	public InitializationPO getInfomation() {
		return new InitializationPO(new ArrayList<CommodityPO>(), new ArrayList<CustomerPO>(), new ArrayList<AccountPO>());
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
