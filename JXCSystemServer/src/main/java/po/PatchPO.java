package po;

import java.io.Serializable;

public class PatchPO extends InvoicePO implements Serializable{
	
	String name;//���
	String type;//����
	int number;//����
	String serialNum;//���
	
	public PatchPO(String name, String type, int number, String serialNum) {
		this.name = name;
		this.type = type;
		this.number = number;
		this.serialNum = serialNum;
	}
	
	public PatchPO copy(){
		return new PatchPO(name, type, number, serialNum);
	}

	
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
