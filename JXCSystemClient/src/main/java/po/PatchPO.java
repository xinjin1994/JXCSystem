package po;

import java.io.Serializable;

public class PatchPO extends InvoicePO implements Serializable{
	
	String good_name;//���
	String good_type;//����
	int number;//����
	String serialNum;//���
	
	public PatchPO(String name, String type, int number, String serialNum) {
		this.good_name = name;
		this.good_type = type;
		this.number = number;
		this.serialNum = serialNum;
	}
	
	public PatchPO copy(){
		return new PatchPO(good_name, good_type, number, serialNum);
	}

	
	public String getGoodName() {
		return good_name;
	}
	public String getGoodType() {
		return good_type;
	}
	public int getNumber() {
		return number;
	}
	public String getSerialNum() {
		return serialNum;
	}
	
}
