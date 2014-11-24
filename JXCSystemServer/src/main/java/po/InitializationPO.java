package po;

import java.io.Serializable;

import dataservice.accountdataservice.AccountDataService;

public class InitializationPO implements Serializable{
	CommodityPO commodity;
	CustomerPO customer;
	AccountPO account;
	
	public InitializationPO(CommodityPO commodity, CustomerPO customer,
			AccountPO account) {
		this.commodity = commodity;
		this.customer = customer;
		this.account = account;
	}
	
	public CommodityPO getCommodity() {
		return commodity;
	}

	public CustomerPO getCustomer() {
		return customer;
	}

	public AccountPO getAccount() {
		return account;
	}
	
}
