package po;

import java.io.Serializable;

public class PaymentPO extends InvoicePO implements Serializable{	

	String serialnum;//���ݱ��
	String operator;//����Ա
	String name;//�ͻ����
	String[] account;//�����˻�
	String item;//��Ŀ�嵥
	String ps;//��ע
	int[] price;//������
	int total;//�����ܶ�
	
	public PaymentPO(String serialnum, String operator, String name, String[] account,
			String item, String ps, int[] price) {
		this.serialnum = serialnum;
		this.operator = operator;
		this.name=name;
		this.account = account;
		this.item = item;
		this.ps = ps;
		this.price = price;
		for(int pri:price){
			this.total=this.total+pri;
		}
	}
	
	public PaymentPO copy(){
		return new PaymentPO(serialnum, operator, name, account, item, ps, price);
	}
	
	public String getSerialnum() {
		return serialnum;
	}
	public String getOperator() {
		return operator;
	}
	public String getName(){
		return name;
	}
	public String[] getAccount() {
		return account;
	}
	public String getItem() {
		return item;
	}
	public String getPs() {
		return ps;
	}
	public int[] getPrice() {
		return price;
	}
	public int getTotal(){
		return total;
	}
}
