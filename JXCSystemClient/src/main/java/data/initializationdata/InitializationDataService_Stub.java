package data.initializationdata;

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
		return new InitializationPO(commodity, customer, account);
	}

}
