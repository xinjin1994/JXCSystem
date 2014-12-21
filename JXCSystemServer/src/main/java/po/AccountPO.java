package po;

import java.io.Serializable;

public class AccountPO implements Serializable{
	public String name;
	public double money;
	
	public AccountPO(String name,double money){
		this.name = name;
		this.money = money;
	}
	
	public AccountPO(String name){
		this.name=name;
		money=0;
	}
	
	public String getName() {
		return name;
	}
	
	public double getMoney() {
		return money;
	}
	
	public AccountPO copy(){
		return new AccountPO(this.name,this.money);
	}
	
}
