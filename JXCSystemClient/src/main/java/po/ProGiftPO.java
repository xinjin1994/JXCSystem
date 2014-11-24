package po;

import java.io.Serializable;

public class ProGiftPO implements Serializable{
	CommodityPO gift;//要促销的商品
	String time1;//开始促销时间
	String time2;//结束促销的时间
	public ProGiftPO(CommodityPO gift, String time1, String time2) {
		super();
		this.gift = gift;
		this.time1 = time1;
		this.time2 = time2;
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
