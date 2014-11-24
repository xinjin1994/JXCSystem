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
	

	public Export_ReturnPO(String ti,int tp,int sm,int em,int dm,String cn,String gn,String gt,String p,String sn,String c,String o,
			int wh,int num,int pr,int dis,int i) {
		time = ti;
		total_price = tp;
		start_money = sm;
		end_money = em;
		discountMoney = dm;
		customerName = cn;
		good_name = gn;
		good_type = gt;
		ps = p;
		serialnum = sn;
		clerk = c;
		operator = o;
		wareHouse = wh;
		number = num;
		price = pr;
		discount = dis;	
		id = i;
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
