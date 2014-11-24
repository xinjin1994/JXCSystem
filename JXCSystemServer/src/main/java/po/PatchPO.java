package po;

import java.io.Serializable;

public class PatchPO extends InvoicePO implements Serializable{

	public PatchPO(String name, String type, int number, String serialNum) {
		this.name = name;
		this.type = type;
		this.number = number;
		this.serialNum = serialNum;
	}
	
	String name;//���
	String type;//����
	int number;//����
	String serialNum;//���
	
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public int getNumber() {
		return number;
	}
	public String getSerialNum() {
		return serialNum;
	}
}
