package vo;

import po.AccountPO;

public class AccountVO {

	public String name;
	public double balance;
	
	public AccountVO(String name, double balance) {
		super();
		this.name = name;
		this.balance = balance;
	}
	
	public AccountVO(AccountPO po){
		this.name=po.getName();
		this.balance=po.getMoney();
	}
	
}
