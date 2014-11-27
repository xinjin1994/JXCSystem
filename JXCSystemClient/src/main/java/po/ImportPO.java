package po;

import java.io.Serializable;

public class ImportPO extends InvoicePO implements Serializable{
	String time;//ʱ��
	String customerName;//�ͻ���ƣ���Ӧ�̣�
	String good_name;//��Ʒ���
	String good_type;//��Ʒ�ͺ�
	String ps;//��ע
	String  serialnum;//���ݱ��
	String clerk;//Ĭ��ҵ��Ա
	String operator;//����Ա
	int wareHouse;//�ֿ�
	int number;//��������
	int price;//���ۼ۸�
	int id;//��Ʒ���
	int total_money;//�ܼ�
	
	public ImportPO(String time,String customerName, String good_name, String good_type,
			String ps, String serialnum, String clerk, String operator,
			int wareHouse, int number, int price, int id, int total_money) {
		this.time = time;
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
		this.id = id;
		this.total_money = total_money;
	}
	
	public ImportPO copy(){
		return new ImportPO(time, customerName, good_name, good_type, ps, serialnum, clerk,
				operator, wareHouse, number, price, id, total_money);
	}

	public String getTime(){
		return time;
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

	public int getId() {
		return id;
	}

	public int getTotal_money() {
		return total_money;
	}	
	
}
