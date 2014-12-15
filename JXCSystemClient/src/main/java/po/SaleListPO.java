package po;

import java.io.Serializable;

public class SaleListPO implements Serializable{
	public String time;//ʱ��
	CommodityPO commodity;
	CustomerPO customer;
	String clerk;//ҵ��Ա
	String wareHouse;//�ֿ�
	int price;//销售单价
	int number;//销售数量
	int totalmoney;//销售总价
	
	public SaleListPO(String time,CommodityPO commodity, CustomerPO customer, String clerk,
			String wareHouse, int price, int number, int totalmoney) {
		this.time = time;
		this.commodity=commodity;
		this.clerk = clerk;
		this.wareHouse = wareHouse;
		this.customer = customer;
		this.price = price;
		this.number = number;
		this.totalmoney = totalmoney;
	}

	public String getTime() {
		return time;
	}
	public String getClerk() {
		return clerk;
	}
	public String getWareHouse() {
		return wareHouse;
	}
	public CommodityPO getCommodity() {
		return commodity;
	}
	public CustomerPO getCustomer(){
		return customer;
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
	
	public SaleListPO copy(){
		return new SaleListPO(time, commodity.copy(), customer.copy(), clerk, wareHouse, price, number, totalmoney);
	}

	
	
	
}
