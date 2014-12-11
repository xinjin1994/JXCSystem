package po;

import java.io.Serializable;

public class ItemPO implements Serializable {

	public String item_name;
	public int money;
	public String ps;
	
	
	public ItemPO(String item_name,int money,String ps){
		this.item_name=item_name;
		this.money=money;
		this.ps=ps;
	}
	
	public String getItemName(){
		return item_name;
	}
	public int getMoney(){
		return money;
	}
	public String getPs(){
		return ps;
	}
	
	public ItemPO copy(){
		return new ItemPO(item_name,money,ps);
	}
	
}
