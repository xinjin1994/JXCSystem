package po;

import java.io.Serializable;


//这个是库存赠送单的PO
public class SendGiftPO extends InvoicePO implements Serializable{
	
	public CommodityPO commodity;
	public int number;
	
	public SendGiftPO(CommodityPO commodity,int number,String note){
		this.commodity=commodity;
		this.number=number;
		this.note=note;
		this.doc_type=1;
	}
	
	public CommodityPO getCommodity(){
		return commodity;
	}
	public int getNumber(){
		return number;
	}
	
	
	public SendGiftPO copy(){
		return new SendGiftPO(commodity.copy(),number,note);
	}

}
