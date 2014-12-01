package po;

import java.io.Serializable;
import java.util.ArrayList;

public class InitializationPO implements Serializable{
	ArrayList<CommodityPO> commodity;
	ArrayList<CustomerPO> customer;
	ArrayList<AccountPO> account;
	ArrayList<UserPO> user;
	
	public InitializationPO(ArrayList<CommodityPO> commodity, ArrayList<CustomerPO> customer,
			ArrayList<AccountPO> account,ArrayList<UserPO> user) {
		this.commodity = commodity;
		this.customer = customer;
		this.account = account;
		this.user=user;
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
	public ArrayList<UserPO> getUser(){
		return user;
	}



	public InitializationPO copy() {
		// TODO Auto-generated method stub
		int i=0;
		
		ArrayList<CommodityPO> com=new ArrayList<CommodityPO>();
		ArrayList<CustomerPO> cus=new ArrayList<CustomerPO>();
		ArrayList<AccountPO> acc=new ArrayList<AccountPO>();
		ArrayList<UserPO> use=new ArrayList<UserPO>();
		for(i=0;i<commodity.size();i++){
			com.add(commodity.get(i));
		}
		for(i=0;i<customer.size();i++){
			cus.add(customer.get(i));
		}
		for(i=0;i<account.size();i++){
			acc.add(account.get(i));
		}
		for(i=0;i<user.size();i++){
			use.add(user.get(i));
		}
		InitializationPO po=new InitializationPO(com,cus,acc,use);
		return po;
	}
	
}
