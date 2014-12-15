package po;

import java.io.Serializable;

public class CommodityPO implements Serializable{
	String note;
	String name;//��Ʒ��
	String type;//�ͺ�
	public double in_price;//���
	public double out_price;//�ۼ�
	public double recent_in_price;//���һ�ν��
	public double recent_out_price;//���һ���ۼ�
	public int number;//��Ʒ����
	public boolean isGift;//�ж��Ƿ�Ϊ��Ʒ
	public int warn;
	
	public String father;
	public double mean;
	
	public CommodityPO(Boolean isGift,String name,String type,double in_price,double out_price,
			String note,double recent_in_price,double recent_out_price,int number){
		this.name = name;
		this.type = type;
		this.in_price = in_price;
		this.out_price = out_price;
//		this.note = note_record;
		this.recent_in_price = recent_in_price;
		this.recent_out_price = recent_out_price;
		this.number = number;
		this.isGift = isGift;
		this.warn=0;
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
		this.warn=0;
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
		this.warn=0;
	}
	
	public CommodityPO copy(){
		CommodityPO po=new CommodityPO(isGift, name, type, in_price, out_price,note,
				recent_in_price, recent_out_price, number);
		po.warn=warn;
		return po;
	}
	
//	public CommodityVO toVO(){
//		return new CommodityVO(note,name,type,number,in_price,out_price,recent_in_price,recent_out_price);
//	}
	
	public boolean getGift(){
		return false;
	}
	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public double getIn_price() {
		return in_price;
	}

	public double getOut_price() {
		return out_price;
	}

	public String getNote() {
		return note;
	}

	public double getRecent_in_price() {
		return recent_in_price;
	}

	public double getRecent_out_price() {
		return recent_out_price;
	}
	
	public int getNumber() {
		return number;
	}
	public double getMean(){
		return mean;
	}
}
