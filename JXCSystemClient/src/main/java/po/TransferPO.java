package po;

import java.io.Serializable;

public class TransferPO implements Serializable {
	
	public String account;
	public int money;
	public String ps;
	
	
	public TransferPO(String account,int money,String ps){
		this.account=account;
		this.money=money;
		this.ps=ps;
	}
	
	
	public String getAccount(){
		return account;
	}
	public int getMoney(){
		return money;
	}
	public String getPs(){
		return ps;
	}

}
