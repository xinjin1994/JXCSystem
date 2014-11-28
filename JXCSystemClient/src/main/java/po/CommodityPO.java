package po;

import java.io.Serializable;

public class CommodityPO extends InvoicePO implements Serializable{
	String name;//��Ʒ��
	String type;//�ͺ�
	int in_price;//���
	int out_price;//�ۼ�
	int note;//���
	int recent_in_price;//���һ�ν��
	int recent_out_price;//���һ���ۼ�
	public int number;//��Ʒ����
	boolean isGift;//�ж��Ƿ�Ϊ��Ʒ
	
	public CommodityPO(Boolean isGift,String name,String type,int in_price,int out_price,
			int note,int recent_in_price,int recent_out_price,int number){
		this.name = name;
		this.type = type;
		this.in_price = in_price;
		this.out_price = out_price;
//		this.note = note_record;
		this.recent_in_price = recent_in_price;
		this.recent_out_price = recent_out_price;
		this.number = number;
		this.isGift = isGift;
	}
	
	public CommodityPO(String name, String type){
		this.name = name;
		this.type = type;
		this.in_price = 0;
		this.out_price = 0;
//		this.note = note_record;
		this.recent_in_price = 0;
		this.recent_out_price = 0;
		this.number = 0;
		this.isGift = false;
	}
	
	public CommodityPO(String name,String type,int in_price,int out_price){
		this.name = name;
		this.type = type;
		this.in_price = in_price;
		this.out_price = out_price;
//		this.note = note_record;
		this.recent_in_price = 0;
		this.recent_out_price = 0;
		this.number = 0;
		this.isGift = false;
	}
	
	public CommodityPO copy(){
		return new CommodityPO(isGift, name, type, in_price, out_price,note,
				recent_in_price, recent_out_price, number);
	}
	
	public boolean getGift(){
		return false;
	}
	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getIn_price() {
		return in_price;
	}

	public int getOut_price() {
		return out_price;
	}

	public int getNote() {
		return note;
	}

	public int getRecent_in_price() {
		return recent_in_price;
	}

	public int getRecent_out_price() {
		return recent_out_price;
	}
	
	public int getNumber() {
		return number;
	}
}
