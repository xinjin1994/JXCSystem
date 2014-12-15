package po;

import java.io.Serializable;

public class ImportGoodPO implements Serializable{

	CommodityPO commodity;
	public int number;
	public double price;  	//这里是商品的单价，人工输入
	public double money;		//这里是这个入库商品列表的总价
	String ps;
	
	public ImportGoodPO(CommodityPO commodity,int number,double price,double money,String ps){
		this.commodity=commodity;
		this.number=number;
		this.price=price;
		this.money=price*number;
		this.ps=ps;
	}
	
	
	public CommodityPO getCommodity(){
		return commodity;
	}
	public int getNumber(){
		return number;
	}
	public double getPrice(){
		return price;
	}
	public double getMoney(){
		return money;
	}
	public String getPs(){
		return ps;
	}
	
	public ImportGoodPO copy(){
		return new ImportGoodPO(commodity.copy(),number,price,money,ps);
	}
	
}
