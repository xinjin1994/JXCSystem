package po;

import java.io.Serializable;

public class SaleListPO implements Serializable{
	public String time;//ʱ��
	String name;//�ͻ����
	String clerk;//ҵ��Ա
	String wareHouse;//�ֿ�
	String type;//�ͺ�
	String commodity;//��Ʒ
	int price;//����
	int number;//����
	int totalmoney;//�ܼ�
	
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
	
	public SaleListPO copy(){
		return new SaleListPO(time, name, clerk, wareHouse, type, commodity, price, number,totalmoney);
	}

	
	
	
}
