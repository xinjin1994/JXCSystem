package po;

import java.io.Serializable;

public class ReceiptPO extends InvoicePO implements Serializable{
	String serialnum;//���ݱ��
	String operator;//����Ա
	String name;//�ͻ����
	String[] account;//�����˻�
	String ps;//��ע
	int[] price;//ת�˽��
	int total;//ת���ܶ�
	
	public ReceiptPO(String serialnum, String operator, String name,
			String[] account, String ps, int[] price) {
		this.serialnum = serialnum;
		this.operator = operator;
		this.name = name;
		this.account = account;
		this.ps = ps;
		this.price = price;
		this.total=0;
		for(int pri:price){
			this.total=this.total+pri;
		}
	}
	
	public ReceiptPO copy(){
		return new ReceiptPO(serialnum, operator, name, account, ps, price);
	}
	
	public String getSerialnum() {
		return serialnum;
	}
	public String getOperator() {
		return operator;
	}
	public String getName() {
		return name;
	}
	public String[] getAccount() {
		return account;
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
	
	public int getNote(){
		String[] str=serialnum.split("-");
		return Integer.parseInt(str[1]);
	}
}
