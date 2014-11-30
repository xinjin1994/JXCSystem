package po;

import java.io.Serializable;

public class AccountPO implements Serializable{
	public String name;
	public int money;
	
	public AccountPO(String name,int money){
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
	
	public int getMoney() {
		return money;
	}
	
	public AccountPO copy(){
		return new AccountPO(this.name,this.money);
	}
	
}
