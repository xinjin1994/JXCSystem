package po;

import java.io.Serializable;

public class TransferPO implements Serializable {
	
	public String account;
	public double money;
	public String ps;
	
	
	public TransferPO(String account,double money,String ps){
		this.account=account;
		this.money=money;
		this.ps=ps;
	}
	
	
	public String getAccount(){
		return account;
	}
	public double getMoney(){
		return money;
	}
	public String getPs(){
		return ps;
	}
	
	public TransferPO copy(){
		return new TransferPO(account,money,ps);
	}

}
