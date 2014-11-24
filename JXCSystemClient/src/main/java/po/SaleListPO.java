package po;

import java.io.Serializable;

public class SaleListPO implements Serializable{
	String time;//时间
	String name;//客户名称
	String clerk;//业务员
	String wareHouse;//仓库
	String type;//型号
	String commodity;//商品
	int price;//单价
	int number;//数量
	int totalmoney;//总价
	public SaleListPO(String time, String name, String clerk, String wareHouse,
			String type, String commodity, int price, int number, int totalmoney) {
		this.time = time;
		this.name = name;
		this.clerk = clerk;
		this.wareHouse = wareHouse;
		this.type = type;
		this.commodity = commodity;
		this.price = price;
		this.number = number;
		this.totalmoney = totalmoney;
	}

	public String getTime() {
		return time;
	}
	public String getName() {
		return name;
	}
	public String getClerk() {
		return clerk;
	}
	public String getWareHouse() {
		return wareHouse;
	}
	public String getType() {
		return type;
	}
	public String getCommodity() {
		return commodity;
	}
	public int getPrice() {
		return price;
	}
	public int getNumber() {
		return number;
	}
	public int getTotalmoney() {
		return totalmoney;
	}

	
	
	
}
