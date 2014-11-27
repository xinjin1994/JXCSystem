package po;

import java.io.Serializable;

public class Export_ReturnPO extends InvoicePO implements Serializable{
	
	String time;//ʱ��
	String customerName;//�ͻ����
	String good_name;//��Ʒ���
	String good_type;//��Ʒ�ͺ�
	String ps;//��ע
	String  serialnum;//���ݱ��
	String clerk;//Ĭ��ҵ��Ա
	String operator;//����Ա
	int wareHouse;//�ֿ�
	int number;//��������
	int price;//���ۼ۸�
	int discount;//ʹ�ô��ȯ�۸�
	int start_money;//����ǰ���
	int end_money;//���ú���
	int discountMoney;//���ý��
	int id;//��Ʒ���
	int total_price;//�ܼ� 
	

	public Export_ReturnPO(String time,int total_price,int start_money,int end_money,int discountMoney,
			String customerName,String good_name,String good_type,String ps,String serialnum,
			String clerk,String operator,int wareHouse,int number,int price,int discouns,int id) {
		this.time = time;
		this.total_price = total_price;
		this.start_money = start_money;
		this.end_money = end_money;
		this.discountMoney = discountMoney;
		this.customerName = customerName;
		this.good_name = good_name;
		this.good_type = good_type;
		this.ps = ps;
		this.serialnum = serialnum;
		this.clerk = clerk;
		this.operator = operator;
		this.wareHouse = wareHouse;
		this.number = number;
		this.price = price;
		this.discount = discouns;	
		this.id = id;
	}
	
	
	public Export_ReturnPO copy(){
		return new Export_ReturnPO(time, total_price, start_money, end_money, discountMoney,
				customerName, good_name, good_type, ps, serialnum, clerk, operator, wareHouse,
				number, price, discount, id);
	}
	
	
	public String getTimr(){
		return time;
	}
	public int getTotal_price() {
		return total_price;
	}

	public int getStart_money() {
		return start_money;
	}
	
	public int getEnd_money() {
		return end_money;
	}
	
	public int getDiscountMoney() {
		return discountMoney;
	}
	
	public int getId() {
		return id;
	}
	
	public String getCustomerName() {
		return customerName;
	}

	public String getGood_name() {
		return good_name;
	}

	public String getGood_type() {
		return good_type;
	}

	public String getPs() {
		return ps;
	}

	public String getSerialnum() {
		return serialnum;
	}

	public String getClerk() {
		return clerk;
	}

	public String getOperator() {
		return operator;
	}

	public int getWareHouse() {
		return wareHouse;
	}

	public int getNumber() {
		return number;
	}

	public int getPrice() {
		return price;
	}

	public int getDiscount() {
		return discount;
	}
}
