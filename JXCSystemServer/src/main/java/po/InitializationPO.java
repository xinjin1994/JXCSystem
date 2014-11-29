package po;

import java.io.Serializable;
import java.util.ArrayList;

public class InitializationPO implements Serializable{
	ArrayList<CommodityPO> commodity;
	ArrayList<CustomerPO> customer;
	ArrayList<AccountPO> account;
	
	public InitializationPO(ArrayList<CommodityPO> commodity, ArrayList<CustomerPO> customer,
			ArrayList<AccountPO> account) {
		this.commodity = commodity;
		this.customer = customer;
		this.account = account;
	}
	
	
	
	public ArrayList<CommodityPO> getCommodity() {
		return commodity;
	}

	public ArrayList<CustomerPO> getCustomer() {
		return customer;
	}

	public ArrayList<AccountPO> getAccount() {
		return account;
	}



	public InitializationPO copy() {
		// TODO Auto-generated method stub
		int i=0;
		
		ArrayList<CommodityPO> com=new ArrayList<CommodityPO>();
		ArrayList<CustomerPO> cus=new ArrayList<CustomerPO>();
		ArrayList<AccountPO> acc=new ArrayList<AccountPO>();
		for(i=0;i<commodity.size();i++){
			com.add(commodity.get(i));
		}
		for(i=0;i<customer.size();i++){
			cus.add(customer.get(i));
		}
		for(i=0;i<account.size();i++){
			acc.add(account.get(i));
		}
		InitializationPO po=new InitializationPO(com,cus,acc);
		return po;
	}
	
}
