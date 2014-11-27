package po;

import java.io.Serializable;

public class ProGiftPO implements Serializable{
	CommodityPO gift;//Ҫ�������Ʒ
	String time1;//��ʼ����ʱ��
	String time2;//��������ʱ��
	
	public ProGiftPO(CommodityPO gift, String time1, String time2) {
		super();
		this.gift = gift;
		this.time1 = time1;
		this.time2 = time2;
	}	
	
	public ProGiftPO copy(){
		return new ProGiftPO(gift, time1, time2);
	}

	public CommodityPO getGift() {
		return gift;
	}
	public String getTime1() {
		return time1;
	}
	public String getTime2() {
		return time2;
	}
}
